# -*- coding: utf-8 -*-
import mysql.connector
import os
import re
import time
import subprocess
import multiprocessing
from mysql.connector import pooling
current_file_path = os.path.abspath(__file__)
current_directory = os.path.dirname(current_file_path)

class DB:
    def __init__(self,isComplete): 
        self.isComplete = isComplete
        if isComplete:
            self.conn = mysql.connector.connect(
                host='127.0.0.1',
                port='3306',
                user='snr',
                password='SnR123456*',
                database='api'
            )      
        else:
            self.conn = mysql.connector.connect(
                host='127.0.0.1',
                port='3306',
                user='snr',
                password='SnR123456*',
                database='snr'
            )
        cur = self.conn.cursor()
        cur.execute("SET GLOBAL max_allowed_packet=1073741824") # 1G
        self.conn.commit()

    def close(self):
        self.conn.close()    

    def reset(self,filename):
        print('Reseting database...')
        cursor = self.conn.cursor()
        with open(filename, 'r') as file:
            sql_statements = file.read()
        cursor.execute(sql_statements)
        while self.conn.next_result():
            pass
        self.conn.commit()
        print('Succefully reset database!')
        cursor.close()
    
    def clear_four_tables(self):
        tables = ['mvn_class', 'mvn_field', 'mvn_interface', 'mvn_method']
        print('Clearing all tables...')
        processes = []
        for table in tables:
            process = multiprocessing.Process(target=self.clear_table, args=(table,))
            processes.append(process)
            process.start()

        for process in processes:
            process.join()
        print('All tables cleared!')
        
    def clear_table(self, table_name):
        if self.isComplete:
            connection = mysql.connector.connect(
                    host='127.0.0.1',
                    port='3306',
                    user='snr',
                    password='SnR123456*',
                    database='api'
                )
        else:
            connection = mysql.connector.connect(
                host='127.0.0.1',
                port='3306',
                user='snr',
                password='SnR123456*',
                database='snr'
            ) 
        connection.autocommit = False
        cursor = connection.cursor()
        cursor.execute(f"DELETE FROM {table_name}")
        connection.commit()
        if cursor:
            cursor.close()
        if connection:
            connection.close()

    def copy_results_to_four_tables(self,results):
        print('Building knowledgebase...')
        cursor = self.conn.cursor()
        for table_name, entry_list in results.items():
            if entry_list:
                # get column names
                cursor.execute(f"SHOW COLUMNS FROM {table_name}")
                columns = [column[0] for column in cursor.fetchall()]

                placeholders = ', '.join(['%s'] * len(columns))
                insert_query = f"INSERT INTO {table_name} ({', '.join(columns)}) VALUES ({placeholders})"

                cursor.executemany(insert_query, entry_list)

        self.conn.commit()




    def copy_large_results_to_four_tables(self,results):
        print('Reseting knowledgebase...')
        #set global variable
        cursor = self.conn.cursor()
        cursor.execute('set unique_checks=0')
        cursor.execute("SET foreign_key_checks = 0")
        cursor.execute("SET SQL_LOG_BIN = 0")
        cursor.execute("SET SESSION BULK_INSERT_BUFFER_SIZE=1073741824")
        cursor.execute("SET SESSION MYISAM_SORT_BUFFER_SIZE=1073741824")
        cursor.execute("SET GLOBAL KEY_BUFFER_SIZE=1073741824")
        processes = []
        for table_name, entry_list in results.items():
            if entry_list:
                cursor.execute(f"ALTER TABLE {table_name} DISABLE KEYS")
                self.conn.commit()
                # cursor.execute(f"ALTER TABLE {table_name} ENGINE=MyISAM")

                process = multiprocessing.Process(target=self.insert_entrylist_to_table, args=(table_name, entry_list))
                processes.append(process)
                process.start()

        for process in processes:
            process.join()
       
        cursor.execute('set unique_checks=1')
        cursor.execute("SET foreign_key_checks = 1")
        cursor.execute("SET SQL_LOG_BIN = 1")
        for table_name in results:
            cursor.execute(f"ALTER TABLE {table_name} ENABLE KEYS")
            # cursor.execute(f"ALTER TABLE {table_name} ENGINE=InnoDB")

        cursor.close()
        print('Knowledgebase has been built successfully!')
    
    # def execute_with_timeout_and_retries(self,query,timeout=10,max_retries=3): #TODO to be test
    #     for i in range(0,max_retries):
    #         print(f'Try {i} of {query}.....')
    #         cursor = self.conn.cursor()
    #         def run_query():
    #             cursor.execute(query)
    #         thread = threading.Thread(target=run_query)
    #         thread.setDaemon(True)
    #         thread.start()
    #         thread.join(timeout)

    #         if not thread.is_alive(): # Query completed within the timeout
    #             return  
    #         else:
    #             cursor.close() 

    #     raise TimeoutError(f"Query execution {query} timed out after {max_retries} retries.")
    
    def kill_thread(self,thread_id):
        try:
            cursor = self.conn.cursor()
            query = f"KILL {thread_id}"
            cursor.execute(query)
            print(f"Thread {thread_id} has been killed successfully.")
        except mysql.connector.Error as err:
            print(f"Error: {err}")
        finally:
            cursor.close()
    
    def kill_binding_query_thread(self): #TODO to be tested
        cursor = self.conn.cursor()
        cursor.execute("SHOW PROCESSLIST")
        threads = cursor.fetchall()
        # print(f'debug176:threads = {threads}')
        for thread in threads:
            thread_id = thread[0]
            info = thread[7]
            if info:
                if info.startswith("WITH RECURSIVE subs"):
                    self.kill_thread(thread_id)
                    print('Killing works.')
        cursor.close()



    def insert_entrylist_to_table(self,table_name,entry_list):
        start_time = time.time()
        if self.isComplete:
            connection = mysql.connector.connect(
                    host='127.0.0.1',
                    port='3306',
                    user='snr',
                    password='SnR123456*',
                    database='api'
                )
        else:
            connection = mysql.connector.connect(
                host='127.0.0.1',
                port='3306',
                user='snr',
                password='SnR123456*',
                database='snr'
            ) 
        
        cursor = connection.cursor()
        # speed up
        connection.autocommit = False 

        # Use LOAD DATA INFILE for batch import
        csv_sql_path = os.path.abspath(os.path.join(current_directory,'sql_csv',f'{table_name}.csv'))
        # print(f"debug166:csv_sql_path={csv_sql_path}")
        load_data_query = f"""
        LOAD DATA INFILE '{csv_sql_path}'
        INTO TABLE {table_name}
        FIELDS TERMINATED BY ',' ENCLOSED BY '"' LINES TERMINATED BY '\\r\\n'
        IGNORE 1 LINES;
        """
        cursor.execute(load_data_query)


        connection.commit()
        if cursor:
            cursor.close()
        if connection:
            connection.close()
        end_time = time.time()
        # print(f'debug138:the process {table_name} used time : {end_time-start_time}')


    
    def query_jars(self,jar):
        cur = self.conn.cursor()
        sql = f"select id,artifactid from mvn_artifact where artifactid like '%{jar}%'"
        cur.execute(sql)
        # 获取查询结果
        results = cur.fetchall()
        cur.close()
        return results

    def query_method_fuzzy(self,str):
        cur = self.conn.cursor()
        # if str.__contains__('<') or str.__contains__('>'): #处理泛型
        #     sql = f"select * from mvn_method where signature like '%{str}%'"
        # else:
        sql = f"select * from mvn_method where name like '%{str}%'"
        cur.execute(sql)
        # 获取查询结果
        results = cur.fetchall()
        cur.close()
        return results

    def query_method_exact(self,str):
        cur = self.conn.cursor()
        sql = f"select * from mvn_method where name ='{str}' "
        cur.execute(sql)
        # 获取查询结果
        results = cur.fetchall()
        cur.close()
        return results
    
    def query_class_fuzzy(self,str):
        cur = self.conn.cursor()
        # if str.__contains__('<') or str.__contains__('>'):
        #     sql = f"select * from mvn_class where signature like '%{str}%'"
        # else:
        sql = f"select * from mvn_class where name like '%{str}%'"
        cur.execute(sql)
        # 获取查询结果
        results = cur.fetchall()
        cur.close()
        return results

    def query_class_exact(self,str):
        cur = self.conn.cursor()
        sql = f"select * from mvn_class where name = '{str}'"
        cur.execute(sql)
        # 获取查询结果
        results = cur.fetchall()
        cur.close()
        return results

    def query_field_fuzzy(self,str):
        cur = self.conn.cursor()
        # if str.__contains__('<') or str.__contains__('>'):
        #     sql = f"select * from mvn_field where signature like '%{str}%'"
        # else:
        sql = f"select * from mvn_field where name like '%{str}%'"
        cur.execute(sql)
        # 获取查询结果
        results = cur.fetchall()
        cur.close()
        return results

    def query_field_exact(self,str):
        cur = self.conn.cursor()
        sql = f"select * from mvn_field where name = '{str}'"
        cur.execute(sql)
        # 获取查询结果
        results = cur.fetchall()
        cur.close()
        return results

    def query_interface_fuzzy(self,str):
        cur = self.conn.cursor()
        sql = f"select * from mvn_interface where interface like '%{str}%'"
        cur.execute(sql)
        # 获取查询结果
        results = cur.fetchall()
        cur.close()
        return results

    def query_interface_exact(self,str):
        cur = self.conn.cursor()
        sql = f"select * from mvn_interface where interface = '{str}'"
        cur.execute(sql)
        # 获取查询结果
        results = cur.fetchall()
        cur.close()
        return results

    def query_all_entries_in_table(self,table):
        cur = self.conn.cursor()
        sql = f"select * from {table}"
        cur.execute(sql)
        # 获取查询结果
        results = cur.fetchall()
        cur.close()
        return results

    def query_four_tables_fuzzy(self,str): #class,field,method,interface
        results = []
        class_results = [
            ['mvn_class', self.query_class_fuzzy(str)]
        ]

        field_results = [
            ['mvn_field', self.query_field_fuzzy(str)]
        ]

        interface_results = [
            ['mvn_interface', self.query_interface_fuzzy(str)]
        ]

        method_results = [
            ['mvn_method', self.query_method_fuzzy(str)] 
        ]
        
        results.extend(class_results)
        results.extend(field_results)
        results.extend(interface_results)
        results.extend(method_results)
        return results

    def query_four_tables_exact(self,str): #class,field,method,interface
        results = []
        class_results = [
            ['mvn_class', self.query_class_exact(str)]
        ]

        field_results = [
            ['mvn_field', self.query_field_exact(str)]
        ]

        interface_results = [
            ['mvn_interface', self.query_interface_exact(str)]
        ]

        method_results = [
            ['mvn_method', self.query_method_exact(str)] 
        ]
        
        results.extend(class_results)
        results.extend(field_results)
        results.extend(interface_results)
        results.extend(method_results)
        return results


    def query_apipool_without_extension(self,api_pool):
        print("Querying knowledge base without extension...")
        # 1.query by name
        api_pool = [api.replace('.', '/') for api in api_pool]
        results = {
        'mvn_class': [],
        'mvn_field': [], 
        'mvn_interface': [],
        'mvn_method': []
        }
        for api in api_pool:
            if (api == 'java/lang'):
                res = self.query_four_tables_fuzzy(api) 
            else:
                res = self.query_four_tables_exact(api) #[['mvn_class', [(attribute,attribute,...),(attribute,attribute,...)...]], ['mvn_field', []], ['mvn_interface', []], ['mvn_method', []]]
            for r in res: 
                # r[0]:tablename, r[1]:query results
                if(len(r[1]) > 0):
                    for x in r[1]:
                        results[r[0]].append(x)

        results['mvn_class'] = list(set(results['mvn_class']))
        results['mvn_interface'] = list(set(results['mvn_interface']))
        results['mvn_field'] = list(set(results['mvn_field']))
        results['mvn_method'] = list(set(results['mvn_method']))
        return results      #'...':[(org/joda/time/...),(...),(...)]
        
    def query_apipool(self,api_pool):
        print("Querying knowledge base...")
        # 1.query by name
        api_pool = [api.replace('.', '/') for api in api_pool]
        results = {
        'mvn_class': [],
        'mvn_field': [], 
        'mvn_interface': [],
        'mvn_method': []
        }
        for api in api_pool:
            if (api == 'java/lang'):
                res = self.query_four_tables_fuzzy(api) 
            else:
                res = self.query_four_tables_exact(api) #[['mvn_class', [(attribute,attribute,...),(attribute,attribute,...)...]], ['mvn_field', []], ['mvn_interface', []], ['mvn_method', []]]
            for r in res: 
                # r[0]:tablename, r[1]:query results
                if(len(r[1]) > 0):
                    for x in r[1]:
                        results[r[0]].append(x)
        # print(f'debug164:results = {results}')

        # 2.collect class id of apis from four tables
        ClassId_list = [item[0] for item in results['mvn_class'] if ('java/lang' not in item[2] and 'java/io' not in item[2])]
        ClassId_list += [item[1] for item in results['mvn_field'] if ('java/lang' not in item[4] and 'java/io' not in item[4])]
        ClassId_list += [item[1] for item in results['mvn_interface'] if ('java/lang' not in item[2] and 'java/io' not in item[2])]
        ClassId_list += [item[1] for item in results['mvn_method'] if ('java/lang' not in item[3] and 'java/io' not in item[3])]
        ClassId_list = list(set(ClassId_list))
        # print(f'debug409:ClassId_list = {ClassId_list}')

        # 3.get super class id by class id
        class_entries = []
        for class_id in ClassId_list:
            class_entries.extend(self.query_class_by_class_id(class_id))
        # print(f'debug415:class_entries = {class_entries}')

        super_class_name_list = list(set([item[4] for item in class_entries if item[4] is not None]))
        for superclass in super_class_name_list:
            entry_list = self.query_class_exact(superclass)
            for entry in entry_list:
                ClassId_list.append(entry[0])
        
        ClassId_list = list(set(ClassId_list))
        # print(f'debug421:super_class_entry = {super_class_entry}\nClassId_list = {ClassId_list}')

        # 4.extend four tables by class id
        for classid in ClassId_list:
            res = self.query_four_tables_by_classid(classid) 
            for r in res:
                if(len(r[1]) > 0):
                    for x in r[1]:
                        results[r[0]].append(x) 
        

        # #2. save super class entries in mvn_class
        # super_class_name_list = list(set([item[4] for item in results['mvn_class'] if item[4] is not None])) #把super_class也带上,注意判断不为None
        # super_class_entry = []
        # for superclass in super_class_name_list:
        #     super_class_entry.extend(self.query_class_exact(superclass))
        # results['mvn_class'] = results['mvn_class'] + super_class_entry

        # #3. use class_id to extend other 3 tables 
        # ClassId_list = list(set([item[0] for item in results['mvn_class'] if 'java/lang' not in item[2]]))
        # for classid in ClassId_list:
        #     res = self.query_three_tables_by_classid(classid)
        #     for r in res:
        #         # r[0]是表名,r[1]是查询结果
        #         if(len(r[1]) > 0):
        #             for x in r[1]:
        #                 results[r[0]].append(x) 
        
        # # TODO ----------------------
        # #4. save param and return type class of mvn_method
        # Param_list = [item[4] for item in results['mvn_method']]
        # Param_list += [item[5] for item in results['mvn_method']]
        # Param_list = list(set(Param_list))
        # #regular expression
        # param_classes = []
        # for param in Param_list:
        #     pattern = r'L(.+?);'
        #     types = re.findall(pattern, param)
        #     for one_type in types:
        #         if 'java/lang' not in one_type:
        #             param_classes.append(one_type) 
        # param_classes = list(set(param_classes))
        # # print(f'debug 205:param_classes = {param_classes}') 

        # #query params in mvn_class
        # param_classes_result = []
        # for param in param_classes:
        #     param_classes_result += self.query_class_exact(param)
        # param_classes_result = list(set(param_classes_result)) # [(attribute,attribute,attribute,..),(...),(...)]
        # for param in param_classes_result: 
        #     results['mvn_class'].append(param)
        # # TODO ----------------------


        # #5. use classid of (params and its super class) to extend other 3 tables  
        # #5.1 get super classes      
        # param_superclass_name_list = list(set([item[4] for item in param_classes_result if item[4] is not None]))
        # param_superclasses_result = []
        # for param in param_superclass_name_list:
        #     param_superclasses_result += self.query_class_exact(param)
        # param_superclasses_result = list(set(param_superclasses_result)) # [(attribute,attribute,attribute,..),(...),(...)]
        # for param in param_superclasses_result:
        #     results['mvn_class'].append(param)
        # #5.2 get class id
        # param_classid_list = list(set([item[0] for item in param_classes_result if 'java/lang' not in item[2]] ))
        # param_superclassid_list = list(set([item[0] for item in param_superclasses_result if 'java/lang' not in item[2]] ))
        # param_classid_list = list(set(param_classid_list+param_superclassid_list))
        # #5.3 use class id to extend other 3 tables
        # for classid in param_classid_list:
        #     res = self.query_three_tables_by_classid(classid)
        #     for r in res:
        #         # r[0]是表名,r[1]是查询结果
        #         if(len(r[1]) > 0):
        #             for x in r[1]:
        #                 results[r[0]].append(x) 


        results['mvn_class'] = list(set(results['mvn_class']))
        results['mvn_interface'] = list(set(results['mvn_interface']))
        results['mvn_field'] = list(set(results['mvn_field']))
        results['mvn_method'] = list(set(results['mvn_method']))
        return results      #'...':[(org/joda/time/...),(...),(...)]

    def query_field_by_classid(self,classid):
        cur = self.conn.cursor()
        sql = f"select * from mvn_field where class_id = {classid}"
        cur.execute(sql)
        # 获取查询结果
        results = cur.fetchall()
        cur.close()
        return results

    def query_interface_by_classid(self,classid):
        cur = self.conn.cursor()
        sql = f"select * from mvn_interface where class_id = {classid}"
        cur.execute(sql)
        # 获取查询结果
        results = cur.fetchall()
        cur.close()
        return results

    def query_method_by_classid(self,classid):
        cur = self.conn.cursor()
        sql = f"select * from mvn_method where class_id = {classid}"
        cur.execute(sql)
        results = cur.fetchall()
        cur.close()
        return results 

    def query_class_by_class_id(self,classid):
        cur = self.conn.cursor()
        sql = f"select * from mvn_class where id = {classid}"
        cur.execute(sql)
        results = cur.fetchall()
        cur.close()
        return results

    def query_three_tables_by_classid(self,classid):
        results = []
        field_results = [
            ['mvn_field', self.query_field_by_classid(classid)]
        ]
        interface_results = [
            ['mvn_interface', self.query_interface_by_classid(classid)]
        ]
        method_results = [
            ['mvn_method', self.query_method_by_classid(classid)] 
        ]
        results.extend(field_results)
        results.extend(interface_results)
        results.extend(method_results)
        return results

    def query_four_tables_by_classid(self,classid):
        results = []
        class_result = [
            ['mvn_class',self.query_class_by_class_id(classid)]
        ]
        field_results = [
            ['mvn_field', self.query_field_by_classid(classid)]
        ]
        interface_results = [
            ['mvn_interface', self.query_interface_by_classid(classid)]
        ]
        method_results = [
            ['mvn_method', self.query_method_by_classid(classid)] 
        ]
        results.extend(field_results)
        results.extend(interface_results)
        results.extend(method_results)
        results.extend(class_result)
        return results




        
    def check_if_entry_exists_in_four_tables(self,name): #TODO to be test
        name = name.replace('.','/')
        cursor = self.conn.cursor()
        tables = ['mvn_class', 'mvn_field', 'mvn_interface', 'mvn_method']
        for table in tables:
            if table == 'mvn_interface':
                query = f"SELECT COUNT(*) FROM {table} WHERE interface = %s"
            else:
                query = f"SELECT COUNT(*) FROM {table} WHERE name = %s"
            cursor.execute(query, (name,))
            count = cursor.fetchone()[0]
            if count > 0:
                return True

        return False



def reset_database():
    start_time = time.time()
    complete_db = DB(isComplete = True)
    db = DB(isComplete = False)
    db.clear_four_tables()
    tables = ['mvn_class', 'mvn_field', 'mvn_interface', 'mvn_method']
    results = {}
    for table in tables:
        results[table] = complete_db.query_all_entries_in_table(table)

    db.copy_large_results_to_four_tables(results)

    end_time = time.time()
    print(f'reset time:{end_time-start_time}')
    db.close()


if __name__ == '__main__':
    # start_time = time.time()
    # db = DB(isComplete = False)
    # db.kill_binding_query_thread()
    # db.clear_four_tables()
    # sql_file = "./backup.sql"
    # db.reset(sql_file)
    # db.close()

    # end_time = time.time()
    # print(f'重置耗时：{end_time-start_time}')
        
    reset_database()

    # complete_database = DB(isComplete=True)
    # print(complete_database.query_apipool(['java.util.date','RESULT_OK']))
    # print(complete_database.check_if_entry_exists_in_four_tables('val$core'))
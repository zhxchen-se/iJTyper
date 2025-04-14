import os
import re
import csv
import json
import time
from openai import OpenAI
import traceback
from tqdm import tqdm  # Import tqdm library for displaying progress bars


class Eval_GPT():
    def initialize_conversation(self):
        # Load API key from environment variables or configuration file
        # Assume you have set OPENAI_API_KEY in the environment variables
        self.client = OpenAI(
            api_key= os.environ.get("OPENAI_API_KEY")
        )
        # if not os.environ.get("OPENAI_API_KEY"):
        #     raise ValueError("OPENAI_API_KEY Not Found!")
            
        self.system_prompt = "You are a helpful assistant. You will be provided with Java code snippets later, please infer the FQNs of the given API elements. Given a code snippet, you should provide an answer in Json format, such as  {'API element': '<FQN>' , 'API element': '<FQN>' , ...}.\n"
        
        # No initial conversation, only set the system prompt
        print(f'System_prompt:{self.system_prompt}\n')

    def ask_java_fqn(self, code, api_elements):
        prompt = f"Java Code:\n{code}\n"
        prompt += f"API elements:\n{api_elements}"
        
        # Add system prompt for each call
        response = self.client.chat.completions.create(
            model="text-davinci-002",
            messages=[
                {"role": "system", "content": self.system_prompt},
                {"role": "user", "content": prompt}
            ]
        )
        # print(f"==>> response: {response}")

        message = response.choices[0].message.content
        return message

    def get_java_code(self,java_file_path):
        code = ""
        if os.path.isfile(java_file_path) and java_file_path.endswith(".java"):
            with open(java_file_path) as f:
                code = f.read()
        return code

    def get_node_truth_map(self,input_file_path):
        node_truth_map = {}
        with open(input_file_path, 'r') as csv_file:
            csv_reader = csv.reader(csv_file, delimiter=',')
            reading_data = False
            for row in csv_reader:
                if reading_data:
                    if row[0].startswith("dl_correct"):
                        break
                    node = row[0]
                    dl_truth = row[2]
                    rule_truth = row[5]
                    truth = None
                    if rule_truth != '-':
                        truth = rule_truth
                    else:
                        truth = dl_truth
                    node_truth_map[node] = truth
                elif row[0] == "Node":
                    reading_data = True
        return node_truth_map

    def process_one_snippet(self, dataset, lib, file_name, base_path):
        # print(f'Asking {file_name}...\n')
        prompt_path = os.path.abspath(os.path.join(os.getcwd(),'Prompts',dataset))
        prompt_lib_path = os.path.abspath(os.path.join(prompt_path,lib))
        # get code
        java_code_path = os.path.abspath(os.path.join(prompt_lib_path,file_name))
        code = self.get_java_code(java_code_path)

        # get api list
        csv_input_file_path = os.path.abspath(os.path.join(base_path,dataset,file_name)).replace('.java','.csv')
        node_truth_map = self.get_node_truth_map(csv_input_file_path)
        api_list = list(node_truth_map.keys())

        # ask
        response = self.ask_java_fqn(code,api_list)
        # print(response)

        # process response
        try:
            node_ans_map = self.process_response_to_map(response)
            # print(f'node_ans_map = {node_ans_map}')
        except Exception as e:
            traceback_info = traceback.format_exc()
            custom_error_message = f"response process error. response = {response}\n {str(e)}\n{traceback_info}"
            raise ValueError(custom_error_message)

        # eval and save 
        self.eval_one_snippet(dataset,lib,file_name,node_ans_map,node_truth_map)
    
    def process_response_to_map(self,response):
        # start = response.find("```json")
        # end = response.rfind("```")
        # json_str = response[start+8:end]
        json_str = re.sub('//.*\n', '', response)
        
        # Replace single quotes with double quotes to conform to standard JSON format
        try:
            # Try parsing directly, it might already be valid JSON
            fqn_dict = json.loads(json_str)
        except json.JSONDecodeError:
            # If parsing fails, try replacing single quotes with double quotes
            json_str = json_str.replace("'", '"')
            try:
                fqn_dict = json.loads(json_str)
            except json.JSONDecodeError as e:
                # If it still fails, more complex parsing might be needed
                # Use regex to extract key-value pairs
                pattern = r"['\"]?([^'\":]+)['\"]?\s*:\s*['\"]([^'\"]+)['\"]"
                matches = re.findall(pattern, json_str)
                if matches:
                    fqn_dict = {key.strip(): value.strip() for key, value in matches}
                else:
                    raise ValueError(f"Unable to parse response: {json_str}\nOriginal error: {str(e)}")
        
        # print(f"==>> fqn_dict: {fqn_dict}")
        return fqn_dict

    def eval_one_snippet(self,dataset,lib,file_name,node_ans_map,node_truth_map):
        gpt_checked = len(node_ans_map)
        truth_checked = len(node_truth_map)
        gpt_file_correct = 0
        output_data = []
        for node in node_truth_map.keys():
            truth = node_truth_map[node]
            ans = node_ans_map.get(node,'-')

            this_node_correct = 1 if truth == ans else 0
            gpt_file_correct += this_node_correct

            output_data.append([file_name,node,ans,truth,this_node_correct])
        # write to csv
        output_csv_folder = os.path.abspath(os.path.join(os.getcwd(),'ChatGPT_Results',dataset,lib))
        if not os.path.exists(output_csv_folder):
            os.makedirs(output_csv_folder)
        output_csv_path = os.path.abspath(os.path.join(output_csv_folder,file_name)).replace('.java','.csv')
        
        with open(output_csv_path, 'w', newline='') as f:
            writer = csv.writer(f)
            writer.writerow(['FileName', 'Node', 'ChatGPT Answer', 'Truth', 'Correct']) # Write header
            writer.writerows(output_data)

        # print(f'Result has been saved to {output_csv_path}')

        return [gpt_file_correct,gpt_checked,truth_checked]

    def chat_all_libs(self, dataset, base_path):
        # prompt_path = os.path.abspath(os.path.join(os.getcwd(),'Prompts',dataset))
        prompt_path = os.path.abspath(os.path.join("/iJTyper/Code/Datasets", dataset))
        libs = ['android','gwt','hibernate','jdk','joda_time','xstream']
        error_log_file = os.path.abspath(os.path.join(os.getcwd(),"error_log.txt"))
        time_log_file = os.path.abspath(os.path.join(os.getcwd(), f"{dataset}_chatgpt_time.json"))
        
        # Load existing time records or create new ones
        time_records = {}
        if os.path.exists(time_log_file):
            try:
                with open(time_log_file, 'r') as f:
                    time_records = json.load(f)
            except json.JSONDecodeError:
                time_records = {}

        for lib in libs:
            prompt_lib_path = os.path.abspath(os.path.join(prompt_path,lib))
            file_names = os.listdir(prompt_lib_path)

            for file_name in tqdm(file_names, desc=f"{lib}", ncols=100):
                if os.path.exists(os.path.abspath(os.path.join(os.getcwd(),'ChatGPT_Results',dataset,lib,file_name.replace('.java','.csv')))):
                    # print(f'Jump {file_name}')
                    continue
                try:
                    start_time = time.time()  # Start time recording

                    self.process_one_snippet(dataset, lib, file_name, base_path)
                    
                    end_time = time.time()  # End time recording
                    elapsed_time = end_time - start_time  # Calculate elapsed time
                    tqdm.write(f"Processed '{lib}/{file_name}' : {elapsed_time:.2f} seconds ")
                    
                    # Update JSON records
                    file_key = f"{file_name}"
                    time_records[file_key] = {
                        "dataset": dataset,
                        "library": lib,
                        "file_name": file_name,
                        "time_seconds": round(elapsed_time, 2)
                    }
                    
                    # Save updated JSON records
                    with open(time_log_file, 'w') as f:
                        json.dump(time_records, f, indent=4)
                        
                except Exception as e:
                    tqdm.write(f"Error in '{lib}/{file_name}' ")
                    with open(error_log_file, "a") as error_log:
                        error_msg = f"Error occurred for library '{lib}' file {file_name}: {str(e)}\n"
                        error_log.write(error_msg+ '\n')
                        error_log.write(traceback.format_exc())  # stack info
                        error_log.write("\n")


if __name__ == '__main__':
    '''
    work_dir : ~/iJTyper
    '''
    base_path = os.path.abspath(os.path.join("/iJTyper/Code/ours",'GroundTruth')) # path for ground truth 
    
    datasets = ['StatType-SO','Short-SO']
    dataset = datasets[1]
    # for dataset in datasets:
    gpt = Eval_GPT()
    gpt.initialize_conversation()

    gpt.chat_all_libs(dataset, base_path)
    # gpt.process_one_snippet(dataset, 'gwt', 'gt1.java', base_path)




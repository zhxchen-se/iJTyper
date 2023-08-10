public class hibernate_class_3 {
    public class SQLiteDialect extends org.hibernate.dialect.Dialect {
        public SQLiteDialect() {
            super();
            registerColumnType(java.sql.Types.BIT, "integer");
            registerColumnType(java.sql.Types.TINYINT, "tinyint");
            registerColumnType(java.sql.Types.SMALLINT, "smallint");
            registerColumnType(java.sql.Types.INTEGER, "integer");
            registerColumnType(java.sql.Types.BIGINT, "bigint");
            registerColumnType(java.sql.Types.FLOAT, "float");
            registerColumnType(java.sql.Types.REAL, "real");
            registerColumnType(java.sql.Types.DOUBLE, "double");
            registerColumnType(java.sql.Types.NUMERIC, "numeric");
            registerColumnType(java.sql.Types.DECIMAL, "decimal");
            registerColumnType(java.sql.Types.CHAR, "char");
            registerColumnType(java.sql.Types.VARCHAR, "varchar");
            registerColumnType(java.sql.Types.LONGVARCHAR, "longvarchar");
            registerColumnType(java.sql.Types.DATE, "date");
            registerColumnType(java.sql.Types.TIME, "time");
            registerColumnType(java.sql.Types.TIMESTAMP, "timestamp");
            registerColumnType(java.sql.Types.BINARY, "blob");
            registerColumnType(java.sql.Types.VARBINARY, "blob");
            registerColumnType(java.sql.Types.LONGVARBINARY, "blob");
            // registerColumnType(Types.NULL, "null");
            registerColumnType(java.sql.Types.BLOB, "blob");
            registerColumnType(java.sql.Types.CLOB, "clob");
            registerColumnType(java.sql.Types.BOOLEAN, "integer");
            registerFunction("concat", new org.hibernate.dialect.function.VarArgsSQLFunction(org.hibernate.Hibernate.STRING, "", "||", ""));
            registerFunction("mod", new org.hibernate.dialect.function.SQLFunctionTemplate(org.hibernate.Hibernate.INTEGER, "?1 % ?2"));
            registerFunction("substr", new org.hibernate.dialect.function.StandardSQLFunction("substr", org.hibernate.Hibernate.STRING));
            registerFunction("substring", new org.hibernate.dialect.function.StandardSQLFunction("substr", org.hibernate.Hibernate.STRING));
        }

        public boolean supportsIdentityColumns() {
            return true;
        }


        public boolean hasDataTypeInIdentityColumn() {
            return false;// As specify in NHibernate dialect

        }


        public java.lang.String getIdentityColumnString() {

            return "integer";
        }

        public java.lang.String getIdentitySelectString() {
            return "select last_insert_rowid()";
        }

        public boolean supportsLimit() {
            return true;
        }

        public java.lang.String getLimitString(java.lang.String query, boolean hasOffset) {
            return new java.lang.StringBuffer(query.length() + 20).append(query).append(hasOffset ? " limit ? offset ?" : " limit ?").toString();
        }

        public boolean supportsTemporaryTables() {
            return true;
        }

        public java.lang.String getCreateTemporaryTableString() {
            return "create temporary table if not exists";
        }

        public boolean dropTemporaryTableAfterUse() {
            return false;
        }

        public boolean supportsCurrentTimestampSelection() {
            return true;
        }

        public boolean isCurrentTimestampSelectStringCallable() {
            return false;
        }

        public java.lang.String getCurrentTimestampSelectString() {
            return "select current_timestamp";
        }

        public boolean supportsUnionAll() {
            return true;
        }

        public boolean hasAlterTable() {
            return false;

        }

        public boolean dropConstraints() {
            return false;
        }

        public java.lang.String getAddColumnString() {
            return "add column";
        }

        public java.lang.String getForUpdateString() {
            return "";
        }

        public boolean supportsOuterJoinForUpdate() {
            return false;
        }

        public java.lang.String getDropForeignKeyString() {
            throw new java.lang.UnsupportedOperationException("No drop foreign key syntax supported by SQLiteDialect");
        }

        public java.lang.String getAddForeignKeyConstraintString(java.lang.String constraintName, java.lang.String[] foreignKey, java.lang.String referencedTable, java.lang.String[] primaryKey, boolean referencesPrimaryKey) {
            throw new java.lang.UnsupportedOperationException("No add foreign key syntax supported by SQLiteDialect");
        }

        public java.lang.String getAddPrimaryKeyConstraintString(java.lang.String constraintName) {
            throw new java.lang.UnsupportedOperationException("No add primary key syntax supported by SQLiteDialect");
        }

        public boolean supportsIfExistsBeforeTableName() {
            return true;
        }

        public boolean supportsCascadeDelete() {
            return false;
        }
    }
}


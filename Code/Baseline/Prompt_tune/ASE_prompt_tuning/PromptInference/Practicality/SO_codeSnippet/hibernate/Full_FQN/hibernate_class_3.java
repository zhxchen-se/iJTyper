public class hibernate_class_3 {
  public class SQLiteDialect extends org.hibernate.dialect.Dialect {
    public SQLiteDialect() {
      org.hibernate.dialect.Dialect.org.hibernate.dialect.Dialect()
      <unknown>.registerColumnType(int,java.lang.String)
      <unknown>.registerColumnType(int,java.lang.String)
      <unknown>.registerColumnType(int,java.lang.String)
      <unknown>.registerColumnType(int,java.lang.String)
      <unknown>.registerColumnType(int,java.lang.String)
      <unknown>.registerColumnType(int,java.lang.String)
      <unknown>.registerColumnType(int,java.lang.String)
      <unknown>.registerColumnType(int,java.lang.String)
      <unknown>.registerColumnType(int,java.lang.String)
      <unknown>.registerColumnType(int,java.lang.String)
      <unknown>.registerColumnType(int,java.lang.String)
      <unknown>.registerColumnType(int,java.lang.String)
      <unknown>.registerColumnType(int,java.lang.String)
      <unknown>.registerColumnType(int,java.lang.String)
      <unknown>.registerColumnType(int,java.lang.String)
      <unknown>.registerColumnType(int,java.lang.String)
      <unknown>.registerColumnType(int,java.lang.String)
      <unknown>.registerColumnType(int,java.lang.String)
      <unknown>.registerColumnType(int,java.lang.String)
      <unknown>.registerColumnType(int,java.lang.String)
      <unknown>.registerColumnType(int,java.lang.String)
      <unknown>.registerColumnType(int,java.lang.String)
      <unknown>.registerFunction(java.lang.String,org.hibernate.dialect.function.VarArgsSQLFunction)
      <unknown>.registerFunction(java.lang.String,org.hibernate.dialect.function.SQLFunctionTemplate)
      <unknown>.registerFunction(java.lang.String,org.hibernate.dialect.function.StandardSQLFunction)
      <unknown>.registerFunction(java.lang.String,org.hibernate.dialect.function.StandardSQLFunction)
    }

    public boolean supportsIdentityColumns() {
      return true;
    }

    /* public boolean supportsInsertSelectIdentity() {
    return true; // As specify in NHibernate dialect
    }
     */
    public boolean hasDataTypeInIdentityColumn() {
      return false;// As specify in NHibernate dialect

    }

    /* public String appendIdentitySelectToInsert(String insertString) {
    return new StringBuffer(insertString.length()+30). // As specify in NHibernate dialect
    append(insertString).
    append("; ").append(getIdentitySelectString()).
    toString();
    }
     */
    public java.lang.String getIdentityColumnString() {
      // return "integer primary key autoincrement";
      return "integer";
    }

    public java.lang.String getIdentitySelectString() {
      return "select last_insert_rowid()";
    }

    public boolean supportsLimit() {
      return true;
    }

    public java.lang.String getLimitString(java.lang.String query, boolean hasOffset) {
      return java.lang.StringBuffer.append(java.lang.String)###java.lang.StringBuffer.append(java.lang.String)###java.lang.StringBuffer.toString();
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
      return false;// As specify in NHibernate dialect

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

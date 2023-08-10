public class Class_9 {
  // init database constants
  private static final java.lang.String DATABASE_DRIVER = "com.mysql.jdbc.Driver";

  private static final java.lang.String DATABASE_URL = "jdbc:mysql://localhost:3306/database_name";

  private static final java.lang.String USERNAME = "root";

  private static final java.lang.String PASSWORD = "";

  private static final java.lang.String MAX_POOL = "250";

  // init connection object
  private java.sql.Connection connection;

  // init properties object
  private java.util.Properties properties;

  // create properties
  private java.util.Properties getProperties() {
    if (properties == null) {
      properties = new java.util.Properties();
      java.util.Properties.setProperty(java.lang.String,java.lang.String)
      java.util.Properties.setProperty(java.lang.String,java.lang.String)
      java.util.Properties.setProperty(java.lang.String,java.lang.String)
    }
    return properties;
  }

  // connect database
  public java.sql.Connection connect() {
    if (connection == null) {
      try {
        java.lang.Class.forName(java.lang.String)
        connection = java.sql.DriverManager.getConnection(java.lang.String,java.util.Properties);
      } catch (java.lang.ClassNotFoundException | java.sql.SQLException e) {
        java.lang.Throwable.printStackTrace()
      }
    }
    return connection;
  }

  // disconnect database
  public void disconnect() {
    if (connection != null) {
      try {
        java.sql.Connection.close()
        connection = null;
      } catch (java.sql.SQLException e) {
        java.lang.Throwable.printStackTrace()
      }
    }
  }
}

public class Class_9 {

    private static final java.lang.String DATABASE_DRIVER = "com.mysql.jdbc.Driver";

    private static final java.lang.String DATABASE_URL = "jdbc:mysql://localhost:3306/database_name";

    private static final java.lang.String USERNAME = "root";

    private static final java.lang.String PASSWORD = "";

    private static final java.lang.String MAX_POOL = "250";


    private java.sql.Connection connection;

    private java.util.Properties properties;

    private java.util.Properties getProperties() {
        if (properties == null) {
            properties = new java.util.Properties();
            properties.setProperty("user", Class_.Class_9.USERNAME);
            properties.setProperty("password", Class_.Class_9.PASSWORD);
            properties.setProperty("MaxPooledStatements", Class_.Class_9.MAX_POOL);
        }
        return properties;
    }

    public java.sql.Connection connect() {
        if (connection == null) {
            try {
                java.lang.Class.forName(Class_.Class_9.DATABASE_DRIVER);
                connection = java.sql.DriverManager.getConnection(Class_.Class_9.DATABASE_URL, getProperties());
            } catch (java.lang.ClassNotFoundException | java.sql.SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    public void disconnect() {
        if (connection != null) {
            try {
                connection.close();
                connection = null;
            } catch (java.sql.SQLException e) {
                e.printStackTrace();
            }
        }
    }
}


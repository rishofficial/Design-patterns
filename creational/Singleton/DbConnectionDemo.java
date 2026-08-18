// Mock helper class for database connection
class SQLConnection {
    public SQLConnection(String user, String pass, String db) {
        System.out.println("Connected to Database [" + db + "] for user [" + user + "]");
    }
}

// Exact implementation of Slide 38 DbConnection
class DbConnection {
    private static DbConnection instance = null;
    private SQLConnection connection;

    private DbConnection() {
        String dbUser = "admin";
        String dbPassword = "password";
        String dbName = "myDatabase";
        connection = new SQLConnection(dbUser, dbPassword, dbName);
    }

    public static DbConnection getDbConnection() {
        if (instance == null)
            instance = new DbConnection();
        return instance;
    }
}

// Runnable Client Wrapper Class matching slide 38
public class DbConnectionDemo {
    public static void main(String[] args) {
        // Slide 38 line: DbConnection connection=DbConnection.getDbConnection();
        DbConnection connection = DbConnection.getDbConnection();
        System.out.println("Retrieved DbConnection instance: " + connection);

        DbConnection connection2 = DbConnection.getDbConnection();
        System.out.println("Retrieved DbConnection instance 2: " + connection2);
        System.out.println("Same Instance Verification: " + (connection == connection2));
    }
}

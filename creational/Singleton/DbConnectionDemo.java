/**
 * Case Study 1: DB Connection Manager Singleton
 * Reference: Slide 38 in slide.md
 * 
 * Demonstrates a lazy-initialized singleton managing access to a database connection resource.
 */

// Mock SQL Connection Class
class SQLConnection {
    private String dbUrl;

    public SQLConnection(String dbUser, String dbPassword, String dbName) {
        this.dbUrl = "jdbc:mysql://localhost:3306/" + dbName + "?user=" + dbUser;
        System.out.println("Established real SQL Connection to: " + dbUrl);
    }

    public void executeQuery(String query) {
        System.out.println("Executing SQL Query ['" + query + "'] on connection [" + Integer.toHexString(hashCode()) + "]");
    }
}

// Singleton Class
class DbConnection {
    private static DbConnection instance = null;
    private SQLConnection connection;

    // Private constructor prevents external instantiation
    private DbConnection() {
        String dbUser = "admin";
        String dbPassword = "secret_password";
        String dbName = "production_db";
        this.connection = new SQLConnection(dbUser, dbPassword, dbName);
    }

    // Public static accessor for lazy initialization
    public static DbConnection getDbConnection() {
        if (instance == null) {
            instance = new DbConnection();
        }
        return instance;
    }

    public void execute(String sql) {
        connection.executeQuery(sql);
    }
}

// Client Demo Class
public class DbConnectionDemo {

    public static void main(String[] args) {
        System.out.println("=== Database Connection Singleton Demo ===");

        // Request connection instance 1
        System.out.println("\n[Client Request 1]");
        DbConnection conn1 = DbConnection.getDbConnection();
        conn1.execute("SELECT * FROM users WHERE active = 1");

        // Request connection instance 2
        System.out.println("\n[Client Request 2]");
        DbConnection conn2 = DbConnection.getDbConnection();
        conn2.execute("SELECT * FROM orders WHERE status = 'PENDING'");

        // Verify both references point to the exact same object in memory
        System.out.println("\nSame Instance Verification:");
        System.out.println("conn1 hashCode: " + conn1.hashCode());
        System.out.println("conn2 hashCode: " + conn2.hashCode());
        System.out.println("Are conn1 and conn2 identical? " + (conn1 == conn2));
    }
}

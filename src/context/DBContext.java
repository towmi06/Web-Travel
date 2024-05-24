package context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBContext {

    // Method to establish a database connection
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        // Load driver
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

        // Establish connection
        String urlDB = "jdbc:sqlserver://TOWMIESS:1433;databaseName=tour";
        String user = "user";
        String password = "12345";
        // Return the connection object
        return DriverManager.getConnection(urlDB, user, password);
    }

    public static void main(String[] args) {
        // Example usage of getConnection() method
        try {
            // Get connection
            Connection conn = getConnection();
            // Print message if connection is successful
            System.out.println("Database connection established.");
            // Don't forget to close the connection when done
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            // Print error message if connection fails
            e.printStackTrace();
        }
    }
}

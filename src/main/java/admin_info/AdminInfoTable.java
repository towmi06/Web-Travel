package admin_info;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class AdminInfoTable {
    public static void main(String[] args) {
        try {
            // Load SQL Server JDBC driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // Establish connection
            String urlDB = "jdbc:sqlserver://DESKTOP-HM360E0\\MSSQLSERVER04:1433;databaseName=Web Travel";
            String user = "sa";
            String password = "12345";
            Connection connection = DriverManager.getConnection(urlDB, user, password);

            // Create table query with coverPhoto and avatar columns
            String createTableQuery = "CREATE TABLE AdminInfo (" +
                    "ID VARCHAR(255) PRIMARY KEY," +
                    "name VARCHAR(255)," +
                    "email VARCHAR(255)," +
                    "phone VARCHAR(255)," +
                    "gender VARCHAR(255)," +
                    "address VARCHAR(255)," +
                    "position VARCHAR(255)," +
                    "coverPhoto VARCHAR(255)," + // New column
                    "avatar VARCHAR(255)," + // New column
                    "facebook VARCHAR(255)," +
                    "twitter VARCHAR(255)," +
                    "instagram VARCHAR(255)," +
                    "tiktok VARCHAR(255)" +
                    ")";

            // Execute query
            Statement statement = connection.createStatement();
            statement.executeUpdate(createTableQuery);
            System.out.println("Table created successfully.");

            // Close connection
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}

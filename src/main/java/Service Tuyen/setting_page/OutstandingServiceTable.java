package setting_page;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class OutstandingServiceTable {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            // Load driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // Establish connection
            String urlDB = "jdbc:sqlserver://DESKTOP-00GD31A\\LEY:1433;databaseName=WEB TOUR";
            String user = "sa";
            String password = "12345";
            conn = DriverManager.getConnection(urlDB, user, password);

            // Create table statement
            String createTableSQL = "CREATE TABLE outstanding_services ("
                    + "ID VARCHAR(10) PRIMARY KEY,"
                    + "rate FLOAT,"
                    + "sales BIGINT,"
                    + "tourName VARCHAR(50),"
                    + "destination VARCHAR(50),"
                    + "departureDate VARCHAR(50),"
                    + "price INT,"
                    + "address VARCHAR(100),"
                    + "category VARCHAR(50),"
                    + "outstanding BIT"
                    + ")";

            stmt = conn.createStatement();

            // Execute the SQL statement
            stmt.executeUpdate(createTableSQL);

            // Connection success message
            System.out.println("Table created successfully!");

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

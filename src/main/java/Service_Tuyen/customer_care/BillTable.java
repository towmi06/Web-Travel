package Service_Tuyen.customer_care;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BillTable {
	public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        
        try {
            // Load SQLServer JDBC driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // Establish connection
            String urlDB = "jdbc:sqlserver://DESKTOP-00GD31A\\LEY:1433;databaseName=WEB TOUR";
            String user = "sa";
            String password = "12345";
            conn = DriverManager.getConnection(urlDB, user, password);
            
            // Create statement
            stmt = conn.createStatement();
            
            // SQL query to create table
            String sql = "CREATE TABLE Bill ("
                         + "ID VARCHAR(50) PRIMARY KEY,"
                         + "providerID VARCHAR(50),"
                         + "customerID VARCHAR(50),"
                         + "tourName NVARCHAR(100),"
                         + "destination NVARCHAR(100),"
                         + "departureDate VARCHAR(50),"
                         + "numberOfPeople INT,"
                         + "price BIGINT,"
                         + "address NVARCHAR(200),"
                         + "type NVARCHAR(50)"
                         + ")";
            
            // Execute query
            stmt.executeUpdate(sql);
            
            System.out.println("Table created successfully.");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // Close connection and statement
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

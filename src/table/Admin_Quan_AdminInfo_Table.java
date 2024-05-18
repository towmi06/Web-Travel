package table;

import context.DBContext;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Admin_Quan_AdminInfo_Table {
    public static void main(String[] args) {
    	Connection conn = null;
        Statement stmt = null;
        
        try {
        	conn = DBContext.getConnection();

            // Create table query with coverPhoto and avatar columns
            String createTableQuery = "CREATE TABLE AdminInfo (" +
                    "ID VARCHAR(255) PRIMARY KEY," +
                    "name VARCHAR(255)," +
                    "email VARCHAR(255)," +
                    "phone VARCHAR(255)," +
                    "gender VARCHAR(255)," +
                    "address VARCHAR(255)," +
                    "position VARCHAR(255)," +
                    "coverPhoto VARCHAR(255)," + 
                    "avatar VARCHAR(255)," + 
                    "facebook VARCHAR(255)," +
                    "twitter VARCHAR(255)," +
                    "instagram VARCHAR(255)," +
                    "tiktok VARCHAR(255)" +
                    ")";

            // Execute query
            Statement statement = conn.createStatement();
            statement.executeUpdate(createTableQuery);
            System.out.println("Table created successfully.");

            // Close connection
            statement.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}

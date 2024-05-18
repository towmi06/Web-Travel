package table;

import context.DBContext;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Admin_Quan_Cooperate_Table {
    public static void main(String[] args) {
    	Connection conn = null;
        Statement stmt = null;
        
        try {
        	conn = DBContext.getConnection();

            // Create table query
            String createTableSQL = "CREATE TABLE Cooperate (" +
                    "tenNCC NVARCHAR(255)," +
                    "email NVARCHAR(255)," +
                    "soDienThoai NVARCHAR(20)," +
                    "diaChi NVARCHAR(255)," +
                    "ngayGui NVARCHAR(20)," +
                    "noiDungHopTac NVARCHAR(MAX)," +
                    ")";

            // Create a Statement object
            Statement statement = conn.createStatement();

            // Execute the query to create the table
            statement.executeUpdate(createTableSQL);
            
            System.out.println("Table created successfully.");

            // Close statement and connection
            statement.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}

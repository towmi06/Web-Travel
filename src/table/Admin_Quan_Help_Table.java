package table;

import context.DBContext;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Admin_Quan_Help_Table {
    public static void main(String[] args) {
    	Connection conn = null;
        Statement stmt = null;
        
        try {
        	conn = DBContext.getConnection();
            
            // Create table
            Statement statement = conn.createStatement();
            String sql = "CREATE TABLE Help (" +
                    "idCauHoi VARCHAR(50) PRIMARY KEY," +
                    "cauHoi NVARCHAR(255)," +
                    "cauTraLoi NVARCHAR(255)" +
                    ")";
            statement.executeUpdate(sql);
            System.out.println("Table created successfully.");
            
            // Close connection
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}

package table;

import context.DBContext;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Service_Tuyen3_ContactInfoService_Table {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
        	conn = DBContext.getConnection();

            // Create statement object
            stmt = conn.createStatement();

            // Create table for ContactInfoService
            String createTableSQL = "CREATE TABLE ContactInfoService (" +
            		"Sell_ID VARCHAR(50) PRIMARY KEY," +
                    "TaiKhoan VARCHAR(50)," +
                    "Username VARCHAR(50)," +
                    "Email VARCHAR(100)," +
                    "PhoneNumber VARCHAR(20)," +
                    "GioiTinh VARCHAR(10)," +
                    "ThongTinNganHang VARCHAR(255)," +
                    "STK VARCHAR(50)," +
                    "MaSoThue VARCHAR(50)," +
                    "Facebook VARCHAR(100)," +
                    "Twitter VARCHAR(100)," +
                    "Instagram VARCHAR(100)," +
                    "Address VARCHAR(255)," +
                    "WorkingHours VARCHAR(100)," +
                    "CoverPhoto VARCHAR(255)," +
                    "Avatar VARCHAR(255)," +
                    "Message VARCHAR(255)," +
                    "MetaBusiness VARCHAR(255)" +
                    ")";
            stmt.execute(createTableSQL);

            System.out.println("Table created successfully.");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // Close connection
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

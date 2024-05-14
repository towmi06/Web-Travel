package Service_Tuyen.setting_page;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ContactInfoServiceData {
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
            // Create statement object
            stmt = conn.createStatement();

            // Insert data into ContactInfoService table
            String insertDataSQL = "INSERT INTO ContactInfoService (TaiKhoan, ServiceID, Username, Email, PhoneNumber, GioiTinh, ThongTinNganHang, STK, MaSoThue, Facebook, Twitter, Instagram, Address, WorkingHours) VALUES " +
                    "('hagiangtravel@gmail.com', 'NCC001', 'Ha Giang Travel', 'hagiangtravel@gmail.com', '0987213671', 'male', 'ACB', '1234567890', '9471781', 'facebook.com', 'twitter.com', 'instagram.com', 'Ha Giang', '8:00 - 17:00')," +
                    "('taxuatravel@gmail.com', 'NCC002', 'Ta Xua Travel', 'taxuatravel@gmail.com', '0381761258', 'female', 'MB', '43268676151', '1248147617', 'facebook.com', 'twitter.com', 'instagram.com', 'Ta Xua', '9:00 - 18:00')," +
                    "('mucangtrai@gmail.com', 'NCC003', 'Mu Cang Trai Travel', 'mucangtrai@gmail.com', '098217316', 'male', 'SCB', '1112223334', '789012', 'facebook.com', 'facebook.com', 'facebook.com', 'Mu Cang Trai', '7:00 - 16:00')";

            stmt.executeUpdate(insertDataSQL);

            System.out.println("Data inserted successfully.");
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
package yDB_web;

import context.DBContext;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Service_Tuyen3_ContactInfoService_Data {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
        	conn = DBContext.getConnection();
            
            // Create statement object
            stmt = conn.createStatement();

            // Insert data into ContactInfoService table
            String insertDataSQL = "INSERT INTO ContactInfoService (Sell_ID, TaiKhoan, Username, Email, PhoneNumber, GioiTinh, ThongTinNganHang, STK, MaSoThue, Facebook, Twitter, Instagram, Address, WorkingHours, CoverPhoto, Avatar, Message, MetaBusiness) VALUES " +
                    "('1', 'hagiangtravel@gmail.com', 'Ha Giang Travel', 'hagiangtravel@gmail.com', '0987213671', 'male', 'ACB', '1234567890', '9471781', 'facebook.com/hagiang', 'twitter.com/hagiang', 'instagram.com/hagiang', 'Ha Giang', '8:00 - 17:00', 'resources/images/hagiang.jpg', 'resources/images/hagiang.jpg', 'https://www.messenger.com/t/333636819825179', 'https://business.facebook.com/latest/inbox/all/?business_id=455014073720604&asset_id=333636819825179&mailbox_id=333636819825179&selected_item_id=100010977510961&thread_type=FB_MESSAGE')," +
                    "('2', 'taxuatravel@gmail.com', 'Ta Xua Travel', 'taxuatravel@gmail.com', '0381761258', 'female', 'MB', '43268676151', '1248147617', 'facebook.com/taxua', 'twitter.com/taxua', 'instagram.com/taxua', 'Ta Xua', '9:00 - 18:00', 'resources/images/taxua.jpg', 'resources/images/taxua.jpg', 'https://www.messenger.com/t/336157916237953', 'https://business.facebook.com/latest/inbox/all/?asset_id=336157916237953&mailbox_id=&selected_item_id=100010977510961&thread_type=FB_MESSAGE')," +
                    "('3', 'mucangtrai@gmail.com', 'Mu Cang Trai Travel', 'mucangtrai@gmail.com', '098217316', 'male', 'SCB', '1112223334', '789012', 'facebook.com/mucangtrai', 'twitter.com/mucangtrai', 'instagram.com/mucangtrai', 'Mu Cang Trai', '7:00 - 16:00', 'resources/images/hagiang.jpg', 'resources/images/hagiang.jpg', 'https://www.messenger.com/t/324807770711750', 'https://business.facebook.com/latest/inbox/all/?asset_id=324807770711750&mailbox_id=&selected_item_id=100010977510961&thread_type=FB_MESSAGE')";

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

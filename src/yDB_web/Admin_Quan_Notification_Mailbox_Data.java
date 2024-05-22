package yDB_web;

import context.DBContext;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Admin_Quan_Notification_Mailbox_Data {
    public static void main(String[] args) throws ClassNotFoundException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DBContext.getConnection();
            System.out.println("Connection success!");
            
            Statement stmt = conn.createStatement();

            String createNotificationTableSQL = "CREATE TABLE notification (" +
                                                "id INT PRIMARY KEY IDENTITY," +
                                                "content NVARCHAR(255) NOT NULL)";
            stmt.executeUpdate(createNotificationTableSQL);
            System.out.println("Table 'notification' created successfully.");

            String insertNotificationDataSQL = "INSERT INTO notification (content) VALUES (?)";
            pstmt = conn.prepareStatement(insertNotificationDataSQL);
            pstmt.setString(1, "Thông báo 1");
            pstmt.executeUpdate();

            pstmt.setString(1, "Thông báo 2");
            pstmt.executeUpdate();

            pstmt.setString(1, "Thông báo 3");
            pstmt.executeUpdate();

            System.out.println("Data inserted into 'notification' successfully.");

            String createMailboxTableSQL = "CREATE TABLE mailbox (" +
                                           "id INT PRIMARY KEY IDENTITY," +
                                           "content NVARCHAR(255) NOT NULL)";
            stmt.executeUpdate(createMailboxTableSQL);
            System.out.println("Table 'mailbox' created successfully.");

            String insertMailboxDataSQL = "INSERT INTO mailbox (content) VALUES (?)";
            pstmt = conn.prepareStatement(insertMailboxDataSQL);
            pstmt.setString(1, "Thư 1");
            pstmt.executeUpdate();

            pstmt.setString(1, "Thư 2");
            pstmt.executeUpdate();

            pstmt.setString(1, "Thư 3");
            pstmt.executeUpdate();

            System.out.println("Data inserted into 'mailbox' successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

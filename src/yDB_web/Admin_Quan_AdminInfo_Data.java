package yDB_web;

import context.DBContext;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Admin_Quan_AdminInfo_Data {
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

            // Execute create table query
            stmt = conn.createStatement();
            stmt.executeUpdate(createTableQuery);
            System.out.println("Table created successfully.");

            // Insert data query
            String insertDataQuery = "INSERT INTO AdminInfo (ID, name, email, phone, gender, address, position, coverPhoto, avatar, facebook, twitter, instagram, tiktok) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            // Prepare statement
            PreparedStatement preparedStatement = conn.prepareStatement(insertDataQuery);

            // Data array
            String[][] adminData = {
                {"AD001", "Vu Manh Quan", "vumanhquan@admin.com", "09123213", "Nam", "Ha Noi", "Admin", "resources/images/cover-photo.jpg", "resources/images/admin_VMQ.jpg", "facebook.com/admin1", "twitter.com/admin1", "instagram.com/admin1", "tiktok.com/admin1"},
                {"AD002", "Nguyen Minh Dung", "nguyenminhdung@admin.com", "037126216", "Nam", "Ha Tay", "Nhan Vien", "resources/images/cover-photo-2.png", "resources/images/admin_2.png", "facebook.com/admin2", "twitter.com/admin2", "instagram.com/admin2", "tiktok.com/admin2"},
                {"AD003", "Pham Hai Long", "phamhailong@admin.com", "02188327", "Nam", "Ha Dong", "Nhan Vien", "resources/images/cover-photo-3.png", "resources/images/admin_3.png", "facebook.com/admin3", "twitter.com/admin3", "instagram.com/admin3", "tiktok.com/admin3"}
            };

            // Iterate over the data array and insert each row
            for (String[] admin : adminData) {
                preparedStatement.setString(1, admin[0]);
                preparedStatement.setString(2, admin[1]);
                preparedStatement.setString(3, admin[2]);
                preparedStatement.setString(4, admin[3]);
                preparedStatement.setString(5, admin[4]);
                preparedStatement.setString(6, admin[5]);
                preparedStatement.setString(7, admin[6]);
                preparedStatement.setString(8, admin[7]);
                preparedStatement.setString(9, admin[8]);
                preparedStatement.setString(10, admin[9]);
                preparedStatement.setString(11, admin[10]);
                preparedStatement.setString(12, admin[11]);
                preparedStatement.setString(13, admin[12]);
                preparedStatement.executeUpdate();
            }

            System.out.println("Data inserted successfully.");

            // Close connection
            preparedStatement.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}

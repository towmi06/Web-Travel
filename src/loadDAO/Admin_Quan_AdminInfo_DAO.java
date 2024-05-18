package loadDAO;

import context.DBContext;
import entity.Admin_Quan_AdminInfo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Admin_Quan_AdminInfo_DAO {
   
    public static Admin_Quan_AdminInfo findAdminByEmail(String email) {
    	Connection conn = null;
        Statement stmt = null;
    	
        try {
        	conn = DBContext.getConnection();

            // Query to find admin by email
            String query = "SELECT * FROM AdminInfo WHERE email = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, email);

            // Execute query
            ResultSet resultSet = statement.executeQuery();

            // Check if admin found
            if (resultSet.next()) {
                // Extract admin information from the result set
                String ID = resultSet.getString("ID");
                String name = resultSet.getString("name");
                String adminEmail = resultSet.getString("email");
                String phone = resultSet.getString("phone");
                String gender = resultSet.getString("gender");
                String address = resultSet.getString("address");
                String position = resultSet.getString("position");
                String coverPhoto = resultSet.getString("coverPhoto");
                String avatar = resultSet.getString("avatar");
                String facebook = resultSet.getString("facebook");
                String twitter = resultSet.getString("twitter");
                String instagram = resultSet.getString("instagram");
                String tiktok = resultSet.getString("tiktok");

                // Create AdminInfo object with extracted information
                Admin_Quan_AdminInfo admin = new Admin_Quan_AdminInfo(ID, name, adminEmail, phone, gender, address, position, coverPhoto, avatar, facebook, twitter, instagram, tiktok);

                // Close resources
                resultSet.close();
                statement.close();
                conn.close();

                // Return the admin object
                return admin;
            }

            // Close resources
            resultSet.close();
            statement.close();
            conn.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        // Return null if admin not found
        return null;
    }
    
    public static int updateAdminInfo(String ID, String name, String email, String phone, String position, String facebook, String twitter, String instagram, String tiktok) {
    	Connection conn = null;
        Statement stmt = null;
    	
    	try {
    		conn = DBContext.getConnection();

            // Query to update admin information
            String query = "UPDATE AdminInfo SET name = ?, email = ?, phone = ?, position = ?, facebook = ?, twitter = ?, instagram = ?, tiktok = ? WHERE ID = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            
            // Set parameters for the prepared statement
            statement.setString(1, name);
            statement.setString(2, email);
            statement.setString(3, phone);
            statement.setString(4, position);
            statement.setString(5, facebook);
            statement.setString(6, twitter);
            statement.setString(7, instagram);
            statement.setString(8, tiktok);
            statement.setString(9, ID);

            // Execute the update query
            int rowsAffected = statement.executeUpdate();
            
            // Close resources
            statement.close();
            conn.close();

            // Check if the update was successful
            if (rowsAffected > 0) {
                System.out.println("Admin information updated successfully.");
                return 10;
            } else {
                System.out.println("Failed to update admin information.");
                return 3;
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return 5;
        }
    }
    
    public static int updateAdminPosition(String ID, String position) {
    	Connection conn = null;
        Statement stmt = null;
    	
        try {
        	conn = DBContext.getConnection();

            // Query to update admin position
            String query = "UPDATE AdminInfo SET position = ? WHERE ID = ?";
            PreparedStatement statement = conn.prepareStatement(query);

            // Set parameters for the prepared statement
            statement.setString(1, position);
            statement.setString(2, ID);

            // Execute the update query
            int rowsAffected = statement.executeUpdate();
            
            // Close resources
            statement.close();
            conn.close();

            // Check if the update was successful
            if (rowsAffected > 0) {
                System.out.println("Admin position updated successfully.");
                return 10;
            } else {
                System.out.println("Failed to update admin position.");
                return 3;
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return 5;
        }
    }

    public List<Admin_Quan_AdminInfo> getAllAdmins() throws ClassNotFoundException {
        List<Admin_Quan_AdminInfo> admins = new ArrayList<>();
        
        Connection conn = null;
        Statement stmt = null;

        try {
        	conn = DBContext.getConnection();
        	
            String query = "SELECT * FROM AdminInfo";
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String ID = resultSet.getString("ID");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String phone = resultSet.getString("phone");
                String gender = resultSet.getString("gender");
                String address = resultSet.getString("address");
                String position = resultSet.getString("position");
                String coverPhoto = resultSet.getString("coverPhoto");
                String avatar = resultSet.getString("avatar");
                String facebook = resultSet.getString("facebook");
                String twitter = resultSet.getString("twitter");
                String instagram = resultSet.getString("instagram");
                String tiktok = resultSet.getString("tiktok");

                Admin_Quan_AdminInfo admin = new Admin_Quan_AdminInfo(ID, name, email, phone, gender, address, position, coverPhoto, avatar, facebook, twitter, instagram, tiktok);
                admins.add(admin);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return admins;
    }
}

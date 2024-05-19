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
        	System.out.println("Connections sussces");
        	
            String query = "SELECT * FROM AdminInfo WHERE email = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, email);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
            	System.out.println("Successfully found admin");
            	
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

                Admin_Quan_AdminInfo admin = new Admin_Quan_AdminInfo(ID, name, adminEmail, phone, gender, address, position, coverPhoto, avatar, facebook, twitter, instagram, tiktok);

                resultSet.close();
                statement.close();
                conn.close();

                return admin;
            }

            resultSet.close();
            statement.close();
            conn.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static String updateAdminInfo(String ID, String name, String email, String phone, String position, String facebook, String twitter, String instagram, String tiktok) {
    	Connection conn = null;
        Statement stmt = null;
    	
    	try {
    		conn = DBContext.getConnection();
    		System.out.println("Connections sussces");

            String query = "UPDATE AdminInfo SET name = ?, email = ?, phone = ?, position = ?, facebook = ?, twitter = ?, instagram = ?, tiktok = ? WHERE ID = ?";
            PreparedStatement statement = conn.prepareStatement(query);

            statement.setString(1, name);
            statement.setString(2, email);
            statement.setString(3, phone);
            statement.setString(4, position);
            statement.setString(5, facebook);
            statement.setString(6, twitter);
            statement.setString(7, instagram);
            statement.setString(8, tiktok);
            statement.setString(9, ID);

            int rowsAffected = statement.executeUpdate();
            
            statement.close();
            conn.close();

            if (rowsAffected > 0) {
                System.out.println("Admin information updated successfully.");
                return "Cập nhật thông tin thành công";
            } else {
                System.out.println("Failed to update admin information.");
                return "Cập nhật thông tin không thành công";
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return "Lỗi hệ thống";
        }
    }
    
    public static String updateAdminPosition(String ID, String position) {
    	Connection conn = null;
        Statement stmt = null;
    	
        try {
        	conn = DBContext.getConnection();
        	System.out.println("Connections sussces");
        	
            String query = "UPDATE AdminInfo SET position = ? WHERE ID = ?";
            PreparedStatement statement = conn.prepareStatement(query);

            statement.setString(1, position);
            statement.setString(2, ID);

            int rowsAffected = statement.executeUpdate();
            
            statement.close();
            conn.close();

            if (rowsAffected > 0) {
                System.out.println("Admin position updated successfully.");
                return "Cật nhật quyền truy cập thành công";
            } else {
                System.out.println("Failed to update admin position.");
                return "Cật nhật quyền truy cập không thành công";
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return "Lỗi hệ thống";
        }
    }

    public List<Admin_Quan_AdminInfo> getAllAdmins() throws ClassNotFoundException {
        List<Admin_Quan_AdminInfo> admins = new ArrayList<>();
        
        Connection conn = null;
        Statement stmt = null;

        try {
        	conn = DBContext.getConnection();
        	System.out.println("Connections sussces");
        	
            String query = "SELECT * FROM AdminInfo";
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
            	System.out.println("Successfully got the list of admins");
            	
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

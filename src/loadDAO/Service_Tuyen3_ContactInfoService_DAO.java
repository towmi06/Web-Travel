package loadDAO;

import context.DBContext;
import entity.Service_Tuyen3_ContactInfoService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Service_Tuyen3_ContactInfoService_DAO {
	public static Service_Tuyen3_ContactInfoService findProviderByCredentials(String taiKhoan) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Service_Tuyen3_ContactInfoService provider = null;

        try {
        	conn = DBContext.getConnection();

            // Prepare statement
            String query = "SELECT * FROM ContactInfoService WHERE taiKhoan = ?";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, taiKhoan);

            // Execute query
            rs = pstmt.executeQuery();

            // Process result
            if (rs.next()) {
                // Tìm thấy nhà cung cấp
                String sell_ID = rs.getString("sell_ID");
                String address = rs.getString("address");
                String email = rs.getString("email");
                String phoneNumber = rs.getString("phoneNumber");
                String workingHours = rs.getString("workingHours");
                String username = rs.getString("username");
                String gioiTinh = rs.getString("gioiTinh");
                String thongTinNganHang = rs.getString("thongTinNganHang");
                String stk = rs.getString("stk");
                String maSoThue = rs.getString("maSoThue");
                String facebook = rs.getString("facebook");
                String twitter = rs.getString("twitter");
                String instagram = rs.getString("instagram");
                String coverPhoto = rs.getString("coverPhoto");
                String avatar = rs.getString("avatar");
                String message = rs.getString("message");
                String metaBusiness = rs.getString("metaBusiness");

                // Tạo đối tượng ContactInfoService
                provider = new Service_Tuyen3_ContactInfoService(sell_ID, taiKhoan, username, email, phoneNumber, gioiTinh, thongTinNganHang, stk, maSoThue, facebook, twitter, instagram, address , workingHours, coverPhoto, avatar, message, metaBusiness);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // Đóng kết nối và các đối tượng liên quan
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return provider; // Trả về nhà cung cấp hoặc null nếu không tìm thấy
    }
    
    public static int updateContactInfo(String address, String email, String phone, String workingHours, String taiKhoan) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
        	conn = DBContext.getConnection();
            
            System.out.print("Connections success");

            // Prepare statement
            String query = "UPDATE ContactInfoService SET address = ?, email = ?, phoneNumber = ?, workingHours = ? WHERE taiKhoan = ?";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, address);
            pstmt.setString(2, email);
            pstmt.setString(3, phone);
            pstmt.setString(4, workingHours);
            pstmt.setString(5, taiKhoan);
            
            int rowsAffected = pstmt.executeUpdate();

            // Check if the update was successful
            if (rowsAffected > 0) {
            	System.out.println("Contact information updated successfully.");
                return 10;
            } else {
            	System.out.println("Failed to update contact information.");
                return 3;
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return 5;
        } finally {
            // Đóng kết nối và các đối tượng liên quan
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    public static int updateAccountInfo(String taiKhoan, String ID, String userName, String email, String phoneNumber, String gender, String thongTinNganHang, String stk, String maSoThue, String facebook, String twitter, String instagram) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
        	conn = DBContext.getConnection();

            // Prepare statement
            String query = "UPDATE ContactInfoService SET serviceID = ?, username = ?, email = ?, phoneNumber = ?, gioiTinh = ?, thongTinNganHang = ?, stk = ?, maSoThue = ?, facebook = ?, twitter = ?, instagram = ? WHERE taiKhoan = ?";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, ID);
            pstmt.setString(2, userName);
            pstmt.setString(3, email);
            pstmt.setString(4, phoneNumber);
            pstmt.setString(5, gender);
            pstmt.setString(6, thongTinNganHang);
            pstmt.setString(7, stk);
            pstmt.setString(8, maSoThue);
            pstmt.setString(9, facebook);
            pstmt.setString(10, twitter);
            pstmt.setString(11, instagram);
            pstmt.setString(12, taiKhoan);

            // Execute update
            int rowsAffected = pstmt.executeUpdate();

            // Check if the update was successful
            if (rowsAffected > 0) {
                System.out.println("Account information updated successfully.");
                return 10;
            } else {
                System.out.println("Failed to update account information.");
                return 3;
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return 5;
        } finally {
            // Close connection and related objects
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    public static int changePassword(String taiKhoan, String currentPass, String newPass, String confirmPass) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
        	conn = DBContext.getConnection();

            // Kiểm tra mật khẩu hiện tại
            String query = "SELECT Password FROM Accounts WHERE Username = ?";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, taiKhoan);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                String currentPasswordDB = rs.getString("Password");
                
                // Kiểm tra mật khẩu hiện tại có đúng không
                if (currentPasswordDB.equals(currentPass)) {
                    // Kiểm tra newPass và confirmPass có giống nhau không
                    if (newPass.equals(confirmPass)) {
                        // Update mật khẩu mới vào CSDL
                        query = "UPDATE Accounts SET Password = ? WHERE Username = ?";
                        pstmt = conn.prepareStatement(query);
                        pstmt.setString(1, newPass);
                        pstmt.setString(2, taiKhoan);

                        int rowsAffected = pstmt.executeUpdate();

                        // Kiểm tra nếu có hàng bị ảnh hưởng, tức là update thành công
                        if (rowsAffected > 0) {
                            System.out.println("Password changed successfully.");
                            return 10;
                        } else {
                            System.out.println("Failed to change password.");
                            return 5;
                        }
                    } else {
                        System.out.println("New password and confirm password do not match.");
                        return 4;
                    }
                } else {
                    System.out.println("Current password is incorrect.");
                    return 3;
                }
            } else {
                System.out.println("User not found.");
                return 2;
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return 1;
        } finally {
            // Đóng kết nối và các đối tượng liên quan
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

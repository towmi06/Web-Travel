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
        Service_Tuyen3_ContactInfoService service = new Service_Tuyen3_ContactInfoService();

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
            	service.setSell_ID(rs.getInt("sell_ID"));
                service.setTaiKhoan(rs.getString("taiKhoan"));
                service.setUsername(rs.getString("username"));
                service.setEmail(rs.getString("email"));
                service.setPhoneNumber(rs.getString("phoneNumber"));
                service.setGioiTinh(rs.getString("gioiTinh"));
                service.setThongTinNganHang(rs.getString("thongTinNganHang"));
                service.setStk(rs.getString("stk"));
                service.setMaSoThue(rs.getString("maSoThue"));
                service.setFacebook(rs.getString("facebook"));
                service.setTwitter(rs.getString("twitter"));
                service.setInstagram(rs.getString("instagram"));
                service.setAddress(rs.getString("address"));
                service.setWorkingHours(rs.getString("workingHours"));
                service.setCoverPhoto(rs.getString("coverPhoto"));
                service.setAvatar(rs.getString("avatar"));
                service.setMessage(rs.getString("message"));
                service.setMetaBusiness(rs.getString("metaBusiness"));
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
        return service; // Trả về nhà cung cấp
    }
    
    public static int updateContactInfo(String address, String email, String phone, String workingHours, String taiKhoan) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
        	conn = DBContext.getConnection();
        	
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
                return 10;
            } else {
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
    
    public static int updateAccountInfo(String taiKhoan, String userName, String email, String phoneNumber, String gender, String thongTinNganHang, String stk, String maSoThue, String facebook, String twitter, String instagram) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
        	conn = DBContext.getConnection();

            // Prepare statement
            String query = "UPDATE ContactInfoService SET username = ?, email = ?, phoneNumber = ?, gioiTinh = ?, thongTinNganHang = ?, stk = ?, maSoThue = ?, facebook = ?, twitter = ?, instagram = ? WHERE taiKhoan = ?";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, userName);
            pstmt.setString(2, email);
            pstmt.setString(3, phoneNumber);
            pstmt.setString(4, gender);
            pstmt.setString(5, thongTinNganHang);
            pstmt.setString(6, stk);
            pstmt.setString(7, maSoThue);
            pstmt.setString(8, facebook);
            pstmt.setString(9, twitter);
            pstmt.setString(10, instagram);
            pstmt.setString(11, taiKhoan);

            // Execute update
            int rowsAffected = pstmt.executeUpdate();

            // Check if the update was successful
            if (rowsAffected > 0) {
                return 10;
            } else {
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
                            return 10;
                        } else { 
                            return 5;
                        }
                    } else {
                        //Mật khẩu mới và xác nhận không trùng nhau
                        return 4;
                    }
                } else {
                    //Mật khẩu hiện tại không đúng
                    return 3;
                }
            } else {
                //Không tìm thấy user
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

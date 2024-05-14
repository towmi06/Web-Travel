package Service_Tuyen.setting_page;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ContactInfoService {
    private String taiKhoan;
    private String serviceID;
    private String username;
    private String email;
    private String phoneNumber;
    private String gioiTinh;
    private String thongTinNganHang;
    private String stk;
    private String maSoThue;
    private String facebook;
    private String twitter;
    private String instagram;
    private String address;
    private String workingHours;

    // Constructors
    public ContactInfoService() {
    }

    public ContactInfoService(String serviceID, String address, String email, String phoneNumber, String workingHours, String taiKhoan, String username, String gioiTinh, String thongTinNganHang, String stk, String maSoThue, String facebook, String twitter, String instagram) {
        this.serviceID = serviceID;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.workingHours = workingHours;
        this.taiKhoan = taiKhoan;
        this.username = username;
        this.gioiTinh = gioiTinh;
        this.thongTinNganHang = thongTinNganHang;
        this.stk = stk;
        this.maSoThue = maSoThue;
        this.facebook = facebook;
        this.twitter = twitter;
        this.instagram = instagram;
    }

    // Getter and setter methods
    public String getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public String getServiceID() {
        return serviceID;
    }

    public void setServiceID(String serviceID) {
        this.serviceID = serviceID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getThongTinNganHang() {
        return thongTinNganHang;
    }

    public void setThongTinNganHang(String thongTinNganHang) {
        this.thongTinNganHang = thongTinNganHang;
    }

    public String getStk() {
        return stk;
    }

    public void setStk(String stk) {
        this.stk = stk;
    }

    public String getMaSoThue() {
        return maSoThue;
    }

    public void setMaSoThue(String maSoThue) {
        this.maSoThue = maSoThue;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(String workingHours) {
        this.workingHours = workingHours;
    }

    // Override toString() method
    @Override
    public String toString() {
        return "ContactInfoService{" +
                "taiKhoan='" + taiKhoan + '\'' +
                ", serviceID='" + serviceID + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", gioiTinh='" + gioiTinh + '\'' +
                ", thongTinNganHang='" + thongTinNganHang + '\'' +
                ", stk='" + stk + '\'' +
                ", maSoThue='" + maSoThue + '\'' +
                ", facebook='" + facebook + '\'' +
                ", twitter='" + twitter + '\'' +
                ", instagram='" + instagram + '\'' +
                ", address='" + address + '\'' +
                ", workingHours='" + workingHours + '\'' +
                '}';
    }
    
    public static ContactInfoService findProviderByCredentials(String taiKhoan) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ContactInfoService provider = null;

        try {
            // Load SQLServer JDBC driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // Establish connection
            String urlDB = "jdbc:sqlserver://DESKTOP-00GD31A\\LEY:1433;databaseName=WEB TOUR";
            String user = "sa";
            String password = "12345";
            conn = DriverManager.getConnection(urlDB, user, password);

            // Prepare statement
            String query = "SELECT * FROM ContactInfoService WHERE taiKhoan = ?";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, taiKhoan);

            // Execute query
            rs = pstmt.executeQuery();

            // Process result
            if (rs.next()) {
                // Tìm thấy nhà cung cấp
                String serviceID = rs.getString("serviceID");
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

                // Tạo đối tượng ContactInfoService
                provider = new ContactInfoService(serviceID, address, email, phoneNumber, workingHours, taiKhoan, username, gioiTinh, thongTinNganHang, stk, maSoThue, facebook, twitter, instagram);
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
            // Load SQLServer JDBC driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // Establish connection
            String urlDB = "jdbc:sqlserver://DESKTOP-00GD31A\\LEY:1433;databaseName=WEB TOUR";
            String user = "sa";
            String password = "12345";
            conn = DriverManager.getConnection(urlDB, user, password);
            
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
            // Load SQLServer JDBC driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // Establish connection
            String urlDB = "jdbc:sqlserver://DESKTOP-00GD31A\\LEY:1433;databaseName=WEB TOUR";
            String user = "sa";
            String password = "12345";
            conn = DriverManager.getConnection(urlDB, user, password);

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
            // Load SQLServer JDBC driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // Establish connection
            String urlDB = "jdbc:sqlserver://DESKTOP-00GD31A\\LEY:1433;databaseName=WEB TOUR";
            String user = "sa";
            String password = "12345";
            conn = DriverManager.getConnection(urlDB, user, password);

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


    public static void main(String[] args) {
        // Thông tin cần cập nhật
        String taiKhoan = "hagiangtravel@gmail.com";
        String ID = "NCC001";
        String userName = "Ha Giang Travel";
        String email = "hagiangtravel@gmail.com";
        String phoneNumber = "0987213671";
        String gender = "Nam";
        String thongTinNganHang = "ACB";
        String stk = "123456789";
        String maSoThue = "9471781";
        String facebook = "facebook.com";
        String twitter = "twitter.com";
        String instagram = "instagram.com";

        // Gọi hàm updateAccountInfo để cập nhật thông tin tài khoản
        ContactInfoService.updateAccountInfo(taiKhoan, ID, userName, email, phoneNumber, gender, thongTinNganHang, stk, maSoThue, facebook, twitter, instagram);
        changePassword("taxuatravel@gmail.com", "taxuaaaa", "taxua.12345", "taxua.12345");
   }
}
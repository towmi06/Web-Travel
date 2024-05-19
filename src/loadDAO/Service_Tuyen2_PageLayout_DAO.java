package loadDAO;

import context.DBContext;
import entity.Service_Tuyen2_PageLayout;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Service_Tuyen2_PageLayout_DAO {
	public static Service_Tuyen2_PageLayout findByTaiKhoan(String taiKhoan) throws ClassNotFoundException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Service_Tuyen2_PageLayout pageLayout = new Service_Tuyen2_PageLayout();

        try {
        	conn = DBContext.getConnection();

            // Chuẩn bị câu truy vấn
            String query = "SELECT * FROM PageLayout WHERE taiKhoan = ?";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, taiKhoan);

            // Thực hiện truy vấn
            rs = pstmt.executeQuery();

            // Xử lý kết quả trả về
            if (rs.next()) {
            	pageLayout.setSapXep(rs.getBoolean("sapXep"));
            	pageLayout.setDichVuNoiBat(rs.getBoolean("dichVuNoiBat"));
            	pageLayout.setChuongTrinhKhuyenMai(rs.getBoolean("chuongTrinhKhuyenMai"));
            	pageLayout.setHienThi(rs.getBoolean("hienThi"));  
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Đóng kết nối và các tài nguyên liên quan
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return pageLayout;
    }
    
    public static int updatePageLayout(String taiKhoan, boolean sapXep, boolean dichVuNoiBat, boolean chuongTrinhKhuyenMai, boolean hienThi) throws ClassNotFoundException {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
        	conn = DBContext.getConnection();
            // Prepare SQL statement
            String query = "UPDATE PageLayout SET sapXep = ?, dichVuNoiBat = ?, chuongTrinhKhuyenMai = ?, hienThi = ? WHERE taiKhoan = ?";
            pstmt = conn.prepareStatement(query);
            pstmt.setBoolean(1, sapXep);
            pstmt.setBoolean(2, dichVuNoiBat);
            pstmt.setBoolean(3, chuongTrinhKhuyenMai);
            pstmt.setBoolean(4, hienThi);
            pstmt.setString(5, taiKhoan);

            // Execute update
            int rowsAffected = pstmt.executeUpdate();
            
            if (rowsAffected > 0) {
                return 10;
            } else {
                return 3;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return 5;
        } finally {
            // Close connection and related resources
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

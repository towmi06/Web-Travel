package Service_Tuyen.setting_page;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PageLayout {
    private String taiKhoan;
    private boolean sapXep;
    private boolean dichVuNoiBat;
    private boolean chuongTrinhKhuyenMai;
    private int soSanPhamMoiTrang;

    // Constructors
    public PageLayout() {
    }

    public PageLayout(String taiKhoan, boolean sapXep, boolean dichVuNoiBat, boolean chuongTrinhKhuyenMai, int soSanPhamMoiTrang) {
        this.taiKhoan = taiKhoan;
        this.sapXep = sapXep;
        this.dichVuNoiBat = dichVuNoiBat;
        this.chuongTrinhKhuyenMai = chuongTrinhKhuyenMai;
        this.soSanPhamMoiTrang = soSanPhamMoiTrang;
    }

    // Getter and setter methods
    public String getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public boolean getSapXep() {
        return sapXep;
    }

    public void setSapXep(boolean sapXep) {
        this.sapXep = sapXep;
    }

    public boolean getDichVuNoiBat() {
        return dichVuNoiBat;
    }

    public void setDichVuNoiBat(boolean dichVuNoiBat) {
        this.dichVuNoiBat = dichVuNoiBat;
    }

    public boolean getChuongTrinhKhuyenMai() {
        return chuongTrinhKhuyenMai;
    }

    public void setChuongTrinhKhuyenMai(boolean chuongTrinhKhuyenMai) {
        this.chuongTrinhKhuyenMai = chuongTrinhKhuyenMai;
    }

    public int getSoSanPhamMoiTrang() {
        return soSanPhamMoiTrang;
    }

    public void setSoSanPhamMoiTrang(int soSanPhamMoiTrang) {
        this.soSanPhamMoiTrang = soSanPhamMoiTrang;
    }

    // Override toString() method
    @Override
    public String toString() {
        return "PageLayout{" +
                "taiKhoan='" + taiKhoan + '\'' +
                ", sapXep=" + sapXep +
                ", dichVuNoiBat=" + dichVuNoiBat +
                ", chuongTrinhKhuyenMai=" + chuongTrinhKhuyenMai +
                ", soSanPhamMoiTrang=" + soSanPhamMoiTrang +
                '}';
    }
    
    public static PageLayout findByTaiKhoan(String taiKhoan) throws ClassNotFoundException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        PageLayout pageLayout = null;

        try {
        	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

	        // Establish connection
	        String urlDB = "jdbc:sqlserver://DESKTOP-00GD31A\\LEY:1433;databaseName=WEB TOUR";
            String user = "sa";
            String password = "12345";
            conn = DriverManager.getConnection(urlDB, user, password);

            // Chuẩn bị câu truy vấn
            String query = "SELECT * FROM PageLayout WHERE taiKhoan = ?";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, taiKhoan);

            // Thực hiện truy vấn
            rs = pstmt.executeQuery();

            // Xử lý kết quả trả về
            if (rs.next()) {
                // Lấy các giá trị từ cơ sở dữ liệu
                boolean sapXep = rs.getBoolean("sapXep");
                boolean dichVuNoiBat = rs.getBoolean("dichVuNoiBat");
                boolean chuongTrinhKhuyenMai = rs.getBoolean("chuongTrinhKhuyenMai");
                int soSanPhamMoiTrang = rs.getInt("soSanPhamMoiTrang");

                // Khởi tạo đối tượng PageLayout
                pageLayout = new PageLayout(taiKhoan, sapXep, dichVuNoiBat, chuongTrinhKhuyenMai, soSanPhamMoiTrang);
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
    
    public static int updatePageLayout(String taiKhoan, boolean sapXep, boolean dichVuNoiBat, boolean chuongTrinhKhuyenMai, int soSanPhamMoiTrang) throws ClassNotFoundException {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // Establish connection
            String urlDB = "jdbc:sqlserver://DESKTOP-00GD31A\\LEY:1433;databaseName=WEB TOUR";
            String user = "sa";
            String password = "12345";
            conn = DriverManager.getConnection(urlDB, user, password);

            // Prepare SQL statement
            String query = "UPDATE PageLayout SET sapXep = ?, dichVuNoiBat = ?, chuongTrinhKhuyenMai = ?, soSanPhamMoiTrang = ? WHERE taiKhoan = ?";
            pstmt = conn.prepareStatement(query);
            pstmt.setBoolean(1, sapXep);
            pstmt.setBoolean(2, dichVuNoiBat);
            pstmt.setBoolean(3, chuongTrinhKhuyenMai);
            pstmt.setInt(4, soSanPhamMoiTrang);
            pstmt.setString(5, taiKhoan);

            // Execute update
            int rowsAffected = pstmt.executeUpdate();
            
            if (rowsAffected > 0) {
                System.out.println("Page layout updated successfully.");
                return 10;
            } else {
                System.out.println("Failed to update page layout.");
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

    
    public static void main(String[] args) throws ClassNotFoundException {
    	updatePageLayout("hagiangtravel@gmail.com", true, true, true, 9);
    }
}

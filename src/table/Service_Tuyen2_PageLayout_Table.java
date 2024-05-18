package table;

import context.DBContext;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Service_Tuyen2_PageLayout_Table {

    public static void main(String[] args) throws ClassNotFoundException {
    	Connection conn = null;
        Statement stmt = null;
    	
        try {
        	conn = DBContext.getConnection();
            
            // Create statement
            stmt = conn.createStatement();
	        // Câu lệnh tạo bảng
	        String sql = "CREATE TABLE PageLayout ("
	                + "taiKhoan NVARCHAR(255), "
	                + "sapXep BIT, "
	                + "dichVuNoiBat BIT, "
	                + "chuongTrinhKhuyenMai BIT, "
	                + "hienThi BIT"
	                + ")";
	
	        // Execute query
            stmt.executeUpdate(sql);
            
            System.out.println("Table created successfully.");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // Close connection and statement
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
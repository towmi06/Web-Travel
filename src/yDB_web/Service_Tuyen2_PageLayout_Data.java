package yDB_web;

import context.DBContext;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Service_Tuyen2_PageLayout_Data {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
        	 conn = DBContext.getConnection();
            
            // Connection success message
            System.out.println("Connection success!");

            // Prepare statement for data insertion
         // Prepare statement for data insertion
            String insertSQL = "INSERT INTO PageLayout (taiKhoan, sapXep, dichVuNoiBat, chuongTrinhKhuyenMai, hienThi) VALUES (?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(insertSQL);

            // Insert data into the table
            String[] pageLayoutData = {
                "hagiangtravel@gmail.com", "true", "true", "true", "true",
                "taxuatravel@gmail.com", "true", "true", "true", "true",
                "mucangtrai@gmail.com", "true", "true", "true", "true"
            };

            for (int i = 0; i < pageLayoutData.length; i += 5) {
                pstmt.setString(1, pageLayoutData[i]);
                pstmt.setBoolean(2, Boolean.parseBoolean(pageLayoutData[i + 1]));
                pstmt.setBoolean(3, Boolean.parseBoolean(pageLayoutData[i + 2]));
                pstmt.setBoolean(4, Boolean.parseBoolean(pageLayoutData[i + 3]));
                pstmt.setBoolean(5, Boolean.parseBoolean(pageLayoutData[i + 3]));
                pstmt.executeUpdate();
            }

            System.out.println("Data inserted successfully.");

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

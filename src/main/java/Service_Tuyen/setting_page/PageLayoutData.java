package Service_Tuyen.setting_page;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PageLayoutData {
    public static void main(String[] args) {
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
            
            // Connection success message
            System.out.println("Connection success!");

            // Prepare statement for data insertion
         // Prepare statement for data insertion
            String insertSQL = "INSERT INTO PageLayout (taiKhoan, sapXep, dichVuNoiBat, chuongTrinhKhuyenMai, soSanPhamMoiTrang) VALUES (?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(insertSQL);

            // Insert data into the table
            String[] pageLayoutData = {
                "hagiangtravel@gmail.com", "true", "true", "true", "3",
                "taxuatravel@gmail.com", "true", "true", "true", "3",
                "mucangtrai@gmail.com", "true", "true", "true", "3"
            };

            for (int i = 0; i < pageLayoutData.length; i += 5) {
                pstmt.setString(1, pageLayoutData[i]);
                pstmt.setBoolean(2, Boolean.parseBoolean(pageLayoutData[i + 1]));
                pstmt.setBoolean(3, Boolean.parseBoolean(pageLayoutData[i + 2]));
                pstmt.setBoolean(4, Boolean.parseBoolean(pageLayoutData[i + 3]));
                pstmt.setInt(5, Integer.parseInt(pageLayoutData[i + 4]));
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

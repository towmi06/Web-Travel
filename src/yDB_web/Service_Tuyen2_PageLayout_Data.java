package yDB_web;

import context.DBContext;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Service_Tuyen2_PageLayout_Data {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        PreparedStatement pstmt = null;

        try {
            conn = DBContext.getConnection();

            // Connection success message
            System.out.println("Connection success!");

            // Create table query
            String createTableSQL = "CREATE TABLE PageLayout ("
                    + "taiKhoan NVARCHAR(255), "
                    + "sapXep BIT, "
                    + "dichVuNoiBat BIT, "
                    + "chuongTrinhKhuyenMai BIT, "
                    + "hienThi BIT"
                    + ")";

            stmt = conn.createStatement();
            stmt.executeUpdate(createTableSQL);
            System.out.println("Table created successfully.");

            // Prepare statement for data insertion
            String insertSQL = "INSERT INTO PageLayout (taiKhoan, sapXep, dichVuNoiBat, chuongTrinhKhuyenMai, hienThi) VALUES (?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(insertSQL);

            // Data array
            String[][] pageLayoutData = {
                {"hagiangtravel@gmail.com", "true", "true", "true", "true"},
                {"taxuatravel@gmail.com", "true", "true", "true", "true"},
                {"mucangtrai@gmail.com", "true", "true", "true", "true"}
            };

            // Insert data into the table
            for (String[] row : pageLayoutData) {
                pstmt.setString(1, row[0]);
                pstmt.setBoolean(2, Boolean.parseBoolean(row[1]));
                pstmt.setBoolean(3, Boolean.parseBoolean(row[2]));
                pstmt.setBoolean(4, Boolean.parseBoolean(row[3]));
                pstmt.setBoolean(5, Boolean.parseBoolean(row[4]));
                pstmt.executeUpdate();
            }

            System.out.println("Data inserted successfully.");

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (stmt != null) stmt.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

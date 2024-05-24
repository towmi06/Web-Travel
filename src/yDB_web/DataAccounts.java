package yDB_web;

import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DataAccounts {
    public static void main(String[] args) throws ClassNotFoundException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        Statement stmt = null;

        try {
            // Get connection from DBContext
            conn = DBContext.getConnection();
            System.out.println("Connection success!");

            // Create statement
            stmt = conn.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS accounts (" +
                            "ID INT PRIMARY KEY," +
                            "Username VARCHAR(50) NOT NULL," +
                            "Password VARCHAR(50) NOT NULL," +
                            "Role VARCHAR(20) NOT NULL" +
                         ")";
            stmt.executeUpdate(sql);
            System.out.println("Table 'accounts' created successfully.");

            // Prepare statement for data insertion
            String insertSQL = "INSERT INTO accounts (ID, Username, Password, Role) VALUES (?, ?, ?, ?)";
            pstmt = conn.prepareStatement(insertSQL);

            // Insert data into the table
            String[] accountData = {
                "11, vumanhquan@admin.com, quan@12345, admin",
                "12, nguyenminhdung@admin.com, dung@12345, admin",
                "13, phamhailong@admin.com, long@12345, admin",
                "01, hagiangtravel@gmail.com, hagiang.12345, service",
                "02, taxuatravel@gmail.com, taxua.12345, service",
                "03, mucangtrai@gmail.com, mucangtrai.12345, service",
                "31, hailong@gmail.com, hailong.12345, customer",
                "32, conganh@gmail.com, conganh.12345, customer",
                "33, minhdung@gmail.com, minhdung.12345, customer"
            };

            for (String data : accountData) {
                String[] values = data.split(", ");
                pstmt.setInt(1, Integer.parseInt(values[0]));
                pstmt.setString(2, values[1]);
                pstmt.setString(3, values[2]);
                pstmt.setString(4, values[3]);
                pstmt.executeUpdate();
            }

            System.out.println("Data inserted successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (stmt != null) {
                    stmt.close();
                }
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
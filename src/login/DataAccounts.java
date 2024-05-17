package login;

import context.DBContext;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataAccounts {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
        	conn = DBContext.getConnection();
            // Connection success message
            System.out.println("Connection success!");

            // Prepare statement for data insertion
            String insertSQL = "INSERT INTO Accounts (ID, Username, Password, Role) VALUES (?, ?, ?, ?)";
            pstmt = conn.prepareStatement(insertSQL);

            // Insert data into the table
            String[] accountData = {
                "11, vumanhquan@admin.com, quan@12345, admin",
                "12, nguyenminhdung@admin.com, dung@12345, admin",
                "13, phamhailong@admin.com, long@12345, admin",
                "01, hagiangtravel@gmail.com, hagiang.12345, service",
                "02, taxuatravel@gmail.com, taxua.12345, service",
                "03, mucangtrai@gmail.com, mucangtrai.12345, service",
                "21, hailong@gmail.com, hailong.12345, customer",
                "22, conganh@gmail.com, conganh.12345, customer",
                "23, minhdung@gmail.com, minhdung.12345, customer"
            };

            for (String data : accountData) {
                String[] values = data.split(", ");
                pstmt.setString(1, values[0]);
                pstmt.setString(2, values[1]);
                pstmt.setString(3, values[2]);
                pstmt.setString(4, values[3]);
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

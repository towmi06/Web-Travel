package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataAccounts {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            // Load driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // Establish connection
            String urlDB = "jdbc:sqlserver://DESKTOP-HM360E0\\MSSQLSERVER04:1433;databaseName=Web Travel";
            String user = "sa";
            String password = "12345";
            conn = DriverManager.getConnection(urlDB, user, password);
            // Connection success message
            System.out.println("Connection success!");

            // Prepare statement for data insertion
            String insertSQL = "INSERT INTO Accounts (ID, Username, Password, Role) VALUES (?, ?, ?, ?)";
            pstmt = conn.prepareStatement(insertSQL);

            // Insert data into the table
            String[] accountData = {
                "ACC001, vumanhquan@admin.com, quan@12345, admin",
                "ACC002, nguyenminhdung@admin.com, dung@12345, admin",
                "ACC003, phamhailong@admin.com, long@12345, admin",
                "ACC004, hagiangtravel@gmail.com, hagiang.12345, service",
                "ACC005, taxuatravel@gmail.com, taxua.12345, service",
                "ACC006, mucangtrai@gmail.com, mucangtrai.12345, service",
                "ACC007, hailong@gmail.com, hailong.12345, customer",
                "ACC008, conganh@gmail.com, conganh.12345, customer",
                "ACC009, minhdung@gmail.com, minhdung.12345, customer"
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

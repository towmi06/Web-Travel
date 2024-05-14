package Admin_Quan.bill_managenment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class BillManagenmentData {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            // Load the SQL Server JDBC driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // Establish connection
            String urlDB = "jdbc:sqlserver://DESKTOP-HM360E0\\MSSQLSERVER04:1433;databaseName=Web Travel";
            String user = "sa";
            String password = "12345";
            conn = DriverManager.getConnection(urlDB, user, password);

            // Prepare statement
            String insertSQL = "INSERT INTO BillManagenment (ID, providerID, customerID, tourName, destination, departureDate, numberOfPeople, price, address, type, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(insertSQL);

            // Insert data into the table
            String[] billData = {
                "HD001", "NCC001", "KH001", "Đảo Phú Quốc", "Phú Quốc, Kiên Giang", "15/05/2024", "4", "5000000", "Hồ Chí Minh", "Tham Quan", "Chưa Xác Nhận",
                "HD002", "NCC002", "KH002", "Đảo Phú Quốc", "Phú Quốc, Kiên Giang", "15/05/2024", "4", "5000000", "Hồ Chí Minh", "Tham Quan", "Đã Xác Nhận",
                "HD003", "NCC002", "KH002", "Đảo Phú Quốc", "Phú Quốc, Kiên Giang", "15/05/2024", "4", "5000000", "Hồ Chí Minh", "Tham Quan", "Đang Diễn Ra",
                "HD004", "NCC002", "KH002", "Đảo Phú Quốc", "Phú Quốc, Kiên Giang", "15/05/2024", "4", "5000000", "Hồ Chí Minh", "Tham Quan", "Hoàn Thành",
                "HD005", "NCC002", "KH002", "Đảo Phú Quốc", "Phú Quốc, Kiên Giang", "15/05/2024", "4", "5000000", "Hồ Chí Minh", "Tham Quan", "Hủy"
            };

            // Loop through the array and insert data into the table
            for (int i = 0; i < billData.length; i += 11) {
                pstmt.setString(1, billData[i]);
                pstmt.setString(2, billData[i + 1]);
                pstmt.setString(3, billData[i + 2]);
                pstmt.setString(4, billData[i + 3]);
                pstmt.setString(5, billData[i + 4]);
                pstmt.setString(6, billData[i + 5]);
                pstmt.setInt(7, Integer.parseInt(billData[i + 6]));
                pstmt.setLong(8, Long.parseLong(billData[i + 7]));
                pstmt.setString(9, billData[i + 8]);
                pstmt.setString(10, billData[i + 9]);
                pstmt.setString(11, billData[i + 10]);

                pstmt.executeUpdate();
            }

            System.out.println("Data inserted successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Close PreparedStatement
                if (pstmt != null) {
                    pstmt.close();
                }
                // Close Connection
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

package Admin_Quan.tour_managenment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class TourManagenmentData {
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
            String insertSQL = "INSERT INTO TourManagenment (ID, providerID, tourName, destination, departureDate, price, address, type) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(insertSQL);

            // Insert data into the table
            String[] tourData = {
                "T001", "NCC001", "Đảo Phú Quốc", "Phú Quốc, Kiên Giang", "2024-05-15", "5000000", "Hồ Chí Minh", "Tham Quan",
                "T002", "NCC001", "Đảo Phú Quốc", "Phú Quốc, Kiên Giang", "2024-05-15", "5000000", "Hồ Chí Minh", "Tham Quan",
                "T003", "NCC002", "Đảo Phú Quốc", "Phú Quốc, Kiên Giang", "2024-05-15", "7000000", "Hồ Chí Minh", "Tham Quan"
            };

            // Loop through the array and insert data into the table
            for (int i = 0; i < tourData.length; i += 8) {
                pstmt.setString(1, tourData[i]);
                pstmt.setString(2, tourData[i + 1]);
                pstmt.setString(3, tourData[i + 2]);
                pstmt.setString(4, tourData[i + 3]);
                pstmt.setString(5, tourData[i + 4]);
                pstmt.setLong(6, Long.parseLong(tourData[i + 5]));
                pstmt.setString(7, tourData[i + 6]);
                pstmt.setString(8, tourData[i + 7]);

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

package customer_care;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BillData {
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
            String insertSQL = "INSERT INTO Bill (ID, providerID, customerID, tourName, destination, departureDate, numberOfPeople, price, address, type) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(insertSQL);

            // Insert data into the table
            String[] billData = {
                "HD001", "NCC001", "KH001", "Đảo Phú Quốc", "Phú Quốc, Kiên Giang", "15/05/2024", "4", "5000000", "Hồ Chí Minh", "Tham Quan",
                "HD002", "NCC002", "KH002", "Đảo Phú Quốc", "Phú Quốc, Kiên Giang", "15/05/2024", "4", "5000000", "Hồ Chí Minh", "Tham Quan",
                "HD003", "NCC002", "KH002", "Đảo Phú Quốc", "Phú Quốc, Kiên Giang", "15/05/2024", "4", "5000000", "Hồ Chí Minh", "Tham Quan"
            };

            // Loop through the array and insert data into the table
            for (int i = 0; i < billData.length; i += 10) {
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

                pstmt.executeUpdate();
            }

            System.out.println("Data inserted successfully.");

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

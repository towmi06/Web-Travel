package setting_page;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

public class OutStandingServiceData {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            // Load driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // Establish connection
            String urlDB = "jdbc:sqlserver://DESKTOP-00GD31A\\LEY:1433;databaseName=WEB TOUR";
            String user = "sa";
            String password = "12345";
            conn = DriverManager.getConnection(urlDB, user, password);

            // SQL statement to insert tour data
            String insertSQL = "INSERT INTO outstanding_services (ID, rate, sales, tourName, destination, departureDate, price, address, category, outstanding) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            pstmt = conn.prepareStatement(insertSQL);

            // Generate 20 tours
            for (int i = 1; i <= 20; i++) {
                // Generate ID
                String ID = "T" + String.format("%03d", i);

                // Generate random rate between 3.0 and 5.0 with one decimal place
                float rate = (float) (3.0 + Math.random() * (5.0 - 3.0));
                rate = (float) Math.round(rate * 10) / 10; // Round to one decimal place

                // Generate random sales between 1000 and 5000
                long sales = (long) (1000 + Math.random() * (5000 - 1000));

                // Generate tourName, destination, departureDate, price, address, category
                // For simplicity, these values are hardcoded
                String tourName = "Tour " + i;
                String destination = "Destination " + i;
                String departureDate = "15/05/2024";
                int price = 5000000;
                String address = "Ho Chi Minh";
                String category = "Tham Quan";
                boolean outstanding = false;
                
                // Set values in prepared statement
                pstmt.setString(1, ID);
                pstmt.setFloat(2, rate);
                pstmt.setLong(3, sales);
                pstmt.setString(4, tourName);
                pstmt.setString(5, destination);
                pstmt.setString(6, departureDate);
                pstmt.setInt(7, price);
                pstmt.setString(8, address);
                pstmt.setString(9, category);
                pstmt.setBoolean(10, outstanding);

                // Execute the SQL statement
                pstmt.executeUpdate();
            }

            // Connection success message
            System.out.println("Tours inserted successfully!");

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

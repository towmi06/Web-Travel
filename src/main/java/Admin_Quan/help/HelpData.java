package Admin_Quan.help;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class HelpData {
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
            String insertSQL = "INSERT INTO Help (idCauHoi, cauHoi, cauTraLoi) VALUES (?, ?, ?)";
            pstmt = conn.prepareStatement(insertSQL);

            // Insert data into the table
            String[][] helpData = {
                {"QA001", "Câu hỏi 1", "Câu trả lời 1"},
                {"QA002", "Câu hỏi 2", "Câu trả lời 2"},
                {"QA003", "Câu hỏi 3", "Câu trả lời 3"}
            };

            for (String[] data : helpData) {
                pstmt.setString(1, data[0]); // idCauHoi
                pstmt.setString(2, data[1]); // cauHoi
                pstmt.setString(3, data[2]); // cauTraLoi
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
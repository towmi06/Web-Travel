package yDB_web;

import context.DBContext;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Admin_Quan_Cooperate_Data {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
        	conn = DBContext.getConnection();
            // Connection success message
            System.out.println("Connection success!");
            
            // Create table query
            String createTableSQL = "CREATE TABLE Cooperate (" +
                    "tenNCC NVARCHAR(255)," +
                    "email NVARCHAR(255)," +
                    "soDienThoai NVARCHAR(20)," +
                    "diaChi NVARCHAR(255)," +
                    "ngayGui NVARCHAR(20)," +
                    "noiDungHopTac NVARCHAR(MAX)," +
                    ")";

            // Create a Statement object
            Statement statement = conn.createStatement();

            // Execute the query to create the table
            statement.executeUpdate(createTableSQL);
            
            System.out.println("Table created successfully.");

            // Prepare statement for data insertion
            String insertSQL = "INSERT INTO Cooperate (tenNCC, email, soDienThoai, diaChi, ngayGui, noiDungHopTac) VALUES (?, ?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(insertSQL);

            // Insert data into the table
            String[] cooperateData = {
                "Ha Giang Travel, hagiangtravel@gmail.com, 0912471744, Ha Giang, 2024-05-11, Nội dung hợp tác 1",
                "Ta Xua Travel, taxuatravel@gmail.com, 0987654321, Ta Xua, 2024-05-12, Nội dung hợp tác 2",
                "Mu Cang Trai Travel, mucangtrai@gmail.com, 0374712841, Mu Cang Trai, 2024-05-13, Nội dung hợp tác 3"
            };

            for (String data : cooperateData) {
                String[] values = data.split(", ");
                pstmt.setString(1, values[0]);
                pstmt.setString(2, values[1]);
                pstmt.setString(3, values[2]);
                pstmt.setString(4, values[3]);
                pstmt.setString(5, values[4]);
                pstmt.setString(6, values[5]);
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

package yDB_web;

import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

public class Service_Tuyen1_OutStanding_Data {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = DBContext.getConnection();
            
         // Create table statement
            String createTableSQL = "CREATE TABLE OutstandingService ("
                    + "id VARCHAR(10) PRIMARY KEY,"
                    + "sell_ID VARCHAR(50),"
                    + "cateID VARCHAR(50),"
                    + "rate FLOAT,"
                    + "sales BIGINT,"
                    + "tourName NVARCHAR(50),"
                    + "image NVARCHAR(50),"
                    + "journeys NVARCHAR(MAX),"
                    + "date NVARCHAR(50),"
                    + "price INT,"
                    + "outstanding BIT"
                    + ")";

            stmt = conn.createStatement();

            // Execute the SQL statement
            stmt.executeUpdate(createTableSQL);

            // Connection success message
            System.out.println("Table created successfully!");

            // SQL statement to retrieve data from the 'tour' table
            String selectSQL = "SELECT id, sell_ID, cateID, tourName, image, journeys, date, price FROM tour";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(selectSQL);

            // SQL statement to insert tour data into the 'OutstandingService' table
            String insertSQL = "INSERT INTO OutstandingService (id, sell_ID, cateID, tourName, image, journeys, date, price, rate, sales, outstanding) " +
                               "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            pstmt = conn.prepareStatement(insertSQL);

            Random random = new Random();

            // Loop through the result set and insert data into the 'OutstandingService' table
            while (rs.next()) {
                String id = rs.getString("id");
                String sell_ID = rs.getString("sell_ID");
                String cateID = rs.getString("cateID");
                String tourName = rs.getString("tourName");
                String image = rs.getString("image");
                String journeys = rs.getString("journeys");
                String date = rs.getString("date");
                int price = rs.getInt("price");
                float rate = random.nextFloat() * 5;  
                long sales = random.nextInt(1000);    

                pstmt.setString(1, id);
                pstmt.setString(2, sell_ID);
                pstmt.setString(3, cateID);
                pstmt.setString(4, tourName);
                pstmt.setString(5, image);
                pstmt.setString(6, journeys);
                pstmt.setString(7, date);
                pstmt.setInt(8, price);
                pstmt.setFloat(9, rate);
                pstmt.setLong(10, sales);
                pstmt.setBoolean(11, false);  

                pstmt.executeUpdate();
            }

            // Connection success message
            System.out.println("Data inserted successfully!");

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (rs != null) {
                    rs.close();
                }
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

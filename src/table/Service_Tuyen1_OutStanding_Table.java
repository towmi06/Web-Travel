package table;

import context.DBContext;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Service_Tuyen1_OutStanding_Table {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
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

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (stmt != null) {
                    stmt.close();
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

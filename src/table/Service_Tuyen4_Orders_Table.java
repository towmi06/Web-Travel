package table;

import context.DBContext;

import java.sql.Connection;
import java.sql.Statement;

public class Service_Tuyen4_Orders_Table {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        
        try {
            conn = DBContext.getConnection();

            // Create table
            Statement statement = conn.createStatement();
            String createTableSQL = "CREATE TABLE Orders (" +
                    "ID VARCHAR(50) PRIMARY KEY," +
                    "sell_ID VARCHAR(50)," +
                    "customer_ID VARCHAR(50)," +
                    "tour_ID VARCHAR(50)," +
                    "booking_date VARCHAR(50)," +
                    "tourName NVARCHAR(100)," +
                    "date NVARCHAR(100)," +
                    "numberOfPeople INT," +
                    "price BIGINT," +
                    "type NVARCHAR(50)," +
                    "status NVARCHAR(50)" +
                    ")";
            statement.executeUpdate(createTableSQL);
            System.out.println("Table created successfully.");

            // Close connection
            statement.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

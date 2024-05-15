package Admin_Quan.tour_managenment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TourManagenmentTable {
    public static void main(String[] args) {
        // JDBC connection variables
        String url = "jdbc:sqlserver://DESKTOP-HM360E0\\MSSQLSERVER04:1433;databaseName=Web Travel";
        String user = "sa";
        String password = "12345";

        // SQL statement to create table
        String sql = "CREATE TABLE TourManagenment (" +
                "ID VARCHAR(10) PRIMARY KEY," +
                "providerID VARCHAR(10)," +
                "tourName NVARCHAR(255)," +
                "destination NVARCHAR(255)," +
                "departureDate NVARCHAR(255)," +
                "price BIGINT," +
                "address NVARCHAR(255)," +
                "type NVARCHAR(50)" +
                ")";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement()) {
            // Execute SQL statement
            statement.executeUpdate(sql);
            System.out.println("Table created successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

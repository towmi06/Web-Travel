package bill_managenment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class BillManagenmentTable {
    public static void main(String[] args) {
        try {
            // Load the SQL Server JDBC driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // Establish connection
            String urlDB = "jdbc:sqlserver://DESKTOP-HM360E0\\MSSQLSERVER04:1433;databaseName=Web Travel";
            String user = "sa";
            String password = "12345";
            Connection connection = DriverManager.getConnection(urlDB, user, password);

            // Create table
            Statement statement = connection.createStatement();
            String createTableSQL = "CREATE TABLE BillManagenment (" +
                    "ID VARCHAR(50) PRIMARY KEY," +
                    "providerID VARCHAR(50)," +
                    "customerID VARCHAR(50)," +
                    "tourName NVARCHAR(100)," +
                    "destination NVARCHAR(100)," +
                    "departureDate NVARCHAR(20)," +
                    "numberOfPeople INT," +
                    "price BIGINT," +
                    "address NVARCHAR(200)," +
                    "type NVARCHAR(50)," +
                    "status NVARCHAR(50)" +
                    ")";
            statement.executeUpdate(createTableSQL);
            System.out.println("Table created successfully.");

            // Close connection
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
package cooperate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CooperateTable {
    public static void main(String[] args) {
        try {
            // Load the SQL Server JDBC driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // Establish connection
            String urlDB = "jdbc:sqlserver://DESKTOP-HM360E0\\MSSQLSERVER04:1433;databaseName=Web Travel";
            String user = "sa";
            String password = "12345";
            Connection connection = DriverManager.getConnection(urlDB, user, password);

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
            Statement statement = connection.createStatement();

            // Execute the query to create the table
            statement.executeUpdate(createTableSQL);
            
            System.out.println("Table created successfully.");

            // Close statement and connection
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}

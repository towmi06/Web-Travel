package help;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class HelpTable {
    public static void main(String[] args) {
        // Load the SQL Server JDBC driver
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            // Establish connection
            String urlDB = "jdbc:sqlserver://DESKTOP-HM360E0\\MSSQLSERVER04:1433;databaseName=Web Travel";
            String user = "sa";
            String password = "12345";
            Connection connection = DriverManager.getConnection(urlDB, user, password);
            
            // Create table
            Statement statement = connection.createStatement();
            String sql = "CREATE TABLE Help (" +
                    "idCauHoi VARCHAR(50) PRIMARY KEY," +
                    "cauHoi NVARCHAR(255)," +
                    "cauTraLoi NVARCHAR(255)" +
                    ")";
            statement.executeUpdate(sql);
            System.out.println("Table created successfully.");
            
            // Close connection
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}

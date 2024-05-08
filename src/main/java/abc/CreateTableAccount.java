package abc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTableAccount {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
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

            // Create table
            stmt = conn.createStatement();
            String sql = "CREATE TABLE Accounts (" +
                            "ID VARCHAR(10) PRIMARY KEY," +
                            "Username VARCHAR(50) NOT NULL," +
                            "Password VARCHAR(50) NOT NULL," +
                            "Role VARCHAR(20) NOT NULL" +
                         ")";
            stmt.executeUpdate(sql);
            System.out.println("Table 'Accounts' created successfully.");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
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

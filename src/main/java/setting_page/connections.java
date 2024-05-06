package setting_page;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class connections {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            // Load driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // Establish connection
            String urlDB = "jdbc:sqlserver://LEY\\THANHTUYEN:1433;databaseName=WEB TOUR";
            String user = "user";
            String password = "12345";
            conn = DriverManager.getConnection(urlDB, user, password);
            // Connection success message
            System.out.println("Connection success!");

   
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

package login;

import context.DBContext;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTableAccount {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
        	conn = DBContext.getConnection();
            // Connection success message
            System.out.println("Connection success!");

            // Create table
            stmt = conn.createStatement();
            String sql = "CREATE TABLE accounts (" +
                            "ID INT PRIMARY KEY," +
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

package login;

import context.DBContext;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class login {

    public static boolean validateUser(String role, String username, String password) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        boolean isValid = false;
        
        try {
        	conn = DBContext.getConnection();
            
            // Prepare statement for querying user
            String querySQL = "SELECT * FROM accounts WHERE Role = ? AND Username = ? AND Password = ?";
            pstmt = conn.prepareStatement(querySQL);
            pstmt.setString(1, role);
            pstmt.setString(2, username);
            pstmt.setString(3, password);
            
            // Execute query
            rs = pstmt.executeQuery();
            
            // Check if user exists
            if (rs.next()) {
                isValid = true;
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (rs != null) {
                    rs.close();
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

        return isValid;
    }
}

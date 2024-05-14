package login;

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
            // Load driver
        	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // Establish connection
            String urlDB = "jdbc:sqlserver://DESKTOP-00GD31A\\LEY:1433;databaseName=WEB TOUR";
            String user = "sa";
            String DBPassword = "12345";
            conn = DriverManager.getConnection(urlDB, user, DBPassword);
            
            // Prepare statement for querying user
            String querySQL = "SELECT * FROM Accounts WHERE Role = ? AND Username = ? AND Password = ?";
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
    
    public static void main(String[] args) {
	    if(validateUser("admin" ,"vu@admin.com", "vu.12345")) 
	    	System.out.print("ok");    
	    else 
	    	System.out.print("ko");
    }
}

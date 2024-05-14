package help;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HelpDAO {
    // Connection parameters
    private static final String urlDB = "jdbc:sqlserver://DESKTOP-HM360E0\\MSSQLSERVER04:1433;databaseName=Web Travel";
    private static final String user = "sa";
    private static final String password = "12345";

    // SQL queries
    private static final String SELECT_ALL_HELP = "SELECT * FROM Help";

    // Method to retrieve all help questions from the database
    public List<Help> getAllHelp() {
        List<Help> helpList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            // Establish connection
            conn = DriverManager.getConnection(urlDB, user, password);

            // Prepare statement
            pstmt = conn.prepareStatement(SELECT_ALL_HELP);

            // Execute query
            rs = pstmt.executeQuery();

            // Process result set
            while (rs.next()) {
                String idCauHoi = rs.getString("idCauHoi");
                String cauHoi = rs.getString("cauHoi");
                String cauTraLoi = rs.getString("cauTraLoi");

                // Create Help object and add to list
                Help help = new Help(idCauHoi, cauHoi, cauTraLoi);
                helpList.add(help);
            }
        } catch (SQLException e) {
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
        return helpList;
    }

    public static void main(String[] args) {
        HelpDAO helpDAO = new HelpDAO();
        List<Help> helpList = helpDAO.getAllHelp();

        // Print out the help questions
        for (Help help : helpList) {
            System.out.println(help.toString());
        }
    }
}

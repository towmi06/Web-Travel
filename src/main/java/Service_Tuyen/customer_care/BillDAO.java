package Service_Tuyen.customer_care;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BillDAO {
    private static final String urlDB = "jdbc:sqlserver://DESKTOP-00GD31A\\LEY:1433;databaseName=WEB TOUR";
    private static final String user = "sa";
    private static final String password = "12345";

    public List<Bill> getAllBills() {
        List<Bill> billList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // Load SQLServer JDBC driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // Establish connection
            conn = DriverManager.getConnection(urlDB, user, password);

            // Prepare statement for retrieving all bills
            String query = "SELECT * FROM Bill";
            pstmt = conn.prepareStatement(query);

            // Execute query
            rs = pstmt.executeQuery();

            // Process result set
            while (rs.next()) {
                // Retrieve data from result set and create Bill object
                Bill bill = new Bill();
                bill.setID(rs.getString("ID"));
                bill.setProviderID(rs.getString("providerID"));
                bill.setCustomerID(rs.getString("customerID"));
                bill.setTourName(rs.getString("tourName"));
                bill.setDestination(rs.getString("destination"));
                bill.setDepartureDate(rs.getString("departureDate"));
                bill.setNumberOfPeople(rs.getInt("numberOfPeople"));
                bill.setPrice(rs.getLong("price"));
                bill.setAddress(rs.getString("address"));
                bill.setType(rs.getString("type"));

                // Add Bill object to list
                billList.add(bill);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return billList;
    }
    
    public static void main(String[] args) {
    	List<Bill> billList = new BillDAO().getAllBills();
        for (Bill bill : billList) {
            System.out.println(bill.toString());
        }
    }
}

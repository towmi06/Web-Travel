package Service_Tuyen.setting_page;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Service_Tuyen.setting_page.OutstandingService;

public class OutstandingServiceDAO {
	public static List<OutstandingService> getOutstandingServices() throws ClassNotFoundException {
	    List<OutstandingService> outstandingServices = new ArrayList<>();
	    Connection conn = null;
	    PreparedStatement stmt = null;
	    ResultSet rs = null;

	    try {
	        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

	        // Establish connection
	        String urlDB = "jdbc:sqlserver://DESKTOP-00GD31A\\LEY:1433;databaseName=WEB TOUR";
            String user = "sa";
            String password = "12345";
            conn = DriverManager.getConnection(urlDB, user, password);

	        // Building the SQL query based on orderBy parameter
	        String query = "SELECT * FROM outstanding_services ORDER BY ID ASC";
	        
	        stmt = conn.prepareStatement(query);
	        rs = stmt.executeQuery();

	        while (rs.next()) {
	            OutstandingService service = new OutstandingService();
	            service.setID(rs.getString("ID"));
	            service.setRate(rs.getFloat("rate"));
	            service.setSales(rs.getLong("sales"));
	            service.setTourName(rs.getString("tourName"));
	            service.setDestination(rs.getString("destination"));
	            service.setDepartureDate(rs.getString("departureDate"));
	            service.setPrice(rs.getInt("price"));
	            service.setAddress(rs.getString("address"));
	            service.setCategory(rs.getString("category"));
	            service.setOutstanding(rs.getBoolean("outstanding"));

	            outstandingServices.add(service);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        // Close resources
	        try {
	            if (rs != null) rs.close();
	            if (stmt != null) stmt.close();
	            if (conn != null) conn.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    return outstandingServices;
	}

	public static List<OutstandingService> getOutstandingServicesSortedBy(String sortBy) throws ClassNotFoundException {
	    List<OutstandingService> outstandingServices = new ArrayList<>();
	    Connection conn = null;
	    PreparedStatement stmt = null;
	    ResultSet rs = null;

	    try {
	        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

	        String urlDB = "jdbc:sqlserver://DESKTOP-00GD31A\\LEY:1433;databaseName=WEB TOUR";
            String user = "sa";
            String password = "12345";
            conn = DriverManager.getConnection(urlDB, user, password);

	        // Building the SQL query based on sortBy parameter
	        String query = "SELECT * FROM outstanding_services ORDER BY " + sortBy + " DESC";

	        stmt = conn.prepareStatement(query);
	        rs = stmt.executeQuery();

	        while (rs.next()) {
	            OutstandingService service = new OutstandingService();
	            service.setID(rs.getString("ID"));
	            service.setRate(rs.getFloat("rate"));
	            service.setSales(rs.getLong("sales"));
	            service.setTourName(rs.getString("tourName"));
	            service.setDestination(rs.getString("destination"));
	            service.setDepartureDate(rs.getString("departureDate"));
	            service.setPrice(rs.getInt("price"));
	            service.setAddress(rs.getString("address"));
	            service.setCategory(rs.getString("category"));
	            service.setOutstanding(rs.getBoolean("outstanding"));

	            outstandingServices.add(service);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        // Close resources
	        try {
	            if (rs != null) rs.close();
	            if (stmt != null) stmt.close();
	            if (conn != null) conn.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    return outstandingServices;
	}


	public static int updateOutstandingService(OutstandingService service) throws ClassNotFoundException {
		Connection conn = null;
	    PreparedStatement stmt = null;

	    try {
	        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

	        // Establish connection
	        String urlDB = "jdbc:sqlserver://DESKTOP-00GD31A\\LEY:1433;databaseName=WEB TOUR";
            String user = "sa";
            String password = "12345";
            conn = DriverManager.getConnection(urlDB, user, password);

	        // Update query
	        String query = "UPDATE outstanding_services SET outstanding = ? WHERE ID = ?";
	        
	        stmt = conn.prepareStatement(query);

	        // Toggle the outstanding status
	        boolean newStatus = !service.getOutstanding();
	        stmt.setBoolean(1, newStatus);
	        stmt.setString(2, service.getID());
	        
	        stmt.executeUpdate();
	        
	        // Update the outstanding status in the OutstandingService object
	        service.setOutstanding(newStatus);
	        
	        int rowsAffected = stmt.executeUpdate();
            
            if (rowsAffected > 0) {
                System.out.println("Page layout updated successfully.");
                return 10;
            } else {
                System.out.println("Failed to update page layout.");
                return 3;
            }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return 5;
	    } finally {
	        // Close resources
	        try {
	            if (stmt != null) stmt.close();
	            if (conn != null) conn.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}

	public static OutstandingService getOutstandingServiceById(String tourId) throws ClassNotFoundException {
		Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        OutstandingService service = null;

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // Establish connection
            String urlDB = "jdbc:sqlserver://DESKTOP-00GD31A\\LEY:1433;databaseName=WEB TOUR";
            String user = "sa";
            String password = "12345";
            
            conn = DriverManager.getConnection(urlDB, user, password);

            // Query to get the tour by ID
            String query = "SELECT * FROM outstanding_services WHERE ID = ?";
            
            stmt = conn.prepareStatement(query);
            stmt.setString(1, tourId);
            
            rs = stmt.executeQuery();
            
            if (rs.next()) {
                service = new OutstandingService();
                service.setID(rs.getString("ID"));
                service.setRate(rs.getFloat("rate"));
                service.setSales(rs.getLong("sales"));
                service.setTourName(rs.getString("tourName"));
                service.setDestination(rs.getString("destination"));
                service.setDepartureDate(rs.getString("departureDate"));
                service.setPrice(rs.getInt("price"));
                service.setAddress(rs.getString("address"));
                service.setCategory(rs.getString("category"));
                service.setOutstanding(rs.getBoolean("outstanding"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return service;
    }
	
	public static void main(String[] args) throws ClassNotFoundException {
        List<OutstandingService> outstandingServices = getOutstandingServicesSortedBy("RATE");
        for (OutstandingService service : outstandingServices) {
            System.out.println(service.toString());
        }
    }
}

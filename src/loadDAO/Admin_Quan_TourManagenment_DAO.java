package loadDAO;

import context.DBContext;
import entity.Service_Th1_OrderManager;
import entity.tour;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Admin_Quan_TourManagenment_DAO {
	
	public List<Service_Th1_OrderManager> getAllOrders() throws ClassNotFoundException, SQLException {
	    List<Service_Th1_OrderManager> orders = new ArrayList<>();
	    Connection connection = null;
	    PreparedStatement statement = null;
	    ResultSet resultSet = null;

	    try {
	        connection = DBContext.getConnection();
	        String sql = "SELECT o.id, o.customer_id, o.tour_id, o.booking_date, o.total_price, " +
	                "o.status, o.created_at, o.updated_at, o.sell_ID, " +
	                "c.name AS customerName, c.phone AS phoneNumber, c.address, " +
	                "t.tourName " +
	                "FROM orders o " +
	                "JOIN customer c ON o.customer_id = c.id " +
	                "JOIN tour t ON t.id = o.tour_id ";
	        statement = connection.prepareStatement(sql);
	        resultSet = statement.executeQuery(); 

	        while (resultSet.next()) {
	            int id = resultSet.getInt("id");
	            int customerId = resultSet.getInt("customer_id");
	            String tourId = resultSet.getString("tour_id");
	            String bookingDate = resultSet.getString("booking_date");
	            double totalPrice = resultSet.getDouble("total_price");
	            String status = resultSet.getString("status");
	            String createdAt = resultSet.getString("created_at");
	            String updatedAt = resultSet.getString("updated_at");
	            int sellId = resultSet.getInt("sell_ID");
	            String customerName = resultSet.getString("customerName");
	            String phoneNumber = resultSet.getString("phoneNumber");
	            String address = resultSet.getString("address");
	            String tourName = resultSet.getString("tourName");

	            Service_Th1_OrderManager order = new Service_Th1_OrderManager(id, customerId, tourId, bookingDate, tourName, totalPrice, status, createdAt, updatedAt, sellId, customerName, phoneNumber, address);
	            orders.add(order);
	        }
	    } finally {
	        if (resultSet != null) resultSet.close();
	        if (statement != null) statement.close();
	        if (connection != null) connection.close();
	    }

	    return orders; 
	}
	
	public List<tour> getAllTours() throws ClassNotFoundException {
	    List<tour> tours = new ArrayList<>();
	    Connection conn = null;
	    PreparedStatement stmt = null;
	    ResultSet rs = null;

	    try {
	        conn = DBContext.getConnection();
	        System.out.println("Connections sussces");
	        
	        String query = "SELECT * FROM tour";
	        stmt = conn.prepareStatement(query);
	        rs = stmt.executeQuery();

	        while (rs.next()) {
	        	System.out.println("Successfully got the list of tours");
	        	
	            String id = rs.getString("id");
	            String tourName = rs.getString("tourName");
	            String image = rs.getString("image");
	            String date = rs.getString("date");
	            double price = rs.getDouble("price");
	            String journeys = rs.getString("journeys");
	            String description1 = rs.getString("description1");
	            int cateID = rs.getInt("cateID");
	            int sellID = rs.getInt("sell_ID");

	            tour tour = new tour(id, tourName, image, date, price, journeys, description1, cateID, sellID);
	            tours.add(tour);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (rs != null) rs.close();
	            if (stmt != null) stmt.close();
	            if (conn != null) conn.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    return tours;
	}

	

    public tour findTourByID(String tourID) throws ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        tour foundTour = null;

        try {
            conn = DBContext.getConnection();
            System.out.println("Connections sussces");

            String query = "SELECT * FROM tour WHERE id = ?";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, tourID);
            rs = stmt.executeQuery();

            if (rs.next()) {
            	System.out.println("Successfully found tour");
            	
                String id = rs.getString("id");
                String tourName = rs.getString("tourName");
                String image = rs.getString("image");
                String date = rs.getString("date");
                double price = rs.getDouble("price");
                String journeys = rs.getString("journeys");
                String description1 = rs.getString("description1");
                int cateID = rs.getInt("cateID");
                int sellID = rs.getInt("sell_ID");

                foundTour = new tour(id, tourName, image, date, price, journeys, description1, cateID, sellID);
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

        return foundTour;
    }

    public static String updateTour(String id, String tourName, String image, String date, double price, String journeys, String description1, int cateID, int sellID) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = DBContext.getConnection();
            System.out.println("Connections sussces");

            String query = "UPDATE Tour SET tourName = ?, image = ?, date = ?, price = ?, journeys = ?, description1 = ?, cateID = ?, sell_ID = ? WHERE id = ?";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, tourName);
            stmt.setString(2, image);
            stmt.setString(3, date);
            stmt.setDouble(4, price);
            stmt.setString(5, journeys);
            stmt.setString(6, description1);
            stmt.setInt(7, cateID);
            stmt.setInt(8, sellID);
            stmt.setString(9, id);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
            	System.out.println("Tour information updated successfully.");
                return "Cập nhật tour thành công";
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Failed to update tour information.");
        return "Cập nhật tour không thành công";
    }
    
    public Map<Integer, Integer> getCateIDCount() throws ClassNotFoundException {
        Map<Integer, Integer> cateIDCount = new HashMap<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = DBContext.getConnection();
            System.out.println("Connections success");

            String query = "SELECT cateID, COUNT(*) AS count FROM tour GROUP BY cateID";
            stmt = conn.prepareStatement(query);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int cateID = rs.getInt("cateID");
                int count = rs.getInt("count");
                cateIDCount.put(cateID, count);
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

        return cateIDCount;
    }
    
    public Map<String, Integer> getOrdersCountByMonth() throws ClassNotFoundException {
        Map<String, Integer> tourCountByMonth = new TreeMap<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = DBContext.getConnection();
            System.out.println("Connections success");

            String query = "SELECT FORMAT(booking_date, 'yyyy-MM') AS month, COUNT(*) AS count FROM orders GROUP BY FORMAT(booking_date, 'yyyy-MM')";
            stmt = conn.prepareStatement(query);
            rs = stmt.executeQuery();

            while (rs.next()) {
                String month = rs.getString("month");
                int count = rs.getInt("count");
                tourCountByMonth.put(month, count);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return tourCountByMonth;
    }
}

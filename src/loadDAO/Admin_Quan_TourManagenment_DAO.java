package loadDAO;

import context.DBContext;
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

    public static void main(String[] args) {
        Admin_Quan_TourManagenment_DAO dao = new Admin_Quan_TourManagenment_DAO();

        try {
            Map<String, Integer> tourCountByMonth = dao.getOrdersCountByMonth();
            System.out.println("Tour Count by Month:");
            for (Map.Entry<String, Integer> entry : tourCountByMonth.entrySet()) {
                System.out.println("Month: " + entry.getKey() + " - Count: " + entry.getValue());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

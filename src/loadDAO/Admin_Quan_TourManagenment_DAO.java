package loadDAO;

import context.DBContext;
import entity.tour;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Admin_Quan_TourManagenment_DAO {

    public tour findTourByID(String tourID) throws ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        tour foundTour = null;

        try {
            conn = DBContext.getConnection();

            String query = "SELECT * FROM Tour WHERE id = ?";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, tourID);
            rs = stmt.executeQuery();

            if (rs.next()) {
                String id = rs.getString("id");
                String tourName = rs.getString("tourName");
                String image = rs.getString("image");
                String date = rs.getString("date");
                double price = rs.getDouble("price");
                String journeys = rs.getString("journeys");
                String description1 = rs.getString("description1");
                int cateID = rs.getInt("cateID");
                int sellID = rs.getInt("sellID");

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

            String query = "UPDATE Tour SET tourName = ?, image = ?, date = ?, price = ?, journeys = ?, description1 = ?, cateID = ?, sellID = ? WHERE id = ?";
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
        
        return "Cập nhật tour không thành công";
    }
}

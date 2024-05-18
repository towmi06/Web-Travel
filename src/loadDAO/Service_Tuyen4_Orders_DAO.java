package loadDAO;

import context.DBContext;
import entity.Service_Tuyen4_Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Service_Tuyen4_Orders_DAO {

    public List<Service_Tuyen4_Order> getAllOrdersForService(String sellID) {
        List<Service_Tuyen4_Order> orderList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DBContext.getConnection();

            // Prepare statement for retrieving all orders
            String query = "SELECT * FROM Orders WHERE sell_ID = ?";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, sellID);

            // Execute query
            rs = pstmt.executeQuery();

            // Process result set
            while (rs.next()) {
                // Retrieve data from result set and create Service_Tuyen4_Order object
                Service_Tuyen4_Order order = new Service_Tuyen4_Order();
                order.setID(rs.getString("ID"));
                order.setSellID(rs.getString("sell_ID"));
                order.setCustomerID(rs.getString("customer_ID"));
                order.setTourID(rs.getString("tour_ID"));
                order.setBookingDate(rs.getString("booking_date"));
                order.setTourName(rs.getString("tourName"));
                order.setDate(rs.getString("date"));
                order.setNumberOfPeople(rs.getInt("numberOfPeople"));
                order.setPrice(rs.getLong("price"));
                order.setType(rs.getString("type"));
                order.setStatus(rs.getString("status"));

                // Add order object to list
                orderList.add(order);
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

        return orderList;
    }
    
    public List<Service_Tuyen4_Order> getAllOrders() {
        List<Service_Tuyen4_Order> orderList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DBContext.getConnection();

            // Prepare statement for retrieving all orders
            String query = "SELECT * FROM Orders";
            pstmt = conn.prepareStatement(query);

            // Execute query
            rs = pstmt.executeQuery();

            // Process result set
            while (rs.next()) {
                // Retrieve data from result set and create Service_Tuyen4_Order object
                Service_Tuyen4_Order order = new Service_Tuyen4_Order();
                order.setID(rs.getString("ID"));
                order.setSellID(rs.getString("sell_ID"));
                order.setCustomerID(rs.getString("customer_ID"));
                order.setTourID(rs.getString("tour_ID"));
                order.setBookingDate(rs.getString("booking_date"));
                order.setTourName(rs.getString("tourName"));
                order.setDate(rs.getString("date"));
                order.setNumberOfPeople(rs.getInt("numberOfPeople"));
                order.setPrice(rs.getLong("price"));
                order.setType(rs.getString("type"));
                order.setStatus(rs.getString("status"));

                // Add order object to list
                orderList.add(order);
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

        return orderList;
    }

    public static Service_Tuyen4_Order findOrderByID(String orderID) throws ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Service_Tuyen4_Order order = null;

        try {
            conn = DBContext.getConnection();

            String query = "SELECT * FROM Orders WHERE ID = ?";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, orderID);
            rs = stmt.executeQuery();

            if (rs.next()) {
                // Retrieve data from ResultSet and create Service_Tuyen4_Order object
                order = new Service_Tuyen4_Order(
                    rs.getString("ID"),
                    rs.getString("sell_ID"),
                    rs.getString("customer_ID"),
                    rs.getString("tour_ID"),
                    rs.getString("booking_date"),
                    rs.getString("tourName"),
                    rs.getString("date"),
                    rs.getInt("numberOfPeople"),
                    rs.getLong("price"),
                    rs.getString("type"),
                    rs.getString("status")
                );
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

        return order;
    }

    public static int updateOrder(String ID, String sellID, String customerID, String tourID, String bookingDate, String tourName, String date, int numberOfPeople, long price, String type) throws ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = DBContext.getConnection();

            // SQL query for updating order
            String query = "UPDATE Orders SET sell_ID=?, customer_ID=?, tour_ID=?, booking_date=?, tourName=?, date=?, numberOfPeople=?, price=?, type=? WHERE ID=?";
            stmt = conn.prepareStatement(query);

            // Set parameters for the prepared statement
            stmt.setString(1, sellID);
            stmt.setString(2, customerID);
            stmt.setString(3, tourID);
            stmt.setString(4, bookingDate);
            stmt.setString(5, tourName);
            stmt.setString(6, date);
            stmt.setInt(7, numberOfPeople);
            stmt.setLong(8, price);
            stmt.setString(9, type);
            stmt.setString(10, ID);

            // Execute the update statement
            int rowsUpdated = stmt.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Order with ID " + ID + " updated successfully.");
                return 1;
            } else {
                System.out.println("Failed to update order with ID " + ID + ".");
                return 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
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

    public static int deleteOrder(String ID) throws ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = DBContext.getConnection();

            // SQL query for deleting order
            String query = "DELETE FROM Orders WHERE ID=?";
            stmt = conn.prepareStatement(query);

            // Set ID parameter for the prepared statement
            stmt.setString(1, ID);

            // Execute the delete statement
            int rowsDeleted = stmt.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("Order with ID " + ID + " deleted successfully.");
                return 1;
            } else {
                System.out.println("Failed to delete order with ID " + ID + ". It may not exist.");
                return 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
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

    public static void main(String[] args) {
        Service_Tuyen4_Orders_DAO ordersDAO = new Service_Tuyen4_Orders_DAO();

        // Test getAllOrders method
        List<Service_Tuyen4_Order> orders = ordersDAO.getAllOrders();

        for (Service_Tuyen4_Order order : orders) {
            System.out.println(order.toString());
        }
    }
}

package loadDAO;

import context.DBContext;
import entity.Service_Th1_OrderManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Service_Tuyen4_Orders_DAO {

    public static List<Service_Th1_OrderManager> getOrdersBySellId(int sell_ID) throws ClassNotFoundException {
        List<Service_Th1_OrderManager> orders = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = DBContext.getConnection();
            String sql = "SELECT o.id, o.customer_id, o.tour_id, o.booking_date, o.total_price, " +
                    "o.status, o.created_at, o.updated_at, o.sell_ID, " +
                    "c.name AS customerName, c.phone AS phoneNumber, c.address, " +
                    "t.tourName " +
                    "FROM orders o " +
                    "JOIN customer c ON o.customer_id = c.id " +
                    "JOIN tour t ON t.id = o.tour_id " +
                    "WHERE o.sell_ID = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, sell_ID);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int customerId = resultSet.getInt("customer_id");
                String tourId = resultSet.getString("tour_id");
                String bookingDate = resultSet.getString("booking_date");
                String tourName = resultSet.getString("tourName");
                double totalPrice = resultSet.getDouble("total_price");
                String status = resultSet.getString("status");
                String createdAt = resultSet.getString("created_at");
                String updatedAt = resultSet.getString("updated_at");
                String customerName = resultSet.getString("customerName");
                String phoneNumber = resultSet.getString("phoneNumber");
                String address = resultSet.getString("address");

                Service_Th1_OrderManager order = new Service_Th1_OrderManager(id, customerId, tourId, bookingDate, tourName, totalPrice, status, createdAt, updatedAt, sell_ID, customerName, phoneNumber, address);
                orders.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return orders;
    }

    public static Service_Th1_OrderManager findOrderByID(int id) throws ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Service_Th1_OrderManager order = null;

        try {
            conn = DBContext.getConnection();

            String sql = "SELECT o.id, o.customer_id, o.tour_id, o.booking_date, o.total_price, " +
                    "o.status, o.created_at, o.updated_at, o.sell_ID, " +
                    "c.name AS customerName, c.phone AS phoneNumber, c.address, " +
                    "t.tourName " +
                    "FROM orders o " +
                    "JOIN customer c ON o.customer_id = c.id " +
                    "JOIN tour t ON t.id = o.tour_id " +
                    "WHERE o.id = ?";
            
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id); 
            rs = stmt.executeQuery();

            if (rs.next()) {
                int customerId = rs.getInt("customer_id");
                String tourId = rs.getString("tour_id");
                String bookingDate = rs.getString("booking_date");
                String tourName = rs.getString("tourName");
                double totalPrice = rs.getDouble("total_price");
                String status = rs.getString("status");
                String createdAt = rs.getString("created_at");
                String updatedAt = rs.getString("updated_at");
                int sellID = rs.getInt("sell_ID"); 
                String customerName = rs.getString("customerName");
                String phoneNumber = rs.getString("phoneNumber");
                String address = rs.getString("address");

                order = new Service_Th1_OrderManager(id, customerId, tourId, bookingDate, tourName, totalPrice, status, createdAt, updatedAt, sellID, customerName, phoneNumber, address);
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

        return order;
    }

    public static int updateOrder(int id, int customerId, String tourId, String bookingDate, String status, String createdAt, String updatedAt) throws ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = DBContext.getConnection();

            // SQL query for updating order
            String query = "UPDATE Orders SET customer_id=?, tour_id=?, booking_date=?, status=?, created_at=?, updated_at=? WHERE ID=?";
            stmt = conn.prepareStatement(query);

            // Set parameters for the prepared statement
            stmt.setInt(1, customerId);
            stmt.setString(2, tourId);
            stmt.setString(3, bookingDate);
            stmt.setString(4, status);
            stmt.setString(5, createdAt);
            stmt.setString(6, updatedAt);
            stmt.setInt(7, id);

            // Execute the update statement
            int rowsUpdated = stmt.executeUpdate();

            if (rowsUpdated > 0) {
                // Update successful
                return 10;
            } else {
                // Update unsuccessful
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

    public static int deleteOrder(int ID) throws ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = DBContext.getConnection();

            // SQL query for deleting payments associated with the order
            String query2 = "DELETE FROM payments WHERE order_id=?";
            stmt = conn.prepareStatement(query2);
            stmt.setInt(1, ID);
            stmt.executeUpdate();

            // SQL query for deleting order
            String query1 = "DELETE FROM Orders WHERE ID=?";
            stmt = conn.prepareStatement(query1);
            stmt.setInt(1, ID);
            int rowsDeleted = stmt.executeUpdate();

            if (rowsDeleted > 0) {
                // Delete successful
                return 10;
            } else {
                // Delete unsuccessful
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

 // Test getOrdersBySellId method
    public static void main(String[] args) throws ClassNotFoundException {
        Service_Tuyen4_Orders_DAO ordersDAO = new Service_Tuyen4_Orders_DAO();

        List<Service_Th1_OrderManager> orders = ordersDAO.getOrdersBySellId(1);

        if (orders != null && !orders.isEmpty()) {
            for (Service_Th1_OrderManager order : orders) {
                System.out.println("Order ID: " + order.getId());
            }
        } else {
            System.out.println("No orders found for the given sell ID.");
        }
    }
}

package loadDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import entity.Service_Th2_DetailOrder;
import context.DBContext;

public class Service_Th2_DetailOrder_DAO {

    public Service_Th2_DetailOrder getOrderById(int orderId) throws ClassNotFoundException, SQLException {
        Service_Th2_DetailOrder order = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            // Initialize database connection using your existing DBContext class
            DBContext dbContext = new DBContext();
            connection = dbContext.getConnection();

            // Your SQL query to fetch data from the database
            String sql = "SELECT orders.*, customer.name, customer.email, customer.phone, customer.address, " +
                         "payments.payment_method, payments.payment_date " +
                         "FROM orders " +
                         "JOIN customer ON orders.customer_id = customer.id " +
                         "JOIN payments ON orders.id = payments.order_id " +
                         "WHERE orders.id = ?";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, orderId);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                // Extract data from the ResultSet
                order = new Service_Th2_DetailOrder();
                order.setId(resultSet.getInt("id"));
                order.setCustomerId(resultSet.getInt("customer_id"));
                order.setTourId(resultSet.getString("tour_id"));
                order.setBookingDate(resultSet.getDate("booking_date"));
                order.setTotalPrice(resultSet.getDouble("total_price"));
                order.setStatus(resultSet.getString("status"));
                order.setCreatedAt(resultSet.getDate("created_at"));
                order.setUpdatedAt(resultSet.getDate("updated_at"));
                order.setSellId(resultSet.getInt("sell_ID"));
                order.setImage(resultSet.getString("image"));
                order.setNumberOrders(resultSet.getInt("NumberOrders"));

                order.setCustomerName(resultSet.getString("name"));
                order.setCustomerEmail(resultSet.getString("email"));
                order.setCustomerPhone(resultSet.getString("phone"));
                order.setCustomerAddress(resultSet.getString("address"));
                order.setPaymentMethod(resultSet.getString("payment_method"));
                order.setPaymentDate(resultSet.getDate("payment_date"));
            }

        } finally {
            // Close resources in finally block to ensure they're always closed
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return order;
    }

    public static void main(String[] args) {
        try {
            Service_Th2_DetailOrder_DAO detailOrderDAO = new Service_Th2_DetailOrder_DAO();
            int testOrderId = 1; // replace with an actual order ID you want to test
            Service_Th2_DetailOrder order = detailOrderDAO.getOrderById(testOrderId);
            if (order != null) {
                System.out.println(order);
            } else {
                System.out.println("Order not found.");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}

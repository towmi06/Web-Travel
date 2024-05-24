package loadDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import entity.Service_Th2_DetailOrder;
import context.DBContext;

public class Service_Th2_DetailOrder_DAO {
    
    // Lấy đơn hàng theo ID
    public Service_Th2_DetailOrder getOrderById(int orderId) throws ClassNotFoundException, SQLException {
        Service_Th2_DetailOrder order = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            DBContext dbContext = new DBContext();
            connection = dbContext.getConnection();
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
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
            if (connection != null) connection.close();
        }
        return order;
    }

    public void updateOrder(Service_Th2_DetailOrder order) throws ClassNotFoundException, SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            DBContext dbContext = new DBContext();
            connection = dbContext.getConnection();
            String sql = "UPDATE orders SET status = ?, updated_at = ? WHERE id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, order.getStatus());
            preparedStatement.setTimestamp(2, new Timestamp(new Date().getTime()));
            preparedStatement.setInt(3, order.getId());
            preparedStatement.executeUpdate();
        } finally {
            if (preparedStatement != null) preparedStatement.close();
            if (connection != null) connection.close();
        }
    }

    // Xóa đơn hàng theo ID
    public void deleteOrder(int orderId) throws ClassNotFoundException, SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            DBContext dbContext = new DBContext();
            connection = dbContext.getConnection();
            String sql = "UPDATE orders SET status = 'Failed', updated_at = ? WHERE id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setTimestamp(1, new Timestamp(new Date().getTime()));
            preparedStatement.setInt(2, orderId);
            preparedStatement.executeUpdate();
        } finally {
            if (preparedStatement != null) preparedStatement.close();
            if (connection != null) connection.close();
        }
    }

    // Cập nhật trạng thái đơn hàng thành 'completed'
    public void completeOrder(int orderId) throws ClassNotFoundException, SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            DBContext dbContext = new DBContext();
            connection = dbContext.getConnection();
            String sql = "UPDATE orders SET status = 'Completed', updated_at = ? WHERE id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setTimestamp(1, new Timestamp(new Date().getTime()));
            preparedStatement.setInt(2, orderId);
            preparedStatement.executeUpdate();
        } finally {
            if (preparedStatement != null) preparedStatement.close();
            if (connection != null) connection.close();
        }
    }
}

package loadDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import context.DBContext;
import entity.Service_Th1_OrderManager;

public class Service_th1_OrderM_DAO {

    public List<Service_Th1_OrderManager> getAllOrders() throws ClassNotFoundException {
        List<Service_Th1_OrderManager> orders = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = DBContext.getConnection();
            String sql = "SELECT o.id, o.customer_id, o.tour_id, o.booking_date, o.total_price, "
                       + "o.status, o.created_at, o.updated_at, o.sell_ID, "
                       + "c.name AS customerName, c.phone AS phoneNumber, c.address "
                       + "FROM orders o "
                       + "JOIN customer c ON o.customer_id = c.id";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int customerId = resultSet.getInt("customer_id");
                int tourId = resultSet.getInt("tour_id");
                String bookingDate = resultSet.getString("booking_date");
                double totalPrice = resultSet.getDouble("total_price");
                String status = resultSet.getString("status");
                String createdAt = resultSet.getString("created_at");
                String updatedAt = resultSet.getString("updated_at");
                int sellId = resultSet.getInt("sell_ID");
                String customerName = resultSet.getString("customerName");
                String phoneNumber = resultSet.getString("phoneNumber");
                String address = resultSet.getString("address");

                Service_Th1_OrderManager order = new Service_Th1_OrderManager(id, customerId, tourId, bookingDate, totalPrice, status, createdAt, updatedAt, sellId, customerName, phoneNumber, address);
                orders.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return orders;
    }
}

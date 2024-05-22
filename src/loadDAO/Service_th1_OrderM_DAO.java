package loadDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import context.DBContext;
import entity.Service_Th1_OrderManager;
import entity.tour;

public class Service_th1_OrderM_DAO {

    public List<Service_Th1_OrderManager> getAllOrders() throws ClassNotFoundException {
        List<Service_Th1_OrderManager> orders = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = DBContext.getConnection();
            String sql = "SELECT o.id, o.customer_id, o.tour_id, o.booking_date, o.total_price, " +
                    "o.status, o.created_at, " +
                    "c.name AS customerName, c.phone AS phoneNumber, c.address, " +
                    "t.tourName, t.image " +
                    "FROM orders o " +
                    "JOIN customer c ON o.customer_id = c.id " +
                    "JOIN tour t ON t.id = o.tour_id ";
	          
            System.out.println("Executing SQL: " + sql);
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int customerId = resultSet.getInt("customer_id");
                String tourId = resultSet.getString("tour_id");
                String imageTour = resultSet.getString("image"); 
                String bookingDate = resultSet.getString("booking_date");
                String tourName = resultSet.getString("tourName"); 
                double totalPrice = resultSet.getDouble("total_price");
                String status = resultSet.getString("status");
                String createdAt = resultSet.getString("created_at");
                System.out.println("id: " + id + ",  imageTour: " + imageTour + ", bookingDate: " + bookingDate + ", totalPrice: " + totalPrice + ", status: " + status + ", createdAt: " + createdAt );

                Service_Th1_OrderManager order = new Service_Th1_OrderManager(id, imageTour, bookingDate, totalPrice, status, createdAt);
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
    public static void main(String[] args) throws ClassNotFoundException {
		Service_th1_OrderM_DAO dao = new Service_th1_OrderM_DAO();
		List<Service_Th1_OrderManager> list = dao.getAllOrders();
		for(Service_Th1_OrderManager i : list) 
			System.out.print(i);
    }
}

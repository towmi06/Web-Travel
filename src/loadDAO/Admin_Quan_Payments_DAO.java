package loadDAO;

import context.DBContext;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class Admin_Quan_Payments_DAO {

    public Map<String, Long> getPaymentMethodTotal() throws ClassNotFoundException, SQLException {
        Map<String, Long> paymentMethodTotalMap = new HashMap<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = DBContext.getConnection();
            String sql = "SELECT payment_method, total FROM payments";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String paymentMethod = resultSet.getString("payment_method");
                long total = resultSet.getLong("total");
                paymentMethodTotalMap.put(paymentMethod, total);
            }
        } finally {
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
        return paymentMethodTotalMap;
    }
    
    public static void main(String[] args) {
        try {
            Admin_Quan_Payments_DAO paymentsDAO = new Admin_Quan_Payments_DAO();
            Map<String, Long> paymentMethodTotalMap = paymentsDAO.getPaymentMethodTotal();

            for (Map.Entry<String, Long> entry : paymentMethodTotalMap.entrySet()) {
                String paymentMethod = entry.getKey();
                Long total = entry.getValue();
                System.out.println("Payment Method: " + paymentMethod + ", Total: " + total);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}

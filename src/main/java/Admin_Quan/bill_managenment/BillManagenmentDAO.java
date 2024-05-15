package Admin_Quan.bill_managenment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BillManagenmentDAO {
    private static final String urlDB = "jdbc:sqlserver://DESKTOP-HM360E0\\MSSQLSERVER04:1433;databaseName=Web Travel";
    private static final String user = "sa";
    private static final String password = "12345";

    public List<BillManagenment> getAllBills() {
        List<BillManagenment> billList = new ArrayList<>();
        String query = "SELECT * FROM BillManagenment";

        try (Connection connection = DriverManager.getConnection(urlDB, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                BillManagenment bill = new BillManagenment();
                bill.setID(resultSet.getString("ID"));
                bill.setProviderID(resultSet.getString("providerID"));
                bill.setCustomerID(resultSet.getString("customerID"));
                bill.setTourName(resultSet.getString("tourName"));
                bill.setDestination(resultSet.getString("destination"));
                bill.setDepartureDate(resultSet.getString("departureDate"));
                bill.setNumberOfPeople(resultSet.getInt("numberOfPeople"));
                bill.setPrice(resultSet.getLong("price"));
                bill.setAddress(resultSet.getString("address"));
                bill.setType(resultSet.getString("type"));
                bill.setStatus(resultSet.getString("status"));

                billList.add(bill);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return billList;
    }

    // Example of usage
    public static void main(String[] args) {
        BillManagenmentDAO billManagenmentDAO = new BillManagenmentDAO();
        List<BillManagenment> bills = billManagenmentDAO.getAllBills();

        for (BillManagenment bill : bills) {
            System.out.println(bill.toString());
        }
    }
}

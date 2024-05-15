package Admin_Quan.tour_managenment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TourManagenmentDAO {
    public List<TourManagenment> getAllTours() {
        List<TourManagenment> tourList = new ArrayList<>();
        String query = "SELECT * FROM TourManagenment";
        
        String urlDB = "jdbc:sqlserver://DESKTOP-HM360E0\\MSSQLSERVER04:1433;databaseName=Web Travel";
        String user = "sa";
        String password = "12345";

        try {
            // Đăng ký driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            // Kết nối CSDL
            try (Connection connection = DriverManager.getConnection(urlDB, user, password);
                 PreparedStatement preparedStatement = connection.prepareStatement(query);
                 ResultSet resultSet = preparedStatement.executeQuery()) {

                while (resultSet.next()) {
                    TourManagenment tour = new TourManagenment();
                    tour.setID(resultSet.getString("ID"));
                    tour.setProviderID(resultSet.getString("providerID"));
                    tour.setTourName(resultSet.getString("tourName"));
                    tour.setDestination(resultSet.getString("destination"));
                    tour.setDepartureDate(resultSet.getString("departureDate"));
                    tour.setPrice(resultSet.getLong("price"));
                    tour.setAddress(resultSet.getString("address"));
                    tour.setType(resultSet.getString("type"));

                    tourList.add(tour);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return tourList;
    }

    // Ví dụ sử dụng
    public static void main(String[] args) {
        TourManagenmentDAO tourManagenmentDAO = new TourManagenmentDAO();
        List<TourManagenment> tours = tourManagenmentDAO.getAllTours();

        for (TourManagenment tour : tours) {
            System.out.println(tour.toString());
        }
    }
}

package tour_managenment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TourManagenment {
    private String ID;
    private String providerID;
    private String tourName;
    private String destination;
    private String departureDate;
    private long price;
    private String address;
    private String type;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getProviderID() {
        return providerID;
    }

    public void setProviderID(String providerID) {
        this.providerID = providerID;
    }

    public String getTourName() {
        return tourName;
    }

    public void setTourName(String tourName) {
        this.tourName = tourName;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "TourManagenment{" +
                "ID='" + ID + '\'' +
                ", providerID='" + providerID + '\'' +
                ", tourName='" + tourName + '\'' +
                ", destination='" + destination + '\'' +
                ", departureDate='" + departureDate + '\'' +
                ", price=" + price +
                ", address='" + address + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
    
    public static TourManagenment findTourByID(String tourID) {
        // Thông tin kết nối CSDL
        String urlDB = "jdbc:sqlserver://DESKTOP-HM360E0\\MSSQLSERVER04:1433;databaseName=Web Travel";
        String user = "sa";
        String password = "12345";
        
        // Truy vấn SQL
        String query = "SELECT * FROM TourManagenment WHERE ID = ?";
        
        try (Connection connection = DriverManager.getConnection(urlDB, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            
            preparedStatement.setString(1, tourID);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    TourManagenment tour = new TourManagenment();
                    tour.setID(resultSet.getString("ID"));
                    tour.setProviderID(resultSet.getString("providerID"));
                    tour.setTourName(resultSet.getString("tourName"));
                    tour.setDestination(resultSet.getString("destination"));
                    tour.setDepartureDate(resultSet.getString("departureDate"));
                    tour.setPrice(resultSet.getLong("price"));
                    tour.setAddress(resultSet.getString("address"));
                    tour.setType(resultSet.getString("type"));
                    return tour; // Trả về tour nếu tìm thấy
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static int updateTour(String ID, String providerID, String tourName, String destination, String departureDate, long price, String address, String type) {
        // Thông tin kết nối CSDL
        String urlDB = "jdbc:sqlserver://DESKTOP-HM360E0\\MSSQLSERVER04:1433;databaseName=Web Travel;characterEncoding=UTF-8";
        String user = "sa";
        String password = "12345";

        // Truy vấn SQL
        String query = "UPDATE TourManagenment SET providerID = ?, tourName = ?, destination = ?, departureDate = ?, price = ?, address = ?, type = ? WHERE ID = ?";

        try (Connection connection = DriverManager.getConnection(urlDB, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, providerID);
            preparedStatement.setString(2, tourName);
            preparedStatement.setString(3, destination);
            preparedStatement.setString(4, departureDate);
            preparedStatement.setLong(5, price);
            preparedStatement.setString(6, address);
            preparedStatement.setString(7, type);
            preparedStatement.setString(8, ID);

            int rowsUpdated = preparedStatement.executeUpdate();
            return 10; 
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 3; 
    }
}
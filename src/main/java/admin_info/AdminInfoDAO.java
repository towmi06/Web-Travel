package admin_info;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminInfoDAO {

    private static final String DB_URL = "jdbc:sqlserver://DESKTOP-HM360E0\\MSSQLSERVER04:1433;databaseName=Web Travel";
    private static final String USER = "sa";
    private static final String PASSWORD = "12345";

    public List<AdminInfo> getAllAdmins() {
        List<AdminInfo> admins = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD)) {
            String query = "SELECT * FROM AdminInfo";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String ID = resultSet.getString("ID");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String phone = resultSet.getString("phone");
                String gender = resultSet.getString("gender");
                String address = resultSet.getString("address");
                String position = resultSet.getString("position");
                String coverPhoto = resultSet.getString("coverPhoto");
                String avatar = resultSet.getString("avatar");
                String facebook = resultSet.getString("facebook");
                String twitter = resultSet.getString("twitter");
                String instagram = resultSet.getString("instagram");
                String tiktok = resultSet.getString("tiktok");

                AdminInfo admin = new AdminInfo(ID, name, email, phone, gender, address, position, coverPhoto, avatar, facebook, twitter, instagram, tiktok);
                admins.add(admin);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return admins;
    }
    
    public static void main(String[] args) {
    	 AdminInfoDAO adminInfoDAO = new AdminInfoDAO(); 
    	 List<AdminInfo> list = adminInfoDAO.getAllAdmins(); 
    	 for (AdminInfo admin : list) {
    	     System.out.println(admin.toString()); 
    	 }
    }
}

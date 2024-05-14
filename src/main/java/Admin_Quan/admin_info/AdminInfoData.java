package Admin_Quan.admin_info;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AdminInfoData {
    public static void main(String[] args) {
        try {
            // Load SQL Server JDBC driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // Establish connection
            String urlDB = "jdbc:sqlserver://DESKTOP-HM360E0\\MSSQLSERVER04:1433;databaseName=Web Travel";
            String user = "sa";
            String password = "12345";
            Connection connection = DriverManager.getConnection(urlDB, user, password);

            // Insert data query
            String insertDataQuery = "INSERT INTO AdminInfo (ID, name, email, phone, gender, address, position, coverPhoto, avatar, facebook, twitter, instagram, tiktok) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            // Prepare statement
            PreparedStatement preparedStatement = connection.prepareStatement(insertDataQuery);

            // Insert row 1
            preparedStatement.setString(1, "AD001");
            preparedStatement.setString(2, "Vu Manh Quan");
            preparedStatement.setString(3, "vumanhquan@admin.com");
            preparedStatement.setString(4, "09123213");
            preparedStatement.setString(5, "Nam");
            preparedStatement.setString(6, "Ha Noi");
            preparedStatement.setString(7, "Admin");
            preparedStatement.setString(8, "resources/images/cover-photo.jpg"); 
            preparedStatement.setString(9, "resources/images/admin_VMQ.jpg");
            preparedStatement.setString(10, "facebook.com/admin1");
            preparedStatement.setString(11, "twitter.com/admin1");
            preparedStatement.setString(12, "instagram.com/admin1");
            preparedStatement.setString(13, "tiktok.com/admin1");
            preparedStatement.executeUpdate();

            // Insert row 2
            preparedStatement.setString(1, "AD002");
            preparedStatement.setString(2, "Nguyen Minh Dung");
            preparedStatement.setString(3, "nguyenminhdung@admin.com");
            preparedStatement.setString(4, "037126216");
            preparedStatement.setString(5, "Nam");
            preparedStatement.setString(6, "Ha Tay");
            preparedStatement.setString(7, "Nhan Vien");
            preparedStatement.setString(8, "resources/images/cover-photo-2.png"); 
            preparedStatement.setString(9, "resources/images/admin_2.png"); 
            preparedStatement.setString(10, "facebook.com/admin2");
            preparedStatement.setString(11, "twitter.com/admin2");
            preparedStatement.setString(12, "instagram.com/admin2");
            preparedStatement.setString(13, "tiktok.com/admin2");
            preparedStatement.executeUpdate();

            // Insert row 3
            preparedStatement.setString(1, "AD003");
            preparedStatement.setString(2, "Pham Hai Long");
            preparedStatement.setString(3, "phamhailong@admin.com");
            preparedStatement.setString(4, "02188327");
            preparedStatement.setString(5, "Nam");
            preparedStatement.setString(6, "Ha Dong");
            preparedStatement.setString(7, "Nhan Vien");
            preparedStatement.setString(8, "resources/images/cover-photo-3.png"); 
            preparedStatement.setString(9, "resources/images/admin_3.png");  
            preparedStatement.setString(10, "facebook.com/admin3");
            preparedStatement.setString(11, "twitter.com/admin3");
            preparedStatement.setString(12, "instagram.com/admin3");
            preparedStatement.setString(13, "tiktok.com/admin3");
            preparedStatement.executeUpdate();

            System.out.println("Data inserted successfully.");

            // Close connection
            preparedStatement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}

package admin_info;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminInfo {
    private String ID;
    private String name;
    private String email;
    private String phone;
    private String gender;
    private String address;
    private String position;
    private String coverPhoto;
    private String avatar;
    private String facebook;
    private String twitter;
    private String instagram;
    private String tiktok;

    // Constructors
    public AdminInfo() {
    }

    public AdminInfo(String ID, String name, String email, String phone, String gender, String address, String position, String coverPhoto, String avatar, String facebook, String twitter, String instagram, String tiktok) {
        this.ID = ID;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.address = address;
        this.position = position;
        this.coverPhoto = coverPhoto;
        this.avatar = avatar;
        this.facebook = facebook;
        this.twitter = twitter;
        this.instagram = instagram;
        this.tiktok = tiktok;
    }

    // Getters and setters
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getCoverPhoto() {
        return coverPhoto;
    }

    public void setCoverPhoto(String coverPhoto) {
        this.coverPhoto = coverPhoto;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public String getTiktok() {
        return tiktok;
    }

    public void setTiktok(String tiktok) {
        this.tiktok = tiktok;
    }

    // toString method
    @Override
    public String toString() {
        return "AdminInfo{" +
                "ID='" + ID + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", position='" + position + '\'' +
                ", coverPhoto='" + coverPhoto + '\'' +
                ", avatar='" + avatar + '\'' +
                ", facebook='" + facebook + '\'' +
                ", twitter='" + twitter + '\'' +
                ", instagram='" + instagram + '\'' +
                ", tiktok='" + tiktok + '\'' +
                '}';
    }

    public static AdminInfo findAdminByEmail(String email) {
        try {
            // Load SQL Server JDBC driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // Establish connection
            String urlDB = "jdbc:sqlserver://DESKTOP-HM360E0\\MSSQLSERVER04:1433;databaseName=Web Travel";
            String user = "sa";
            String password = "12345";
            Connection connection = DriverManager.getConnection(urlDB, user, password);

            // Query to find admin by email
            String query = "SELECT * FROM AdminInfo WHERE email = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, email);

            // Execute query
            ResultSet resultSet = statement.executeQuery();

            // Check if admin found
            if (resultSet.next()) {
                // Extract admin information from the result set
                String ID = resultSet.getString("ID");
                String name = resultSet.getString("name");
                String adminEmail = resultSet.getString("email");
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

                // Create AdminInfo object with extracted information
                AdminInfo admin = new AdminInfo(ID, name, adminEmail, phone, gender, address, position, coverPhoto, avatar, facebook, twitter, instagram, tiktok);

                // Close resources
                resultSet.close();
                statement.close();
                connection.close();

                // Return the admin object
                return admin;
            }

            // Close resources
            resultSet.close();
            statement.close();
            connection.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        // Return null if admin not found
        return null;
    }
    
    public static int updateAdminInfo(String ID, String name, String email, String phone, String position, String facebook, String twitter, String instagram, String tiktok) {
        try {
            // Load SQL Server JDBC driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // Establish connection
            String urlDB = "jdbc:sqlserver://DESKTOP-HM360E0\\MSSQLSERVER04:1433;databaseName=Web Travel";
            String user = "sa";
            String password = "12345";
            Connection connection = DriverManager.getConnection(urlDB, user, password);

            // Query to update admin information
            String query = "UPDATE AdminInfo SET name = ?, email = ?, phone = ?, position = ?, facebook = ?, twitter = ?, instagram = ?, tiktok = ? WHERE ID = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            
            // Set parameters for the prepared statement
            statement.setString(1, name);
            statement.setString(2, email);
            statement.setString(3, phone);
            statement.setString(4, position);
            statement.setString(5, facebook);
            statement.setString(6, twitter);
            statement.setString(7, instagram);
            statement.setString(8, tiktok);
            statement.setString(9, ID);

            // Execute the update query
            int rowsAffected = statement.executeUpdate();
            
            // Close resources
            statement.close();
            connection.close();

            // Check if the update was successful
            if (rowsAffected > 0) {
                System.out.println("Admin information updated successfully.");
                return 10;
            } else {
                System.out.println("Failed to update admin information.");
                return 3;
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return 5;
        }
    }
    
    public static int updateAdminPosition(String ID, String position) {
        try {
            // Load SQL Server JDBC driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // Establish connection
            String urlDB = "jdbc:sqlserver://DESKTOP-HM360E0\\MSSQLSERVER04:1433;databaseName=Web Travel";
            String user = "sa";
            String password = "12345";
            Connection connection = DriverManager.getConnection(urlDB, user, password);

            // Query to update admin position
            String query = "UPDATE AdminInfo SET position = ? WHERE ID = ?";
            PreparedStatement statement = connection.prepareStatement(query);

            // Set parameters for the prepared statement
            statement.setString(1, position);
            statement.setString(2, ID);

            // Execute the update query
            int rowsAffected = statement.executeUpdate();
            
            // Close resources
            statement.close();
            connection.close();

            // Check if the update was successful
            if (rowsAffected > 0) {
                System.out.println("Admin position updated successfully.");
                return 10;
            } else {
                System.out.println("Failed to update admin position.");
                return 3;
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return 5;
        }
    }

    public static void main(String[] args) {
        AdminInfo ad = findAdminByEmail("vumanhquan@admin.com");
        ad.updateAdminPosition("AD001", "Admin");
        System.out.print(ad.toString());
    }
}

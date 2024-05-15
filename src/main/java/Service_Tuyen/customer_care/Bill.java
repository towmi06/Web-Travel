package Service_Tuyen.customer_care;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Bill {
    private String ID;
    private String providerID;
    private String customerID;
    private String tourName;
    private String destination;
    private String departureDate;
    private int numberOfPeople;
    private long price;
    private String address;
    private String type;

    // Constructors
    public Bill() {
    }

    public Bill(String ID, String providerID, String customerID, String tourName, String destination, String departureDate, int numberOfPeople, long price, String address, String type) {
        this.ID = ID;  
        this.providerID = providerID;
        this.customerID = customerID;
        this.tourName = tourName;
        this.destination = destination;
        this.departureDate = departureDate;
        this.numberOfPeople = numberOfPeople;
        this.price = price;
        this.address = address;
        this.type = type;
    }

    // Getter and setter methods
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

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
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

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
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

    // Override toString() method
    @Override
    public String toString() {
        return "Bill{" +
                "ID='" + ID + '\'' +
                ", providerID='" + providerID + '\'' +
                ", customerID='" + customerID + '\'' +
                ", tourName='" + tourName + '\'' +
                ", destination='" + destination + '\'' +
                ", departureDate='" + departureDate + '\'' +
                ", numberOfPeople=" + numberOfPeople +
                ", price=" + price +
                ", address='" + address + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
    
    public static Bill findBillByID(String billID) throws ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Bill bill = null;

        try {
        	// Load SQLServer JDBC driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // Establish connection
            String urlDB = "jdbc:sqlserver://DESKTOP-00GD31A\\LEY:1433;databaseName=WEB TOUR";
            String user = "sa";
            String password = "12345";
            conn = DriverManager.getConnection(urlDB, user, password);
            
            String query = "SELECT * FROM Bill WHERE ID = ?";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, billID);
            rs = stmt.executeQuery();

            if (rs.next()) {
                // Lấy thông tin từ ResultSet và tạo đối tượng Bill
                bill = new Bill(
                    rs.getString("ID"),
                    rs.getString("providerID"),
                    rs.getString("customerID"),
                    rs.getString("tourName"),
                    rs.getString("destination"),
                    rs.getString("departureDate"),
                    rs.getInt("numberOfPeople"),
                    rs.getLong("price"),
                    rs.getString("address"),
                    rs.getString("type")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Đóng các đối tượng ResultSet, PreparedStatement và Connection
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return bill;
    }
    
    public static int updateBill(String ID, String providerID, String customerID, String tourName, String destination, String departureDate, int numberOfPeople, long price, String address, String type) throws ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            // Load SQLServer JDBC driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // Establish connection
            String urlDB = "jdbc:sqlserver://DESKTOP-00GD31A\\LEY:1433;databaseName=WEB TOUR";
            String user = "sa";
            String password = "12345";
            conn = DriverManager.getConnection(urlDB, user, password);
            
            // SQL query for updating bill
            String query = "UPDATE Bill SET providerID=?, customerID=?, tourName=?, destination=?, departureDate=?, numberOfPeople=?, price=?, address=?, type=? WHERE ID=?";
            stmt = conn.prepareStatement(query);
            
            // Set parameters for the prepared statement
            stmt.setString(1, providerID);
            stmt.setString(2, customerID);
            stmt.setString(3, tourName);
            stmt.setString(4, destination);
            stmt.setString(5, departureDate);
            stmt.setInt(6, numberOfPeople);
            stmt.setLong(7, price);
            stmt.setString(8, address);
            stmt.setString(9, type);
            stmt.setString(10, ID);
            
            // Execute the update statement
            int rowsUpdated = stmt.executeUpdate();
            
            if (rowsUpdated > 0) {
                System.out.println("Bill with ID " + ID + " updated successfully.");
                return 10;
            } else {
                System.out.println("Failed to update bill with ID " + ID + ".");
                return 3;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return 5;
        } finally {
            // Close the PreparedStatement and Connection
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    public static int deleteBill(String ID) throws ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            // Load SQLServer JDBC driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // Establish connection
            String urlDB = "jdbc:sqlserver://DESKTOP-00GD31A\\LEY:1433;databaseName=WEB TOUR";
            String user = "sa";
            String password = "12345";
            conn = DriverManager.getConnection(urlDB, user, password);
            
            // SQL query for deleting bill
            String query = "DELETE FROM Bill WHERE ID=?";
            stmt = conn.prepareStatement(query);
            
            // Set ID parameter for the prepared statement
            stmt.setString(1, ID);
            
            // Execute the delete statement
            int rowsDeleted = stmt.executeUpdate();
            
            if (rowsDeleted > 0) {
                System.out.println("Bill with ID " + ID + " deleted successfully.");
                return 10;
            } else {
                System.out.println("Failed to delete bill with ID " + ID + ". It may not exist.");
                return 3;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return 5;
        } finally {
            // Close the PreparedStatement and Connection
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

 
    public static void main(String[] args) throws ClassNotFoundException {
    	Bill bill = findBillByID("HD001");
    	
        System.out.println(bill.toString());
    }
}

package loadDAO;

import context.DBContext;
import entity.Service_Tuyen1_OutStanding;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Service_Tuyen1_OutStanding_DAO {
    
    // Lấy danh sách các dịch vụ outstanding theo sell_ID sắp xếp theo sales và rate
    public static List<Service_Tuyen1_OutStanding> getOutstandingServices(String sell_ID) throws ClassNotFoundException {
        List<Service_Tuyen1_OutStanding> outstandingServices = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = DBContext.getConnection();

            // Building the SQL query
            String query = "SELECT * FROM OutstandingService WHERE sell_ID = ? ORDER BY sales DESC, rate DESC";

            stmt = conn.prepareStatement(query);
            stmt.setString(1, sell_ID);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Service_Tuyen1_OutStanding service = new Service_Tuyen1_OutStanding();
                
                service.setId(rs.getString("id"));
                service.setSell_ID(rs.getString("sell_ID"));
                service.setCateID(rs.getString("cateID"));
                service.setRate(rs.getFloat("rate"));
                service.setSales(rs.getLong("sales"));
                service.setTourName(rs.getString("tourName"));
                service.setImage(rs.getString("image"));
                service.setJourneys(rs.getString("journeys"));
                service.setDate(rs.getString("date"));
                service.setPrice(rs.getInt("price"));
                service.setOutstanding(rs.getBoolean("outstanding"));

                outstandingServices.add(service);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return outstandingServices;
    }
    
    public List<Service_Tuyen1_OutStanding> getAllTour() throws ClassNotFoundException {
        List<Service_Tuyen1_OutStanding> outstandingServices = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = DBContext.getConnection();

            // Building the SQL query
            String query = "SELECT * FROM OutstandingService";

            stmt = conn.prepareStatement(query);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Service_Tuyen1_OutStanding service = new Service_Tuyen1_OutStanding();
                
                service.setId(rs.getString("id"));
                service.setSell_ID(rs.getString("sell_ID"));
                service.setCateID(rs.getString("cateID"));
                service.setRate(rs.getFloat("rate"));
                service.setSales(rs.getLong("sales"));
                service.setTourName(rs.getString("tourName"));
                service.setImage(rs.getString("image"));
                service.setJourneys(rs.getString("journeys"));
                service.setDate(rs.getString("date"));
                service.setPrice(rs.getInt("price"));
                service.setOutstanding(rs.getBoolean("outstanding"));

                outstandingServices.add(service);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return outstandingServices;
    }


    // Cập nhật trạng thái outstanding của dịch vụ
    public static int updateOutstandingService(Service_Tuyen1_OutStanding service) throws ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = DBContext.getConnection();

            // Update query
            String query = "UPDATE OutstandingService SET outstanding = ? WHERE id = ?";
            
            stmt = conn.prepareStatement(query);

            // Toggle the outstanding status
            boolean newStatus = !service.getOutstanding();
            stmt.setBoolean(1, newStatus);
            stmt.setString(2, service.getId());

            int rowsAffected = stmt.executeUpdate();
            
            // Update the outstanding status in the OutstandingService object
            service.setOutstanding(newStatus);

            if (rowsAffected > 0) {
                return 10;
            } else {
                return 3;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return 5;
        } finally {
            // Close resources
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Lấy thông tin dịch vụ outstanding theo ID
    public static Service_Tuyen1_OutStanding getOutstandingServiceById(String tourId) throws ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Service_Tuyen1_OutStanding service = new Service_Tuyen1_OutStanding();

        try {
            conn = DBContext.getConnection();
            // Query to get the tour by ID
            String query = "SELECT * FROM OutstandingService WHERE id = ?";
            
            stmt = conn.prepareStatement(query);
            stmt.setString(1, tourId);
            
            rs = stmt.executeQuery();
            
            if (rs.next()) {            
                service.setId(rs.getString("id"));
                service.setSell_ID(rs.getString("sell_ID"));
                service.setCateID(rs.getString("cateID"));
                service.setRate(rs.getFloat("rate"));
                service.setSales(rs.getLong("sales"));
                service.setTourName(rs.getString("tourName"));
                service.setImage(rs.getString("image"));
                service.setJourneys(rs.getString("journeys"));
                service.setDate(rs.getString("date"));
                service.setPrice(rs.getInt("price"));
                service.setOutstanding(rs.getBoolean("outstanding"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return service;
    }
    
    // test
    public static void main(String[] args) {
        try {   
            List<Service_Tuyen1_OutStanding> services = new Service_Tuyen1_OutStanding_DAO().getOutstandingServices("1");
            
            for (Service_Tuyen1_OutStanding service : services) {
                System.out.println(service.getId());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
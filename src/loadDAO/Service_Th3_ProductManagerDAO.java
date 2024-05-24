package loadDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.Service_Th3_ProductManage;
import context.DBContext;

public class Service_Th3_ProductManagerDAO {

    public List<Service_Th3_ProductManage> getActiveProductsBySellId(int sellId) {
        List<Service_Th3_ProductManage> products = new ArrayList<>();
        String sql = "SELECT t.id, t.tourName, t.image, t.date, t.price, t.journeys, t.sell_ID as sellId, c.name as categoryName " +
                     "FROM tour t " +
                     "JOIN categories c ON t.cateID = c.id " +
                     "WHERE t.sell_ID = ? AND t.status = 'active'";
        try (Connection conn = DBContext.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, sellId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Service_Th3_ProductManage product = new Service_Th3_ProductManage();
                    product.setId(rs.getString("id"));
                    product.setTourName(rs.getString("tourName"));
                    product.setImage(rs.getString("image"));
                    product.setDate(rs.getString("date"));
                    product.setPrice(rs.getDouble("price"));
                    product.setJourneys(rs.getString("journeys"));
                    product.setSellId(rs.getInt("sellId"));
                    product.setCategoryName(rs.getString("categoryName"));
                    products.add(product);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }
// delete tour 
    public boolean hasOrders(String tourId) {
        String query = "SELECT COUNT(*) FROM orders WHERE tour_id = ?";
        try (Connection conn = DBContext.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, tourId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public void deleteProduct(String id) {
        String query = "UPDATE tour SET status = 'deleted' WHERE id = ?";
        try (Connection conn = DBContext.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    // add new tour
    public void insertProduct(String name, String image, String price, String title, String description, String category, int sellId) {
        String query = "INSERT INTO tour (name, image, price, title, description, cateID, sell_ID) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBContext.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, name);
            ps.setString(2, image);
            ps.setString(3, price);
            ps.setString(4, title);
            ps.setString(5, description);
            ps.setString(6, category);
            ps.setInt(7, sellId);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // edit tour 
    public boolean editProduct(String name, String image, String price, String title, String description, String category, String id) {
        String query = "UPDATE tour SET name = ?, image = ?, price = ?, title = ?, description = ?, cateID = ? WHERE id = ?";
        try (Connection conn = DBContext.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, name);
            ps.setString(2, image);
            ps.setString(3, price);
            ps.setString(4, title);
            ps.setString(5, description);
            ps.setString(6, category);
            ps.setString(7, id);
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false; // Thêm return false ở đây
    }


    public static void main(String[] args) {
        Service_Th3_ProductManagerDAO dao = new Service_Th3_ProductManagerDAO();
        List<Service_Th3_ProductManage> list = dao.getActiveProductsBySellId(2);
        for (Service_Th3_ProductManage product : list) {
            System.out.println(product);
        }
    }
}

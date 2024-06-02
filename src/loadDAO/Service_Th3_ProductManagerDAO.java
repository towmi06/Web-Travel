package loadDAO;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Service_Th3_ProductManage;
import entity.categories;
import entity.tour;
import context.DBContext;

public class Service_Th3_ProductManagerDAO {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
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
	// Lấy tất cả danh mục
		public List<categories> getAllCategories() {
			List<categories> list = new ArrayList<>();
			String query = "SELECT * FROM categories";
			try {
				conn = new DBContext().getConnection(); // Mở kết nối với SQL
				ps = conn.prepareStatement(query);
				rs = ps.executeQuery();
				while (rs.next()) {
					list.add(new categories(rs.getInt(1), rs.getString(2), rs.getString(3)));
				}
			} catch (Exception e) {
				// Xử lý ngoại lệ, ví dụ: ghi log
				e.printStackTrace();
			} finally {
				// Đóng kết nối, PreparedStatement và ResultSet sau khi sử dụng
				try {
					if (rs != null)
						rs.close();
					if (ps != null)
						ps.close();
					if (conn != null)
						conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return list;
		}
	    public Service_Th3_ProductManage getProductById(String id) {
	        String query = "SELECT * FROM tour WHERE id = ?";
	        try (Connection conn = DBContext.getConnection();
	             PreparedStatement ps = conn.prepareStatement(query)) {
	            ps.setString(1, id);
	            try (ResultSet rs = ps.executeQuery()) {
	                if (rs.next()) {
	                    Service_Th3_ProductManage product = new Service_Th3_ProductManage();
	                    product.setId(rs.getString("id"));
	                    product.setTourName(rs.getString("tourName"));
	                    product.setImage(rs.getString("image"));
	                    product.setDate(rs.getString("date"));
	                    product.setPrice(rs.getDouble("price"));
	                    product.setJourneys(rs.getString("journeys"));
	                    product.setDescription1(rs.getString("description1"));
	                    return product;
	                }
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return null;
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
    
    //edit tour
    public void updateProduct(String id, String date, BigDecimal price, String journeys, String description1) throws SQLException {
        String query = "UPDATE tour SET date = ?, price = ?, journeys = ?, description1 = ? WHERE id = ?";
        try (Connection conn = DBContext.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, date);
            ps.setBigDecimal(2, price);
            ps.setString(3, journeys);
            ps.setString(4, description1);
            ps.setString(5, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


 


    public void insertProduct(String id, String tourName, String image, String date, String price, String journeys, String description1, String category, int sellId) throws SQLException {
        String query = "INSERT INTO [dbo].[tour] ([id], [tourName], [image], [date], [price], [journeys], [description1], [cateID], [sell_ID]) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
        		conn = DBContext.getConnection();
        		ps = conn.prepareStatement(query);
        		ps.setString(1, id);
                ps.setString(2, tourName);
                ps.setString(3, image);
                ps.setString(4, date);
                ps.setString(5, price);
                ps.setString(6, journeys);
                ps.setString(7, description1);
                ps.setString(8, category);
                ps.setInt(9, sellId);
                ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



	public static void main(String[] args) {
		DAO dao = new DAO();
		List<tour> list = dao.getAllTour();
		for(tour i : list) 
			System.out.print(i);
		List<categories> listC = dao.getAllCategories();
		for (categories o : listC) {
			// In ra thông tin của từng danh mục
			System.out.println(o);
		}
	}
}

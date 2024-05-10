package loadDAO;

import java.sql.Connection;
import entity.categories;
import entity.tour;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import context.DBContext;

public class DAO {
	// Biến kết nối và thực thi truy vấn
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	// Lấy tất cả tour
	public List<tour> getAllTour() {
		List<tour> list = new ArrayList<>();
		String query = "SELECT * FROM tour";
		try {
			conn = new DBContext().getConnection(); // Mở kết nối với SQL
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new tour(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5),
						rs.getString(6), rs.getString(7), rs.getInt(8), rs.getInt(9)));
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

package Load_db;

	import connect_data.DBContext;
	import table_data.tour;
	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.util.ArrayList;
	import java.util.List;

public class load {
	    Connection conn = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;

	    public List<tour> getAllTour() {
	        List<tour> list = new ArrayList<>();
	        String query = "select * from tour";
	        try {
	            conn = new DBContext().getConnection();//mo ket noi voi sql
	            ps = conn.prepareStatement(query);
	            rs = ps.executeQuery();
	      
	            while (rs.next()) {
	                list.add(new tour(
	                		rs.getInt(1),
	                        rs.getString(2),
	                        rs.getString(3),
	                        rs.getString(4),
	                        rs.getDouble(5),
	                        rs.getString(6),
	                        rs.getString(7),
	                        rs.getString(8),
	                        rs.getString(9),
	                        rs.getInt(10),
	                        rs.getInt(11)));
	            }
	        } catch (Exception e) {
	        }
	        return list;
	    }

	    public static void main(String[] args) {
	    	load Load = new load();
	    	List<tour>list = Lish
	    }
	    public List<tour> getTop3() {
	        List<tour> list = new ArrayList<>();
	        String query = "select top 3 * from tour";
	        try {
	            conn = new DBContext().getConnection();//mo ket noi voi sql
	            ps = conn.prepareStatement(query);
	            rs = ps.executeQuery();
	            while (rs.next()) {
	                list.add(new tour(rs.getInt(1),
	                        rs.getString(2),
	                        rs.getString(3),
	                        rs.getDouble(4),
	                        rs.getString(5),
	                        rs.getString(6)));
	            }
	        } catch (Exception e) {
	        }
	        return list;
	    }

	    public List<tour> getNext3tour(int amount) {
	        List<tour> list = new ArrayList<>();
	        String query = "SELECT *\n"
	                + "  FROM tour\n"
	                + " ORDER BY id\n"
	                + "OFFSET ? ROWS\n"
	                + " FETCH NEXT 3 ROWS ONLY";
	        try {
	            conn = new DBContext().getConnection();//mo ket noi voi sql
	            ps = conn.prepareStatement(query);
	            ps.setInt(1, amount);
	            rs = ps.executeQuery();
	            while (rs.next()) {
	                list.add(new tour(rs.getInt(1),
	                        rs.getString(2),
	                        rs.getString(3),
	                        rs.getDouble(4),
	                        rs.getString(5),
	                        rs.getString(6)));
	            }
	        } catch (Exception e) {
	        }
	        return list;
	    }
	    public List<tour> gettourByCID(String cid) {
	        List<tour> list = new ArrayList<>();
	        String query = "select * from tour\n"
	                + "where cateID = ?";
	        try {
	            conn = new DBContext().getConnection();//mo ket noi voi sql
	            ps = conn.prepareStatement(query);
	            ps.setString(1, cid);
	            rs = ps.executeQuery();
	            while (rs.next()) {
	                list.add(new tour(rs.getInt(1),
	                        rs.getString(2),
	                        rs.getString(3),
	                        rs.getDouble(4),
	                        rs.getString(5),
	                        rs.getString(6)));
	            }
	        } catch (Exception e) {
	        }
	        return list;
	    }

	    public List<tour> gettourBySellID(int id) {
	        List<tour> list = new ArrayList<>();
	        String query = "select * from tour\n"
	                + "where sell_ID = ?";
	        try {
	            conn = new DBContext().getConnection();//mo ket noi voi sql
	            ps = conn.prepareStatement(query);
	            ps.setInt(1, id);
	            rs = ps.executeQuery();
	            while (rs.next()) {
	                list.add(new tour(rs.getInt(1),
	                        rs.getString(2),
	                        rs.getString(3),
	                        rs.getDouble(4),
	                        rs.getString(5),
	                        rs.getString(6)));
	            }
	        } catch (Exception e) {
	        }
	        return list;
	    }

	    public List<tour> searchByName(String txtSearch) {
	        List<tour> list = new ArrayList<>();
	        String query = "select * from tour\n"
	                + "where [name] like ?";
	        try {
	            conn = new DBContext().getConnection();//mo ket noi voi sql
	            ps = conn.prepareStatement(query);
	            ps.setString(1, "%" + txtSearch + "%");
	            rs = ps.executeQuery();
	            while (rs.next()) {
	                list.add(new tour(rs.getInt(1),
	                        rs.getString(2),
	                        rs.getString(3),
	                        rs.getDouble(4),
	                        rs.getString(5),
	                        rs.getString(6)));
	            }
	        } catch (Exception e) {
	        }
	        return list;
	    }

	    public tour gettourByID(String id) {
	        String query = "select * from tour\n"
	                + "where id = ?";
	        try {
	            conn = new DBContext().getConnection();//mo ket noi voi sql
	            ps = conn.prepareStatement(query);
	            ps.setString(1, id);
	            rs = ps.executeQuery();
	            while (rs.next()) {
	                return new tour(rs.getInt(1),
	                        rs.getString(2),
	                        rs.getString(3),
	                        rs.getDouble(4),
	                        rs.getString(5),
	                        rs.getString(6));
	            }
	        } catch (Exception e) {
	        }
	        return null;
	    }

	    public List<Category> getAllCategory() {
	        List<Category> list = new ArrayList<>();
	        String query = "select * from Category";
	        try {
	            conn = new DBContext().getConnection();//mo ket noi voi sql
	            ps = conn.prepareStatement(query);
	            rs = ps.executeQuery();
	            while (rs.next()) {
	                list.add(new Category(rs.getInt(1),
	                        rs.getString(2)));
	            }
	        } catch (Exception e) {
	        }
	        return list;
	    }

	    public tour getLast() {
	        String query = "select top 1 * from tour\n"
	                + "order by id desc";
	        try {
	            conn = new DBContext().getConnection();//mo ket noi voi sql
	            ps = conn.prepareStatement(query);
	            rs = ps.executeQuery();
	            while (rs.next()) {
	                return new tour(rs.getInt(1),
	                        rs.getString(2),
	                        rs.getString(3),
	                        rs.getDouble(4),
	                        rs.getString(5),
	                        rs.getString(6));
	            }
	        } catch (Exception e) {
	        }
	        return null;
	    }

	    public Account login(String user, String pass) {
	        String query = "select * from account\n"
	                + "where [user] = ?\n"
	                + "and pass = ?";
	        try {
	            conn = new DBContext().getConnection();//mo ket noi voi sql
	            ps = conn.prepareStatement(query);
	            ps.setString(1, user);
	            ps.setString(2, pass);
	            rs = ps.executeQuery();
	            while (rs.next()) {
	                return new Account(rs.getInt(1),
	                        rs.getString(2),
	                        rs.getString(3),
	                        rs.getInt(4),
	                        rs.getInt(5));
	            }
	        } catch (Exception e) {
	        }
	        return null;
	    }

	    public Account checkAccountExist(String user) {
	        String query = "select * from account\n"
	                + "where [user] = ?\n";
	        try {
	            conn = new DBContext().getConnection();//mo ket noi voi sql
	            ps = conn.prepareStatement(query);
	            ps.setString(1, user);
	            rs = ps.executeQuery();
	            while (rs.next()) {
	                return new Account(rs.getInt(1),
	                        rs.getString(2),
	                        rs.getString(3),
	                        rs.getInt(4),
	                        rs.getInt(5));
	            }
	        } catch (Exception e) {
	        }
	        return null;
	    }

	    public void singup(String user, String pass) {
	        String query = "insert into account\n"
	                + "values(?,?,0,0)";
	        try {
	            conn = new DBContext().getConnection();//mo ket noi voi sql
	            ps = conn.prepareStatement(query);
	            ps.setString(1, user);
	            ps.setString(2, pass);
	            ps.executeUpdate();
	        } catch (Exception e) {
	        }
	    }

	    public void deletetour(String pid) {
	        String query = "delete from tour\n"
	                + "where id = ?";
	        try {
	            conn = new DBContext().getConnection();//mo ket noi voi sql
	            ps = conn.prepareStatement(query);
	            ps.setString(1, pid);
	            ps.executeUpdate();
	        } catch (Exception e) {
	        }
	    }

	    public void inserttour(String name, String image, String price,
	            String title, String description, String category, int sid) {
	        String query = "INSERT [dbo].[tour] \n"
	                + "([name], [image], [price], [title], [description], [cateID], [sell_ID])\n"
	                + "VALUES(?,?,?,?,?,?,?)";
	        try {
	            conn = new DBContext().getConnection();//mo ket noi voi sql
	            ps = conn.prepareStatement(query);
	            ps.setString(1, name);
	            ps.setString(2, image);
	            ps.setString(3, price);
	            ps.setString(4, title);
	            ps.setString(5, description);
	            ps.setString(6, category);
	            ps.setInt(7, sid);
	            ps.executeUpdate();
	        } catch (Exception e) {
	        }
	    }

	    public void edittour(String name, String image, String price,
	            String title, String description, String category, String pid) {
	        String query = "update tour\n"
	                + "set [name] = ?,\n"
	                + "[image] = ?,\n"
	                + "price = ?,\n"
	                + "title = ?,\n"
	                + "[description] = ?,\n"
	                + "cateID = ?\n"
	                + "where id = ?";
	        try {
	            conn = new DBContext().getConnection();//mo ket noi voi sql
	            ps = conn.prepareStatement(query);
	            ps.setString(1, name);
	            ps.setString(2, image);
	            ps.setString(3, price);
	            ps.setString(4, title);
	            ps.setString(5, description);
	            ps.setString(6, category);
	            ps.setString(7, pid);
	            ps.executeUpdate();
	        } catch (Exception e) {
	        }
	    }

	    public static void main(String[] args) {
	        load load = new load();
	        List<tour> list = load.getAlltour();
	        List<Category> listC = load.getAllCategory();

	        for (Category o : listC) {
	            System.out.println(o);
	        }
	    

}

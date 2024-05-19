package loadDAO;

import context.DBContext;
import entity.Admin_Quan_Help;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Admin_Quan_Help_DAO {

    public List<Admin_Quan_Help> getAllHelp() throws ClassNotFoundException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        List<Admin_Quan_Help> helpList = new ArrayList<>();
        try {
        	conn = DBContext.getConnection();
        	System.out.println("Connections sussces");

        	String sql = "SELECT * FROM Help";
        	
            pstmt = conn.prepareStatement(sql);

            rs = pstmt.executeQuery();

            while (rs.next()) {
            	System.out.println("Successfully got the list of questions");
            	
                String idCauHoi = rs.getString("idCauHoi");
                String cauHoi = rs.getString("cauHoi");
                String cauTraLoi = rs.getString("cauTraLoi");

                Admin_Quan_Help help = new Admin_Quan_Help(idCauHoi, cauHoi, cauTraLoi);
                helpList.add(help);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return helpList;
    }

    public String themCauHoi(Admin_Quan_Help help) throws SQLException, ClassNotFoundException {
        String result = "";
        if (help == null || help.getIdCauHoi() == null || help.getIdCauHoi().isEmpty()) {
        	System.out.println("Please enter complete information");
            return "Vui lòng nhập đầy đủ thông tin";
        }
        if (help.getCauHoi() == null || help.getCauHoi().isEmpty() || help.getCauTraLoi() == null || help.getCauTraLoi().isEmpty()) {
        	System.out.println("Please enter complete information");
        	return "Vui lòng nhập đầy đủ thông tin";
        }
        String sql = "INSERT INTO help (idCauHoi, cauHoi, cauTraLoi) VALUES (?, ?, ?)";
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
        	conn = DBContext.getConnection();
        	System.out.println("Connections sussces");
        	
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, help.getIdCauHoi());
            pstmt.setString(2, help.getCauHoi());
            pstmt.setString(3, help.getCauTraLoi());

            if (pstmt.executeUpdate() > 0) {
            	System.out.println("Adding questions susscess");
                result = "Thêm câu hỏi thành công";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            result = "ID câu hỏi đã tồn tại";
        } finally {
            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return result;
    }
    
    public String xoaCauHoi(String idCauHoi) throws SQLException, ClassNotFoundException {
        String result = "";
        if (idCauHoi == null || idCauHoi.isEmpty()) {
        	System.out.println("Please enter complete information");
            return "Vui lòng nhập đầy đủ thông tin";
        }
        String sql = "DELETE FROM help WHERE idCauHoi=?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
        	conn = DBContext.getConnection();
        	System.out.println("Connections sussces");
        	
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, idCauHoi);

            if (pstmt.executeUpdate() > 0) {
            	System.out.println("Delete questions susscess");
                result = "Xóa câu hỏi thành công";
            }
            else {
            	System.out.println("Delete questions faild");
                result = "Không tìm thấy câu hỏi";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return result;
    }

    public String suaCauHoi(Admin_Quan_Help help) throws SQLException, ClassNotFoundException {
        String result = "";
        if (help == null || help.getIdCauHoi() == null || help.getIdCauHoi().isEmpty()) {
        	System.out.println("Please enter complete information");
            return "Vui lòng nhập đầy đủ thông tin";
        }
        if (help.getCauHoi() == null || help.getCauHoi().isEmpty() || help.getCauTraLoi() == null || help.getCauTraLoi().isEmpty()) {
        	System.out.println("Please enter complete information");
            return "Vui lòng nhập đầy đủ thông tin";
        }
        String sql = "UPDATE help SET cauHoi=?, cauTraLoi=? WHERE idCauHoi=?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
        	conn = DBContext.getConnection();
        	System.out.println("Connections sussces");
        	
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, help.getCauHoi());
            pstmt.setString(2, help.getCauTraLoi());
            pstmt.setString(3, help.getIdCauHoi());

            if (pstmt.executeUpdate() > 0) {
            	System.out.println("Change questions susscess");
                result = "Cập nhật câu hỏi thành công";
            }
            else {
            	System.out.println("Change questions faild");
                result = "Không tìm thấy câu hỏi";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return result;
    }
}
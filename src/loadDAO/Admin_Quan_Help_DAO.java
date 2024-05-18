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

        	String sql = "SELECT * FROM Help";
        	
            // Prepare statement
            pstmt = conn.prepareStatement(sql);

            // Execute query
            rs = pstmt.executeQuery();

            // Process result set
            while (rs.next()) {
                String idCauHoi = rs.getString("idCauHoi");
                String cauHoi = rs.getString("cauHoi");
                String cauTraLoi = rs.getString("cauTraLoi");

                // Create Help object and add to list
                Admin_Quan_Help help = new Admin_Quan_Help(idCauHoi, cauHoi, cauTraLoi);
                helpList.add(help);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close resources
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

    // Phương thức thêm câu hỏi
    public int themCauHoi(Admin_Quan_Help help) throws SQLException, ClassNotFoundException {
        int result = 0;
        if (help == null || help.getIdCauHoi() == null || help.getIdCauHoi().isEmpty())
            return 0;
        if (help.getCauHoi() == null || help.getCauHoi().isEmpty() || help.getCauTraLoi() == null || help.getCauTraLoi().isEmpty())
            return 1;
        String sql = "INSERT INTO help (idCauHoi, cauHoi, cauTraLoi) VALUES (?, ?, ?)";
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
        	conn = DBContext.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, help.getIdCauHoi());
            pstmt.setString(2, help.getCauHoi());
            pstmt.setString(3, help.getCauTraLoi());

            // Execute insert query
            if (pstmt.executeUpdate() > 0)
                result = 10;
        } catch (SQLException e) {
            e.printStackTrace();
            result = 3;
        } finally {
            // Close resources
            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return result;
    }

    // Phương thức xóa câu hỏi
    public int xoaCauHoi(String idCauHoi) throws SQLException, ClassNotFoundException {
        int result = 0;
        if (idCauHoi == null || idCauHoi.isEmpty())
            return 0;
        String sql = "DELETE FROM help WHERE idCauHoi=?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
        	conn = DBContext.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, idCauHoi);

            // Execute delete query
            if (pstmt.executeUpdate() > 0)
                result = 10;
            else
                result = 3;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close resources
            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return result;
    }

    // Phương thức sửa câu hỏi
    public int suaCauHoi(Admin_Quan_Help help) throws SQLException, ClassNotFoundException {
        int result = 0;
        if (help == null || help.getIdCauHoi() == null || help.getIdCauHoi().isEmpty())
            return 0;
        if (help.getCauHoi() == null || help.getCauHoi().isEmpty() || help.getCauTraLoi() == null || help.getCauTraLoi().isEmpty())
            return 1;
        String sql = "UPDATE help SET cauHoi=?, cauTraLoi=? WHERE idCauHoi=?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
        	conn = DBContext.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, help.getCauHoi());
            pstmt.setString(2, help.getCauTraLoi());
            pstmt.setString(3, help.getIdCauHoi());

            // Execute update query
            if (pstmt.executeUpdate() > 0)
                result = 10;
            else
                result = 3;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close resources
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
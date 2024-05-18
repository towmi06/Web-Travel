package loadDAO;

import context.DBContext;
import entity.Admin_Quan_Cooperate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Admin_Quan_Cooperate_DAO {
	
    public List<Admin_Quan_Cooperate> getAllCooperates() throws ClassNotFoundException {
    	Connection conn = null;
        Statement stmt = null;
    	
        List<Admin_Quan_Cooperate> cooperateList = new ArrayList<>();
        String query = "SELECT * FROM Cooperate";

        try {
        	conn = DBContext.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
            	Admin_Quan_Cooperate cooperate = new Admin_Quan_Cooperate();
                cooperate.setTenNCC(rs.getString("tenNCC"));
                cooperate.setEmail(rs.getString("email"));
                cooperate.setSoDienThoai(rs.getString("soDienThoai"));
                cooperate.setDiaChi(rs.getString("diaChi"));
                cooperate.setNgayGui(rs.getString("ngayGui"));
                cooperate.setNoiDungHopTac(rs.getString("noiDungHopTac"));
                cooperateList.add(cooperate);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cooperateList;
    }
}

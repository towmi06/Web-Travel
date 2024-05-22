package loadDAO;

import context.DBContext;
import entity.Admin_Quan_Cooperate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Admin_Quan_Cooperate_DAO {
    
    public List<Admin_Quan_Cooperate> getAllCooperates() throws ClassNotFoundException {
        List<Admin_Quan_Cooperate> cooperateList = new ArrayList<>();
        String query = "SELECT * FROM Cooperate";

        try {
        	Connection conn = DBContext.getConnection();
        	System.out.println("Connections sussces");
        	
            PreparedStatement pstmt = conn.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
            	System.out.println("Successfully got the list of cooperates");
            	
                String tenNCC = rs.getString("tenNCC");
                String email = rs.getString("email");
                String soDienThoai = rs.getString("soDienThoai");
                String diaChi = rs.getString("diaChi");
                String ngayGui = rs.getString("ngayGui");
                String noiDungHopTac = rs.getString("noiDungHopTac");

                Admin_Quan_Cooperate cooperate = new Admin_Quan_Cooperate(tenNCC, email, soDienThoai, diaChi, ngayGui, noiDungHopTac);
                cooperateList.add(cooperate);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cooperateList;
    }
}

package Admin_Quan.cooperate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CooperateDAO {
    private Connection getConnection() throws SQLException {
        // Establish connection
        String urlDB = "jdbc:sqlserver://DESKTOP-HM360E0\\MSSQLSERVER04:1433;databaseName=Web Travel";
        String user = "sa";
        String password = "12345";
        return DriverManager.getConnection(urlDB, user, password);
    }

    public List<Cooperate> getAllCooperates() {
        List<Cooperate> cooperateList = new ArrayList<>();
        String query = "SELECT * FROM Cooperate";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Cooperate cooperate = new Cooperate();
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
    
    public static void main(String[] args) {
        CooperateDAO cooperateDAO = new CooperateDAO();
        List<Cooperate> cooperates = cooperateDAO.getAllCooperates();
        for (Cooperate cooperate : cooperates) {
            System.out.println(cooperate.toString());
        }
    }
}

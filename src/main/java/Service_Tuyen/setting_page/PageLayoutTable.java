package Service_Tuyen.setting_page;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class PageLayoutTable {

    public static void main(String[] args) {
        // Thông tin kết nối
        String urlDB = "jdbc:sqlserver://DESKTOP-00GD31A\\LEY:1433;databaseName=WEB TOUR";
        String user = "sa";
        String password = "12345";

        // Câu lệnh tạo bảng
        String createTableSQL = "CREATE TABLE PageLayout ("
                + "taiKhoan NVARCHAR(255), "
                + "sapXep BIT, "
                + "dichVuNoiBat BIT, "
                + "chuongTrinhKhuyenMai BIT, "
                + "soSanPhamMoiTrang INT"
                + ")";

        try (Connection conn = DriverManager.getConnection(urlDB, user, password);
             Statement statement = conn.createStatement()) {
            // Thực thi câu lệnh tạo bảng
            statement.execute(createTableSQL);
            System.out.println("Table created successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

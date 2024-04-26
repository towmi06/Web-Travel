package Load_db;

import java.sql.*;
import javax.imageio.ImageIO;

import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import javax.swing.*;

public class loadImg {
    // Phương thức để kết nối đến cơ sở dữ liệu và hiển thị hình ảnh từ tên file
    public void displayImageFromDB() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Kết nối đến cơ sở dữ liệu
            conn = DriverManager.getConnection("jdbc:sqlserver://TOWMIESS:1433/tour", "user", "12345");

            // Thực hiện truy vấn SQL để lấy tên file ảnh
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT image FROM dsTour");

            // Hiển thị ảnh
            while (rs.next()) {
                String tenFileAnh = rs.getString("ten_file_anh");
                displayImage(tenFileAnh);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Phương thức hiển thị ảnh từ tên file
    private void displayImage(String tenFileAnh) {
        try {
            // Đọc tệp ảnh từ ổ đĩa
            BufferedImage image = ImageIO.read(new File(tenFileAnh));

            // Hiển thị ảnh trong cửa sổ
            ImageIcon icon = new ImageIcon(image);
            JFrame frame = new JFrame();
            frame.setLayout(new FlowLayout());
            frame.setSize(300, 300);
            JLabel lbl = new JLabel();
            lbl.setIcon(icon);
            frame.add(lbl);
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

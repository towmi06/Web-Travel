package loadDAO;

import context.DBContext;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Admin_Quan_Notification_Mailbox_DAO {

    public List<String> getNotificationList() throws ClassNotFoundException {
        List<String> notificationList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = DBContext.getConnection();
            String sql = "SELECT content FROM notification";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                String content = rs.getString("content");
                notificationList.add(content);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return notificationList;
    }

    public List<String> getMailboxList() throws ClassNotFoundException {
        List<String> mailboxList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = DBContext.getConnection();
            String sql = "SELECT content FROM mailbox";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                String content = rs.getString("content");
                mailboxList.add(content);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return mailboxList;
    }

    public String addNotification(String content) throws ClassNotFoundException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DBContext.getConnection();
            String sql = "INSERT INTO notification (content) VALUES (?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, content);
            pstmt.executeUpdate();
            return "Gửi thông báo thành công";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Lỗi khi gửi thông báo";
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public String addMailbox(String content) throws ClassNotFoundException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DBContext.getConnection();
            String sql = "INSERT INTO mailbox (content) VALUES (?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, content);
            pstmt.executeUpdate();
            return "Gửi thư thành công";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Lỗi khi gửi thư";
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

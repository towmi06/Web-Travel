package Admin_Quan.help;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Help {
    private String idCauHoi;
    private String cauHoi;
    private String cauTraLoi;

    // Constructor
    public Help(String idCauHoi, String cauHoi, String cauTraLoi) {
        this.idCauHoi = idCauHoi;
        this.cauHoi = cauHoi;
        this.cauTraLoi = cauTraLoi;
    }

    // Getters and Setters
    public String getIdCauHoi() {
        return idCauHoi;
    }

    public void setIdCauHoi(String idCauHoi) {
        this.idCauHoi = idCauHoi;
    }

    public String getCauHoi() {
        return cauHoi;
    }

    public void setCauHoi(String cauHoi) {
        this.cauHoi = cauHoi;
    }

    public String getCauTraLoi() {
        return cauTraLoi;
    }

    public void setCauTraLoi(String cauTraLoi) {
        this.cauTraLoi = cauTraLoi;
    }

    // toString method
    @Override
    public String toString() {
        return "ID câu hỏi: " + idCauHoi + ", Câu hỏi: " + cauHoi + ", Câu trả lời: " + cauTraLoi;
    }
    
 // Phương thức thêm câu hỏi
    public int themCauHoi() throws SQLException {
        int result = 0;
        if (idCauHoi == null || idCauHoi.length() <= 0)
            return 0;
        if (cauHoi == null || cauHoi.length() <= 0 || cauTraLoi == null || cauTraLoi.length() <= 0)
            return 1;
        String sql = "";
        Connection conn = null;
        Statement statement = null;
        ResultSet rs = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
            String dburl = "jdbc:sqlserver://localhost:1433;databaseName=Web Travel"; 
            String username = "sa";
            String userpass = "12345";
            conn = DriverManager.getConnection(dburl, username, userpass);
            statement = conn.createStatement();
            sql = "SELECT * FROM help WHERE idCauHoi='" + idCauHoi + "'";
            rs = statement.executeQuery(sql);
            if (!rs.next()) {
                sql = "INSERT INTO help (idCauHoi, cauHoi, cauTraLoi) VALUES ('" + idCauHoi + "','" + cauHoi + "','" + cauTraLoi + "')";
                if (statement.executeUpdate(sql) > 0)
                    result = 10;
            } else
                result = 3;
            rs.close();
            statement.close();
            conn.close();
        } catch (Exception e) {
            if (rs != null)
                rs.close();
            if (statement != null)
                statement.close();
            if (conn != null)
                conn.close();
            System.out.println(e.toString());
        }
        return result;
    }

    // Phương thức xóa câu hỏi
    public int xoaCauHoi() throws SQLException {
        int result = 0;
        if (idCauHoi == null || idCauHoi.length() <= 0)
            return 0;
        String sql = "";
        Connection conn = null;
        Statement statement = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
            String dburl = "jdbc:sqlserver://localhost:1433;databaseName=Web Travel";
            String username = "sa";
            String userpass = "12345";
            conn = DriverManager.getConnection(dburl, username, userpass);
            statement = conn.createStatement();
            sql = "DELETE FROM help WHERE idCauHoi='" + idCauHoi + "'";
            if (statement.executeUpdate(sql) > 0)
                result = 10;
            else
                result = 3;
            statement.close();
            conn.close();
        } catch (Exception e) {
            if (statement != null)
                statement.close();
            if (conn != null)
                conn.close();
            System.out.println(e.toString());
        }
        return result;
    }

    // Phương thức sửa câu hỏi
    public int suaCauHoi() throws SQLException {
        int result = 0;
        if (idCauHoi == null || idCauHoi.length() <= 0)
            return 0;
        if (cauHoi == null || cauHoi.length() <= 0 || cauTraLoi == null || cauTraLoi.length() <= 0)
            return 1;
        String sql = "";
        Connection conn = null;
        Statement statement = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
            String dburl = "jdbc:sqlserver://localhost:1433;databaseName=Web Travel"; 
            String username = "sa";
            String userpass = "12345";
            conn = DriverManager.getConnection(dburl, username, userpass);
            statement = conn.createStatement();
            sql = "SELECT * FROM help WHERE idCauHoi='" + idCauHoi + "'";
            ResultSet rs = statement.executeQuery(sql);
            if (rs.next()) {
                sql = "UPDATE help SET cauHoi='" + cauHoi + "', cauTraLoi='" + cauTraLoi + "' WHERE idCauHoi='" + idCauHoi + "'";
                if (statement.executeUpdate(sql) > 0)
                    result = 10;
            } else
                result = 3;
            rs.close();
            statement.close();
            conn.close();
        } catch (Exception e) {
            if (statement != null)
                statement.close();
            if (conn != null)
                conn.close();
            System.out.println(e.toString());
        }
        return result;
    }
    
    public static void main(String[] args) throws SQLException { 
    	Help test = new Help("QA004", "Q4", "A4");
    	test.xoaCauHoi();
    }
}

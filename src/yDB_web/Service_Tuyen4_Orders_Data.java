package yDB_web;

import context.DBContext;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Service_Tuyen4_Orders_Data {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DBContext.getConnection();
            
            // Connection success message
            System.out.println("Connection success!");
            
            // Create table
            Statement statement = conn.createStatement();
            String createTableSQL = "CREATE TABLE Orders (" +
                    "ID VARCHAR(50) PRIMARY KEY," +
                    "sell_ID VARCHAR(50)," +
                    "customer_ID VARCHAR(50)," +
                    "tour_ID VARCHAR(50)," +
                    "booking_date VARCHAR(50)," +
                    "tourName NVARCHAR(100)," +
                    "date NVARCHAR(100)," +
                    "numberOfPeople INT," +
                    "price BIGINT," +
                    "type NVARCHAR(50)," +
                    "status NVARCHAR(50)" +
                    ")";
            statement.executeUpdate(createTableSQL);
            System.out.println("Table created successfully.");

            // Prepare statement for data insertion
            String insertSQL = "INSERT INTO Orders (ID, sell_ID, customer_ID, tour_ID, booking_date, tourName, date, numberOfPeople, price, type, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(insertSQL);

            // Insert data into the table
            String[] billData = {
                "OD001", "1", "KH001", "A10", "10/05/2024", "Soc Trang", "3 Ngay 2 Dem", "4", "5000000", "Tham Quan", "Chua xac nhan",
                "OD002", "1", "KH006", "a17", "22/06/2023", "Đong Nai", "2 Ngay 1 Dem", "8", "8000000", "Phuot", "Da xac nhan",
                "OD003", "1", "KH009", "a19", "23/04/2024", "Binh Phuoc", "2 Ngay 1 Dem", "3", "2500000", "Trecking", "Dang thuc hien",
                "OD004", "1", "KH010", "a20", "24/04/2024", "Ben Tre", "3 Ngay 2 Dem", "1", "1300000", "Tham Quan", "Hoan thanh",
                "OD005", "1", "KH003", "A38", "15/07/2024", "Ha Long", "4 Ngay 3 Dem", "7", "9000000", "Camping", "Da Huy",
                "OD006", "1", "KH002", "A41", "14/05/2024", "Tay Bac", "3 Ngay 2 Dem", "2", "3000000", "Camping", "Chua xac nhan",
                "OD007", "1", "KH012", "a9", "13/07/2023", "Chau Doc", "4 Ngay 3 Dem", "10", "11250000", "Tham Quan", "Da xac nhan",
                "OD008", "1", "KH019", "A10", "22/01/2024", "Soc Trang", "3 Ngay 2 Dem", "11", "9500000", "Tham Quan", "Dang thuc hien",
                "OD009", "1", "KH025", "a19", "02/02/2024", "Binh Phuoc", "4 Ngay 3 Dem", "9", "9000000", "Phuot", "Hoan thanh",
                "OD010", "1", "KH030", "A41", "17/05/2024", "Tay Bac", "3 Ngay 3 Dem", "2", "2000000", "Trecking", "Da Huy",

                "OD011", "2", "KH011", "a11", "01/02/2024", "Binh Duong", "3 Ngay 2 Dem", "6", "5800000", "Phuot", "Chua xac nhan",
                "OD012", "2", "KH016", "a13", "12/02/2024", "Ha Tien", "2 Ngay 1 Dem", "17", "18000000", "Phuot", "Da xac nhan",
                "OD013", "2", "KH008", "a30", "23/03/2024", "Hau Giang", "2 Ngay 1 Dem", "3", "2500000", "Trecking", "Dang thuc hien",
                "OD014", "2", "KH013", "a11", "29/02/2024", "Binh Duong", "3 Ngay 2 Dem", "5", "1290000", "Tham Quan", "Hoan thanh",
                "OD015", "2", "KH004", "a11", "23/01/2024", "Binh Duong", "3 Ngay 2 Dem", "4", "8200000", "Camping", "Da Huy",
                "OD016", "2", "KH007", "a30", "17/02/2024", "Hau Giang", "3 Ngay 2 Dem", "11", "12000000", "Camping", "Chua xac nhan",
                "OD017", "2", "KH013", "a13", "09/02/2024", "Hau Tien", "2 Ngay 1 Dem", "6", "11250000", "Tham Quan", "Da xac nhan",
                "OD018", "2", "KH020", "a30", "12/02/2024", "Hau Giang", "3 Ngay 2 Dem", "4", "550000", "Tham Quan", "Dang thuc hien",
                "OD019", "2", "KH028", "a11", "19/05/2024", "Binh Duong", "3 Ngay 2 Dem", "9", "9000000", "Tham Quan", "Hoan thanh",
                "OD020", "2", "KH003", "a11", "14/05/2024", "Binh Duong", "3 Ngay 3 Dem", "2", "2000000", "Trecking", "Da Huy",

                "OD021", "3", "KH012", "a16", "22/04/2024", "Dong Thap", "1 Ngay 1 Dem", "2", "2800000", "Phuot", "Chua xac nhan",
                "OD022", "3", "KH026", "a25", "27/04/2024", "Dong Thap", "2 Ngay 1 Dem", "12", "17000000", "Phuot", "Da xac nhan",
                "OD023", "3", "KH018", "a32", "22/02/2024", "Long An", "2 Ngay 1 Dem", "4", "5500000", "Trecking", "Dang thuc hien",
                "OD024", "3", "KH015", "A50", "17/05/2024", "Sapa", "3 Ngay 2 Dem", "6", "790000", "Tham Quan", "Hoan thanh",
                "OD025", "3", "KH001", "A50", "08/04/2024", "Sapa", "3 Ngay 2 Dem", "8", "8800000", "Camping", "Da Huy",
                "OD026", "3", "KH009", "A52", "29/01/2024", "Ha Long", "3 Ngay 2 Dem", "11", "12000000", "Camping", "Chua xac nhan",
                "OD027", "3", "KH016", "a8", "21/02/2024", "Con Dao", "2 Ngay 1 Dem", "6", "11250000", "Tham Quan", "Da xac nhan",
                "OD028", "3", "KH022", "a16", "01/06/2024", "Dong Thap", "3 Ngay 2 Dem", "4", "550000", "Tham Quan", "Dang thuc hien",
                "OD029", "3", "KH023", "a8", "22/12/2023", "Con Dao", "4 Ngay 3 Dem", "9", "9000000", "Tham Quan", "Hoan thanh",
                "OD030", "3", "KH003", "a16", "17/05/2024", "Dong Thap", "3 Ngay 3 Dem", "2", "2000000", "Trecking", "Da Huy",
            };

            // Loop through the array and insert data into the table
            for (int i = 0; i < billData.length; i += 11) {
            	pstmt.setString(1, billData[i]);
                pstmt.setString(2, billData[i + 1]);
                pstmt.setString(3, billData[i + 2]);
                pstmt.setString(4, billData[i + 3]);
                pstmt.setString(5, billData[i + 4]);
                pstmt.setString(6, billData[i + 5]);
                pstmt.setString(7, billData[i + 6]);
                pstmt.setInt(8, Integer.parseInt(billData[i + 7]));
                pstmt.setLong(9, Long.parseLong(billData[i + 8]));
                pstmt.setString(10, billData[i + 9]);
                pstmt.setString(11, billData[i + 10]);
                pstmt.executeUpdate();
            }

            System.out.println("Data inserted successfully.");

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

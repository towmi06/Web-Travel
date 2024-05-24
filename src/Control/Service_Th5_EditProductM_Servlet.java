package Control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Service_Th3_ProductManage;
import loadDAO.Service_Th3_ProductManagerDAO;

@WebServlet("/Service_Th5_EditProductM_Servlet")
public class Service_Th5_EditProductM_Servlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final Service_Th3_ProductManagerDAO productManagerDAO = new Service_Th3_ProductManagerDAO(); // Tạo đối tượng DAO
    
    public Service_Th5_EditProductM_Servlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy ID của tour cần chỉnh sửa từ request parameter
        String tourId = request.getParameter("id");
        
        // Lấy thông tin của tour từ cơ sở dữ liệu
        Service_Th3_ProductManage product = productManagerDAO.getActiveProductsBySellId(sellId); // Sửa thành getProductById
        
        // Truyền thông tin của tour vào request attribute để hiển thị trong trang JSP
        request.setAttribute("product", product);
        
        // Forward đến trang JSP để hiển thị form chỉnh sửa
        request.getRequestDispatcher("/EditTour.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Nhận các tham số từ form chỉnh sửa
        String name = request.getParameter("name");
        String image = request.getParameter("image");
        String price = request.getParameter("price");
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String category = request.getParameter("category");
        String id = request.getParameter("id");
        
        // Cập nhật thông tin của tour trong cơ sở dữ liệu
        boolean isSuccess = productManagerDAO.editProduct(name, image, price, title, description, category, id);
        
        // Hiển thị thông báo cập nhật thành công
        if (isSuccess) {
            request.setAttribute("message", "Tour information updated successfully");
        } else {
            request.setAttribute("message", "Failed to update tour information");
        }
        
        // Forward đến trang JSP để hiển thị thông báo
        request.getRequestDispatcher("/EditTour.jsp").forward(request, response);
    }
}

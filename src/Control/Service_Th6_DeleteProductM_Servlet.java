package Control;

import loadDAO.Service_Th3_ProductManagerDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/Service_Th6_DeleteProductM_Servlet")
public class Service_Th6_DeleteProductM_Servlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String id = request.getParameter("id");
        Service_Th3_ProductManagerDAO dao = new Service_Th3_ProductManagerDAO();

        // Kiểm tra xem sản phẩm có đơn hàng liên quan không
        if (dao.hasOrders(id)) {
            // Nếu có, hiển thị thông báo xác nhận xóa trên cùng trang
            request.setAttribute("confirmationMessage", "Có đơn hàng liên quan đến sản phẩm này. Bạn có chắc chắn muốn xóa?");
            request.setAttribute("id", id); // Truyền id sản phẩm để xóa vào JSP
            dao.deleteProduct(id);
            response.sendRedirect("Service_Th3_ProducM_Servlet?sellId=" + request.getParameter("sellId"));
            return;
        }

        // Nếu không có đơn hàng liên quan, cập nhật trạng thái của sản phẩm và refresh lại trang
        dao.deleteProduct(id);
        response.sendRedirect("Service_Th3_ProducM_Servlet?sellId=" + request.getParameter("sellId"));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Xác nhận xóa từ phía người dùng
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Handles product deletion requests";
    }
}

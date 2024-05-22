package Control;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import loadDAO.Service_Th2_DetailOrder_DAO;
import entity.Service_Th2_DetailOrder;

@WebServlet("/Service_Th2_DetailOrderM_Servlet")
public class Service_Th2_DetailOrderM_Servlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy id từ tham số yêu cầu
    	String orderIdStr = request.getParameter("orderId");

        if (orderIdStr != null) {
            int orderId = Integer.parseInt(orderIdStr);

            // Sử dụng DAO để truy xuất chi tiết đơn hàng
            Service_Th2_DetailOrder_DAO orderDAO = new Service_Th2_DetailOrder_DAO();
            try {
                Service_Th2_DetailOrder orderDetail = orderDAO.getOrderById(orderId);
                // Đặt đối tượng chi tiết đơn hàng vào request và chuyển tiếp đến trang JSP để hiển thị
                request.setAttribute("orderDetail", orderDetail);
                request.getRequestDispatcher("/2.Service/3.QliOder/detailOrder.jsp").forward(request, response);
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Lỗi khi truy xuất chi tiết đơn hàng.");
            }
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID đơn hàng không hợp lệ.");
        }
    }
}

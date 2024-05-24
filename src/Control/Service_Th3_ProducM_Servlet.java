package Control;

import loadDAO.Service_Th3_ProductManagerDAO;
import entity.Service_Th3_ProductManage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/Service_Th3_ProducM_Servlet")
public class Service_Th3_ProducM_Servlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sellIdParam = request.getParameter("sellId");
        if (sellIdParam == null || sellIdParam.isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Yêu cầu tham số sellId.");
            return;
        }

        try {
            int sellId = Integer.parseInt(sellIdParam);
            Service_Th3_ProductManagerDAO dao = new Service_Th3_ProductManagerDAO();
            List<Service_Th3_ProductManage> products = dao.getActiveProductsBySellId(sellId);
            request.setAttribute("products", products);
            request.getRequestDispatcher("./2.Service/2.Qlidv/ListProduct.jsp").forward(request, response);
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Tham số sellId phải là số nguyên hợp lệ.");
        }
    }
}

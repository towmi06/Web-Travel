package Control;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import loadDAO.Service_th1_OrderM_DAO;
import entity.Service_Th1_OrderManager;

@WebServlet("/Service_Th1_OrderM")
public class Service_Th1_OrderM extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sellIdStr = request.getParameter("sellId");
        if (sellIdStr == null) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "sellId is required");
            return;
        }

        int sellId;
        try {
            sellId = Integer.parseInt(sellIdStr);
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid sellId");
            return;
        }

        Service_th1_OrderM_DAO orderDAO = new Service_th1_OrderM_DAO();
        List<Service_Th1_OrderManager> orders = null;
        try {
            orders = orderDAO.getOrdersBySellId(sellId);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        request.setAttribute("orders", orders);
        request.getRequestDispatcher("/2.Service/3.QliOder/orders.jsp").forward(request, response);
    }
}

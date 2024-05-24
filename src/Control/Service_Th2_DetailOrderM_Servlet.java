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
        String orderIdStr = request.getParameter("orderId");
        if (orderIdStr != null) {
            int orderId = Integer.parseInt(orderIdStr);
            Service_Th2_DetailOrder_DAO orderDAO = new Service_Th2_DetailOrder_DAO();
            try {
                Service_Th2_DetailOrder orderDetail = orderDAO.getOrderById(orderId);
                request.setAttribute("orderDetail", orderDetail);
                request.getRequestDispatcher("/2.Service/3.QliOder/detailOrder.jsp").forward(request, response);
            } catch (ClassNotFoundException | SQLException e) {
                handleError(response, "Error retrieving order details: " + e.getMessage());
            }
        } else {
            handleError(response, "Invalid order ID.");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String orderIdStr = request.getParameter("orderId");
        String message = "";

        if (orderIdStr != null) {
            int orderId = Integer.parseInt(orderIdStr);
            Service_Th2_DetailOrder_DAO orderDAO = new Service_Th2_DetailOrder_DAO();

            try {
                switch(action) {
                    case "accept":
                        Service_Th2_DetailOrder orderDetail = orderDAO.getOrderById(orderId);
                        if (orderDetail != null && orderDetail.getStatus().equals("pending")) {
                            orderDetail.setStatus("accepted");
                            orderDAO.updateOrder(orderDetail);
                            message = "Order has been successfully accepted.";
                        } else {
                            message = "Unable to accept order. The order might not be in pending status.";
                        }
                        break;
                    case "cancel":
                        orderDAO.deleteOrder(orderId);
                        message = "Order has been successfully cancelled.";
                        break;
                    case "complete":
                        orderDAO.completeOrder(orderId);
                        message = "Order has been successfully completed.";
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid action: " + action);
                }
                request.setAttribute("message", message);
                doGet(request, response);

            } catch (IllegalArgumentException e) {
                handleError(response, "Invalid action: " + action);
            } catch (ClassNotFoundException | SQLException e) {
                handleError(response, "Error processing request: " + e.getMessage());
            }
        } else {
            handleError(response, "Invalid order ID.");
        }
    }

    private void handleError(HttpServletResponse response, String message) throws IOException {
        response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, message);
    }
}

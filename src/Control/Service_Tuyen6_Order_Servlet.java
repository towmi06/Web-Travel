package Control;

import entity.Service_Th1_OrderManager;
import loadDAO.Service_Tuyen4_Orders_DAO;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class BillServlet
 */
@WebServlet("/OrderServlet")
public class Service_Tuyen6_Order_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int orderId;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Service_Tuyen6_Order_Servlet() {
        super();
        orderId = 0;
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		orderId = Integer.parseInt(request.getParameter("orderId"));
		session.setAttribute("orderId", orderId);
		
		response.sendRedirect("/Web_Travel/2.Service/index.jsp?callFunction=true");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}

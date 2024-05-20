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
 * Servlet implementation class UpdateBillServlet
 */
@WebServlet("/UpdateOrderServlet")
public class Service_Tuyen7_UpdateOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Service_Tuyen4_Orders_DAO ordersDAO;
	private int result;
	private int id;
    private int customerId;
    private String tourId;
    private String bookingDate;
    private double totalPrice;
    private String status;
    private String createdAt;
    private String updatedAt;
    private String customerName;
    private String phoneNumber;
    private String address;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Service_Tuyen7_UpdateOrderServlet() {
        super();
        ordersDAO = new Service_Tuyen4_Orders_DAO();
        result = 0;
        id = 0;
        customerId = 0;
        tourId = "";
        bookingDate = "";
        totalPrice = 0.0;
        status = "";
        createdAt = "";
        updatedAt = "";
        customerName = "";
        phoneNumber = "";
        address = "";
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		id = Integer.parseInt(request.getParameter("id"));
        customerId = Integer.parseInt(request.getParameter("customerId"));
        tourId = request.getParameter("tourId");
        bookingDate = request.getParameter("bookingDate");
        totalPrice = Double.parseDouble(request.getParameter("totalPrice"));
        status = request.getParameter("status");
        createdAt = request.getParameter("createdAt");
        updatedAt = request.getParameter("updatedAt");
        
        if(request.getParameter("btnSave") != null) {
        	try {
        		result = ordersDAO.updateOrder(id, customerId, tourId, bookingDate, totalPrice, status, createdAt, updatedAt);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
        	if(result == 10) 
            	session.setAttribute("message", "update thông tin đơn thành công");
            else 
            	session.setAttribute("message", "update thông tin đơn không thành công");
        	
        	response.sendRedirect("/Web_Travel/2.Service/index.jsp");
        }
        else if(request.getParameter("btnCancel") != null) {
        	try {
				result = ordersDAO.deleteOrder(id);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
        	if(result == 10) 
            	session.setAttribute("message", "xóa đơn thành công");
            else 
            	session.setAttribute("message", "xóa đơn không thành công");

        	response.sendRedirect("/Web_Travel/2.Service/index.jsp");
        }
     	
	}
}

package Control;

import entity.Service_Tuyen4_Order;
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
	private String id;
	private String sellID;
	private String customerID;
	private String tourID;
	private String bookingDate;
	private String tourName;
	private String date;
	private int numberOfPeople;
	private long price;
	private String type;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Service_Tuyen7_UpdateOrderServlet() {
        super();
        ordersDAO = new Service_Tuyen4_Orders_DAO();
        result = 0;
    	id = "";
    	sellID = "";
    	customerID = "";
    	tourID = "";
    	bookingDate = "";
    	tourName = "";
    	date = "";
    	numberOfPeople = 0;
    	price = 0;
    	type = "";
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
		
		id = request.getParameter("id");
	    sellID = request.getParameter("providerID");
	    customerID = request.getParameter("customerID");
	    tourID = request.getParameter("tourID");
	    bookingDate = request.getParameter("destination");
	    tourName = request.getParameter("tourName");
	    date = request.getParameter("departureDate");
	    numberOfPeople = Integer.parseInt(request.getParameter("numberOfPeople"));
	    price = Long.parseLong(request.getParameter("price"));
	    type = request.getParameter("type");
        
        if(request.getParameter("btnSave") != null) {
        	try {
				result = ordersDAO.updateOrder(id, sellID, customerID, tourID, bookingDate,  tourName, date, numberOfPeople, price, type);
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

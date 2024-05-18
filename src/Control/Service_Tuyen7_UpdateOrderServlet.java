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
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Service_Tuyen7_UpdateOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
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
		
		String id = request.getParameter("id");
	    String sellID = request.getParameter("providerID");
	    String customerID = request.getParameter("customerID");
	    String tourID = request.getParameter("tourID");
	    String bookingDate = request.getParameter("destination");
	    String tourName = request.getParameter("tourName");
	    String date = request.getParameter("departureDate");
	    int numberOfPeople = Integer.parseInt(request.getParameter("numberOfPeople"));
	    long price = Long.parseLong(request.getParameter("price"));
	    String type = request.getParameter("type");
        
        if(request.getParameter("btnSave") != null) {
        	int result = 0;
        	try {
				result = Service_Tuyen4_Orders_DAO.updateOrder(id, sellID, customerID, tourID, bookingDate,  tourName, date, numberOfPeople, price, type);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
        	if(result == 10) {
            	session.setAttribute("message", "update thông tin đơn thành công");
            }
            else {
            	session.setAttribute("message", "update thông tin đơn không thành công");
            }
            response.sendRedirect("/Web_Travel/2.Service/index.jsp");   	
        }
        else if(request.getParameter("btnCancel") != null) {
        	int result = 0;
        	try {
				result = Service_Tuyen4_Orders_DAO.deleteOrder(id);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
        	if(result == 10) {
            	session.setAttribute("message", "xóa đơn thành công");
            }
            else {
            	session.setAttribute("message", "xóa đơn không thành công");
            }
            response.sendRedirect("/Web_Travel/2.Service/index.jsp");   
        }
        	
	}

}

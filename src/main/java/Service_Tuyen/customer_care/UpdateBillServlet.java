package Service_Tuyen.customer_care;

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
@WebServlet("/UpdateBillServlet")
public class UpdateBillServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateBillServlet() {
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
        String providerID = request.getParameter("providerID");
        String customerID = request.getParameter("customerID");
        String tourName = request.getParameter("tourName");
        String destination = request.getParameter("destination");
        String departureDate = request.getParameter("departureDate");
        int numberOfPeople = Integer.parseInt(request.getParameter("numberOfPeople"));
        long price = Long.parseLong(request.getParameter("price"));
        String address = request.getParameter("address");
        String type = request.getParameter("type");
        
        if(request.getParameter("btnSave") != null) {
        	int result = 0;
        	try {
				result = Bill.updateBill(id, providerID, customerID, tourName, destination, departureDate, numberOfPeople, price, address, type);
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
            response.sendRedirect("/Web_Travel/3.Service/index.jsp");   	
        }
        else if(request.getParameter("btnCancel") != null) {
        	int result = 0;
        	try {
				result = Bill.deleteBill(id);
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
            response.sendRedirect("/Web_Travel/3.Service/index.jsp");   
        }
        	
	}

}

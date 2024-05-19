package Control;

import entity.Admin_Quan.TourManagenment;
import loadDAO.Admin_Quan.TourManagenmentDAO;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class TourManagenmentServlet
 */
@WebServlet("/TourManagenmentServlet")
public class Admin_Quan_TourManagenment_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Admin_Quan_TourManagenment_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String tourId = request.getParameter("tourId");
		TourManagenment tour = null;
		tour = TourManagenmentDAO.findTourByID(tourId);
		session.setAttribute("tour", tour);
		response.sendRedirect("/Web_Travel/2.Admin/manage-tour-information-edit.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String id = request.getParameter("id");
        String providerID = request.getParameter("providerID");
        String tourName = request.getParameter("tourName");
        String destination = request.getParameter("destination");
        String departureDate = request.getParameter("departureDate");
        long price = Long.parseLong(request.getParameter("price"));
        String address = request.getParameter("address");
        String type = request.getParameter("type");

        int result = TourManagenmentDAO.updateTour(id, providerID, tourName, destination, departureDate, price, address, type);

        if (result == 10) {
        	session.setAttribute("message", "Cập nhật thông tin tour thành công");
        } else {
        	session.setAttribute("message", "Cập nhật thông tin tour thất bại");
        }
        
        response.sendRedirect("/Web_Travel/2.Admin/index.jsp");
	}

}

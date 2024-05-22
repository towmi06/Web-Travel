package Control;

import entity.Service_Tuyen1_OutStanding;
import entity.tour;
import loadDAO.Admin_Quan_TourManagenment_DAO;
import loadDAO.Service_Tuyen1_OutStanding_DAO;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Admin_Quan_TourManagenment_Servlet
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
        tour foundTour = null;
        try {
            foundTour = new Admin_Quan_TourManagenment_DAO().findTourByID(tourId);
            session.setAttribute("tour", foundTour);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/Web_Travel/3.Admin/manage-tour-information-edit.jsp");
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
	    
		String id = request.getParameter("id");
		int sellID = Integer.parseInt(request.getParameter("sell_ID"));
		int cateID = Integer.parseInt(request.getParameter("cateID"));
	    String tourName = request.getParameter("tourName");
	    String image = request.getParameter("image");
	    String journeys = request.getParameter("journeys");
	    String description1 = request.getParameter("description1");
	    String date = request.getParameter("date");
	    double price = Double.parseDouble(request.getParameter("price"));

	    String result = Admin_Quan_TourManagenment_DAO.updateTour(id, tourName, image, date, price, journeys, description1, cateID, sellID);
	    List<tour> allTourList = null;
        try {
			allTourList = new Admin_Quan_TourManagenment_DAO().getAllTours();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	    session.setAttribute("message", result);
	    session.setAttribute("allTourList", allTourList);
        
        response.sendRedirect("/Web_Travel/3.Admin/index.jsp");
	}

}

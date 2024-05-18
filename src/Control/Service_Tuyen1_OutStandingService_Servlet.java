package Control;

import entity.Service_Tuyen1_OutStanding;
import loadDAO.Service_Tuyen1_OutStanding_DAO;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class outstandingServiceServlet
 */
@WebServlet("/outstandingServiceServlet")
public class Service_Tuyen1_OutStandingService_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Service_Tuyen1_OutStandingService_Servlet() {
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
		
		String[] tourIds = request.getParameterValues("outstandingIds");
		
		int result = 0;
        List<Service_Tuyen1_OutStanding> danhSach = null;
        String sell_ID = (String) session.getAttribute("sell_ID");
        try {
            danhSach = Service_Tuyen1_OutStanding_DAO.getOutstandingServices(sell_ID);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Update the outstanding status of each service
        if (danhSach != null) {
            for (Service_Tuyen1_OutStanding service : danhSach) { // danh sách đối tương outstandingService
                // Check if the service ID is in the list of tourIds
                boolean found = false;
                for (String tourId : tourIds) { // duyệt tourId trong mảng tourIds
                    if (tourId.equals(service.getId())) {
                        found = true;
                        break;
                    }
                }

                // Perform update based on conditions
                if (found && !service.getOutstanding()) {
                    // If the service ID is found and outstanding status is false, update to true
                    try {
						result = Service_Tuyen1_OutStanding_DAO.updateOutstandingService(service);
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                } else if (!found && service.getOutstanding()) {
                    // If the service ID is not found and outstanding status is true, update to false
                    try {
                    	result = Service_Tuyen1_OutStanding_DAO.updateOutstandingService(service);
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                }

                // Print service details
                response.getWriter().println(service.toString());
            }
        }
        if (result == 10) 
            session.setAttribute("message", "Cập nhật dịch vụ nổi bật thành công");
        else 
            session.setAttribute("message", "Cập nhật dịch vụ nổi bật không thành công");
        
        response.sendRedirect("/Web_Travel/2.Service/index.jsp");
	}
}

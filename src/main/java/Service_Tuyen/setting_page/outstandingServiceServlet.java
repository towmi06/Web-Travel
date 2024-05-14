package setting_page;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import setting_page.OutstandingServiceDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class outstandingServiceServlet
 */
@WebServlet("/outstandingServiceServlet")
public class outstandingServiceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public outstandingServiceServlet() {
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
		String[] tourIds = request.getParameterValues("outstandingIds");

        List<OutstandingService> danhSach = null;
        try {
            danhSach = OutstandingServiceDAO.getOutstandingServices();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Update the outstanding status of each service
        if (danhSach != null) {
            for (OutstandingService service : danhSach) {
                // Check if the service ID is in the list of tourIds
                boolean found = false;
                for (String tourId : tourIds) {
                    if (tourId.equals(service.getID())) {
                        found = true;
                        break;
                    }
                }

                // Perform update based on conditions
                if (found && !service.getOutstanding()) {
                    // If the service ID is found and outstanding status is false, update to true
                    try {
						OutstandingServiceDAO.updateOutstandingService(service);
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                } else if (!found && service.getOutstanding()) {
                    // If the service ID is not found and outstanding status is true, update to false
                    try {
						OutstandingServiceDAO.updateOutstandingService(service);
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                }

                // Print service details
                response.getWriter().println(service.toString());
            }
        }
        response.sendRedirect("/Web_Travel/3.Service/index.jsp");
	}
}

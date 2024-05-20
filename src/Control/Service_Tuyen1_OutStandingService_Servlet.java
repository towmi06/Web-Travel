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
	private Service_Tuyen1_OutStanding_DAO outStandingDAO;
	private List<Service_Tuyen1_OutStanding> danhSach;
	private int result;
	private String[] tourIds;
	private int sell_ID ;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Service_Tuyen1_OutStandingService_Servlet() {
        super();
        outStandingDAO = new Service_Tuyen1_OutStanding_DAO();
        danhSach = null;
        result = 0;
        tourIds = null;
        sell_ID = 0;
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		tourIds = request.getParameterValues("outstandingIds");
		sell_ID = (int) session.getAttribute("sell_ID");
        try {
            danhSach = outStandingDAO.getOutstandingServices(sell_ID);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Cập nhật trạng thái nổi bật của từng dịch vụ
        if (danhSach != null) {
            for (Service_Tuyen1_OutStanding service : danhSach) { // danh sách đối tượng outstandingService
                // Kiểm tra xem ID dịch vụ có nằm trong danh sách tourIds không
                boolean found = false;
                for (String tourId : tourIds) { // duyệt tourId trong mảng tourIds
                    if (tourId.equals(service.getId())) {
                        found = true;
                        break;
                    }
                }

                // Thực hiện cập nhật dựa trên điều kiện
                if (found && !service.getOutstanding()) {
                    // Nếu ID dịch vụ được tìm thấy và trạng thái nổi bật là false, cập nhật thành true
                    try {
						result = outStandingDAO.updateOutstandingService(service);
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					}
                } else if (!found && service.getOutstanding()) {
                    // Nếu ID dịch vụ không được tìm thấy và trạng thái nổi bật là true, cập nhật thành false
                    try {
                    	result = outStandingDAO.updateOutstandingService(service);
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					}
                }
            }
        }
        if (result == 10) 
            session.setAttribute("message", "Cập nhật dịch vụ nổi bật thành công");
        else 
            session.setAttribute("message", "Cập nhật dịch vụ nổi bật không thành công");
        
        response.sendRedirect("/Web_Travel/2.Service/index.jsp");
	}
}

package Control;

import entity.Service_Tuyen3_ContactInfoService;
import loadDAO.Service_Tuyen3_ContactInfoService_DAO;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ContactInfoServiceServlet
 */
@WebServlet("/ContactInfoServiceServlet")
public class Service_Tuyen3_ContactInfoService_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Service_Tuyen3_ContactInfoService_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String taiKhoan = request.getParameter("taiKhoan");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String workingHours = request.getParameter("working_hours");
        
        int result = Service_Tuyen3_ContactInfoService_DAO.updateContactInfo(address, email, phone, workingHours, taiKhoan);
        if(result == 10) {
        	session.setAttribute("message", "update thông tin liên hệ thành công");
        }
        else {
        	session.setAttribute("message", "update thông tin liên hệ không thành công");
        }
        response.sendRedirect("/Web_Travel/2.Service/index.jsp");
	}
}

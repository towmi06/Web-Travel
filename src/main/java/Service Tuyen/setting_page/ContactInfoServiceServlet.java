package setting_page;


import setting_page.ContactInfoService;
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
public class ContactInfoServiceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContactInfoServiceServlet() {
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
        
        int result = ContactInfoService.updateContactInfo(address, email, phone, workingHours, taiKhoan);
        if(result == 10) {
        	session.setAttribute("message", "update thông tin liên hệ thành công");
        }
        else {
        	session.setAttribute("message", "update thông tin liên hệ không thành công");
        }
        response.sendRedirect("/Web_Travel/3.Service/index.jsp");
	}
}

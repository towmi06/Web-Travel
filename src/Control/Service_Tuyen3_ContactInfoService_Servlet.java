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
	private Service_Tuyen3_ContactInfoService_DAO contactInfoDAO;
	private int result;
	private String taiKhoan;
	private String address;
	private String email;
	private String phone;
	private String workingHours;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Service_Tuyen3_ContactInfoService_Servlet() {
        super();
        contactInfoDAO = new Service_Tuyen3_ContactInfoService_DAO();
        int result = 0;
        String taiKhoan = "";
    	String address = "";
    	String email = "";
    	String phone = "";
    	String workingHours = "";
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
		
		taiKhoan = request.getParameter("taiKhoan");
        address = request.getParameter("address");
        email = request.getParameter("email");
        phone = request.getParameter("phone");
        workingHours = request.getParameter("working_hours");
        
        //Cập nhật thông tin liên hệ của nhà cung cấp
        result = contactInfoDAO.updateContactInfo(address, email, phone, workingHours, taiKhoan);
        if(result == 10) 
        	session.setAttribute("message", "update thông tin liên hệ thành công");
        else 
        	session.setAttribute("message", "update thông tin liên hệ không thành công");
        
        response.sendRedirect("/Web_Travel/2.Service/index.jsp");
	}
}

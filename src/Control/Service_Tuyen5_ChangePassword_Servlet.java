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
 * Servlet implementation class changePassword
 */
@WebServlet("/changePassword")
public class Service_Tuyen5_ChangePassword_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Service_Tuyen3_ContactInfoService_DAO contactDAO;
	int result;
	String taiKhoan;
	String currentPass;
	String newPass;
	String confirmPass;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Service_Tuyen5_ChangePassword_Servlet() {
        super();
        contactDAO = new Service_Tuyen3_ContactInfoService_DAO();
        result = 0;
    	taiKhoan = "";
    	currentPass = "";
    	newPass = "";
    	confirmPass = "";
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
		
		taiKhoan = (String) request.getSession().getAttribute("email"); 
	    currentPass = request.getParameter("currentPass");
	    newPass = request.getParameter("newPass");
	    confirmPass = request.getParameter("confirmPass");

	    result = contactDAO.changePassword(taiKhoan, currentPass, newPass, confirmPass);
	   
	    if(result == 10) 
	    	session.setAttribute("message", "đổi mật khẩu thành công");
	    else if (result == 5) 
	    	session.setAttribute("message", "đổi mật khẩu không thành công");
	    else if(result == 4) 
	    	session.setAttribute("message", "xác nhận mật khẩu không trùng khớp");
	    else if(result == 3)
	    	session.setAttribute("message", "mật khẩu hiện tại sai");
	    else 
	    	session.setAttribute("message", "hết phiên đăng nhập");

	    response.sendRedirect("/Web_Travel/2.Service/index.jsp");
	}
}

package Control;

import entity.Admin_Quan_AdminInfo;
import loadDAO.Admin_Quan_AdminInfo_DAO;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class GrantAccessServlet
 */
@WebServlet("/GrantAccessServlet")
public class Admin_Quan_GrantAccess_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Admin_Quan_GrantAccess_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String email = request.getParameter("email");
		Admin_Quan_AdminInfo admin = Admin_Quan_AdminInfo_DAO.findAdminByEmail(email);

		session.setAttribute("admin", admin);
	    response.sendRedirect("/Web_Travel/3.Admin/grant-access-edit.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String email = request.getParameter("employeeID");
	    String position = request.getParameter("positionSelect"); 
	    
	    String result = Admin_Quan_AdminInfo_DAO.updateAdminPosition(email, position);	 
	    List<Admin_Quan_AdminInfo> adminList = null;
		try {
			adminList = new Admin_Quan_AdminInfo_DAO().getAllAdmins();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		session.setAttribute("message", result);
		session.setAttribute("adminList", adminList);
		
	    response.sendRedirect("/Web_Travel/3.Admin/index.jsp");
	}
}

package Admin_Quan.admin_info;

import Admin_Quan.admin_info.AdminInfo;

import java.io.IOException;
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
public class GrantAccessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GrantAccessServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String email = request.getParameter("email");
		AdminInfo admin = null;
		admin = AdminInfo.findAdminByEmail(email);
		session.setAttribute("admin", admin);
	    response.sendRedirect("/Web_Travel/2.Admin/grant-access-edit.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String email = request.getParameter("employeeID");
	    String position = request.getParameter("positionSelect");
	    int result = AdminInfo.updateAdminPosition(email, position);
	    
	    if(result == 10) {
        	session.setAttribute("message", "cật nhật quyền truy cập thành công");
        }
        else {
        	session.setAttribute("message", "cật nhật quyền truy cập không thành công");
        }	    
	    response.sendRedirect("/Web_Travel/2.Admin/index.jsp");
	}
}

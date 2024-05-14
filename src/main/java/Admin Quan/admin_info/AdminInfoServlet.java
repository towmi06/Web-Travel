package admin_info;

import admin_info.AdminInfo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AdminInfoServlet
 */
@WebServlet("/AdminInfoServlet")
public class AdminInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminInfoServlet() {
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
		
		String adminID = request.getParameter("adminID");
        String adminName = request.getParameter("adminName");
        String adminEmail = request.getParameter("adminEmail");
        String adminPhone = request.getParameter("adminPhone");
        String adminPosition = request.getParameter("adminPosition");
        String adminFacebook = request.getParameter("adminFacebook");
        String adminTwitter = request.getParameter("adminTwitter");
        String adminInstagram = request.getParameter("adminInstagram");
        String adminTiktok = request.getParameter("adminTiktok");

        int result = AdminInfo.updateAdminInfo(adminID, adminName, adminEmail, adminPhone, adminPosition, adminFacebook, adminTwitter, adminInstagram, adminTiktok);
        
        if(result == 10) {
        	session.setAttribute("message", "cập nhật thông tin thành công");
        }
        else {
        	session.setAttribute("message", "cập nhật thông tin không thành công");
        }
        
        response.sendRedirect("/Web_Travel/2.Admin/index.jsp");
	}

}

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
 * Servlet implementation class userInfoEdit
 */
@WebServlet("/userInfoEdit")
public class Service_Tuyen4_UserInfoEdit_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Service_Tuyen4_UserInfoEdit_Servlet() {
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
        String taiKhoan = (String) session.getAttribute("email");

        String ID = request.getParameter("serviceID");
        String userName = request.getParameter("username");
        String email = request.getParameter("email");
        String phoneNumber = request.getParameter("phoneNumber");
        String gender = request.getParameter("gender");
        String thongTinNganHang = request.getParameter("bankInfo");
        String stk = request.getParameter("accountNumber");
        String maSoThue = request.getParameter("taxCode");
        String facebook = request.getParameter("facebook");
        String twitter = request.getParameter("twitter");
        String instagram = request.getParameter("instagram");

        // Call updateAccountInfo method to update account information
        int result = Service_Tuyen3_ContactInfoService_DAO.updateAccountInfo(taiKhoan, ID, userName, email, phoneNumber, gender, thongTinNganHang, stk, maSoThue, facebook, twitter, instagram);

        if(result == 10) 
        	session.setAttribute("message", "update thông tin tài khoảng thành công");
        else 
        	session.setAttribute("message", "update thông tin tài khoảng thành công");
        // Redirect back to user information page
        response.sendRedirect("/Web_Travel/2.Service/index.jsp");
	}

}

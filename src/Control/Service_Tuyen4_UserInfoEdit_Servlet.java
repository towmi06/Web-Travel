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
	private Service_Tuyen3_ContactInfoService_DAO contactDAO;
	private int result;
	private String taiKhoan;
	private String userName;
	private String email;
	private String phoneNumber;
	private String gender;
	private String thongTinNganHang;
	private String stk;
	private String maSoThue;
	private String facebook;
	private String twitter;
	private String instagram;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Service_Tuyen4_UserInfoEdit_Servlet() {
        super();
        contactDAO = new Service_Tuyen3_ContactInfoService_DAO();
        result = 0;
    	taiKhoan = "";
    	userName = "";
    	email = "";
    	phoneNumber = "";
    	gender = "";
    	thongTinNganHang = "";
    	stk = "";
    	maSoThue = "";
    	facebook = "";
    	twitter = "";
    	instagram = "";
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
       
		taiKhoan = (String) session.getAttribute("email");
        userName = request.getParameter("username");
        email = request.getParameter("email");
        phoneNumber = request.getParameter("phoneNumber");
        gender = request.getParameter("gender");
        thongTinNganHang = request.getParameter("bankInfo");
        stk = request.getParameter("accountNumber");
        maSoThue = request.getParameter("taxCode");
        facebook = request.getParameter("facebook");
        twitter = request.getParameter("twitter");
        instagram = request.getParameter("instagram");

        // Call updateAccountInfo method to update account information
        result = contactDAO.updateAccountInfo(taiKhoan, userName, email, phoneNumber, gender, thongTinNganHang, stk, maSoThue, facebook, twitter, instagram);

        if(result == 10) 
        	session.setAttribute("message", "update thông tin tài khoảng thành công");
        else 
        	session.setAttribute("message", "update thông tin tài khoảng thành công");
        
        response.sendRedirect("/Web_Travel/2.Service/index.jsp");
	}
}

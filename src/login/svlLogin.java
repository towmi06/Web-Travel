package login;

import entity.*;
import loadDAO.*;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class svlLogin
 */
@WebServlet("/svlLogin")
public class svlLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public svlLogin() {
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
		String role = request.getParameter("role");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        boolean isValid = login.validateUser(role, email, password);

        if (isValid) {
        	if(role.equals("admin")) {
        		Admin_Quan_AdminInfo admin = Admin_Quan_AdminInfo_DAO.findAdminByEmail(email);
        		
        		List<Admin_Quan_Cooperate> cooperates = null;
				try {
					cooperates = new Admin_Quan_Cooperate_DAO().getAllCooperates();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				List<Admin_Quan_Help> helpList = null;
				try {
					helpList = new Admin_Quan_Help_DAO().getAllHelp();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				List<Admin_Quan_AdminInfo> adminList = null;
				try {
					adminList = new Admin_Quan_AdminInfo_DAO().getAllAdmins();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				
				List<Service_Th1_OrderManager> allOrders = null;				
				try {
					allOrders = new Service_th1_OrderM_DAO().getAllOrders();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        
				List<Service_Tuyen1_OutStanding> allTourList = null;
		        try {
					allTourList = new Service_Tuyen1_OutStanding_DAO().getAllTour();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

		        session.setAttribute("allOrders", allOrders);
		        session.setAttribute("allTourList", allTourList);
				session.setAttribute("adminList", adminList);
                session.setAttribute("adminInfo", admin);
                session.setAttribute("cooperates", cooperates);
                session.setAttribute("helpList", helpList);
                
                response.sendRedirect("/Web_Travel/3.Admin/index.jsp");
        	}
        	else if(role.equals("customer"))
                response.sendRedirect("/Web_Travel/1.Customer/index.html");
        	else if(role.equals("service")) { 
        		Service_Tuyen3_ContactInfoService service = new Service_Tuyen3_ContactInfoService_DAO().findProviderByCredentials(email);
        		int sell_ID = service.getSell_ID();
        		
        		session.setAttribute("service", service); 
        		session.setAttribute("sell_ID", sell_ID); 
            	session.setAttribute("email", email); 
        		
        		response.sendRedirect("/Web_Travel/2.Service/index.jsp");
        	}
        } else {
        	String errorMessage = "Sai tài khoản hoặc mật khẩu!";
            request.setAttribute("errorMessage", errorMessage);
            request.getRequestDispatcher("3.Admin/login/index.jsp").forward(request, response);
        }
	}
}

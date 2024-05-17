package login;

import Model.Admin_Quan.*;
import DAO.Admin_Quan.*;
import Model.Service_Tuyen.ContactInfoService;
import DAO.Service_Tuyen.ContactInfoServiceDAO;

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
        		AdminInfo admin = AdminInfoDAO.findAdminByEmail(email);
        		List<Cooperate> cooperates = null;
				try {
					cooperates = new CooperateDAO().getAllCooperates();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        		List<Help> helpList = null;
				try {
					helpList = new HelpDAO().getAllHelp();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

                session.setAttribute("adminInfo", admin);
                session.setAttribute("cooperates", cooperates);
                session.setAttribute("helpList", helpList);
                
        		response.sendRedirect("/Web_Travel/2.Admin/index.jsp");
        	}
        	else if(role.equals("customer"))
                response.sendRedirect("/Web_Travel/1.Customer/index.html");
        	else if(role.equals("service")) {
        		ContactInfoService service = new ContactInfoServiceDAO().findProviderByCredentials(email);
        		String IDNCC = service.getServiceID();
        		
        		session.setAttribute("service", service); 
        		session.setAttribute("IDNCC", IDNCC); 
            	session.setAttribute("email", email); 
            	response.sendRedirect("/Web_Travel/3.Service/index.jsp");
        	}
        } else {
        	String errorMessage = "Sai tài khoản hoặc mật khẩu!";
            request.setAttribute("errorMessage", errorMessage);
            request.getRequestDispatcher("2.Admin/login/index.jsp").forward(request, response);
        }
	}
}

package login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		String role = request.getParameter("role");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        boolean isValid = login.validateUser(role, email, password);

        if (isValid) {
        	if(role.equals("admin"))
        		response.sendRedirect("/Web_Travel/2.Admin/index.html");
        	else if(role.equals("customer"))
                response.sendRedirect("/Web_Travel/1.Customer/index.html");
        	else if(role.equals("service"))
                response.sendRedirect("/Web_Travel/3.Service/index.html");
        } else {
        	String errorMessage = "Sai tài khoản hoặc mật khẩu!";
            request.setAttribute("errorMessage", errorMessage);
            request.getRequestDispatcher("2.Admin/login/index.jsp").forward(request, response);
        }
	}
}

package Control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import loadDAO.Admin_Quan_Notification_Mailbox_DAO;

/**
 * Servlet implementation class Admin_Quan_Notification_Mailbox_Servlet
 */
@WebServlet("/NotificationMailboxServlet")
public class Admin_Quan_Notification_Mailbox_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Admin_Quan_Notification_Mailbox_Servlet() {
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
		
		String notificationInput = request.getParameter("notificationInput");
		String result = "";
        if (notificationInput != null && !notificationInput.trim().isEmpty()) {
            try {
            	result = new Admin_Quan_Notification_Mailbox_DAO().addNotification(notificationInput);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        
        List<String> allNotificationList = null;
	    try {
			allNotificationList = new Admin_Quan_Notification_Mailbox_DAO().getNotificationList();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
        session.setAttribute("message", result);
        session.setAttribute("allNotificationList", allNotificationList);
		
	    response.sendRedirect("/Web_Travel/3.Admin/index.jsp");
	}

}

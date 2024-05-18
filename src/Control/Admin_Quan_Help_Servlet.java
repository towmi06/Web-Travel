package Control;

import entity.Admin_Quan_Help;
import loadDAO.Admin_Quan_Help_DAO;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class HelpServlet
 */
@WebServlet("/HelpServlet")
public class Admin_Quan_Help_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Admin_Quan_Help_Servlet() {
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
		String idCauHoi = request.getParameter("idCauHoi").trim(); 
        String cauHoi = request.getParameter("cauHoi").trim();
        String cauTraLoi = request.getParameter("cauTraloi").trim();

        try {
            if (request.getParameter("btnSave") != null && (idCauHoi != null && idCauHoi.length() > 0) && (cauHoi != null && cauHoi.length() > 0) && (cauTraLoi != null && cauTraLoi.length() > 0)) {
            	Admin_Quan_Help help = new Admin_Quan_Help(idCauHoi, cauHoi, cauTraLoi);
                int result = new Admin_Quan_Help_DAO().themCauHoi(help);

                String message;
                if (result == 10) {
                    message = "Thêm câu hỏi thành công";
                } else if (result == 3) {
                    message = "ID câu hỏi đã tồn tại";
                } else {
                    message = "Thêm câu hỏi không thành công";
                }
                session.setAttribute("message", message);

            } else if (request.getParameter("btnDelete") != null && (idCauHoi != null && idCauHoi.length() > 0)) {
            	Admin_Quan_Help help = new Admin_Quan_Help(idCauHoi, "", ""); 
                int result = new Admin_Quan_Help_DAO().xoaCauHoi(idCauHoi);

                String message;
                if (result == 10) {
                    message = "Xóa câu hỏi thành công";
                } else if (result == 3) {
                    message = "Không tìm thấy câu hỏi";
                } else {
                    message = "Xóa câu hỏi không thành công";
                }
                session.setAttribute("message", message);

            } else if (request.getParameter("btnChange") != null && (idCauHoi != null && idCauHoi.length() > 0) && (cauHoi != null && cauHoi.length() > 0) && (cauTraLoi != null && cauTraLoi.length() > 0)) {
            	Admin_Quan_Help help = new Admin_Quan_Help(idCauHoi, cauHoi, cauTraLoi);
                int result = new Admin_Quan_Help_DAO().suaCauHoi(help);
                
                String message;
                if (result == 10) {
                    message = "Sửa câu hỏi thành công";
                } else if (result == 3) {
                    message = "Không tìm thấy câu hỏi";
                } else {
                    message = "Sửa câu hỏi không thành công";
                }
                session.setAttribute("message", message); 
            }
            
            List<Admin_Quan_Help> helpList = new Admin_Quan_Help_DAO().getAllHelp();
            session.setAttribute("helpList", helpList);
            response.sendRedirect("/Web_Travel/3.Admin/index.jsp");
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}

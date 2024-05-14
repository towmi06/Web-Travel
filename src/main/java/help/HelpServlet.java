package help;

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
public class HelpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelpServlet() {
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
                Help helpObj = new Help(idCauHoi, cauHoi, cauTraLoi);
                int result = helpObj.themCauHoi(); 

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
                Help helpObj = new Help(idCauHoi, "", ""); 
                int result = helpObj.xoaCauHoi(); 

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
                Help helpObj = new Help(idCauHoi, cauHoi, cauTraLoi); 
                int result = helpObj.suaCauHoi(); 

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
            
            List<Help> helpList = new HelpDAO().getAllHelp();
            session.setAttribute("helpList", helpList);
            response.sendRedirect("/Web_Travel/2.Admin/index.jsp");
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}

package Control;

import entity.Service_Tuyen2_PageLayout;
import loadDAO.Service_Tuyen2_PageLayout_DAO;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class PageLayoutSevlet
 */
@WebServlet("/PageLayoutSevlet")
public class Service_Tuyen2_PageLayout_Sevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Service_Tuyen2_PageLayout_Sevlet() {
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
		
		String email = (String) session.getAttribute("email");
		Service_Tuyen2_PageLayout pageLayout = null;
	    try {
			pageLayout = Service_Tuyen2_PageLayout_DAO.findByTaiKhoan(email);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
        String taiKhoan = (String) session.getAttribute("email");
        String allowSorting = request.getParameter("allowSorting");
        String hideService = request.getParameter("hideService");
        String hidePromotion = request.getParameter("hidePromotion");
        String display = request.getParameter("display");

        // Chuyển đổi các giá trị sang kiểu dữ liệu phù hợp nếu cần thiết
        boolean sapXep = false;
        if(allowSorting == null) sapXep = false;
        else sapXep = true;
        
        boolean dichVuNoiBat = false;
        if(hideService == null) dichVuNoiBat = false;
        else dichVuNoiBat = true;
        	
        boolean chuongTrinhKhuyenMai = false;
        if(hidePromotion == null) chuongTrinhKhuyenMai = false;
        else chuongTrinhKhuyenMai = true;
        
        boolean hienThi = Boolean.parseBoolean(display);
        
        int result = 0;
		try {
			result = Service_Tuyen2_PageLayout_DAO.updatePageLayout(taiKhoan, sapXep, dichVuNoiBat, chuongTrinhKhuyenMai, hienThi);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        if (result == 10) 
            session.setAttribute("message", "Cập nhật thông tin bố cục trang thành công");
        else 
            session.setAttribute("message", "Cập nhật thông tin bố cục trang không thành công");
        
        response.sendRedirect("/Web_Travel/2.Service/index.jsp");
	}

}

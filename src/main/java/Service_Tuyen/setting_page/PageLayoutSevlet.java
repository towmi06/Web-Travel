package Service_Tuyen.setting_page;

import Service_Tuyen.setting_page.PageLayout;
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
public class PageLayoutSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PageLayoutSevlet() {
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
		PageLayout pageLayout = null;
	    try {
			pageLayout = PageLayout.findByTaiKhoan(email);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
        String taiKhoan = (String) session.getAttribute("email");
        String allowSorting = request.getParameter("allowSorting");
        String hideService = request.getParameter("hideService");
        String hidePromotion = request.getParameter("hidePromotion");
        String productPerPage = request.getParameter("productPerPage");

        // Chuyển đổi các giá trị sang kiểu dữ liệu phù hợp nếu cần thiết
        boolean sapXep = false;
        if(allowSorting == null) sapXep = false;
        else sapXep = true;
        
        boolean dichVuNoiBat = false;
        if(hideService == null) dichVuNoiBat = false;
        else dichVuNoiBat = true;
        	
        boolean chuongTrinhKhuyenMai = false;
        if(productPerPage == null) chuongTrinhKhuyenMai = false;
        else chuongTrinhKhuyenMai = true;
        
        int soSanPhamMoiTrang = Integer.parseInt(productPerPage);
        
        int result = 0;
		try {
			result = PageLayout.updatePageLayout(taiKhoan, sapXep, dichVuNoiBat, chuongTrinhKhuyenMai, soSanPhamMoiTrang);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        if (result == 10) 
            session.setAttribute("message", "Cập nhật thông tin bố cục trang thành công");
        else 
            session.setAttribute("message", "Cập nhật thông tin bố cục trang không thành công");
        
        response.sendRedirect("/Web_Travel/3.Service/index.jsp");
	}

}

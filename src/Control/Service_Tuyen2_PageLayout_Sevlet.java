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
	Service_Tuyen2_PageLayout pageLayout;
	Service_Tuyen2_PageLayout_DAO pageLayoutDAO;
	int result;
	private String email;
	String taiKhoan;
	String allowSorting;
	boolean sapXep;
	String hideService;
	boolean dichVuNoiBat;
	String hidePromotion;
	boolean chuongTrinhKhuyenMai;
	String display;
	boolean hienThi;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Service_Tuyen2_PageLayout_Sevlet() {
        super();
        pageLayout = new Service_Tuyen2_PageLayout();
        pageLayoutDAO = new Service_Tuyen2_PageLayout_DAO();
        result = 0;
        email = null;
        taiKhoan = "";
    	allowSorting = "";
    	sapXep = false;
    	hideService = "";
    	dichVuNoiBat = false;
    	hidePromotion = "";
    	chuongTrinhKhuyenMai = false;
    	display = "";
    	hienThi = false;
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
		
		email = (String) session.getAttribute("email");
	    try {
			pageLayout = pageLayoutDAO.findByTaiKhoan(email);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
        taiKhoan = (String) session.getAttribute("email");
        allowSorting = request.getParameter("allowSorting");
        hideService = request.getParameter("hideService");
        hidePromotion = request.getParameter("hidePromotion");
        display = request.getParameter("display");

        // Chuyển đổi các giá trị sang kiểu dữ liệu phù hợp nếu cần thiết
        if(allowSorting == null) sapXep = false; //nếu nút sắp xếp không được bấm thì gán sapXep = false
        else sapXep = true; //nếu nút sắp xếp được bấm thì gán sapXep = false
        
        if(hideService == null) dichVuNoiBat = false;
        else dichVuNoiBat = true;
        	
        if(hidePromotion == null) chuongTrinhKhuyenMai = false;
        else chuongTrinhKhuyenMai = true;
        
        if(display == null) hienThi = false;
        else hienThi = true;
        
		try {
			result = pageLayoutDAO.updatePageLayout(taiKhoan, sapXep, dichVuNoiBat, chuongTrinhKhuyenMai, hienThi);
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

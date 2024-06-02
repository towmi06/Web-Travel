package Control;

import loadDAO.Service_Th3_ProductManagerDAO;
import entity.Service_Th3_ProductManage;
import entity.categories;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Service_Th5_EditProductM_Servlet", urlPatterns = {"/edit"})
public class Service_Th5_EditProductM_Servlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private Service_Th3_ProductManagerDAO productManagerDAO;

    @Override
    public void init() {
        productManagerDAO = new Service_Th3_ProductManagerDAO(); 
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        String id = request.getParameter("id");
       // String nameTour = request.getParameter("nameTour");
       // String image = request.getParameter("image");
        String date = request.getParameter("date");
        String priceStr = request.getParameter("price");
        BigDecimal price = new BigDecimal(priceStr); // Chuyển đổi chuỗi giá trị sang BigDecimal

        String journeys = request.getParameter("journeys");
        String description1 = request.getParameter("description1");
        //String category = request.getParameter("category");
        
        Service_Th3_ProductManagerDAO tour = new Service_Th3_ProductManagerDAO();
        tour.updateProduct(id, date, price, journeys, description1);
        
     // Forward the request to the edit page
        response.sendRedirect(request.getContextPath() + "/Service_Th3_ProducM_Servlet?sellId=" + 1);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	  
    	String id = request.getParameter("id");
        System.out.println("Received ID in GET request: " + id);

        if (id == null || id.trim().isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Không nhận được ID tour");
            return;
        }

        Service_Th3_ProductManage tour = productManagerDAO.getProductById(id);
        if (tour == null) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Không tìm thấy.");
            return;
        }
        request.setAttribute("tour", tour);
        request.getRequestDispatcher("/2.Service/2.Qlidv/EditTour.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
			processRequest(request, response);
		} catch (ServletException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}

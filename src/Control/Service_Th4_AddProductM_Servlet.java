package Control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.categories;
import loadDAO.Service_Th3_ProductManagerDAO;

@WebServlet(name = "Service_Th4_AddProductM_Servlet", urlPatterns = {"/add"})
public class Service_Th4_AddProductM_Servlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final Service_Th3_ProductManagerDAO productManagerDAO = new Service_Th3_ProductManagerDAO();

    public Service_Th4_AddProductM_Servlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<categories> listC = productManagerDAO.getAllCategories();
        request.setAttribute("listC", listC);
        request.getRequestDispatcher("/2.Service/2.Qlidv/AddTour.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException(e);
        }
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        String id = request.getParameter("id");
        String nameTour = request.getParameter("nameTour");
        String image = request.getParameter("image");
        String date = request.getParameter("date");
        String price = request.getParameter("price");
        String journeys = request.getParameter("journeys");
        String description1 = request.getParameter("description1");
        String category = request.getParameter("category");
        int sellId = 1; 

        productManagerDAO.insertProduct(id, nameTour, image, date, price, journeys, description1, category, sellId);
        response.sendRedirect(request.getContextPath() + "/Service_Th3_ProducM_Servlet?sellId=" + sellId);
    }
}

package Control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import loadDAO.Service_Th3_ProductManagerDAO;
import entity.Service_Th3_ProductManage;
import java.util.List;

@WebServlet("/Service_Th7_detail_Servlet")
public class Service_Th7_detail_Servlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    public Service_Th7_detail_Servlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Service_Th3_ProductManagerDAO dao = new Service_Th3_ProductManagerDAO();
        Service_Th3_ProductManage tour = dao.getProductById(id);
        
        request.setAttribute("tour", tour);
        
        request.getRequestDispatcher("/2.Service/2.Qlidv/detailTour.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

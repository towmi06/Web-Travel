package Control;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entity.tour;
import entity.categories;
import loadDAO.DAO;

@WebServlet("/HomeControl")
public class HomeControl extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public HomeControl() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DAO dao = new DAO();
        List<tour> list = dao.getAllTour();
        List<categories> listC = dao.getAllCategories(); // assuming such method exists
        request.setAttribute("listP", list);
        request.setAttribute("listC", listC);
        request.getRequestDispatcher("allTour.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}

package Control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import loadDAO.Service_Th3_ProductManagerDAO;
import entity.Service_Th3_ProductManage;

@WebServlet("/Service_Th_EditC")
public class Service_Th_EditC extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private final Service_Th3_ProductManagerDAO productManagerDAO = new Service_Th3_ProductManagerDAO();

    public Service_Th_EditC() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		System.out.println("Received ID in GET request: " + id);
		
		if (id == null || id.trim().isEmpty()) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Product ID is missing or invalid.");
			return;
		}

		Service_Th3_ProductManage product = productManagerDAO.getProductById(id);
		if (product == null) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND, "Product not found.");
			return;
		}

		request.setAttribute("product", product);
		request.getRequestDispatcher("/2.Service/2.Qlidv/EditTour.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}

package Control;

import loadDAO.Service_Th3_ProductManagerDAO;
import entity.Service_Th3_ProductManage;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Service_Th5_EditProductM_Servlet", urlPatterns = {"/Service_Th5_EditProductM_Servlet"})
public class Service_Th5_EditProductM_Servlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private Service_Th3_ProductManagerDAO productManagerDAO;

    @Override
    public void init() {
        productManagerDAO = new Service_Th3_ProductManagerDAO(); // Initialize your DAO here
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
        String id = request.getParameter("id");
        System.out.println("Received ID in POST request: " + id);

        if (id == null || id.trim().isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Product ID is missing or invalid.");
            return;
        }

        String date = request.getParameter("date");
        date = (date != null) ? date.trim() : null;
        System.out.println("Received Date: " + date);

        String priceStr = request.getParameter("price");
        priceStr = (priceStr != null) ? priceStr.trim() : null;
        System.out.println("Received Price: " + priceStr);

        String journeys = request.getParameter("journeys");
        journeys = (journeys != null) ? journeys.trim() : null;
        System.out.println("Received Journeys: " + journeys);

        String description1 = request.getParameter("description1");
        description1 = (description1 != null) ? description1.trim() : null;
        System.out.println("Received Description: " + description1);

        Service_Th3_ProductManage product = new Service_Th3_ProductManage();
        product.setId(id);
        product.setDate(date);

        try {
            double price = Double.parseDouble(priceStr);
            product.setPrice(price);
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid price format.");
            return;
        }

        product.setJourneys(journeys);
        product.setDescription1(description1);

        productManagerDAO.updateProduct(product);

        response.sendRedirect("manager"); // Redirect to a confirmation or listing page
    }

    @Override
    public String getServletInfo() {
        return "Servlet for editing tour product information";
    }
}

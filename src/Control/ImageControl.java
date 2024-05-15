package Control;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ImageControl")
public class ImageControl extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Get image file path from request parameter
        String imagePath = request.getParameter("path");
        
        // Set content type
        response.setContentType("image/jpeg");
        
        // Read image from file and write to response output stream
        File imageFile = new File(imagePath);
        try (FileInputStream fis = new FileInputStream(imageFile)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                response.getOutputStream().write(buffer, 0, bytesRead);
            }
        }
    }
}

package Control;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ImageControl")
public class ImageControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Lấy tên của ảnh từ request parameter
		String imageName = request.getParameter("imageName");

		// Xác định đường dẫn đến thư mục chứa ảnh (ví dụ:
		// /path/to/your/image/directory/)
		String imagePath = "./image_tour" + imageName;

		// Tạo một đối tượng File đại diện cho ảnh
		File imageFile = new File(imagePath);

		// Kiểm tra xem ảnh có tồn tại không
		if (imageFile.exists()) {
			// Thiết lập kiểu MIME cho phản hồi
			response.setContentType("image/jpeg");

			// Sao chép dữ liệu từ FileInputStream của ảnh vào OutputStream của phản hồi
			try (FileInputStream fis = new FileInputStream(imageFile)) {
				byte[] buffer = new byte[1024];
				int bytesRead;
				while ((bytesRead = fis.read(buffer)) != -1) {
					response.getOutputStream().write(buffer, 0, bytesRead);
				}
			}
		} else {
			// Trả về mã lỗi 404 nếu ảnh không tồn tại
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}

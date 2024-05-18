<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Thông Tin Liên Hệ / Liên Kết MXH</title>
    <!--JS-->
    <script src="resources/js/core.js"></script>
    <script src="resources/js/contact-info/contact-information-social-media-links.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <script src="https://unpkg.com/leaflet/dist/leaflet.js"></script>
    <!--Style CSS-->
    <link rel="stylesheet" type="text/css" href="resources/css/contact-info.css"/> 
    <link rel="stylesheet" type="text/css" href="resources/css/dark_mode.css"/> 
    <link rel="stylesheet" href="https://unpkg.com/leaflet/dist/leaflet.css"/>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto&display=swap">
</head>
<body>
    <div class="main-container">
        <div class="information">
            <!-- Phần thông tin của admin -->
            <form class="information" method="post" action="/Web_Travel/AdminInfoServlet">
	            <div class="contact-info">
	                <ul>
	                	<li style="margin-top: 50px">
	                    	<strong>ID:</strong> 
	                    	<input type="text" id="adminID" name="adminID" value="${sessionScope.adminInfo.ID}">
	                    </li>
	                    <li>
	                    	<strong>Admin:</strong> 
	                    	<input type="text" id="adminName" name="adminName" value="${sessionScope.adminInfo.name}">
	                    </li>
						<li>
							<strong>Email:</strong> 
							<input type="email" id="adminEmail" name="adminEmail" value="${sessionScope.adminInfo.email}">
						</li>
						<li>
							<strong>Số Điện Thoại:</strong> 
							<input type="tel" id="adminPhone" name="adminPhone" value="${sessionScope.adminInfo.phone}">
						</li>
						<li>
							<strong>Vị Trí:</strong> 
							<input type="text" id="adminPosition" name="adminPosition" value="${sessionScope.adminInfo.position}">
						</li>
						
						<h2>Tài Khoản Mạng Xã Hội</h2>
		                <li>
		                    <strong>FaceBook:</strong> 
		                    <input type="text" id="adminFacebook" name="adminFacebook" value="${sessionScope.adminInfo.facebook}">
		                </li>
						<li>
							<strong>Twitter:</strong> 
							<input type="text" id="adminTwitter" name="adminTwitter" value="${sessionScope.adminInfo.twitter}">
						</li>
						<li>
							<strong>Instagram:</strong> 
							<input type="tex" id="adminInstagram" name="adminInstagram" value="${sessionScope.adminInfo.instagram}">
						</li>
						<li>
							<strong>TikTok:</strong> 
							<input type="text" id="adminTiktok" name="adminTiktok" value="${sessionScope.adminInfo.tiktok}">
						</li>
		                <button class="edit-button" type="submit">Save</button>   
	                </ul>
	            </div>
            </form>
            <!-- Kết thúc phần thông tin của admin -->
        </div>                
    </div> 
</body>
</html>
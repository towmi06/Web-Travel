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
            <img src="${sessionScope.adminInfo.coverPhoto}" alt="Cover Photo" class="cover-photo">
            <img src="${sessionScope.adminInfo.avatar}" alt="Avatar" class="avatar">
            <div class="contact-info">
                <ul>
                	<li><strong>ID:</strong> ${sessionScope.adminInfo.ID}</li>
                    <li><strong>Admin:</strong> ${sessionScope.adminInfo.name}</li>
                    <li><strong>Email:</strong> ${sessionScope.adminInfo.email}</li>
                    <li><strong>Số Điện Thoại:</strong> ${sessionScope.adminInfo.phone}</li>
                    <li><strong>Vị Trí:</strong> ${sessionScope.adminInfo.position}</li>
                </ul>
            </div>
            <!-- Kết thúc phần thông tin của admin -->

            <!-- Phần mạng xã hội -->
            <div class="social-media">
                <h2>Tài Khoản Mạng Xã Hội</h2>
                <a href="${sessionScope.adminInfo.facebook}"><img src="resources/images/facebook.png" alt="Facebook"></a>
                <a href="${sessionScope.adminInfo.twitter}"><img src="resources/images/twitter.png" alt="Twitter"></a>
                <a href="${sessionScope.adminInfo.instagram}"><img src="resources/images/instagram.png" alt="Instagram"></a>
                <a href="${sessionScope.adminInfo.tiktok}"><img src="resources/images/tiktok.png" alt="TikTok"></a>
                <button class="edit-button" id="editButton" onclick="loadContactEditPage()">Edit</button>   
            </div>
            <!-- Kết thúc phần mạng xã hội -->
        </div>                
    </div> 
</body>
</html>
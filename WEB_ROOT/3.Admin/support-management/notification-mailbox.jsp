<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Thông Báo Và Hòm Thư</title>
    <!--JS-->
    <script src="resources/js/core.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <script src="https://unpkg.com/leaflet/dist/leaflet.js"></script>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto&display=swap">
    <!--Style CSS-->
    <link rel="stylesheet" type="text/css" href="resources/css/support-management.css"/> 
    <link rel="stylesheet" type="text/css" href="resources/css/dark_mode.css"/> 
    <link rel="stylesheet" href="https://unpkg.com/leaflet/dist/leaflet.css"/>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto&display=swap">
</head>
<body>
    <!--Main container-->
    <div class="main-container">
        <form class="notification-box" action="/Web_Travel/NotificationMailboxServlet" method="post">
            <h2>Thông Báo</h2>
            <p>Đây là nơi hiển thị các thông báo quan trọng đến khách hàng.</p>
            <input type="text" name="notificationInput" id="notificationInput" placeholder="Nhập thông báo của bạn..."/>
            <button type="submit">Gửi</button>
        </form>
        
        <div class="mailbox">
            <h2>Hòm Thư</h2>
            <p>Đây là nơi gửi và nhận thư từ hệ thống hoặc từ nhân viên hỗ trợ.</p>
            <%
                List<String> allMailboxList = (List<String>) session.getAttribute("allMailboxList");
                if (allMailboxList != null && !allMailboxList.isEmpty()) {
                    for (String mail : allMailboxList) {
                        out.println("<p>" + mail + "</p>");
                    }
                } else {
                    out.println("<p>Không có thư nào.</p>");
                }
            %>
        </div>
    </div>
    <!--End main container-->
</body>
</html>
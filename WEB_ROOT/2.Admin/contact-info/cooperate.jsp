<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Hợp Tác</title>
    <!--JS-->
    <script src="resources/js/core.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <script src="https://unpkg.com/leaflet/dist/leaflet.js"></script>
    <!--Style CSS-->
    <link rel="stylesheet" type="text/css" href="resources/css/contact-info.css"/> 
    <link rel="stylesheet" type="text/css" href="resources/css/dark_mode.css"/> 
    <link rel="stylesheet" href="https://unpkg.com/leaflet/dist/leaflet.css"/>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto&display=swap">
</head>
<body>
    <!--Main container-->
    <div class="container">
        <h1>Danh Sách NCC Gửi Biểu Mẫu</h1>
        <div class="sort-and-search">
            <!--Sort-->
            <div class="sort-dropdown">
                <label for="sort-options">Sắp Xếp Theo:</label>
                <select id="sort-options" onchange="sortTable()">
                    <option value="name">Tên</option>
                    <option value="date">Ngày Gửi</option>
                    <option value="location">Địa Chỉ</option>
                </select>
            </div>
            <!--Search-->
            <div class="search">
                <input type="search" name="btnSearch" id="search" class="search-input" placeholder="Nhập ở đây">
                <img src="resources/images/search.svg" class="search-icon"></img>
            </div>
        </div>
        
        <table>
            <thead>
                <tr>
                    <th>Tên NCC</th>
                    <th>Email</th>
                    <th>Số Điện Thoại</th>
                    <th>Địa Chỉ</th>
                    <th>Ngày Gửi</th>
                    <th>Nội Dung Hợp Tác</th>
                    <th>Thao Tác</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="cooperate" items="${sessionScope.cooperates}">
                    <tr>
                        <td>${cooperate.tenNCC}</td>
                        <td>${cooperate.email}</td>
                        <td>${cooperate.soDienThoai}</td>
                        <td>${cooperate.diaChi}</td>
                        <td>${cooperate.ngayGui}</td>
                        <td>${cooperate.noiDungHopTac}</td>
                        <td>
						    <form action="/Web_Travel/CooperateServlet" method="post"> 
						        <input type="hidden" name="email" value="${cooperate.email}">
						        <button type="submit" class="edit-btn">Liên Hệ</button>
						    </form>
						</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
    <!--End main container-->
</body>
</html>
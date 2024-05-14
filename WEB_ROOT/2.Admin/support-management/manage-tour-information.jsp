<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>
<%@ page import="tour_managenment.TourManagenment" %>
<%@ page import="tour_managenment.TourManagenmentDAO" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quản Lý Thông Tin Tour</title>
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

	<% 
		List<TourManagenment> tours = new TourManagenmentDAO().getAllTours();
        request.setAttribute("tours", tours);
    %>
	
    <!--Main container-->
    <div class="main-container">
        <h1>Thông Tin Tour</h1>
        <div class="sort-and-search">
            <!--Sort-->
            <div class="sort-dropdown">
                <label for="sort-options">Sắp Xếp Theo:</label>
                <select id="sort-options" onchange="sortTable()">
                    <option value="id">ID</option>
                    <option value="destination">Điểm Đến</option>
                    <option value="price">Giá</option>
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
                    <th>ID</th>
                    <th>ID NCC</th>
                    <th>Tên Tour</th>
                    <th>Điểm Đến</th>
                    <th>Ngày Khởi Hành</th>
                    <th>Giá</th>
                    <th>Địa Chỉ</th>
                    <th>Loại Hình</th>
                    <th>Thao Tác</th>
                </tr>
            </thead>
            <tbody>
			    <c:forEach var="tour" items="${requestScope.tours}">
			        <tr>
			            <td><c:out value="${tour.ID}" /></td>
			            <td><c:out value="${tour.providerID}" /></td>
			            <td><c:out value="${tour.tourName}" /></td>
			            <td><c:out value="${tour.destination}" /></td>
			            <td><c:out value="${tour.departureDate}" /></td>
			            <td><c:out value="${tour.price}" /></td>
			            <td><c:out value="${tour.address}" /></td>
			            <td><c:out value="${tour.type}" /></td>
			            <td>
			                <form action="/Web_Travel/TourManagenmentServlet" method="get">
			                    <input type="hidden" name="tourId" value="${tour.ID}">
			                    <button type="submit" class="edit-btn">Edit</button>
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

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
    <!--Main container-->
    <h1>Thông Tin Tour</h1>
    <form action="/Web_Travel/TourManagenmentServlet" method="post">
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
			        <tr>
			            <td><input name="id" value="${sessionScope.tour.ID}" /></td>
			            <td><input name="providerID" value="${sessionScope.tour.providerID}" /></td>
			            <td><input name="tourName" value="${sessionScope.tour.tourName}" /></td>
			            <td><input name="destination" value="${sessionScope.tour.destination}" /></td>
			            <td><input name="departureDate" value="${sessionScope.tour.departureDate}" /></td>
			            <td><input name="price" value="${sessionScope.tour.price}" /></td>
			            <td><input name="address" value="${sessionScope.tour.address}" /></td>
			            <td><input name="type" value="${sessionScope.tour.type}" /></td>
			            <td><button type="submit" class="edit-btn">Save</button>
			            </td>
			        </tr> 
			</tbody>
        </table>
    </form>
    <!--End main container-->
</body>
</html>

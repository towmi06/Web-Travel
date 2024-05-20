<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>
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
    <link rel="icon" href="/Web_Travel/3.Admin/login/assets/logo.png">
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
                    <th>Sell ID</th>
                    <th>Cate ID</th>
                    <th>Tên Tour</th>
                    <th>Ảnh</th>
                    <th>Hành Trình</th>
                    <th>Điểm Đến</th>
                    <th>Thời Gian</th>
                    <th>Giá</th>
                    <th>Thao Tác</th>
                </tr>
            </thead>
            <tbody>
			        <tr>
			            <td><input name="id" value="${sessionScope.tour.id}" /></td>
			            <td><input name="sell_ID" value="${sessionScope.tour.sell_ID}" /></td>
			            <td><input name="cateID" value="${sessionScope.tour.cateID}" /></td>
			            <td><input name="tourName" value="${sessionScope.tour.tourName}" /></td>
			            <td><input name="image" value="${sessionScope.tour.image}" /></td>
			            <td><input name="journeys" value="${sessionScope.tour.journeys}" /></td>
			            <td><input name="description1" value="${sessionScope.tour.description1}" /></td>
			            <td><input name="date" value="${sessionScope.tour.date}" /></td>
			            <td><input name="price" value="${sessionScope.tour.price}" /></td>
			            <td><button type="submit" class="edit-btn">Save</button>
			            </td>
			        </tr> 
			</tbody>
        </table>
    </form>
    <!--End main container-->
</body>
</html>

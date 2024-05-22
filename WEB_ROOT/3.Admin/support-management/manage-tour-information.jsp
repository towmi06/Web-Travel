<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    <div class="main-container">
        <h1>Thông Tin Tour</h1>
        <div class="sort-and-search">
            <!--Sort-->
            <div class="sort-dropdown">
                <label for="sort-options3">Sắp Xếp Theo:</label>
                <select id="sort-options3" onchange="sortTable3()">
                    <option value="0">ID</option>
                    <option value="1">Sell ID</option>
                    <option value="2">Cate ID</option>
                    <option value="3">Tên Tour</option>
                    <option value="4">Ảnh</option>
                    <option value="5">Hành Trình</option>
                    <option value="6">Miêu Tả</option>
                    <option value="7">Thời Gian</option>
                    <option value="8">Giá</option>
                </select>
            </div>
            <!--Search-->
            <div class="search">
                <input type="search" name="btnSearch" id="searchInput4" class="search-input" oninput="searchTable4()" placeholder="Nhập ở đây">
                <img src="resources/images/search.svg" class="search-icon"></img>
            </div>
        </div>
        
        <table id="tourTable">
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
			    <c:forEach var="tour" items="${sessionScope.allTourList}">
			        <tr>
			            <td><c:out value="${tour.id}" /></td>
			            <td><c:out value="${tour.sellID}" /></td>
			            <td><c:out value="${tour.cateID}" /></td>
			            <td><c:out value="${tour.tourName}" /></td>
			            <td><c:out value="${tour.image}" /></td>
			            <td><c:out value="${tour.journeys}" /></td>
			            <td><c:out value="${tour.description1}" /></td>
			            <td><c:out value="${tour.date}" /></td>
			            <td><c:out value="${tour.price}" /></td>
			            <td>
			                <form action="/Web_Travel/TourManagenmentServlet" method="get">
			                    <input type="hidden" name="tourId" value="${tour.id}">
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

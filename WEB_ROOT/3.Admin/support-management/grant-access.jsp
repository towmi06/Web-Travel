<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cấp Quyền Truy Cập</title>
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
        <h1>Nhân Viên</h1>
        <div class="sort-and-search">
            <!--Sort-->
            <div class="sort-dropdown">
                <label for="sort-options4">Sắp Xếp Theo:</label>
                <select id="sort-options4" onchange="sortTable4()">
                    <option value="0">ID</option>
                    <option value="1">Tên</option>
                    <option value="2">Giới Tính</option>
                    <option value="3">Tài Khoản</option>
                    <option value="4">Số Điện Thoại</option>
                    <option value="5">Chức Vụ</option>
                </select>
            </div>
            <!--Search-->
            <div class="search">
                <input type="search" name="btnSearch" id="searchInput2" class="search-input" oninput="searchTable2()" placeholder="Nhập ở đây">
                <img src="resources/images/search.svg" class="search-icon"></img>
            </div>
        </div>
        
        <table id="adminTable">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Tên</th>
                    <th>Giới Tính</th>
                    <th>Tài Khoản</th>
                    <th>Số Điện Thoại</th>
                    <th>Địa Chỉ</th>
                    <th>Chức Vụ</th>
                    <th>Thao Tác</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="admin" items="${sessionScope.adminList}">
                    <tr>
                        <td>${admin.ID}</td>
                        <td>${admin.name}</td>
                        <td>${admin.gender}</td>
                        <td>${admin.email}</td>
                        <td>${admin.phone}</td>
                        <td>${admin.address}</td>
                        <td>${admin.position}</td>
                        <td>
                            <form action="/Web_Travel/GrantAccessServlet" method="get">
                                <input type="hidden" name="email" value="${admin.email}">
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
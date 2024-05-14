<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="admin_info.AdminInfoDAO" %>
<%@ page import="admin_info.AdminInfo" %>
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

	<%
		List<AdminInfo> adminList = new AdminInfoDAO().getAllAdmins(); 
		session.setAttribute("adminList", adminList);
	%>

    <!--Main container-->
    <div class="main-container">
        <h1>Nhân Viên</h1>
        <div class="sort-and-search">
            <!--Sort-->
            <div class="sort-dropdown">
                <label for="sort-options">Sắp Xếp Theo:</label>
                <select id="sort-options" onchange="sortTable()">
                    <option value="id">ID</option>
                    <option value="name">Tên</option>
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
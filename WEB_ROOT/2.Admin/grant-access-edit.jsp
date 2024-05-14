<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
		AdminInfo admin = (AdminInfo) session.getAttribute("admin");
	    session.setAttribute("admin", admin);
	%>

    <!--Main container-->
        <h1>Nhân Viên</h1>
        <form action="/Web_Travel/GrantAccessServlet" method="post"> 
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
		            <tr>
		                <td>${sessionScope.admin.ID}</td>
		                <td>${sessionScope.admin.name}</td>
		                <td>${sessionScope.admin.gender}</td>
		                <td>${sessionScope.admin.email}</td>
		                <td>${sessionScope.admin.phone}</td>
		                <td>${sessionScope.admin.address}</td>
		                <td>
		                    <select name="positionSelect">
		                        <option value="Admin" <% if (admin.getPosition().equals("Admin")) out.print("selected"); %>>Admin</option>
		                        <option value="Nhan Vien" <% if (admin.getPosition().equals("Nhan Vien")) out.print("selected"); %>>Nhân Viên</option>
		                    </select>
		                </td>
		                <td>    
		                    <input type="hidden" name="employeeID" value="${sessionScope.admin.ID}">
		                    <button type="submit" class="edit-btn">Save</button>
		                </td>
		            </tr>
		        </tbody>
		    </table>
		</form>
    <!--End main container-->
</body>
</html>
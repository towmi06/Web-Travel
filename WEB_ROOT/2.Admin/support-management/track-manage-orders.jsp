<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>
<%@ page import="bill_managenment.BillManagenment" %>
<%@ page import="bill_managenment.BillManagenmentDAO" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quản Lý Nội Dung</title>
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
    	List<BillManagenment> bills = new BillManagenmentDAO().getAllBills();
        request.setAttribute("bills", bills);
    %>
    
    <!--Main container-->
    <div class="main-container">
        <h1>Thông Tin Đơn</h1>
        <div class="sort-and-search">
            <!--Sort-->
            <div class="sort-dropdown">
                <label for="sort-options">Sắp Xếp Theo:</label>
                <select id="sort-options" onchange="sortTable()">
                    <option value="id">ID</option>
                    <option value="email">Email</option>
                    <option value="contact">sdt</option>
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
                    <th>ID KH</th>
                    <th>Tên Tour</th>
                    <th>Điểm Đến</th>
                    <th>Ngày Khởi Hành</th>
                    <th>Số người</th>
                    <th>Giá</th>
                    <th>Địa Chỉ</th>
                    <th>Loại Hình</th> 
                    <th>Trạng Thái</th> 
                </tr>
            </thead>
            <tbody>
                <c:forEach var="bill" items="${requestScope.bills}">
                    <tr>
                        <td><c:out value="${bill.ID}" /></td>
                        <td><c:out value="${bill.providerID}" /></td>
                        <td><c:out value="${bill.customerID}" /></td>
                        <td><c:out value="${bill.tourName}" /></td>
                        <td><c:out value="${bill.destination}" /></td>
                        <td><c:out value="${bill.departureDate}" /></td>
                        <td><c:out value="${bill.numberOfPeople}" /></td>
                        <td><c:out value="${bill.price}" /></td>
                        <td><c:out value="${bill.address}" /></td>
                        <td><c:out value="${bill.type}" /></td>
                        <td><c:out value="${bill.status}" /></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
    <!--End main container-->
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>
<%@ page import="entity.Service_Th1_OrderManager" %>
<%@ page import="loadDAO.Service_th1_OrderM_DAO" %>
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
    <!--Main container-->
    <div class="main-container">
        <h1>Thông Tin Đơn</h1>
        <div class="sort-and-search">
            <!--Sort-->
            <<div class="sort-dropdown">
                <label for="sort-options">Sắp Xếp Theo:</label>
                <select id="sort-options" onchange="sortTable()">
                    <option value="0">ID</option>
                    <option value="1">Customer ID</option>
                    <option value="2">Tour ID</option>
                    <option value="3">Ngày đặt</option>
                    <option value="4">Giá</option>
                    <option value="5">Trạng thái</option>
                    <option value="6">Ngày tạo</option>
                    <option value="7">Ngày cập nhật</option>
                    <option value="8">Sell ID</option>
                    <option value="9">Tên khách hàng</option>
                    <option value="10">Số điện thoại</option>
                    <option value="11">Địa chỉ</option>
                </select>
            </div>
            <!--Search-->
            <div class="search">
                <input type="search" name="btnSearch" id="searchInput3" class="search-input" oninput="searchTable3()" placeholder="Nhập ở đây">
                <img src="resources/images/search.svg" class="search-icon"></img>
            </div>
        </div>
        
        <table id="orderTable">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Customer ID</th>
                    <th>Tour ID</th>
                    <th>Ngày đặt</th>
                    <th>Giá</th>
                    <th>Trạng thái</th>
                    <th>Ngày tạo</th>
                    <th>Ngày cập nhật</th>
                    <th>Sell ID</th> 
                    <th>Tên khách hàng</th>
                    <th>Số điện thoại</th> 
                    <th>Địa chỉ</th> 
                </tr>
            </thead>
            <tbody>
                <c:forEach var="order" items="${sessionScope.allOrders}">
                    <tr>
                        <td><c:out value="${order.id}" /></td>
                        <td><c:out value="${order.customerId}" /></td>
                        <td><c:out value="${order.tourId}" /></td>
                        <td><c:out value="${order.bookingDate}" /></td>
                        <td><c:out value="${order.totalPrice}" /></td>
                        <td><c:out value="${order.status}" /></td>
                        <td><c:out value="${order.createdAt}" /></td>
                        <td><c:out value="${order.updatedAt}" /></td>
                        <td><c:out value="${order.sellId}" /></td>
                        <td><c:out value="${order.customerName}" /></td>
                        <td><c:out value="${order.phoneNumber}" /></td>
                        <td><c:out value="${order.address}" /></td>
                    </tr>
               </c:forEach>
            </tbody>
        </table>
    </div>
    <!--End main container-->
</body>
</html>
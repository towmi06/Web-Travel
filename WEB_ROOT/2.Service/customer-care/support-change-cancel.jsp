<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>
<%@ page import="entity.Service_Th1_OrderManager" %>
<%@ page import="loadDAO.Service_Tuyen4_Orders_DAO" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quản Lý Thông Tin Tour</title>
    <!-- Style CSS -->
    <link rel="stylesheet" type="text/css" href="resources/css/cancel-service.css"/> 
</head>
<body>  

    <%
        int sellID = (int) session.getAttribute("sell_ID");
  		List<Service_Th1_OrderManager> orderList = Service_Tuyen4_Orders_DAO.getOrdersBySellId(1);
        session.setAttribute("orderList", orderList);
    %>

    <!-- Main container -->
    <div class="main-container">
        <h1>Thông Tin Đơn</h1>
        <div class="sort-and-search">
            <!-- Sort -->
            <div class="sort-dropdown">
                <label for="sort-options2">Sắp Xếp Theo:</label>
                <select id="sort-options2" onchange="sortTable2()">
                    <option value="0">ID</option>
                    <option value="1">Customer ID</option>
                    <option value="2">Tour ID</option>
                    <option value="3">Ngày đặt</option>
                    <option value="4">Tên tour</option>
                    <option value="5">Giá</option>
                    <option value="6">Trạng thái</option>
                    <option value="7">Ngày tạo</option>
                    <option value="8">Ngày cập nhật</option>
                    <option value="9">Tên khách hàng</option>
                    <option value="10">Số điện thoại</option>
                    <option value="11">Địa chỉ</option>
                </select>
            </div>
            <!-- Search -->
            <div class="search">
                <input type="search" id="searchInput" class="search-input" oninput="searchTable2()" placeholder="Nhập ở đây">
                <img src="resources/images/search.svg" class="search-icon" alt="search-icon">
            </div>
        </div>
        
        <table id="supportTable">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Customer ID</th>
                    <th>Tour ID</th>
                    <th>Ngày đặt</th>
                    <th>Tên tour</th>
                    <th>Giá</th>
                    <th>Trạng thái</th>
                    <th>Ngày tạo</th>
                    <th>Ngày cập nhật</th>
                    <th>Tên khách hàng</th>
                    <th>Số điện thoại</th> 
                    <th>Địa chỉ</th> 
                    <th>Thao tác</th> 
                </tr>
            </thead>
            <tbody>
                <c:forEach var="order" items="${orderList}">
                    <tr>
                        <td><c:out value="${order.id}" /></td>
                        <td><c:out value="${order.customerId}" /></td>
                        <td><c:out value="${order.tourId}" /></td>
                        <td><c:out value="${order.bookingDate}" /></td>
                        <td><c:out value="${order.tourName}" /></td>
                        <td><c:out value="${order.totalPrice}" /></td>
                        <td><c:out value="${order.status}" /></td>
                        <td><c:out value="${order.createdAt}" /></td>
                        <td><c:out value="${order.updatedAt}" /></td>
                        <td><c:out value="${order.customerName}" /></td>
                        <td><c:out value="${order.phoneNumber}" /></td>
                        <td><c:out value="${order.address}" /></td>
                        <td><a href="/Web_Travel/OrderServlet?orderId=${order.id}" class="edit-btn" style="text-decoration: none;">Edit</a></td>
                    </tr>
               </c:forEach>
            </tbody>
        </table>
    </div>
    <!-- End main container -->
</body>
</html>
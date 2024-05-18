<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>
<%@ page import="entity.Service_Tuyen4_Order" %>
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
        String sellID = (String) session.getAttribute("sell_ID");
        List<Service_Tuyen4_Order> orderList = new Service_Tuyen4_Orders_DAO().getAllOrdersForService(sellID);
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
                    <option value="1">Sell ID</option>
                    <option value="2">Customer ID</option>
                    <option value="3">Tour ID</option>
                    <option value="4">Ngày đặt</option>
                    <option value="5">Tên tour</option>
                    <option value="6">Thời gian</option>
                    <option value="7">Số người</option>
                    <option value="8">Giá</option>
                    <option value="9">Loại hình</option>
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
                    <th>Sell ID</th>
                    <th>Customer ID</th>
                    <th>Tour ID</th>
                    <th>Ngày đặt</th>
                    <th>Tên tour</th>
                    <th>Thời gian</th>
                    <th>Số người</th>
                    <th>Giá</th>
                    <th>Loại hình</th> 
                    <th>Thao Tác</th> 
                </tr>
            </thead>
            <tbody>
                <c:forEach var="order" items="${orderList}">
                    <tr>
                        <td><c:out value="${order.ID}" /></td>
                        <td><c:out value="${order.sellID}" /></td>
                        <td><c:out value="${order.customerID}" /></td>
                        <td><c:out value="${order.tourID}" /></td>
                        <td><c:out value="${order.bookingDate}" /></td>
                        <td><c:out value="${order.tourName}" /></td>
                        <td><c:out value="${order.date}" /></td>
                        <td><c:out value="${order.numberOfPeople}" /></td>
                        <td><c:out value="${order.price}" /></td>
                        <td><c:out value="${order.type}" /></td>
                        <td>
                            <form action="/Web_Travel/OrderServlet" method="post">
                                <input type="hidden" name="orderId" value="${order.ID}">
                                <button type="submit" class="edit-btn">Edit</button>
                            </form>
                        </td>
                    </tr>
               </c:forEach>
            </tbody>
        </table>
    </div>
    <!-- End main container -->
</body>
</html>
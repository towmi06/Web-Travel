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
    <!--Style CSS-->
    <link rel="icon" href="/Web_Travel/3.Admin/login/assets/logo.png">
    <link rel="stylesheet" type="text/css" href="resources/css/cancel-service.css"/>
    <style>
        .table-input {
            width: 100%;
            box-sizing: border-box; /* Ensure padding and border are included in width */
        }
    </style>
</head>
<body>

	<%
	    String orderId = (String) session.getAttribute("orderId");
	    Service_Tuyen4_Order order = new Service_Tuyen4_Orders_DAO().findOrderByID(orderId);
	    session.setAttribute("order", order);
	%>


    <!--Main container-->
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
       
        <form action="/Web_Travel/UpdateOrderServlet" method="post">
            <table>
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
	                    <th>Lưu đơn</th> 
	                    <th>Hủy đơn</th> 
                    </tr>
                </thead>
                <tbody>
                        <tr>
                            <td><input type="text" name="id" value="${sessionScope.order.ID}" class="table-input"/></td>
                            <td><input type="text" name="sellID" value="${sessionScope.order.sellID}" class="table-input"/></td>
                            <td><input type="text" name="customerID" value="${sessionScope.order.customerID}" class="table-input"/></td>
                            <td><input type="text" name="tourID" value="${sessionScope.order.tourID}" class="table-input"/></td>
                            <td><input type="text" name="bookingDate" value="${sessionScope.order.bookingDate}" class="table-input"/></td>
                            <td><input type="text" name="tourName" value="${sessionScope.order.tourName}" class="table-input"/></td>
                            <td><input type="text" name="date" value="${sessionScope.order.date}" class="table-input"/></td>
                            <td><input type="text" name="numberOfPeople" value="${sessionScope.order.numberOfPeople}" class="table-input"/></td>
                            <td><input type="text" name="price" value="${sessionScope.order.price}" class="table-input"/></td>
                            <td><input type="text" name="type" value="${sessionScope.order.type}" class="table-input"/></td>
                            <td><button name="btnSave" type="submit" class="edit-btn">Lưu Đơn</button></td>
                            <td><button name="btnCancel" type="submit" class="edit-btn">Hủy Đơn</button></td>
                        </tr>
                </tbody>
            </table>
        </form>
    </div>
    <!--End main container-->
</body>
</html>

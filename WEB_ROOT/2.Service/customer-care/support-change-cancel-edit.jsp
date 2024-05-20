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
	    int orderId = (int) session.getAttribute("orderId");
		Service_Th1_OrderManager order = new Service_Tuyen4_Orders_DAO().findOrderByID(orderId);
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
                    <option value="1">Customer ID</option>
                    <option value="2">Tour ID</option>
                    <option value="3">Ngày đặt</option>
                    <option value="4">Giá</option>
                    <option value="5">Trạng thái</option>
                    <option value="6">Ngày tạo</option>
                    <option value="7">Ngày cập nhật</option>
                    <option value="8">Tên khách hàng</option>
                    <option value="9">Số điện thoại</option>
                    <option value="10">Địa chỉ</option>
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
	                    <th>Customer ID</th>
	                    <th>Tour ID</th>
	                    <th>Ngày đặt</th>
	                    <th>Giá</th>
	                    <th>Trạng thái</th>
	                    <th>Ngày tạo</th>
	                    <th>Ngày cập nhật</th>
	                    <th>Tên khách hàng</th>
	                    <th>Số điện thoại</th> 
	                    <th>Địa chỉ</th> 
	                    <th>Lưu đơn</th> 
	                    <th>Hủy đơn</th> 
                    </tr>
                </thead>
                <tbody>
                        <tr>
                            <td><input type="text" name="id" value="${sessionScope.order.id}" class="table-input"/></td>
                            <td><input type="text" name="customerId" value="${sessionScope.order.customerId}" class="table-input"/></td>
                            <td><input type="text" name="tourId" value="${sessionScope.order.tourId}" class="table-input"/></td>
                            <td><input type="text" name="bookingDate" value="${sessionScope.order.bookingDate}" class="table-input"/></td>
                            <td><input type="text" name="totalPrice" value="${sessionScope.order.totalPrice}" class="table-input"/></td>
                            <td><input type="text" name="status" value="${sessionScope.order.status}" class="table-input"/></td>
                            <td><input type="text" name="createdAt" value="${sessionScope.order.createdAt}" class="table-input"/></td>
                            <td><input type="text" name="updatedAt" value="${sessionScope.order.updatedAt}" class="table-input"/></td>
                            <td><c:out value="${sessionScope.order.customerName}" /></td>
                     	  	<td><c:out value="${sessionScope.order.phoneNumber}" /></td>
                        	<td><c:out value="${sessionScope.order.address}" /></td>
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

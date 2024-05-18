<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quản Lý Thông Tin Tour</title>
    <!--Style CSS-->
    <link rel="icon" href="/Web_Travel/3.Admin/login/assets/logo.png">
    <link rel="stylesheet" type="text/css" href="resources/css/cancel-service.css"/> 
</head>
<body>
    <!--Main container-->
    <div class="main-container">
        <h1>Thông Tin Đơn</h1>
       
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
                            <td><input type="text" name="id" value="${sessionScope.order.ID}"/></td>
                            <td><input type="text" name="sellID" value="${sessionScope.order.sellID}" /></td>
                            <td><input type="text" name="customerID" value="${sessionScope.order.customerID}" /></td>
                            <td><input type="text" name="tourID" value="${sessionScope.order.tourID}" /></td>
                            <td><input type="text" name="bookingDate" value="${sessionScope.order.bookingDate}" /></td>
                            <td><input type="text" name="tourName" value="${sessionScope.order.tourName}" /></td>
                            <td><input type="text" name="date" value="${sessionScope.order.date}" /></td>
                            <td><input type="text" name="numberOfPeople" value="${sessionScope.order.numberOfPeople}" /></td>
                            <td><input type="text" name="price" value="${sessionScope.order.price}" /></td>
                            <td><input type="text" name="type" value="${sessionScope.order.type}" /></td>
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

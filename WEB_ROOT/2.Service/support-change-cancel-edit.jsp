<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="Service_Tuyen.customer_care.Bill" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quản Lý Thông Tin Tour</title>
    <!--Style CSS-->
    <link rel="stylesheet" type="text/css" href="resources/css/cancel service.css"/> 
</head>
<body>
    <!--Main container-->
    <div class="main-container">
        <h1>Thông Tin Đơn</h1>
       
        <form action="/Web_Travel/UpdateBillServlet" method="post">
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
                        <th>Lưu</th>
                        <th>Hủy</th>
                    </tr>
                </thead>
                <tbody>
                        <tr>
                            <td><input type="text" name="id" value="${sessionScope.bill.ID}"/></td>
                            <td><input type="text" name="providerID" value="${sessionScope.bill.providerID}" /></td>
                            <td><input type="text" name="customerID" value="${sessionScope.bill.customerID}" /></td>
                            <td><input type="text" name="tourName" value="${sessionScope.bill.tourName}" /></td>
                            <td><input type="text" name="destination" value="${sessionScope.bill.destination}" /></td>
                            <td><input type="text" name="departureDate" value="${sessionScope.bill.departureDate}" /></td>
                            <td><input type="text" name="numberOfPeople" value="${sessionScope.bill.numberOfPeople}" /></td>
                            <td><input type="text" name="price" value="${sessionScope.bill.price}" /></td>
                            <td><input type="text" name="address" value="${sessionScope.bill.address}" /></td>
                            <td><input type="text" name="type" value="${sessionScope.bill.type}" /></td>
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

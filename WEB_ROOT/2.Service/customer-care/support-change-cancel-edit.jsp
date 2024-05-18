<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>
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
                    <th>Thao Tác</th>
                    
                </tr>
            </thead>
            <form action="/Web_Travel/BillServlet" method="post">
                <tbody>
                    <tr>
                        <td><input type="text" name="id" value="${bill.ID}"/></td>
                        <td><input type="text" name="providerID" value="${bill.providerID}" /></td>
                        <td><input type="text" name="customerID" value="${bill.customerID}" /></td>
                        <td><input type="text" name="tourName" value="${bill.tourName}" /></td>
                        <td><input type="text" name="destination" value="${bill.destination}" /></td>
                        <td><input type="text" name="departureDate" value="${bill.departureDate}" /></td>
                        <td><input type="text" name="numberOfPeople" value="${bill.numberOfPeople}" /></td>
                        <td><input type="text" name="price" value="${bill.price}" /></td>
                        <td><input type="text" name="address" value="${bill.address}" /></td>
                        <td><input type="text" name="type" value="${bill.type}" /></td>
                        <td><button type="submit" class="edit-btn">Save</button></td>
                    </tr>
                </tbody>
            </form>
        </table>
    </div>
    <!--End main container-->
</body>
</html>

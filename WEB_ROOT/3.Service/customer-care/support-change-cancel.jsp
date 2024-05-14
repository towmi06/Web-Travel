<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>
<%@ page import="customer_care.Bill" %>
<%@ page import="customer_care.BillDAO" %>
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

	<%
		List<Bill> billList = new BillDAO().getAllBills();
		request.setAttribute("billList", billList);
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
                    <th>Thao Tác</th> 
                </tr>
            </thead>
            <tbody>
            	<c:forEach var="bill" items="${requestScope.billList}">
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
	                    <td>
                            <form action="/Web_Travel/BillServlet" method="post">
                                <input type="hidden" name="billId" value="${bill.ID}">
                                <button type="submit" class="edit-btn">Edit</button>
                            </form>
                        </td>
	                </tr>
	           </c:forEach>
            </tbody>
        </table>
    </div>
    <!--End main container-->
</body>
</html>
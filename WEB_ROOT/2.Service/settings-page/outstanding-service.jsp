<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ page import="entity.Service_Tuyen1_OutStanding" %>
<%@ page import="loadDAO.Service_Tuyen1_OutStanding_DAO" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quản Lý Thông Tin Tour</title>
    <!--Style CSS-->
    <link rel="stylesheet" type="text/css" href="resources/css/outstanding-service.css"/> 
</head>
<body>

	<%
    	int sell_ID = (int) session.getAttribute("sell_ID");
 		List<Service_Tuyen1_OutStanding> danhSach = Service_Tuyen1_OutStanding_DAO.getOutstandingServices(sell_ID);
  		session.setAttribute("danhSach", danhSach);
    %>

    <!--Main container-->
    <div class="main-container">
        <h2>Dịch vụ bán chạy</h2>
        <div class="sort-and-search">
            <!--Sort-->
            <div class="sort-dropdown">
                <label for="sort-options">Sắp Xếp Theo:</label>
                <select id="sort-options" onchange="sortTable()">
                    <option value="0">ID</option>
                    <option value="1">Sell_ID</option>
                    <option value="2">Cate_ID</option>
                    <option value="3">Rate</option>
                    <option value="4">Sales</option>
                    <option value="5">Tour Name</option>
                    <option value="6">Journeys</option>
                    <option value="7">Date</option>
                    <option value="8">Price</option>
                </select>
            </div>
            <!--Search-->
           <div class="search">
                <input type="search" name="btnSearch" id="searchInput" class="search-input" oninput="searchTable()" placeholder="Nhập ở đây">
                <img src="resources/images/search.svg" class="search-icon"></img>
            </div>
        </div>
        
        <div id="table-container">
            <form action="/Web_Travel/outstandingServiceServlet" method="post" id="updateForm">
                <table id="outstandingTable">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Sell_ID</th>
                            <th>Cate_ID</th>
                            <th>Rate</th>
                            <th>Sales</th>
                            <th>Tour Name</th>
                            <th>Journeys</th>
                            <th>Date</th>
                            <th>Price</th>
                            <th>Thao Tác</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="service" items="${danhSach}">
                            <tr>
                                <td><c:out value="${service.id}" /></td>
                                <td><c:out value="${service.sell_ID}" /></td>
                                <td><c:out value="${service.cateID}" /></td>
                                <td><c:out value="${service.rate}" /></td>
                                <td><c:out value="${service.sales}" /></td>
                                <td><c:out value="${service.tourName}" /></td>
                                <td><c:out value="${service.journeys}" /></td>
                                <td><c:out value="${service.date}" /></td>
                                <td><c:out value="${service.price}" /></td>
                                <td><input class="edit-checkbox" type="checkbox" name="outstandingIds" value="${service.id}" <c:if test="${service.outstanding}">checked</c:if> ></td> 
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
    
                <button type="submit" class="save-btn">Lưu</button>
            </form>
        </div>
    </div>
    <!--End main container-->  
</body>
</html>

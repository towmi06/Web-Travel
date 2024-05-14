<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ page import="java.util.List" %>
<%@ page import="Service_Tuyen.setting_page.OutstandingService" %>
<%@ page import="Service_Tuyen.setting_page.OutstandingServiceDAO" %>
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
    <!--Main container-->
    <div class="main-container">
        <h2>Dịch vụ bán chạy</h2>
        <div class="sort-and-search">
            <!--Sort-->
            <div class="sort-dropdown">
                <form action="/Web_Travel/outstandingServiceServlet" method="post">
                    <label for="sort-options">Sắp Xếp Theo:</label>
                    <select name="sortBy" id="sort-options">
                        <option value="ID">ID</option>
                        <option value="rate">Rate</option>
                        <option value="sales">Sales</option>
                    </select>
                </form>
            </div>
        </div>
        
        <div id="table-container">
            <form action="/Web_Travel/outstandingServiceServlet" method="post" id="updateForm">
                <table>
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Rate</th>
                            <th>Sales</th>
                            <th>Tên Tour</th>
                            <th>Điểm Đến</th>
                            <th>Ngày Khởi Hành</th>
                            <th>Giá</th>
                            <th>Địa Chỉ</th>
                            <th>Loại Hình</th>
                            <th>Outstanding</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%  
                            List<OutstandingService> danhSach = OutstandingServiceDAO.getOutstandingServices();
                            request.setAttribute("danhSach", danhSach);
                            for (OutstandingService service : danhSach) {
                        %>
                            <tr>
                                <td><c:out value="<%= service.getID() %>" /></td>
                                <td><c:out value="<%= service.getRate() %>" /></td>
                                <td><c:out value="<%= service.getSales() %>" /></td>
                                <td><c:out value="<%= service.getTourName() %>" /></td>
                                <td><c:out value="<%= service.getDestination() %>" /></td>
                                <td><c:out value="<%= service.getDepartureDate() %>" /></td>
                                <td><c:out value="<%= service.getPrice() %>" /></td>
                                <td><c:out value="<%= service.getAddress() %>" /></td>
                                <td><c:out value="<%= service.getCategory() %>" /></td>
                                <td><input class="edit-checkbox" type="checkbox" name="outstandingIds" value="<%= service.getID() %>" <% if(service.getOutstanding()) out.print("checked"); %> ></td> 
                            </tr>
                        <%
                            }
                        %>
                    </tbody>
                </table>
    
                <button type="submit" class="save-btn">Lưu</button>
            </form>
        </div>

    </div>
    <!--End main container-->  
</body>
</html>
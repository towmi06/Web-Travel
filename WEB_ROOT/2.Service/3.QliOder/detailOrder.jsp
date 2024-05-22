<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Order Details</title>
</head>
<body>
    <h1>Order Details</h1>
    <table border="1">
        <tr>
            <th>Order ID</th>
            <th> Image Tour </th>
            <th>Tour Name</th>
            <th>Journeys</th>
            <th>NumberCus</th>
            <th>Phone</th>
            <th>Name Customer</th>
            <th>Address</th>
        </tr>
        <c:forEach var="orderDetail" items="${orderDetails}">
            <tr>
                <td>${orderDetail.orderId}</td>
                <td>${orderDetail.productName}</td>
                <td>${orderDetail.quantity}</td>
                <td>${orderDetail.price}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>

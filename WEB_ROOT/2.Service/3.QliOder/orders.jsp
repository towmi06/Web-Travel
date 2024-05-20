<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Order List</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <h2>Order List</h2>
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>ID</th>
                   <!-- <th>Customer ID</th>-->
                    <th>Image</th>
                    <th>Booking Date</th>
                    <th>Total Price</th>
                    <th>Status</th>
                    <th>Created At</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="order" items="${orders}">
                    <tr>
                        <td>${order.id}</td>
                        <td><img src="./2.Service/resources/images/image_tour/${orders.tourID}.jpg" alt="${orders.tourID}" class="card-img-top"> </td>
                        <td>${order.bookingDate}</td>
                        <td>${order.totalPrice}</td>
                        <td>${order.status}</td>
                        <td>${order.createdAt}</td>
                     <!--    <td>${order.customerName}</td>
                        <td>${order.phoneNumber}</td>
                        <td>${order.address}</td> -->
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>

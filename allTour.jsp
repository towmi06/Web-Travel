<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>All Tours</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .tour {
            margin: 25px;
            flex-direction: column;
            align-items: center;
            height: 600px;
            width: 500px;
        }
        .tour img {
            width: 100%;
            height: 300px;
            border: none;
        }
        .left-column {
            margin-left: -100px;
        }
        .card-body {
            display: flex;
            flex-direction: column;
            justify-content: center;
            text-align: left;
            padding: 1rem;
        }
        /* Chỉnh kích thước cột cho hiển thị 2 cột trên mỗi hàng */
        @media (min-width: 768px) {
            .col-md-6 {
                flex: 0 0 calc(50% - 10px); /* 20px là khoảng cách giữa 2 cột */
                max-width: calc(50% - 10px);
            }
        }
    </style>
</head>
<body>

<div class="container">
    <div class="row">
        <!-- Left Column for Categories -->
        <div class="col-md-2 left-column">
            <h2>Categories</h2>
            <div class="list-group">
                <c:if test="${not empty listC}">
                    <c:forEach var="cate" items="${listC}">
                        <button type="button" class="list-group-item list-group-item-action">${cate.name}</button>
                    </c:forEach>
                </c:if>
            </div>
        </div>
        <!-- Right Column for Tours -->
        <div class="col-md-10">
            <h2>All Tours</h2>
            <div class="row">
                <c:forEach var="tour" items="${listP}" varStatus="status">
                    <div class="col-md-6">
                        <div class="tour card">
                            <img src="./image/image_tour/${tour.image}" alt="${tour.image}" class="card-img-top">
                            <div class="card-body">
                                <h5 class="card-title">${tour.tourName}</h5>
                                <p class="card-text">Price: ${tour.price}</p>
                                <p class="card-text">Journey: ${tour.journeys}</p>
                                <a href="#" class="btn btn-primary">Add to Cart</a>
                                <a href="#" class="btn btn-secondary">View Details</a>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</div>


</body>
</html>

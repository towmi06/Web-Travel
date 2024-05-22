<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title> 🛍️ Order List Management</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/boxicons/2.0.7/css/boxicons.min.css">
    <style>
        .center {
            text-align: center;
            font-size: 17px;
        }
        .button-style {
            border-radius: 5px;
            background-color: #0a4f4f;
            color: #ffffff;
            border: none;
            padding: 7px 10px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 18px;
            margin: 5px 3px;
            cursor: pointer;
        }
        .status-column {
            text-align: center;
            vertical-align: middle;
            text-transform: uppercase;
            font-weight: bold;
        }
        .header-row {
            background-color: #d1ecf1; /* Light blue color */
        }
    </style>
</head>
<body>
<div class="container">
    <h2 class="center" style="font-size: 40px; margin-top: 20px; margin-bottom:15px;">
        <i class='bx bx-purchase-tag-alt' style='color:#326f30;'></i> Order List
    </h2>

    <div class="row" style="margin-bottom: 7px;">
        <div class="col-md-6">
            <form>
                <div class="input-group">
                    <input type="search" name="search" id="search" placeholder="Search everything"
                           class="form-control" style =  "border-radius: 3px;">
                    <span class="input-group-append">
                        <button type="submit" class="btn btn-primary" style="background-color: #0a4f4f; border-radius: 5px;">
						    <box-icon name='search-alt' flip='horizontal' color='#ffffff'></box-icon>
                            🌐 Search
                        </button>
                    </span>
                </div>
            </form>
        </div>
        <div class="col-md-6">
            <div class="float-right">
                <div role="group" class="btn-group-sm btn-group">
                    <button class="btn btn-focus" style="background-color:#0a4f4f; color: #ffffff; border-radius: 5px;margin-right: 3px;">This week</button>
                    
					<button class="active btn btn-focus" style="background-color:#0a4f4f; color: #ffffff; border-radius: 5px;">Anytime</button>

                </div>
            </div>
        </div>
    </div>
                <table class="table table-bordered">
                    <thead class="header-row">
                        <tr>
                            <th class="center">ID</th>
                            <th class="center">Image</th>
                            <th class="center">Booking Date</th>
                            <th class="center">Total Price</th>
                            <th class="center">Status</th>
                            <th class="center">Created At</th>
                            <th class="center">Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="order" items="${orders}">
                            <tr>
                                <td style="text-align: center; vertical-align: middle;">${order.id}</td>
                                <td style="text-align: center; vertical-align: middle;">
                                    <img src="./2.Service/resources/images/image_tour/${order.imageTour}"
                                         alt="${order.imageTour}"
                                         style="width: 300px; height: 200px; display: block; margin: 0 auto;">
                                </td>
                                <td style="text-align: center; vertical-align: middle;">${order.bookingDate}</td>
                                <td style="text-align: center; vertical-align: middle;">${order.totalPrice}</td>
                                <td class="status-column" style="text-align: center; vertical-align: middle;">${order.status}</td>
                                <td style="text-align: center; vertical-align: middle;">${order.createdAt}</td>
                                <td style="text-align: center; vertical-align: middle;">
                                    <form action="Service_Th2_DetailOrderM_Servlet" method="GET">
									    <input type="hidden" name="id" value="${order.id}">
									    <button class="button-style" type="submit">Detail</button>
									</form>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
</body>
</html>

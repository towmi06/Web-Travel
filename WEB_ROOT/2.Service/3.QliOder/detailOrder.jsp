<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Order Details</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no, shrink-to-fit=no" />
    <meta name="description" content="This is an example dashboard created using build-in elements and components.">

    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">

    <link href="./2.Service/resources/css/main.css" rel="stylesheet">
    <link href="./2.Service/resources/my_style.css" rel="stylesheet">
</head>
<body>
<!-- Main -->
<div class="container mt-5">
    <div class="app-page-title">
        <div class="page-title-wrapper">
            <div class="page-title-heading">
                <div class="page-title-icon">
                    <i class="pe-7s-ticket icon-gradient bg-mean-fruit"></i>
                </div>
                <div>
                    Order
                    <div class="page-title-subheading">
                        View, create, update, delete and manage.
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="row mt-4">
        <div class="col-md-12">
            <div class="card mb-3">
                <div class="card-body">
                    <div class="table-responsive">
                        <h2 class="text-center">Products list</h2>
                        <hr>
                        <table class="table table-borderless table-striped table-hover">
                            <thead>
                                <tr>
                                    <th>Product</th>
                                    <th class="text-center">Number of Customer</th>
                                    <th class="text-center">Time Booking</th>
                                    <th class="text-center">Total</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="orderDetail" items="${orders}">
                                    <tr>
                                        <td>
                                            <div class="d-flex align-items-center">
                                                <img src="./2.Service/resources/images/image_tour/${orderDetail.imageTour}" alt="" class="img-thumbnail mr-3" style="height: 60px;">
        
                                            </div>
                                        </td>
                                        <td class="text-center">${orderDetail.numberOrders}</td>
                                        <td class="text-center">${orderDetail.bookingDate}</td>
                                        <td class="text-center">${orderDetail.totalPrice}</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>

                    <h2 class="text-center mt-5">Order info</h2>
                    <hr>
                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group row">
                                <label class="col-sm-4 col-form-label">Order ID</label>
                                <div class="col-sm-8">
                                    <p class="form-control-plaintext">${orderDetail.id}</p>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-sm-4 col-form-label">Booking Date</label>
                                <div class="col-sm-8">
                                    <p class="form-control-plaintext">${orderDetail.bookingDate}</p>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-sm-4 col-form-label">Full Name</label>
                                <div class="col-sm-8">
                                    <p class="form-control-plaintext">${orderDetail.customerName}</p>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-sm-4 col-form-label">Email</label>
                                <div class="col-sm-8">
                                    <p class="form-control-plaintext">${orderDetail.customerEmail}</p>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-sm-4 col-form-label">Phone</label>
                                <div class="col-sm-8">
                                    <p class="form-control-plaintext">${orderDetail.customerPhone}</p>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-sm-4 col-form-label">Street Address</label>
                                <div class="col-sm-8">
                                    <p class="form-control-plaintext">${orderDetail.customerAddress}</p>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6" >
                            <div class="form-group row" style = "margin-left:70px;">
                                <label class="col-sm-4 col-form-label">Payment Type</label>
                                <div class="col-sm-8">
                                    <p class="form-control-plaintext">${orderDetail.paymentMethod}</p>
                                </div>
                            </div>
                            <div class="form-group row" style = "margin-left:70px;">
                                <label class="col-sm-4 col-form-label">Payment Date</label>
                                <div class="col-sm-8">
                                    <span class="form-control-plaintext">${orderDetail.paymentDate}</span>
                                </div>
                            </div>
                            <div class="form-group row" style = "margin-left:70px;">
                                <label class="col-sm-4 col-form-label">Status</label>
                                <div class="col-sm-8">
                                    <span class="badge badge-dark">${orderDetail.status}</span>
                                </div>
                            </div>
                            <div class="form-group row" style = "margin-left:70px;">
                                <label class="col-sm-4 col-form-label">Update</label>
                                <div class="col-sm-8">
                                    <span class="form-control-plaintext">${orderDetail.updatedAt}</span>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </div>
</div>
<!-- End Main -->

<!-- Bootstrap JS and dependencies -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>

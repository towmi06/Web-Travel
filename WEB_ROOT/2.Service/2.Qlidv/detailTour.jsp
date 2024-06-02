<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Tour Details</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no, shrink-to-fit=no" />

    <!-- Bootstrap CSS -->
    <link rel="icon" href="/Web_Travel/2.Service/resources/images/online-shopping.png">
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
                <div>Tour
                    <div class="page-title-subheading">
                        View, create, update, delete and manage.
                    </div>
                </div>
            </div>
        </div>
    </div>

    <c:if test="${not empty message}">
        <div class="alert alert-success alert-dismissible fade show" role="alert">
            ${message}
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
    </c:if>

    <div class="row mt-4">
        <div class="col-md-3">
            <a href="javascript:history.back()" class="btn btn-link" style="font-size:18px">&lt; Back</a>
        </div>
        <div class="col-md-6 text-center">
            <h2>Products list</h2>
        </div>
    </div>

    <div class="card mb-3">
        <div class="card-body">
            <div class="table-responsive">
                <!-- Thông tin đơn hàng -->
                <table class="table table-borderless table-striped table-hover">
                    <thead>
                        <tr>
                            <th>Tour</th>
                            <th class="text-center">Date</th>
                            <th class="text-center">Rate</th>
                            <th class="text-center">Total</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>
                                <div class="d-flex align-items-center">
                                    <img src="./2.Service/resources/images/image_tour/${tour.image}" alt="" class="img-thumbnail mr-3" style="height: 60px;">
                                    <span>${tour.tourName}</span>
                                </div>
                            </td>
                            <td class="text-center">${tour.date}</td>
                            <td class="text-center">⭐⭐⭐⭐4.5/300 lượt đánh giá</td>
                            <td class="text-center">${tour.price}</td>
                        </tr>
                    </tbody>
                </table>
            </div>

            <h2 class="text-center mt-5">Tour info</h2>
            <hr>
            <div class="row">
                <div class="col-md-6">
                    <div class="form-group row">
                        <label class="col-sm-4 col-form-label">Tour ID</label>
                        <div class="col-sm-8">
                            <p class="form-control-plaintext">${tour.id}</p>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-4 col-form-label">Date</label>
                        <div class="col-sm-8">
                            <p class="form-control-plaintext">${tour.date}</p>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-4 col-form-label">Full Name</label>
                        <div class="col-sm-8">
                            <p class="form-control-plaintext">${tour.tourName}</p>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-4 col-form-label">Journeys</label>
                        <div class="col-sm-8">
                            <p class="form-control-plaintext">${tour.journeys}</p>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-4 col-form-label">Status</label>
                        <div class="col-sm-8">
                             <span class="badge badge-success">active</span>
                        </div>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="form-group row">
                        <label class="col-sm-4 col-form-label">Number Order recently:</label>
                        <div class="col-sm-8">
                            <p class="form-control-plaintext">20</p>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-4 col-form-label">Description</label>
                        <div class="col-sm-8">
                            <p class="form-control-plaintext">${tour.description1}</p>
                        </div>
                    </div>
                    <div class="d-flex justify-content-end">
                        <a href="${pageContext.request.contextPath}/edit?id=${tour.id}" class="btn btn-primary mr-2">
                            <i class='bx bx-edit'></i> Edit
                        </a>
                        <form action="Service_Th6_DeleteProductM_Servlet" method="post" onsubmit="return confirm('Do you really want to delete this item?')">
                            <input type="hidden" name="id" value="${tour.id}">
                            <button type="submit" class="btn btn-danger">
                                <i class="bx bx-trash"></i> Delete
                            </button>
                        </form>
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

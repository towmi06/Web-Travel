<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add New Product</title>
    <link rel="icon" href="/Web_Travel/2.Service/resources/images/online-shopping.png">
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">

    <style>
        .fixed-header {
            position: fixed;
            top: 0;
            left: 0;
            width: 100%;
            z-index: 1000;
            background: #f8f9fa;
            padding: 1rem 0;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }
        .fixed-header a.back-button {
            font-size: 1.5rem;
            margin-right: 1rem;
            text-decoration: none;
            color: #007bff;
        }
        .form-container {
            margin-top: 7rem; /* Adjusted for larger header */
        }
        .image-container img {
            width: 300px;
            height: 220px;
            object-fit: cover;
        }
    </style>
</head>
<body>
    <nav class="fixed-header navbar navbar-light">
        <div class="container-fluid">
            <a href="javascript:history.back()" class="back-button">&lt; Back</a>
            <h2 class="mx-auto">Add Product</h2>
        </div>
    </nav>

    <form action="add" method="post" class="container form-container">
        <div class="row">
            <div class="col-md-6">
                <div class="form-group">
                    <label for="id">ID tour</label>
                    <input id="id" name="id" type="text" class="form-control" required>
                </div>
            </div>
            <div class="col-md-6">
                <div class="form-group">
                    <label for="nameTour">Name</label>
                    <input id="nameTour" name="nameTour" type="text" class="form-control" required>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-3">
                <div class="form-group">
                    <label for="image">Image</label>
                    <input id="image" name="image" type="text" class="form-control" required>
                </div>
            </div>
            <div class="col-md-3">
                <div class="form-group">
                    <label for="date">Date</label>
                    <input id="date" name="date" type="text" class="form-control" required>
                </div>
            </div>
            <div class="col-md-3">
                <div class="form-group">
                    <label for="price">Price</label>
                    <input id="price" name="price" type="text" class="form-control" required>
                </div>
            </div>
            <div class="col-md-3">
                <div class="form-group">
                    <label for="category">Category</label>
                    <select id="category" name="category" class="form-control" required>
                        <c:forEach items="${listC}" var="cate">
                            <option value="${cate.id}">${cate.name}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
        </div>
        <div class="form-group">
            <label for="journeys">Journeys</label>
            <textarea id="journeys" name="journeys" class="form-control" required></textarea>
        </div>
        <div class="form-group">
            <label for="description1">Description</label>
            <textarea id="description1" name="description1" class="form-control" required></textarea>
        </div>
        <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
            <button type="submit" class="btn btn-success">Add</button>
        </div>
    </form>
</body>
</html>

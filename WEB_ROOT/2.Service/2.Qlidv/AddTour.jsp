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
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/boxicons/2.0.7/css/boxicons.min.css">
    <link href="https://unpkg.com/tailwindcss@^2/dist/tailwind.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link href="./2.Service/resources/css/main.css" rel="stylesheet">
    <link href="./2.Service/resources/my_style.css" rel="stylesheet">
    <style>
        .fixed-header {
            position: fixed;
            top: 0;
            left: 0;
            width: 100%;
            z-index: 1000;
            background: white;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }
        .fixed-header a.back-button {
            font-size: 1.5rem;
            margin-right: 1rem;
            text-decoration: none;
            color: #007bff;
        }
        .form-container {
            margin-top: 6rem;
        }
        .image-container img {
            width: 300px;
            height: 220px;
            object-fit: cover;
        }
    </style>
</head>
<body>
    <!-- Header Section -->
    <div class="fixed-header p-2 d-flex align-items-center justify-content-between">
        <a href="javascript:history.back()" class="back-button"> < Back</a>
        <h2 class="my-0 font-weight-bold text-center">Add New Product</h2>
        <div>
            <button type="button" class="btn btn-warning" onclick="cancelAdd()">Cancel</button>
            <button type="submit" class="btn btn-primary" onclick="saveProduct()">ADD</button>
        </div>
    </div>

    <!-- Form Section -->
    <div class="container mx-auto mt-5">
        <form id="addProductForm" action="Service_Th5_AddProductM_Servlet" method="post" enctype="multipart/form-data">
            <!-- Product Details -->
            <div class="row">
                <div class="col-md-6">
                    <div class="form-group">
                        <label for="productName">Product Name:</label>
                        <input type="text" class="form-control" id="productName" name="productName" required>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="form-group">
                        <label for="productPrice">Price: $</label>
                        <input type="number" class="form-control" id="productPrice" name="productPrice" required>
                    </div>
                </div>
            </div>

            <!-- Product Image -->
            <div class="row">
                <div class="col-md-6">
                    <div class="form-group">
                        <label for="productImage">Product Image:</label>
                        <div class="image-upload-container" onclick="document.getElementById('newImage').click();">
                            <img id="new-image-preview" src="./2.Service/resources/images/add-image-icon.jpg"  alt="New Image"  style="width:600px; height:400px;">
                            <input type="file" id="newImage" name="newImage" onchange="previewNewImage(this);" accept="image/*" style="display: none;">
                        </div>
                        <small class="form-text text-muted">Upload a product image or leave it empty for default image.</small>
                    </div>
                </div>
          

            <!-- Date and Journeys -->
           
                <div class="col-md-6" >
	                <div class="row">
	                    <div class="form-group">
	                        <label for="tourDate" style="margin-left:10px;">Date:</label>
	                        <input type="date" class="form-control" id="tourDate" name="tourDate"style="width:550px;margin-left:10px;" required>
	                    </div>
	                </div>
                	<div class="row">
	                    <div class="form-group">
	                        <label for="tourJourneys" style="margin-left:10px;">Journey:</label>
	                        <input type="text" class="form-control" id="tourJourneys" name="tourJourneys" style="width:550px;margin-left:10px ;"required>
	                    </div>
               		</div>
               		<div class="row">
	                    <div class="form-group">
	                        <label for="tourJourneys" style="margin-left:10px;"> Image Name: </label>
	                        <input type="text" class="form-control" id="newImage" name="newImage" style="width:550px;margin-left:10px ;"required>
	                    </div>
	               <div class="row">
	                    <div class="form-group">
                           <label>Category</label>
                                <select name="category" class="form-select" aria-label="Default select example">
                                    <c:forEach items="${listCC}" var="o">
                                        <option value="${o.cid}">${o.cname}</option>
                                    </c:forEach>
                                </select>
                          </div>
               		</div>
           		</div>
			</div>
            <!-- Product Description -->
            <div class="row">
                <div class="col-md-12">
                    <div class="form-group">
                        <label for="productDescription">Description:</label>
                        <textarea class="form-control" id="productDescription" name="productDescription" rows="10" required></textarea>
                    </div>
                </div>
            </div>

            
    </div>

    <!-- JavaScript Section -->
    <script>
        function cancelAdd() {
            window.history.back();
        }

        function saveProduct() {
            // Perform validation if needed
            document.getElementById('addProductForm').submit();
        }

        function previewNewImage(input) {
            if (input.files && input.files[0]) {
                var reader = new FileReader();
                reader.onload = function (e) {
                    document.getElementById('new-image-preview').src = e.target.result;
                };
                reader.readAsDataURL(input.files[0]);
            }
        }
    </script>
</body>
</html>

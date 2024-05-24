<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Tour Information</title>
    <link rel="icon" href="/Web_Travel/2.Service/resources/images/online-shopping.png">
    <link href="https://unpkg.com/tailwindcss@^2/dist/tailwind.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
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
            margin-top: 5rem;
        }
        .image-container img {
            width: 300px;
            height: 220px;
            object-fit: cover;
        }
        .image-preview {
            max-width: 300px;
            display: none;
            margin: 0 auto;
        }
    </style>
</head>
<body>
    <c:out value="${message}" />
    <div class="container form-container">
        <form id="editTourForm" action="Service_Th5_EditProductM_Servlet" method="post" enctype="multipart/form-data">
            <div class="fixed-header p-2 d-flex align-items-center justify-content-between">
                <a href="javascript:history.back()" class="back-button"> &lt; Back</a>
                <h2 class="my-0 font-weight-bold text-center">Edit Tour Information</h2>
                <div>
                    <button type="button" class="btn btn-secondary ml-2" onclick="cancelEdit()">Cancel</button>
                    <button type="button" class="btn btn-primary" onclick="saveForm()">Save</button>
                </div>
            </div>
            
            <input type="hidden" name="id" value="${product.id}">
            <div class="row">
                <div class="col-md-12 text-center mb-4">
                    <h2 class="font-weight-bold">Tour Name: ${product.tourName}</h2>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <div class="position-relative form-group">
                        <label for="" class="col-md-3 text-md-right col-form-label">Ảnh</label>
                        <div style="width: 250px; height: 200px; overflow: hidden; object-fit: cover;">
                            <img src="./2.Service/resources/images/image_tour/${product.image}" alt="Current Image" style="width: 250px; height: 200px; object-fit: cover;">
                        </div>
                    </div>
                    <div class="position-relative form-group">
                        <label for="imageName1" class="col-md-3 text-md-right col-form-label">Tên Ảnh</label>
                        <div class="col-md-9 col-xl-8">
                            <input type="text" class="form-control" id="imageName1" name="imageName1" value="${product.image}" required disabled>
                        </div>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="row">
                        <div class="col-md-4">
                            <div class="form-group">
                                <label for="tourDate">Date:</label>
                                <input type="text" class="form-control" id="date" name="date" value="${product.date}" required>
                            </div>
                        </div>
                        <div class="col-md-3">
                            <div class="form-group">
                                <label for="tourPrice">Price: $</label>
                                <input type="number" class="form-control" id="price" name="price" value="${product.price}" required>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="tourJourneys">Journey:</label>
                            <textarea class="form-control" id="journeys" name="journeys" rows="2" required>${product.journeys}</textarea>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="tourDescription">Description:</label>
                            <textarea class="form-control" id="description1" name="description1" rows="4" required>${product.description1}</textarea>
                        </div>
                    </div>
                </div>
            </div>
        </form>
    </div>

    <script>
        function saveForm() {
            document.getElementById("editTourForm").submit();
        }

        function cancelEdit() {
            history.back();
        }
    </script>
</body>
</html>

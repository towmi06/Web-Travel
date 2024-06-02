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
	   <c:if test="${not empty message}">
	    <div class="alert alert-success alert-dismissible fade show" role="alert">
	        ${message}
	        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
	            <span aria-hidden="true">&times;</span>
	        </button>
	    </div>
	</c:if>

    <div class="container form-container">
        <form action="edit" method="post">
            <div class="fixed-header p-2 d-flex align-items-center justify-content-between">
                <a href="javascript:history.back()" class="back-button"> &lt; Back</a>
                <h2 class="my-0 font-weight-bold text-center">Edit Tour Information</h2>
                <div>
                    <button type="button" class="btn btn-secondary ml-2" onclick="cancelEdit()">Cancel</button>
                     <button type="submit" class="btn btn-success">Save</button>
                </div>
            </div>
            
            <input type="hidden" name="id" value="${tour.id}">
            <div class="row">
                <div class="col-md-12 text-center mb-4">
                    <label for="tourName">Tour Name</label>
			    <h2 id="tourName" class="font-weight-bold">${tour.tourName}</h2>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <div class="position-relative form-group">
                        <div style="width: 500px; height: 400px; overflow: hidden; object-fit: cover;">
                            <img src="./2.Service/resources/images/image_tour/${tour.image}" alt="Current Image" style="width: 500px; height: 400px; object-fit: cover;">
                        </div>
                    </div>
                    <div class="position-relative form-group">
                        <label for="image" class="col-md-3 text-md-right col-form-label">Tên Ảnh</label>
                        <div class="col-md-9 col-xl-8">
                            <input type="text" class="form-control" id="imageName1" name="imageName1" value="${tour.image}" required disabled>
                        </div>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="row">
                        <div class="col-md-4">
                            <div class="form-group">
                                <label for="date">Date:</label>
                                <input type="text" class="form-control" id="date" name="date" value="${tour.date}" required>
                            </div>
                        </div>
                        <div class="col-md-3">
                            <div class="form-group">
                                <label for="price">Price: $</label>
                                <input type="text" class="form-control" id="price" name="price" value="${tour.price}" required>
                            </div>
                        </div>
                        <div class="col-md-3">

          		  </div>
                    </div>
                    <div class="col-md-12">
                        <div class="form-group">
                            <label for="tourJourneys">Journey:</label>
                            <textarea class="form-control" id="journeys" name="journeys" rows="2" required>${tour.journeys}</textarea>
                        </div>
                    </div>
                    <div class="col-md-12">
                        <div class="form-group">
                            <label for="tourDescription">Description:</label>
                            <textarea class="form-control" id="description1" name="description1" rows="4" required>${tour.description1}</textarea>
                        </div>
                    </div>
                </div>
            </div>
        </form>
    </div>

    <script>
        function cancelEdit() {
            history.back();
        }
    </script>
</body>
</html>

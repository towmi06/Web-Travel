<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Tour Information</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<c:out value="${message}" />
<div class="container">
    <h2 class="my-4">Edit Tour Information</h2>
    <form action="edit_tour_action.jsp" method="post" enctype="multipart/form-data">
        <div class="form-group">
            <label for="tourName">Tour Name:</label>
            <input type="text" class="form-control" id="tourName" name="tourName" required>
        </div>
        <div class="form-group">
            <label for="tourImage">Tour Image:</label>
            <input type="file" class="form-control-file" id="tourImage" name="tourImage" accept="image/*" required>
            <img id="preview-image" src="#" alt="Preview" style="display: none;">
        </div>
        <div class="form-group">
            <label for="tourDate">Tour Date:</label>
            <input type="date" class="form-control" id="tourDate" name="tourDate" required>
        </div>
        <div class="form-group">
            <label for="tourPrice">Tour Price:</label>
            <input type="number" class="form-control" id="tourPrice" name="tourPrice" required>
        </div>
        <div class="form-group">
            <label for="tourJourneys">Tour Journeys:</label>
            <textarea class="form-control" id="tourJourneys" name="tourJourneys" rows="3" required></textarea>
        </div>
        <div class="form-group">
            <label for="tourDescription">Tour Description:</label>
            <textarea class="form-control" id="tourDescription" name="tourDescription" rows="5" required></textarea>
        </div>
        <div class="form-group">
            <label for="category">Category:</label>
            <select class="form-control" id="category" name="category" required>
                <option value="">Select Category</option>
                <c:forEach var="category" items="${categories}">
                    <option value="${category.id}">${category.name}</option>
                </c:forEach>
            </select>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>

<script>
    function previewImage(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();
            reader.onload = function (e) {
                $('#preview-image').attr('src', e.target.result).show();
            };
            reader.readAsDataURL(input.files[0]);
        }
    }
    
    $('#tourImage').change(function() {
        previewImage(this);
    });
</script>

</body>
</html>

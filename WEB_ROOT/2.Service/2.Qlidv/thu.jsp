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

<div class="container">
    <h2 class="my-4">Edit Tour Information</h2>
    <div class="position-relative row form-group">
        <label for="images" class="col-md-3 text-md-right col-form-label">Images</label>
        <div class="col-md-9 col-xl-8">
            <ul class="text-nowrap" id="images">
                <c:forEach var="image" items="${tourImages}">
                    <li class="float-left d-inline-block mr-2 mb-2" style="position: relative; width: 32%;">
                        <form action="delete_image_action.jsp" method="post">
                            <input type="hidden" name="imageId" value="${image.id}">
                            <button type="submit" onclick="return confirm('Do you really want to delete this item?')"
                                    class="btn btn-sm btn-outline-danger border-0 position-absolute">
                                <i class="fas fa-times"></i>
                            </button>
                        </form>
                        <div style="width: 100%; height: 220px; overflow: hidden;">
                            <img src="${image.path}" alt="Image" style="width: 100%;">
                        </div>
                    </li>
                </c:forEach>
                <li class="float-left d-inline-block mr-2 mb-2" style="width: 32%;">
                    <form action="upload_image_action.jsp" method="post" enctype="multipart/form-data">
                        <div style="width: 100%; max-height: 220px; overflow: hidden;">
                            <img style="width: 100%; cursor: pointer;" class="thumbnail"
                                 data-toggle="tooltip" title="Click to add image" data-placement="bottom"
                                 src="assets/images/add-image-icon.jpg" alt="Add Image" onclick="document.getElementById('imageInput').click();">

                            <input name="image" type="file" id="imageInput" onchange="changeImg(this);"
                                   accept="image/x-png,image/gif,image/jpeg" class="image form-control-file" style="display: none;">
                            <input type="hidden" name="tourId" value="${tourId}">
                        </div>
                    </form>
                </li>
            </ul>
        </div>
    </div>
</div>

<script src="https://kit.fontawesome.com/a076d05399.js"></script>
<script>
    function changeImg(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();
            reader.onload = function (e) {
                $('.thumbnail').attr('src', e.target.result);
            };
            reader.readAsDataURL(input.files[0]);
        }
    }
</script>

</body>
</html>

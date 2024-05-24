<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Product Management</title>
     <link rel="icon" href="/Web_Travel/2.Service/resources/images/online-shopping.png">
    <link rel="icon" href="/Web_Travel/2.Service/login/assets/logo.png">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/boxicons/2.0.7/css/boxicons.min.css">
    <style>
        .center {
            text-align: center;
            font-size: 17px;
        }
        .button-style {
            border-radius: 5px;
            color: #0a4f4f;
            border: none;
            padding: 7px 10px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 18px;
            margin: 5px 3px;
            cursor: pointer;
        }
        .button-style:hover {
            box-shadow: 0px 0px 7px rgba(14, 125, 125, 0.5);
        }
        .header-row {
            background-color: #d1ecf1;
        }
        .pagination {
            justify-content: center;
        }
        .table-wrapper {
            margin-top: 20px;
        }
        .table-title h2 {
            margin: 5px 0;
        }
        .table-title .btn {
            font-size: 18px;
            margin-left: 10px;
        }
        .table-title .btn i {
            margin-right: 5px;
        }
        .row-hover:hover {
            background-color: #f2f2f2;
        }
        .deleted {
            display: none;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="table-wrapper">
        <div class="table-title">
            <div class="row" style="margin-left: 400px;">
                <div class="col-sm-6">
                    <h2 style="font-size:40px;"><b>Product List</b></h2>
                    
                </div>
                <div class="col-sm-6">
                    <a href="#addEmployeeModal" class="btn btn-success" data-toggle="modal" style="margin-left:200px;bottom:3px;"><span>+ Create</span></a>
                	
                </div>
            </div>
        </div>

        <table class="table table-bordered">
            <thead class="header-row">
                <tr>
                    <th class="center"><input type="checkbox" id="selectAll" onclick="toggleSelectAll()"></th>
                    <th class="center">ID</th>
                    <th class="center">Name Tour</th>
                    <th class="center">Image</th>
                    <th class="center">Price</th>
                    <th class="center">Date</th>
                    <th class="center">Category</th>
                    <th class="center">Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="product" items="${products}">
                    <tr class="row-hover">
                        <td style="text-align: center; vertical-align: middle;">
                            <input type="checkbox" name="selectProduct" value="${product.id}">
                        </td>
                        <td style="text-align: center; vertical-align: middle;">${product.id}</td>
                        <td style="text-align: center; vertical-align: middle;">${product.tourName}</td>
                        <td style="text-align: center; vertical-align: middle;">
                            <img src="./2.Service/resources/images/image_tour/${product.image}"
                                 alt="${product.tourName}"
                                 style="width: 250px; height: auto; display: block; margin: 0 auto;">
                        </td>
                        <td style="text-align: center; vertical-align: middle;">${product.price}</td>
                        <td style="text-align: center; vertical-align: middle;">${product.date}</td>
                        <td style="text-align: center; vertical-align: middle;">${product.categoryName}</td>
                        <td style="text-align: center; vertical-align: middle;" class="action-icons">
                            <a href="Service_Th8_DetailProductM_Servlet?id=${product.id}" class="button-style"><i class='bx bx-info-circle'></i></a>
                            <a href="Service_Th_EditC?id=${product.id}" class="button-style"><i class='bx bx-edit'></i></a>
                            <form class="d-inline" action="Service_Th6_DeleteProductM_Servlet" method="post">
                                <input type="hidden" name="id" value="${product.id}">
                                <input type="hidden" name="sellId" value="${product.sellId}">
                                <button style="border: none; background: none;"
                                        type="submit" data-toggle="tooltip" title="Delete"
                                        data-placement="bottom"
                                        onclick="return confirm('Do you really want to delete this item?')">
                                    <span class="button-style">
                                        <i class="bx bx-trash"></i>
                                        
                                    </span>
                                </button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<script>
    function toggleSelectAll() {
        const selectAllCheckbox = document.getElementById('selectAll');
        const checkboxes = document.getElementsByName('selectProduct');
        checkboxes.forEach(checkbox => {
            checkbox.checked = selectAllCheckbox.checked;
        });
    }
</script>

</body>
</html>

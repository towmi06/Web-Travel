<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="Service_Tuyen.setting_page.ContactInfoService" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="user-information.css">
    <script src="resources/js/account-information/user-information.js"></script>
    <title>Information</title>
</head>
<body>

<%
    String email = (String) session.getAttribute("email");
    ContactInfoService provider = ContactInfoService.findProviderByCredentials(email);
    session.setAttribute("provider", provider);
%>

   <!-- infor service-->
   <div class="infor-service">
        <img src="${sessionScope.service.coverPhoto}" class="cover-photo">
        <img src="${sessionScope.service.avatar}" class="avatar-infsv">
        <div class="nameinf"> 
            <h4>${provider.username}</h4>
            <h4> Bio</h4>
        </div>
        <div class="id">
            <h4> ID</h4>
            <p style="margin-left: 15%;" style="color: rgb(55, 54, 54);"> ${provider.serviceID}</p>
        </div>
        <div class="user-name">
            <h4>User Name</h4>
            <p style="margin-left: 16.5%;">${provider.username}</p>
        </div>

        <div class="email">
            <h4>Email</h4>
            <p style="margin-left: 22%;">${provider.email}</p>
        </div>

        <div class="phone-number">
            <h4>Phone Number</h4>
            <p style="margin-left: 12%;">${provider.phoneNumber}</p>
        </div>

        <div class="gender">
            <h4>Gender</h4>
            <p style="margin-left: 12%;">${provider.gioiTinh}</p>
        </div>

        <div class="bank-account">
            <h4>Thông tin ngân hàng : ${provider.thongTinNganHang}</h4>
            <h4>- Số tài khoản: ${provider.stk}</h4>
        </div>

        <div class="tax-code">
            <h4>Mã số thuế </h4>
            <p style="margin-left: 16%;">${provider.maSoThue}</p> 
        </div>

        <div class="social-link">
            <!-- Liên kết các tài khoản mạng xã hội của người dùng -->
            <p>Liên kết MXH: 
                <a href="${provider.facebook}">Facebook</a>, 
                <a href="${provider.twitter}">Twitter</a>, 
                <a href="${provider.instagram}">Instagram</a>
            </p>
        </div>
        <div class="save-btn1">
         	<button  class="save-btn" onclick="loadUserInfoEditPage()">Edit</button>
        </div>
    </div>
</body>
</html>
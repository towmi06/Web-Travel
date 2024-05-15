<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="Service_Tuyen.setting_page.ContactInfoService" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Thông tin liên hệ</title>
    <link rel="stylesheet" type="text/css" href="resources/css/contact-info.css"/> 
</head>
<body>

<%
    String email = (String) session.getAttribute("email");
    ContactInfoService provider = ContactInfoService.findProviderByCredentials(email);
    session.setAttribute("provider", provider);
%>


<div class="main-infor">
    <h2 class="title-infor">Thông tin liên hệ</h2>
    <form action="/Web_Travel/ContactInfoServiceServlet" method="post">
        <div class="contact-info">
       		<div class="info-item">
                <h4>Tài khoản:</h4>
                <input type="text" id="address-input" name="taiKhoan" value="<c:out value='${provider.taiKhoan}' />">
            </div>
            <div class="info-item">
                <h4>Địa chỉ:</h4>
                <input type="text" id="address-input" name="address" value="<c:out value='${provider.address}' />">
            </div>
            <div class="info-item">
                <h4>Email:</h4>
                <input type="email" id="email-input" name="email" value="<c:out value='${provider.email}' />">
            </div>
            <div class="info-item">
                <h4>Điện thoại:</h4>
                <input type="tel" id="phone-input" name="phone" value="<c:out value='${provider.phoneNumber}' />">
            </div>
            <div class="info-item">
                <h4>Thời gian làm việc:</h4>
                <input type="text" id="working-hours-input" name="working_hours" value="<c:out value='${provider.workingHours}' />">
            </div>
            <button type="submit" style="margin-top: 10px;" class="save-button" name="contact-info-save">Lưu</button>
            <button type="button" style="margin-top: 10px;" class="cancel-button" onclick="location.href='/Web_Travel/3.Service/index.jsp';">Hủy</button>
        </div>
    </form>
</div>
</body>
</html>

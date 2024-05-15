<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="Service_Tuyen.setting_page.ContactInfoService" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Đổi mật khẩu</title>
    <link rel="stylesheet" type="text/css" href="resources/css/social-network-link.css"/> 
</head>
<body>
    <form class="main-pass" method="post" action="/Web_Travel/changePassword">
        <h2 class="title-pass">Thay đổi mật khẩu</h2>
            <div class="input-pass" style="margin-top: 90px;">
                <h4>Mật khẩu hiện tại</h4>  
                <input name="currentPass" type="password" placeholder="Nhập mật khẩu hiện tại" class="password-input">
            </div>

            <div class="input-pass" style="margin-top: 180px;">
                <h4>Mật khẩu mới</h4>  
                <input name="newPass" type="password" placeholder="Nhập mật khẩu mới" class="password-input">
            </div>

            <div class="input-pass" style="margin-top: 270px;">
                <h4>Xác nhận mật khẩu</h4>  
                <input name="confirmPass" type="password" placeholder="Nhập mật khẩu hiện tại" class="password-input">
            </div>

            <div class="input-pass" style="margin-top: 360px;">
                <h4>Mã xác thực</h4>
                <input type="text" placeholder="Nhập mã xác thực" class="auth-input">
                <img src="resources/images/MaXacThuc.png" alt="Mã xác thực" class="auth-image">
                <button class="reload-button">Load</button>
            </div>
            
            <div class="input-pass" style="margin-top: 530px;">
                <button type="submit" class="save-button">Lưu lại</button>
                <button type="button" class="cancel-button" onclick="location.href='/Web_Travel/3.Service/index.jsp';">Hủy bỏ</button>
            </div>
    </form>
</body>
</html>
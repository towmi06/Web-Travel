<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	<!-- infor service-->
	<form class="infor-service"  method="post" action="/Web_Travel/userInfoEdit">
	    <img src="${sessionScope.service.coverPhoto}" class="cover-photo">
        <img src="${sessionScope.service.avatar}" class="avatar-infsv">
	    <div class="nameinf"> 
	        <h4>${provider.username}</h4>
	        <h4> Bio</h4>
	    </div>
	    <div class="id">
	        <h4> ID</h4>
	        <input type="text" id="serviceID" name="serviceID" value=" ${provider.sell_ID}">
	    </div>
	    <div class="user-name">
	        <h4>User Name</h4>
	        <input type="text" id="username" name="username" value=" ${provider.username}">
	    </div>
	
	    <div class="email">
	        <h4>Email</h4>
	        <input type="text" id="email" name="email" value=" ${provider.email}">
	    </div>
	
	    <div class="phone-number">
	        <h4>Phone Number</h4>
	        <input type="text" id="phoneNumber" name="phoneNumber" value=" ${provider.phoneNumber}">
	    </div>
	
	    <div class="gender">
	        <h4 class="gen-der"> Gender</h4>
	        <label for="male" style="margin-left: 115px;">Male</label>
	        <input type="radio" id="male" name="gender" value="male">
	    
	        <label for="female">Female</label>
	        <input type="radio" id="female" name="gender" value="female">
	    
	        <label for="other">Other</label>
	        <input type="radio" id="other" name="gender" value="other">
	    </div>
	
	    <div class="bank-account">
	        <h4>Thông tin ngân hàng :</h4>
	        <input type="text" id="bankInfo" name="bankInfo" value="${provider.thongTinNganHang}">
	        <h4>- Số tài khoản:</h4>
	        <input type="text" id="accountNumber" name="accountNumber" value="${provider.stk}">
	    </div>
	
	    <div class="tax-code">
	        <h4>Mã số thuế </h4>
	        <input type="text" id="taxCode" name="taxCode" value="${provider.maSoThue}">
	    </div>
	
	    <div class="social-link">
	        <p>Liên kết MXH:</p>
	        
	        <h4>Facebook : <input type="text" id="facebook" name="facebook" value="${provider.facebook}"></h4>
	        <h4>Twitter :  <input type="text" id="twitter" name="twitter" value="${provider.twitter}"></h4>
	        <h4 style="margin-top: -90px; margin-left: 400px;">Instagram : <input type="text" id="instagram" name="instagram" value="${provider.instagram}"></h4>
	    </div>
	    <div class="save-btn1" style="margin-top: -10px; margin-left: -400px;">
	        <button id="save-button" class="save-btn" onclick="saveChanges()">Save</button>
	    </div>
	</form>
</body>
</html>
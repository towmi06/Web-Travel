<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Trợ Giúp</title>
    <!--JS-->
    <script src="resources/js/core.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <script src="https://unpkg.com/leaflet/dist/leaflet.js"></script>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto&display=swap">
    <!--Style CSS-->
    <link rel="stylesheet" type="text/css" href="resources/css/support-management.css"/> 
    <link rel="stylesheet" type="text/css" href="resources/css/dark_mode.css"/> 
    <link rel="stylesheet" href="https://unpkg.com/leaflet/dist/leaflet.css"/>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto&display=swap">
</head>
<body>
    <!--Main container-->
    <div class="main-container">
        <div class="help">
            <h2>Câu Hỏi Phổ Biến</h2>
            <div class="faq">
                <c:forEach var="help" items="${sessionScope.helpList}">
                    <div class="question">
                        <h3>Câu hỏi ${help.idCauHoi}: ${help.cauHoi}</h3>
                    </div>
                    <div class="answer">
                        <p>${help.cauTraLoi}</p>
                    </div>
                </c:forEach>
            </div>

            <form class="action-buttons" method="post" action="/Web_Travel/HelpServlet">
            	ID Câu Hỏi: <input type='text' name='idCauHoi' value=''><br>
				Câu Hỏi: <input type='text' name='cauHoi' value=''><br>
				Câu Trả Lời: <input type='text' name='cauTraloi' value=''><br>
				<input class="add-button" type="submit" value='Lưu Câu Hỏi' name='btnSave'/>
				<input class="edit-button" type="submit" value='Sửa Câu Hỏi' name='btnChange'/>
				<input class="delete-button" type="submit" value='Xóa Câu Hỏi' name='btnDelete'/>
            </form>
        </div>
    </div>	
    <!--End main container-->
</body>
</html>
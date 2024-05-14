<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="setting_page.PageLayout" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bố cục trang dịch vụ</title>
    <link rel="stylesheet" type="text/css" href="resources/css/page-layout.css"/>
    <script src="resources/js/settings-page/page-layout.js"></script>
</head>
<body>
	<%
	    String email = (String) session.getAttribute("email");
	    PageLayout pageLayout = PageLayout.findByTaiKhoan(email);
	    session.setAttribute("pageLayout", pageLayout);
	%>
	
	<div class="main-container">
	
	</div>
	<!--header-->
	<div class="header-layout">
	    <div class="title-layout">
	        <h4>Chỉnh sửa bố cục</h4>
	    </div>
	</div>
	
	<!--main-->
	<!--left-main-->
	<div id="leftMain" class="left-main">
	    <iframe src="shop.html" frameborder="0" width="100%" height="100%"></iframe>
	</div>
	
	<!--right-main-->
	<div class="right-bar"> 
	    <form class="menu" action="/Web_Travel/PageLayoutSevlet" method="post">
	        <ul>
	            <li class="drop-down">
	                <a onclick="toggleSubMenu('submenu1')" class="drop-down-toggle">
	                    1. Sắp xếp sản phẩm
	                </a>
	                <ul class="submenu1" id="submenu1">
	                    <li>
	                        <input class="checkbox-custom" type="checkbox" name="allowSorting" <% if(pageLayout.getSapXep()) out.print("checked"); %> >
	                        <a for="allowSorting" class="label-custom">Cho phép người mua sắp xếp sản phẩm ?</a>
	                    </li>
	                </ul>
	            </li>
	
	            <li class="drop-down">
	                <a onclick="toggleSubMenu('submenu2')" class="drop-down-toggle">
	                    2. Tùy chỉnh dịch vụ
	                </a>
	                <ul class="submenu1" id="submenu2">
	                    <li>
	                        <input class="checkbox-custom" type="checkbox" name="hideService" <% if(pageLayout.getDichVuNoiBat()) out.print("checked"); %> >
	                        <a for="hideService" class="label-custom">Ẩn dịch vụ nổi bật ?</a>
	                    </li>
	                    <li>
	                        <input class="checkbox-custom" type="checkbox" name="hidePromotion" <% if(pageLayout.getChuongTrinhKhuyenMai()) out.print("checked"); %> >
	                        <a for="hidePromotion" class="label-custom">Ẩn chương trình khuyến mãi ?</a>
	                    </li>
	                </ul>
	            </li>
	
	            <li class="drop-down">
	                <a onclick="toggleSubMenu('submenu3')" class="drop-down-toggle">
	                    3. Phân trang
	                </a>
	                <ul class="submenu1" id="submenu3">
	                    <li>
	                        <a href="#" class="page-option-label">Số sản phẩm hiển thị ở mỗi trang :</a>
	                        <select name="productPerPage" class="select-custom">
	                            <option value="3" <% if (pageLayout.getSoSanPhamMoiTrang() == 3) out.print("selected"); %> >3</option>
	                            <option value="6" <% if (pageLayout.getSoSanPhamMoiTrang() == 6) out.print("selected"); %> >6</option>
	                            <option value="9" <% if (pageLayout.getSoSanPhamMoiTrang() == 9) out.print("selected"); %> >9</option>
	                            <option value="12" <% if (pageLayout.getSoSanPhamMoiTrang() == 12) out.print("selected"); %> >12</option>
	                        </select>
	                    </li>
	                </ul>
	            </li>
	            <!-- Thêm div chứa nút Lưu và Thoát -->
	            <div class="button-group">
	                <button type="submit" class="save-button">Lưu</button>
	                <button type="button" class="exit-button" onclick="location.href='/Web_Travel/3.Service/index.jsp';">Thoát</button>
	            </div>
	        </ul>
	    </form>
	</div>    
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="entity.Service_Tuyen2_PageLayout" %>
<%@ page import="entity.Service_Tuyen1_OutStanding" %>
<%@ page import="loadDAO.Service_Tuyen2_PageLayout_DAO" %>
<%@ page import="loadDAO.Service_Tuyen1_OutStanding_DAO" %>
<!DOCTYPE html>
<html lang="en"> 

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Du lịch Việt</title>
    <link rel="icon" href="resources/images/logo.png">
    <link rel="stylesheet" type="text/css" href="resources/css/shop.css">
    <link rel="stylesheet" href="https://unpkg.com/boxicons@latest/css/boxicons.min.css">
</head>

<body>

	<%
		String email = (String) session.getAttribute("email");
		Service_Tuyen2_PageLayout pageLayout = Service_Tuyen2_PageLayout_DAO.findByTaiKhoan(email);
			    
		String sell_ID = (String) session.getAttribute("sell_ID");
		List<Service_Tuyen1_OutStanding> danhSach = Service_Tuyen1_OutStanding_DAO.getOutstandingServices(sell_ID);
		
		session.setAttribute("danhSach", danhSach);    
		session.setAttribute("pageLayout", pageLayout);
	%>

    <!-- Header -->
    <div class="content" id="home">
        <nav>
        	<img src="resources/images/logo.png" class="logo" alt="Logo" title="Du lịch Việt">
            <ul class="navbar">
                <li>
                    <a href="#home">Trang chủ</a>
                    <a href="#locations">Địa điểm</a>
                    <a href="#package">Gói dịch vụ</a>
                    <div class="dropdown" id="dropdown">
                        <a href="javascript:void(0);" class="dropbtn">Tiện ích</a>
                        <div class="dropdown-content" id="dropdown-content">
                            <a href="#home">Thanh toán</a>
                            <a href="#locations">Địa điểm hot</a>
                            <a href="#blog">Blog</a>
                            <a href="./package.html">Điều khoản sử dụng</a>
                            <a href="./contact.html">Các dịch vụ hot</a>
                            <a href="./partnership.html">Hợp tác với chúng tôi</a>
                            <a href="./affiliate.html">Tuyển dụng </a>
                        </div>
                        <script src="resources/js/dropdowns.js"></script>
                    </div>
                    <a href="jsp_user/about.html" style="margin-right: 170px;">Liên hệ</a>
                </li>
            </ul>
                
            </ul>
            <div class="language-selector" >
                <div class="flag-container">
                    <img src="resources/images/flagvn.jpg" alt="Selected Flag" class="selected-flag">
                </div>
                <select class="language_drop" name="countries" id="countries" style="width:50px;">
                    <option value="yu" data-imagecss="resources/images/flagvn.jpg" data-title="Việt Nam">VN</option>   
                    <option value="yt" data-imagecss="resources/images/flag-1.jpg" data-title="English">ENG</option>
                </select>
            </div>
            <script src="resources/js/language.js"></script>
                
            <!-- Biểu tượng thông báo -->
            <a href="#" class="notification-link">
                    <input type="text" id="notification-input" class="notification-input">
                    <i class='bx bx-bell' style='color:#fd5bbd' ></i>
                    <label for="notification-input" class="notification-label">Thông báo </label>         
            </a>            
         	         
          	<!-- Thêm phần đăng nhập và đăng kí -->
         	<div class="user-actions">
            	<!-- Đăng nhập và đăng kí -->
            	 <a href="index.jsp" class="login-link"><i class='bx bx-user' style=" width:20px"  ></i></i>Trang quản lý</a>
        	</div>
        </nav>
     </div>
	 <!-- chat-->
    <div class="chat-widget">
        <div class="chat-logo">
            <a href="${sessionScope.service.message}" target="_blank">
                <img src="resources/images/logo_chat.png" alt="Chat Logo">
            </a>
        </div>
    </div>
    <!-- services -->
    <section class="contact-info-main">
        <div class="supplier-content">
            <img src="resources/images/Dốc_Thẩm_Mã_2022_-_NKS.jpg" class="cover-photo">
            <img src="${sessionScope.service.avatar}" class="avt">
            <h2 class="name">${sessionScope.service.username}</h2>
            <h4 class="status">Online</h4>

            <div class="bettwen-row">
                <div class="betwwen-col">
                    <button class="betwwen-button">
                        <img src="resources/images/followers.png" class="icon">
                        <h4>Số người theo dõi: </h4>
                        <h4 style="color: rgb(214, 110, 62);">1k</h4>
                    </button>

                    <button class="betwwen-button">
                        <img src="resources/images/product.png" class="icon">
                        <h4>Số sản phẩm: </h4>
                        <h4 style="color: rgb(214, 110, 62);">10</h4>
                    </button>

                    <button class="betwwen-button">
                        <img src="resources/images/rating.png" class="icon">
                        <h4>Đánh giá: </h4>
                        <h4 style="color: rgb(214, 110, 62);">4.9/5 (7tr đánh giá)</h4>
                    </button>
                </div>

                <div class="betwwen-col">
                    <button class="betwwen-button">
                        <img src="resources/images/call.png" class="icon">
                        <h4>Số điện thoại: </h4>
                        <h4 style="color: rgb(214, 110, 62);">${sessionScope.service.phoneNumber}</h4>
                    </button>

                    <button class="betwwen-button">
                        <img src="resources/images/gmail.png" class="icon">
                        <h4>Gmail: </h4>
                        <h4 style="color: rgb(214, 110, 62);">${sessionScope.service.email}</h4>
                    </button>

                    <button class="betwwen-button">
                        <img src="resources/images/address.png" class="icon">
                        <h4>Địa chỉ: </h4>
                        <h4 style="color: rgb(214, 110, 62);">${sessionScope.service.address}</h4>
                    </button>
                </div>
            </div>
        </div>
    </section>
    <!-- services -->

    <!-- Locations -->

    <%
    	if (pageLayout.getDichVuNoiBat()) {
	%>
	    <section class="locations" id="locations" style="display: block;">
	<%
	    } else {
	%>
	    <section class="locations" id="locations" style="display: none;">
	<%
	    }
	%>
        <div class="package-title">
            <h2>Dịch vụ nổi bật</h2>
        </div>
        <div class="location-content">
            <div class="slider">
            <%
            	int count = 0;
            	for (Service_Tuyen1_OutStanding service : danhSach) {
            		if(service.getOutstanding()) {
            			count++;
            %>
                <div class="slide">
                    <a href="./locations.html#kashmir" target="_blank">
                        <div class="col-content">
                            <img src="resources/images/image_tour/<%= service.getImage() %>" alt="">
                            <h5><c:out value="<%= service.getTourName() %>" /></h5>
                            <p><c:out value="<%= service.getDate() %>" /></p>
                        </div>
                    </a>
                </div>
             <%
            		}
            	}
             %>
            </div>
        </div>
        
        <!-- Navigation arrows -->
		<!-- Next and previous buttons -->
		<a class="prev" onclick="plusSlides(-1)">&#10094;</a>
		<a class="next" onclick="plusSlides(1)">&#10095;</a>
		<div class="dots" style="text-align:center">
		    <%
		        int numDots = (int) Math.ceil(count / 2.0); 
		        for (int i = 1; i <= numDots; i++) {
		    %>
		        <span class="dot" onclick="currentSlide(<%= i %>)"></span>
		    <%
		        }
		    %>
		</div>
	</section>

   	<script src="resources/js/slider1.js"></script>
    
    <!--Button tat ca dv-->
    <!-- Nút chuyển đến trang Tất cả dịch vụ 
        <button onclick="window.location.href='./tat-ca-dich-vu.html'">Tất cả dịch vụ</button>-->
        <div class="view-all-services">
            <a href="link_to_all_services_page"> Xem thêm   →</a>
        </div>

    <!-- Packages -->
    <%
    	if (pageLayout.getChuongTrinhKhuyenMai()) {
	%>
	    <section style="display: block;">
	<%
	    } else {
	%>
	    <section style="display: none;">
	<%
	    }
	%>
        <div class="package-title">
            <h2>Siêu ưu đãi dành cho khách hàng hội viên </h2>
        </div>

        <div class="package-content">

            <div class="box">
                <div class="image">
                    <img src="resources/images/p1.jpg" alt="">
                    <h3>🏷️sale 10%-</h3>
                </div>

                <div class="dest-content">
                    <div class="location">
                        <h4>Bronze</h4>
                        <ul class="pac-details">
                            <li>🏨Khách sạn ⭐⭐⭐</li>
                            <li>📹Gói chụp 10 tấm ảnh miễn phí </li>
                            <li>🤵🏻Hướng dẫn viên </li>
                            <li>🎧Hỗ trợ 24/7 </li>
                        </ul>
                    </div>
                </div>
            </div>

            <div class="box">
                <div class="image">
                    <img src="resources/images/p2.jpg" alt="">
                    <h3>🏷️sale 15%-</h3>
                </div>

                <div class="dest-content">
                    <div class="location">
                        <h4>Silver</h4>
                        <ul class="pac-details">
                            <li>🏨Khách sạn ⭐⭐⭐</li>
                            <li>📹Ekip chụp ảnh miễn phí không giới hạn</li>
                            <li>🤵🏻Hướng dẫn viên </li>
                            <li>🎧Hỗ trợ 24/7 </li>
                        </ul>
                    </div>
                </div>
            </div>

            <div class="box">
                <div class="image">
                    <img src="resources/images/p3.jpg" alt="">
                    <h3>🏷️sale 22%-</h3>
                </div>

                <div class="dest-content">
                    <div class="location">
                        <h4>Gold</h4>
                        <ul class="pac-details">
                            <li>🏨Khách sạn ⭐⭐⭐⭐</li>
                            <li>🥗Được chuẩn bị sẵn bữa sáng và tối</li>
                            <li>📹Ekip chụp ảnh miễn phí không giới hạn</li>
                            <li>🤵🏻Hướng dẫn viên </li>
                            <li>🎧Hỗ trợ 24/7 </li>
                        </ul>
                    </div>
                </div>
            </div>

            <div class="box">
                <div class="image">
                    <img src="resources/images/p4.jpg" alt="">
                    <h3>🏷️sale 26%-</h3>
                </div>

                <div class="dest-content">
                    <div class="location">
                        <h4>Platinum</h4>
                        <ul class="pac-details">
                            <li>🏨Khách sạn ⭐⭐⭐⭐⭐</li>
                            <li>🥗Được chuẩn bị sẵn 3 bữa</li>
                            <li>📹Ekip chụp ảnh miễn phí không giới hạn</li>
                            <li>🛫Phương tiện hạng bussiness</li>
                            <li>🤵🏻Hướng dẫn viên </li>
                            <li>🎧Hỗ trợ 24/7 </li>
                        </ul> 
                    </div>
                </div>
            </div>
        </div>
    </section>
    
    <%
    	if (pageLayout.getHienThi()) {
	%>
	    <section class="locations" id="locations" style="display: block;">
	<%
	    } else {
	%>
	    <section class="locations" id="locations" style="display: none;">
	<%
	    }
	%>
        <div class="package-title">
            <h2>Dịch vụ nổi bật</h2>
        </div>
        <div class="location-content">
            <div class="slider">
            <%
            	int count2 = 0;
            	for (Service_Tuyen1_OutStanding service : danhSach) {
            		if(service.getOutstanding()) {
            %>
                <div class="slide">
                    <a href="./locations.html#kashmir" target="_blank">
                        <div class="col-content">
                            <img src="resources/images/image_tour/<%= service.getImage() %>" alt="">
                            <h5><c:out value="<%= service.getTourName() %>" /></h5>
                            <p><c:out value="<%= service.getDate() %>" /></p>
                        </div>
                    </a>
                </div>
             <%
            		}
            	}
             %>
            </div>
        </div>
        
        <!-- Navigation arrows -->
		<!-- Next and previous buttons -->
		<a class="prev" onclick="plusSlides(-1)">&#10094;</a>
		<a class="next" onclick="plusSlides(1)">&#10095;</a>
		<div class="dots" style="text-align:center">
		    <%
		        int numDots2 = (int) Math.ceil(count2 / 2.0); 
		        for (int i = 1; i <= numDots2; i++) {
		    %>
		        <span class="dot" onclick="currentSlide(<%= i %>)"></span>
		    <%
		        }
		    %>
		</div>
	</section>


    <!-- Newsletter -->

    <section class="newsletter">
        <div class="newstext">
            <h2>Newsletter</h2>
            <p>Subscribe to get offers and latest<br>updates every week!</p>
        </div>

        <div class="send">
            <form action="">
                <input type="email" name="emailid" placeholder="E-mail" required>
                <input type="submit" value="Subscribe">
            </form>
        </div>

    </section>
    
    <!-- Footer -->

    <section class="footer">
        <div class="foot">
            <img src="resources/images/logo.png" style="margin-top: 50px; margin-left: 70px;max-width: 10%; height:auto;">
            
            <div class="footer-content">
                <div class="intro" style="margin-top: 70px;
                    font-size:18px;color:rgb(226, 222, 222) ;
                    max-width: 350px; margin-left:10px;
                    font-family:  sans-serif; font-weight: 400; line-height: 2; display:'block'">
                    <p>Chúng tôi chuyên cung cấp các dịch vụ du lịch chất lượng, đảm 
                        bảo mang lại trải nghiệm du lịch tuyệt vời cho tất cả du khách. 
                        Hãy đồng hành cùng DuLichViet khám phá những điểm đến độc đáo và hấp dẫn
                        nhất của Việt Nam.
                    </p>
                </div>
            <div class="footlinks">
                    <h4>Giới thiệu</h4>
                    <ul>
                        <li><a href="./register.html">Đăng kí </a></li>
                        <li><a href="./about.html">Về chúng tôi</a></li>
                       
                        <li><a href="./contact.html">Điều khoản sử dụng</a></li>
                        <li><a href="./contact.html">Chính sách quyền riêng tư</a></li>
                        <li><a href="./contact.html">Liên hệ</a></li>
                    </ul>
                </div>

                <div class="footlinks">
                    <h4>Connect</h4>
                    <div class="social">
                        <a href="https://www.facebook.com" target="_blank"><i
                                class='bx bxl-facebook'></i></a>
                        <a href="https://www.instagram.com" target="_blank"><i
                                class='bx bxl-instagram'></i></a>
                        <a href="https://www.twitter.com" target="_blank"><i
                                class='bx bxl-twitter'></i></a>
                        <a href="https://www.linkedin.com" target="_blank"><i
                                class='bx bxl-linkedin'></i></a>
                        <a href="https://www.youtube.com" target="_blank"><i class='bx bxl-youtube'></i></a>
                        <a href="https://www.github.com" target="_blank"><i class='bx bxl-github'></i></a>
                    </div>
                    <br>
                    <br>
                    <h4>Phương thức thanh toán</h4>
                            <img src="resources/images/pay.jpg" style = "border-radius: 15px;">
                            <!-- Thêm các biểu tượng thanh toán khác ở đây -->
                </div>

            </div>
        </div>
        <div class="end">
            <img src="resources/images/image.png"  alt="Logo" style="width:150px;float: right; margin-right:200px;margin-top:-10px">
            <p>Copyright ©2024DuLichViet. Website developed by: N5_PTIT</p>
            <br>
        </div>
        </section>
        
        </section>
</body>

</html>
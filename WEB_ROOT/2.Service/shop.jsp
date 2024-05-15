<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="Service_Tuyen.setting_page.PageLayout" %>
<%@ page import="Service_Tuyen.setting_page.OutstandingService" %>
<%@ page import="Service_Tuyen.setting_page.OutstandingServiceDAO" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Du lịch Việt</title>
    <link rel="icon" href="resources/images/logo.png">
    <link rel="stylesheet" type="text/css" href="resources/css/shop.css"/> 
    <link rel="stylesheet" href="https://unpkg.com/boxicons@latest/css/boxicons.min.css">
</head>

<body>

	<%
	    String email = (String) session.getAttribute("email");
	    PageLayout pageLayout = PageLayout.findByTaiKhoan(email);
	    
	    List<OutstandingService> danhSach = OutstandingServiceDAO.getOutstandingServices();
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
                            <script src="resources/js/dropdowns.js">                           
                            </script>
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
                 <!-- Biểu tượng giỏ hàng -->
                 <div class="cart-container">
                    <div class="cart-icon" onclick="toggleCart()">
                        <i class='bx bx-shopping-bag' style='color:#fd5bbd'></i>
                    </div>
                    <div class="cart-hover" id="cartHover">
                        <div class="select-items">
                            <br>
                            <table>1<br>
                                   2<br>
                                   3
                            </table>
                        </div>
                        <hr class="separator">
                        <div class="select-total">
                            <span class="total-label">TỔNG: </span>
                            <h5 class="total-value">$0</h5>
                        </div>
                        
                        <div class="select-button">
                            <a href="shopping-cart.html" class="primary-btn view-card">Giỏ hàng</a>
                            <a href="check-out.html" class="primary-btn checkout-btn">Thanh toán </a>
                        </div>
                        <br>
                    </div>
                        <script>
                            function toggleCart() {
                                var cartHover = document.getElementById("cartHover");
                                cartHover.style.display = cartHover.style.display === "block" ? "none" : "block";
                            }
                            
                        </script>
                        
                </div>
                
                
                <!-- Thêm phần đăng nhập và đăng kí -->
                <div class="user-actions">
                    <!-- Đăng nhập và đăng kí -->
                    <a href="./login.html" class="login-link"><i class='bx bx-user' style=" width:20px"  ></i></i>Đăng nhập</a>
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
                        <h4 style="color: rgb(214, 110, 62);">1k</h4>
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
                        <h4 style="color: rgb(214, 110, 62);">0349530775</h4>
                    </button>

                    <button class="betwwen-button">
                        <img src="resources/images/gmail.png" class="icon">
                        <h4>Gmail: </h4>
                        <h4 style="color: rgb(214, 110, 62);">abc@gmail.com</h4>
                    </button>

                    <button class="betwwen-button">
                        <img src="resources/images/address.png" class="icon">
                        <h4>Địa chỉ: </h4>
                        <h4 style="color: rgb(214, 110, 62);">Hà Đông</h4>
                    </button>
                </div>
            </div>
        </div>
    </section>
    
    <!-- services -->

    <!-- Locations -->

    <section class="locations" id="locations">
        <div class="package-title">
            <h2>Tour nổi bật</h2>
        </div>
        <div class="location-content">
            <div class="slider">
                <!-- Slide 1 -->
                <div class="slide">
                    <a href="./locations.html#kashmir" target="_blank">
                        <div class="col-content">
                            <img src="resources/images/image_tour/A65.jpg" alt="">
                            <h5>Hang Heo</h5>
                            <p>Nha Trang</p>
                        </div>
                    </a>
                </div>
                <!-- Slide 2 -->
                <div class="slide">
                    <a href="./locations.html#istanbul" target="_blank">
                        <div class="col-content">
                            <img src="resources/images/image_tour/a1.jpg" alt="">
                            <h5>Bãi Sao</h5>
                            <p>Phú Quốc</p>
                        </div>
                    </a>
                </div>
                <!-- Slide 3 -->
                <div class="slide">
                    <a href="./locations.html#paris" target="_blank">
                        <div class="col-content">
                            <img src="resources/images/image_tour/a4.jpg" alt="">
                            <h5>Nhà hát Cao Văn Lầu</h5>
                            <p>Bạc Liêu</p>
                        </div>
                    </a>
                </div>
                <!-- Slide 4 -->
                <div class="slide">
                    <a href="./locations.html#bali" target="_blank">
                        <div class="col-content">
                            <img src="resources/images/image_tour/a5.jpg" alt="">
                            <h5>Chùa Vinh Tràng</h5>
                            <p>Mỹ Tho</p>
                        </div>
                    </a>
                </div>
                <!-- Slide 5 -->
                <div class="slide">
                    <a href="./locations.html#dubai" target="_blank">
                        <div class="col-content">
                            <img src="resources/images/image_tour/a8.jpg" alt="">
                            <h5>Côn Đảo</h5>
                            <p>Bà Rịa - Vũng Tàu</p>
                        </div>
                    </a>
                </div>
                <!-- Slide 6 -->
                <div class="slide">
                    <a href="./locations.html#geneva" target="_blank">
                        <div class="col-content">
                            <img src="resources/images/image_tour/a18.jpg" alt="">
                            <h5>Tháp Pô Klong Garai</h5>
                            <p>Tháp Chàm, Ninh Thuận</p>
                        </div>
                    </a>
                </div>
                <!-- Slide 7 -->
                <div class="slide">
                    <a href="./locations.html#port-blair" target="_blank">
                        <div class="col-content">
                            <img src="resources/images/image_tour/a57.jpg" alt="">
                            <h5>Bà Nà Hill</h5>
                            <p>Đà Nẵng</p>
                        </div>
                    </a>
                </div>
                <!-- Slide 8 -->
                <div class="slide">
                    <a href="./locations.html#rome" target="_blank">
                        <div class="col-content">
                            <img src="resources/images/image_tour/a41.jpg" alt="">
                            <h5>Đồng Văn</h5>
                            <p>Hà Giang</p>
                        </div>
                    </a>
                </div>
                <!-- Add more slides here if needed -->
            </div>
        </div>
        <!-- Navigation arrows -->
 <!-- Next and previous buttons -->
 <a class="prev" onclick="plusSlides(-1)">&#10094;</a>
 <a class="next" onclick="plusSlides(1)">&#10095;</a>
</div>
    <!-- Pagination dots -->
    <div class="dots" style="text-align:center">
        <span class="dot" onclick="currentSlide(1)"></span>
        <span class="dot" onclick="currentSlide(2)"></span>
        <span class="dot" onclick="currentSlide(3)"></span>
        <span class="dot" onclick="currentSlide(4)"></span>
        <!-- Add more dots here if needed -->
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

    <!-- Newsletter -->

    
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
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<!DOCTYPE html>
<html lang="en">
<!DOCTYPE html>
<html lang="en">

<!DOCTYPE html>
<html lang="en">

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Du lịch Việt</title>
    <link rel="icon" href="ima/logo.png">
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <link rel="stylesheet" href="https://unpkg.com/boxicons@latest/css/boxicons.min.css">
</head>

<body>

    <!-- Background Video & Header -->
    <div class="banner">
        <video src="./ima/video_web.mp4" type="video/mp4" autoplay muted loop></video>

        <!-- Header -->
        <div class="content" id="home">
            <nav>
      <style>
        /* Hover */
        .navbar a:hover {
            color: rgb(14 109 109);
            box-shadow: 0 0 10px rgba(138, 136, 136, 0.5);
        }

        nav {
            width: 100%;
            height: 70px;
            position: fixed;
            background-color: rgb(254, 254, 254);
            box-shadow: 5px 5px 30px rgba(0, 0, 0, 15%);
            display: flex;
            align-items: center;
            justify-content: space-between;
        }

        nav ul {
            margin-right: 2vh;
        }

        nav .logo {
            width: 70px;
            margin: 2vh;
            margin-left: 4%;
        }

        nav ul li {
            list-style: none;
            display: inline-block;
            margin-left: 15px;
        }

        .navbar {
            text-align: center; /* Căn giữa các phần tử bên trong .navbar */
            justify-content: space-around;
        }

        .navbar li {
            display: inline-block; /* Hiển thị các phần tử liên kết cùng một dòng */
        }

        .navbar a {
            margin-right: 20px; /* Khoảng cách giữa các liên kết */
            /*Màu Chữ tiêu đề */
            color: rgb(0, 0, 0);
            font-size: 18px;
            padding: 10px 22px;
            border-radius: 5px;
            font-weight: 550; /* Tăng độ đậm của chữ */
            text-decoration: none;
            transition: ease 0.4s;
        }

        /* Active */
        .navbar a.active {
            background: rgb(255, 255, 255); /* Màu nền khi active */
            color: rgb(255, 254, 254); /* Màu chữ khi active */
            box-shadow: 5px 10px 30px rgba(85, 85, 85, 0.2); /* Bóng đổ khi active */
            border-radius: 5px; /* Bo góc */
        }

        nav ul li a {
            text-decoration: none;
            color: rgb(255, 255, 255);
            font-size: 17px;
        }
    </style>
                <img src="ima/logo.png" class="logo" alt="Logo" title="Du lịch Việt">
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
                            <script src="src/dropdowns.js">       </script>
                        </div>
                        <a href="about.html" style="margin-right: 170px;">Liên hệ</a>
                    </li>
                </ul>

                </ul>
                <div class="language-selector">
                    <div class="flag-container">
                        <img src="./ima/flagvn.jpg" alt="Selected Flag" class="selected-flag">
                    </div>
                    <select class="language_drop" name="countries" id="countries" style="width:50px;">
                        <option value="yu" data-imagecss="./ima/flagvn.jpg" data-title="Việt Nam">VN</option>
                        <option value="yt" data-imagecss="./ima/flag-1.jpg" data-title="English">ENG</option>
                    </select>
                </div>
                <script src="src/language.js"></script>
                <!-- Biểu tượng thông báo -->
                <a href="#" class="notification-link">
                    <input type="text" id="notification-input" class="notification-input">
                    <i class='bx bx-bell' style='color:#0a4f4f'></i>
                    <label for="notification-input" class="notification-label">Thông báo </label>

                </a>
                <!-- Biểu tượng giỏ hàng -->
                <div class="cart-container">
                    <div class="cart-icon" onclick="toggleCart()">
                        <i class='bx bx-shopping-bag' style='color:#0a4f4f'></i>
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
                            <a href="shopping-cart.html" class="primary-btn view-card" style='background-color:#0a4f4f;'>Giỏ hàng</a>
                            <a href="check-out.html" class="primary-btn checkout-btn" style='background-color:#0a4f4f'>Thanh toán </a>
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
                   <a href="<%= request.getContextPath() %>/3.Admin/login/index.jsp" class="login-link"><i class='bx bx-user' style=" width:20px"></i>Đăng nhập</a>

                </div>

                <!-- Thanh dropdown cho các tiện ích 
                
                <div class="dropdown" id="dropdown-menu">
                    <div class="dropdown-toggle" onclick="toggleDropdown()"></div>
                    <div class="dropdown-content" id="dropdown-content">
                        <a href="#home">Trang chủ</a>
                        <a href="#locations">Địa điểm</a>
                        <a href="#package">Gói dịch vụ</a>
                        <a href="contact.html">Liên hệ chúng tôi</a>
                        <a href="partnership.html">Hợp tác với chúng tôi</a>
                        <a href="affiliate.html">Trở thành đối tác liên kết</a>
                    </div>
                </div>

                <script src="src/dropdowns.js"></script>-->

                <!-- chat-->
                <div class="chat-widget">
                    <div class="chat-logo" onclick="toggleChat()">
                        <img src="./ima/logo_chat.png" alt="Chat Logo">
                    </div>
                    <div class="chat-box hidden">
                        <!-- Nội dung của hộp chat -->
                        Du lịch Việt xin trân trọng được phục vụ quý khách!
                    </div>
                </div>
                <script src="src/chatcs.js"></script>
                <script>
                    // Lấy ra logo chat
                    const chatLogo = document.getElementById('chat-logo');
                    // Gán sự kiện click vào logo chat
                    chatLogo.addEventListener('click', function () {
                        // Gọi hàm từ file chatcs.js khi được kích hoạt
                        toggleChat();
                    });
                </script>
            </nav>
            <div class="title">
                <h1>DU LỊCH VIỆT</h1>
                <p>Cùng DuLichViet khám phá và tận hưởng trải nghiệm du lịch Việt Nam với những gói Tour hấp dẫn và hàng
                    ngàn ưu đãi!
                </p>
                <a href="register.html" class="button">Đăng kí ngay</a>
            </div>
        </div>
    </div>
    <!-- services -->
    <section class="container">
        <div class="services-wrapper">
            <div class="border">
                <div class="services">
                    <div class="text">
                        <h2>Bạn đang muốn tìm địa điểm du lịch?</h2>
                        <p>Hơn 50 địa điểm du dịch và dịch vụ giá tốt đang chờ bạn...</p>
                    </div>

                    <div class="flex gap-20 dropdown-search">
                        <!-- Tên địa điểm -->
                        <div class="dropdown-item">
                            <div class="input-with-icon">
                                <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"
                                    fill="none">
                                    <path
                                        d="M11 6C13.7614 6 16 8.23858 16 11M16.6588 16.6549L21 21M19 11C19 15.4183 15.4183 19 11 19C6.58172 19 3 15.4183 3 11C3 6.58172 6.58172 3 11 3C15.4183 3 19 6.58172 19 11Z"
                                        stroke="black" stroke-width="2" stroke-linecap="round" stroke-linejoin="round">
                                    </path>
                                </svg>
                                <input type="text" id="location" name="location" placeholder="Nhập tên điểm đến">
                            </div>
                        </div>

                        <!-- Tất cả địa điểm -->
                        <div class="dropdown-item localtion">
                            <div class="input-with-icon">
                                <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"
                                    fill="none" stroke="black" stroke-width="2" stroke-linecap="round"
                                    stroke-linejoin="round" class="icon">
                                    <path
                                        d="M5.7 15C4.03377 15.6353 3 16.5205 3 17.4997C3 19.4329 7.02944 21 12 21C16.9706 21 21 19.4329 21 17.4997C21 16.5205 19.9662 15.6353 18.3 15M12 9H12.01M18 9C18 13.0637 13.5 15 12 18C10.5 15 6 13.0637 6 9C6 5.68629 8.68629 3 12 3C15.3137 3 18 5.68629 18 9ZM13 9C13 9.55228 12.5523 10 12 10C11.4477 10 11 9.55228 11 9C11 8.44772 11.4477 8 12 8C12.5523 8 13 8.44772 13 9Z"
                                        stroke="black" stroke-width="2" stroke-linecap="round" stroke-linejoin="round">
                                    </path>
                                </svg>
                                <input id="searchInput" class="p-md priceButton" type="button" value="Tất cả địa điểm">
                                <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"
                                    fill="none" stroke="black" stroke-width="2" stroke-linecap="round"
                                    stroke-linejoin="round" class="icon">
                                    <path d="M6 9L12 15L18 9" stroke="#a0aec0" stroke-width="2" stroke-linecap="round"
                                        stroke-linejoin="round"></path>
                                </svg>
                            </div>

                            <!-- Thêm menu dropdown cho các tùy chọn -->
                            <div class="dropdown-menu localtionSearch">
                                <div class="SearchBox_dropdown-item">Tất cả địa điểm</div>
                                <div class="SearchBox_dropdown-item">Tour thăm quan</div>
                                <div class="SearchBox_dropdown-item">Tour thiên nhiên</div>
                                <div class="SearchBox_dropdown-item">Tour biển</div>
                            </div>
                        </div>

                        <!-- Tất cả mức giá -->
                        <div class="dropdown-item Price">
                            <div class="input-with-icon">
                                <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"
                                    fill="none" stroke="#101828" stroke-width="2" stroke-linecap="round"
                                    stroke-linejoin="round" class="feather feather-map-pin icon">
                                    <path
                                        d="M15 10V9.91667C15 8.85812 14.1419 8 13.0833 8H11C9.89543 8 9 8.89543 9 10C9 11.1046 9.89543 12 11 12H13C14.1046 12 15 12.8954 15 14C15 15.1046 14.1046 16 13 16H10.9583C9.87678 16 9 15.1232 9 14.0417V14M12 17.5V6.5M21 12C21 16.9706 16.9706 21 12 21C7.02944 21 3 16.9706 3 12C3 7.02944 7.02944 3 12 3C16.9706 3 21 7.02944 21 12Z"
                                        stroke="#101828" stroke-width="2" stroke-linecap="round"
                                        stroke-linejoin="round">
                                    </path>
                                </svg>
                                <input id="priceInput" class="p-md priceButton" type="button" value="Tất cả mức giá">

                                <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"
                                    fill="none" stroke="black" stroke-width="2" stroke-linecap="round"
                                    stroke-linejoin="round" class="icon">
                                    <path d="M6 9L12 15L18 9" stroke="#a0aec0" stroke-width="2" stroke-linecap="round"
                                        stroke-linejoin="round"></path>
                                </svg>
                            </div>
                            <!-- Thêm menu dropdown cho các tùy chọn -->
                            <div class="dropdown-menu PriceSearch">
                                <div class="SearchBox_dropdown-item ">Tất cả mức giá</div>
                                <div class="SearchBox_dropdown-item ">Từ 1 đến 3 triệu</div>
                                <div class="SearchBox_dropdown-item ">Từ 3 đến 6 triệu</div>
                                <div class="SearchBox_dropdown-item ">Trên 6 triệu</div>
                            </div>
                            <script src="src/MenuSearch.js"></script>
                        </div>
                        <!-- Nút tìm kiếm -->
							<button type="button"
							        class="Button_button__QHarr SearchBox_submit-btn__eNdeg Button_button-normal__y4h10 Button_button-color__7QnYK">
							    <div class="label md" style="color: white;">Tìm kiếm</div>
							    
							</button>
						<!-- Thêm một đoạn mã JavaScript để kích hoạt servlet -->
							<script>
							document.addEventListener('DOMContentLoaded', function() {
							    // Lắng nghe sự kiện click trên nút tìm kiếm
							    document.getElementById('searchButton').addEventListener('click', function() {
							        // Thực hiện hành động tìm kiếm bằng cách chuyển hướng đến servlet tìm kiếm
							        window.location.href = 'login.html';
							        // href dường dẫn svl
							    });
							});

							</script>
						
                    </div>
                </div>
            </div>
        </div>

    </section>

    <section class="locations" id="locations">
        <div class="package-title">
            <h2>Địa điểm hấp dẫn nhất mùa hè này!</h2>
        </div>
        <div class="location-content">
            <div class="slider">
                <!-- Slide 1 -->
                <div class="slide">
                    <a href="./locations.html#kashmir" target="_blank">
                        <div class="col-content">
                            <img src="ima/image_tour/A65.jpg" alt="">
                            <h5>Hang Heo</h5>
                            <p>Nha Trang</p>
                        </div>
                    </a>
                </div>
                <!-- Slide 2 -->
                <div class="slide">
                    <a href="./locations.html#istanbul" target="_blank">
                        <div class="col-content">
                            <img src="./ima/image_tour/a1.jpg" alt="">
                            <h5>Bãi Sao</h5>
                            <p>Phú Quốc</p>
                        </div>
                    </a>
                </div>
                <!-- Slide 3 -->
                <div class="slide">
                    <a href="./locations.html#paris" target="_blank">
                        <div class="col-content">
                            <img src="./ima/image_tour/a4.jpg" alt="">
                            <h5>Nhà hát Cao Văn Lầu</h5>
                            <p>Bạc Liêu</p>
                        </div>
                    </a>
                </div>
                <!-- Slide 4 -->
                <div class="slide">
                    <a href="./locations.html#bali" target="_blank">
                        <div class="col-content">
                            <img src="./ima/image_tour/a5.jpg" alt="">
                            <h5>Chùa Vinh Tràng</h5>
                            <p>Mỹ Tho</p>
                        </div>
                    </a>
                </div>
                <!-- Slide 5 -->
                <div class="slide">
                    <a href="./locations.html#dubai" target="_blank">
                        <div class="col-content">
                            <img src="./ima/image_tour/a8.jpg" alt="">
                            <h5>Côn Đảo</h5>
                            <p>Bà Rịa - Vũng Tàu</p>
                        </div>
                    </a>
                </div>
                <!-- Slide 6 -->
                <div class="slide">
                    <a href="./locations.html#geneva" target="_blank">
                        <div class="col-content">
                            <img src="./ima/image_tour/a18.jpg" alt="">
                            <h5>Tháp Pô Klong Garai</h5>
                            <p>Tháp Chàm, Ninh Thuận</p>
                        </div>
                    </a>
                </div>
                <!-- Slide 7 -->
                <div class="slide">
                    <a href="./locations.html#port-blair" target="_blank">
                        <div class="col-content">
                            <img src="./ima/image_tour/A57.jpg" alt="">
                            <h5>Bà Nà Hill</h5>
                            <p>Đà Nẵng</p>
                        </div>
                    </a>
                </div>
                <!-- Slide 8 -->
                <div class="slide">
                    <a href="./locations.html#rome" target="_blank">
                        <div class="col-content">
                            <img src="./ima/image_tour/A41.jpg" alt="">
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

    <script src="src/slider1.js"></script>

	<!--Button tat ca dv-->
	<!-- Nút chuyển đến trang Tất cả dịch vụ -->
	<div class="view-all-services">
    <form action="/Web_Travel/HomeControl" method="GET" style="display: inline;">
        <a href="javascript:void(0);" onclick="this.parentElement.submit()">Xem thêm →</a>
    </form>
</div>

    <!-- Packages -->
    <div class="package-title">
        <h2>Siêu ưu đãi dành cho khách hàng hội viên </h2>
    </div>

    <div class="package-content">

        <div class="box">
            <div class="image">
                <img src="./ima/p1.jpg" alt="">
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
                <img src="./ima/p2.jpg" alt="">
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
                <img src="./ima/p3.jpg" alt="">
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
                <img src="./ima/p4.jpg" alt="">
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

    <section class="newsletter">
        <div class="newstext">
            <h2>ĐĂNG KÍ NGAY <br> NHẬN THÔNG TIN KHUYẾN MÃI</h2>
            <p>Nhập email để có cơ hội giảm 50%<br>cho chuyến đi tiếp theo của quý khách</p>
        </div>

        <div class="send">
            <form action="">
                <input type="email" name="emailid" placeholder="E-mail" required>
                <input type="submit" value="Đăng ký">
            </form>
        </div>

    </section>

    <!-- Footer -->

    <section class="footer">
        <div class="foot">
            <img src="./image/logo.png" style="margin-top: 50px; margin-left: 70px;max-width: 10%; height:auto;">

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
                        <li><a href="register.html">Đăng kí </a></li>
                        <li><a href="about.html">Về chúng tôi</a></li>

                        <li><a href="Terms of service.html">Điều khoản và dịch vụ</a></li>
                        <li><a href="Privacy.html">Chính sách quyền riêng tư</a></li>
                        <li><a href="contact.html">Liên hệ</a></li>
                    </ul>
                </div>

                <div class="footlinks">
                    <h4>Kết nối với chúng tôi</h4>
                    <div class="social">
                        <a href="https://www.facebook.com" target="_blank"><i class='bx bxl-facebook'></i></a>
                        <a href="https://www.instagram.com" target="_blank"><i class='bx bxl-instagram'></i></a>
                        <a href="https://www.twitter.com" target="_blank"><i class='bx bxl-twitter'></i></a>
                        <a href="https://www.linkedin.com" target="_blank"><i class='bx bxl-linkedin'></i></a>
                        <a href="https://www.youtube.com" target="_blank"><i class='bx bxl-youtube'></i></a>
                        <a href="https://www.github.com" target="_blank"><i class='bx bxl-github'></i></a>
                    </div>
                    <br>
                    <br>
                    <h4>Phương thức thanh toán</h4>
                    <img src="./ima/pay.jpg" style="border-radius: 15px;">
                    <!-- Thêm các biểu tượng thanh toán khác ở đây -->
                </div>

            </div>
        </div>
        <div class="end">
            <img src=".\ima\image.png" alt="Logo"
                style="width:150px;float: right; margin-right:200px;margin-top:-10px">
            <p>Copyright ©2024DuLichViet. Website developed by: N5_PTIT</p>
            <br>
        </div>
    </section>

    </section>
</body>

</html>
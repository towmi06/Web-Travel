<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Service Manager</title>
    <link rel="icon" href="resources/images/logo.png">
    <!--JS-->
    <script src="resources/js/script.js"></script>
    <!--overview--> 
    <script src="resources/js/overview/analysis-performance.js"></script>
    <script src="resources/js/overview/news.js"></script>
    <script src="resources/js/overview/revenue.js"></script>
    <!--order-management--> 
    <script src="resources/js/order-management/service-order.js"></script>
    <script src="resources/js/order-management/number-of-customer.js"></script>
    <script src="resources/js/order-management/order-status.js"></script>
    <!--service-management--> 
    <script src="resources/js/service-management/promotions.js"></script>
    <script src="resources/js/service-management/add-service.js"></script>
    <script src="resources/js/service-management/edit-service.js"></script>
    <script src="resources/js/service-management/delete-service.js"></script>
    <!--settings-page--> 
    <script src="resources/js/settings-page/contact-info.js"></script>
    <script src="resources/js/settings-page/outstanding-service.js"></script>
    <script src="resources/js/settings-page/page-layout.js"></script>
    <!--service-management--> 
    <script src="resources/js/account-information/social-network-link.js"></script>
    <script src="resources/js/account-information/user-information.js"></script>
    <!--customer-care-->
    <script src="resources/js/customer-care/support-change-cancel.js"></script>
    <!--setting-->
    <script src="resources/js/settings/change-password.js"></script>
    <!--support--> 
    <script src="resources/js/support/frequently-asked-questions.js"></script>
    <script src="resources/js/support/help.js"></script>
    <!--Other-->
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <!--Style CSS-->
    <link rel="stylesheet" type="text/css" href="resources/css/style.css"/> 
    <link rel="stylesheet" type="text/css" href="resources/css/dark_mode.css"/> 
    <link rel="stylesheet" type="text/css" href="resources/css/page-layout.css"/>
    <link rel="stylesheet" type="text/css" href="custom_calendar-main/style.css"/> 
    <link rel="stylesheet" href="resources/css/user-information.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;600&family=Roboto:wght@400;500;600,700,800" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>
    <!--Top sidebar-->
    <div class="header"> 
        <div class="header-content">
            <!--Logo and name page-->
            <div class="title">
                <a href="index.html" title="Logo">
                    <img src="resources/images/logo.png" alt="logo" class="logo">
                </a>
                <h3 id="admin">Service</h3>
            </div>

            <!--Search-->
            <div class="search">
                <input type="search" name="btnSearch" id="search" class="search-input" placeholder="Nhập ở đây">
                <img src="resources/images/search.svg" class="search-icon"></img>
            </div>

            <!--Notification-->
            <button id="notificationButton" class="notification">
                <img src="resources/images/notification.png" class="icon1">
            </button>

            <!--Avatar and username-->
            <button id="adminButton" class="admin" onclick="toggleChevron('chevronIcon')">
                <img src="resources/images/avatar.jpg" alt="Avatar" class="admin-avatar">
                <img src="resources/images/chevron-down.svg" class="chevron-icon" id="chevronIcon">
            </button>

        </div>
    </div> 
    <!--End top sidebar-->

    <!--Function Page-->
    <!--Notificatiion Page-->
    <div id="notificationPage" class="notification-page">
        <h3>Thông báo hệ thống</h3>
    </div>

    <!--Admin Page-->
    <div id="adminPage" class="admin-page">
        <div class="admin-page-avatar">
            <img src="resources/images/avatar.jpg" class="admin-avatar">
            <span class="admin-page-name">Name Service</span>
        </div>

        <a style="font-size: 17px;" class="admin-page-button" href="shop.html">
            <img src="resources/images/pngwing.com (8).png" class="icon">
            <h4>Trang Cá Nhân</h4>
        </a>

        <button style="font-size: 17px;" class="admin-page-button" onclick="loadContactList()">
            <img src="resources/images/pngwing.com (9).png" class="icon">
            <h4>Điều khoản dịch vụ</h4>
        </button>

        <a style="font-size: 17px;" class="admin-page-button" href="login/index.html">
            <img src="resources/images/sign-out.svg" class="icon">
            <h4>Đăng xuất</h4>
        </a>
    </div>


    <!--End function page-->

    <!--Left sidebar-->
    <div class="left-side-bar"> 
        <div class="sidebar-menu">
            <ul id="accordion-menu top">
                <!--Phân tích dữ liệu-->
                <li class="dropdown">
                    <button class="dropdown-toggle" onclick="toggleChevron('chevronIcon2')">
                        <img src="resources/images/analyst.png" class="icon">
                        <span>Tổng Quan</span>
                        <img src="resources/images/chevron-down.svg" class="chevron-icon" id="chevronIcon2">
                    </button>
                    <ul class="submenu">
                        <li><a href="#Phân-tích-hiệu-suất" onclick="loadAnalysisPerformance()"> Phân tích - hiệu suất</a></li>
                        <li><a href="#Tin-tức" onclick="loadNews()"> Tin tức</a></li>
                        <li><a href="#Doanh-Thu" onclick="loadRevenue()"> Doanh thu</a></li>
                    </ul>
                </li>

                <!--Quản Lý Đon Đặt Dịch Vụ-->
                <li class="dropdown">
                    <button class="dropdown-toggle" onclick="toggleChevron('chevronIcon3')">
                        <img src="resources/images/purchases.png" class="icon">
                        <span>Quản Lý Đơn Đặt Dịch Vụ</span>
                        <img src="resources/images/chevron-down.svg" class="chevron-icon" id="chevronIcon3">
                    </button>
                    <ul class="submenu">
                        <li><a href="#Số-lượng-khách-khách-hàng" onclick="loadNumberOfCustomer()"> Số Lượng Khách Hàng</a></li>
                        <li><a href="#Tình-trạng-đơn" onclick="loadOrderStatus()"> Tình Trạng Đơn</a></li>
                        <li><a href="#Đơn-đặt-dịch-vụ" onclick="loadServiceOrder()"> Đơn Đặt Dịch Vụ</a></li>
                    </ul>
                </li>

                <!--Quản lý dịch vụ-->
                <li class="dropdown">
                    <button class="dropdown-toggle" onclick="toggleChevron('chevronIcon4')">
                        <img src="resources/images/quanLyDichVu.png" class="icon">
                        <span>Quản Lý Dịch Vụ</span>
                        <img src="resources/images/chevron-down.svg" class="chevron-icon" id="chevronIcon4">
                    </button>
                    <ul class="submenu">
                        <li><a href="#Thêm-dịch-vụ" onclick="loadAddService()"> Thêm Dịch Vụ</a></li>
                        <li><a href="#Sửa-dịch-vụ" onclick="loadEditService()"> Sửa Dịch Vụ</a></li>
                        <li><a href="#Xóa-dịch-vụ" onclick="loadDeleteService()"> Xóa Dịch Vụ</a></li>
                        <li><a href="#Chương-trình-khuyến-mãi" onclick="loadPromotions()"> Chương Trình Khuyến Mãi</a></li>
                    </ul>
                </li>

                <!--Thiết lập trang-->
                <li class="dropdown">
                    <button class="dropdown-toggle" onclick="toggleChevron('chevronIcon5')">
                        <img src="resources/images/tlt.png" class="icon">
                        <span>Thiết Lập Trang</span>
                        <img src="resources/images/chevron-down.svg" class="chevron-icon" id="chevronIcon5">
                    </button>
                    <ul class="submenu">
                        <li><a href="#Giới-thiệu-dịch-vụ-dịch-vụ-nổi-bật" onclick="loadOutstandingService()"> Giới Thiệu Dịch Vụ - Dịch Vụ Nổi Bật</a></li>
                        <li><a href="#Bố-cục-trang-dịch-vụ" onclick="loadPageLayout()"> Bố Cục Trang Dịch Vụ</a></li>
                        <li><a href="#Thông-tin-liên-hệ" onclick="loadContactInfo()"> Thông Tin Liên Hệ</a></li>
                    </ul>
                </li>

                <!--Thông Tin Tài Khoản-->
                <li class="dropdown">
                    <button class="dropdown-toggle" onclick="toggleChevron('chevronIcon6')">
                        <img src="resources/images/ThongTin.png" class="icon">
                        <span>Thông Tin Tài Khoản</span>
                        <img src="resources/images/chevron-down.svg" class="chevron-icon" id="chevronIcon6">
                    </button>
                    <ul class="submenu">
                        <li><a href="#Thông-tin-người-dùng" onclick="loadUserInformation()"> Thông Tin Người Dùng</a></li>
                        <li><a href="#Liên-kết-mạng-xã-hội" onclick="loadSocialNetwork()"> Đổi Mật Khẩu</a></li>
                    </ul>
                </li>

                <!--Chăm Sóc Khách Hàng-->
                <li class="dropdown">
                    <button class="dropdown-toggle" onclick="toggleChevron('chevronIcon7')">
                        <img src="resources/images/Cskh.png" class="icon">
                        <span>Chăm Sóc Khách Hàng</span>
                        <img src="resources/images/chevron-down.svg" class="chevron-icon" id="chevronIcon7">
                    </button>
                    <ul class="submenu">
                        <li><a href="#Hỗ-trợ-đổi-hủy" onclick="loadSupportChangeCancel()"> Hỗ Trợ Đổi / Hủy</a></li>
                        <li><a href="message2.html"  onclick="loadChat()"> Chat Tư Vấn</a></li>
                    </ul>
                </li>

                 <!--Setting-->
                 <li class="dropdown" style="margin-top: 80px;">
                    <button id="settingButton" class="dropdown-toggle" onclick="toggleChevron('chevronIcon8')">
                        <img src="resources/images/setting.svg" class="icon">
                        <span>Cài Đặt</span>
                        <img src="resources/images/chevron-down.svg" class="chevron-icon" id="chevronIcon8">
                    </button>
                    <ul class="submenu">
                        <li><a href="#chế-độ-tối" onclick="toggleDarkMode()"> Chế độ tối</a></li>
                        <li><a href="#ngôn-ngữ" onclick="toggleLanguage()"> Ngôn Ngữ</a></li>
                    </ul>
                </li>
                <!--Hỗ trợ-->
                <li class="dropdown">
                    <button class="dropdown-toggle" onclick="toggleChevron('chevronIcon9')">
                        <img src="resources/images/question.png" class="icon2" >
                        <span style="margin-left: 5px;">Hỗ Trợ</span>
                        <img src="resources/images/chevron-down.svg" class="chevron-icon" id="chevronIcon9">
                    </button>
                    <ul class="submenu">
                        <li><a href="#Câu-hỏi-thường-gặp" onclick="loadFrequentlyAskedQuestions()"> Câu Hỏi Thường Gặp</a></li>
                        <li><a href="#Trợ-giúp" onclick="loadHelp()"> Trợ Giúp</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>  
    <!--End top sidebar-->

    <!--Main container-->
    <div id="mainContent" class="main-container">
        <div class="dashboard">
            <h1>Dashboard</h1>
            <div class="url">
                <h3>Dashboard ></h3>
                <a href="index.html">Home</a>
            </div>
        </div>

        <!--overview-->
        <div class="overview">
            <div class="view">
                <div class="img">
                    <img src="resources/images/order.png" class="icon3">
                </div>
                <h2 class="quanity">1020</h2>
                <h2 class="title2">Đơn hàng mới</h2>
            </div>

            <div class="view">
                <div class="img2">
                    <img src="resources/images/visitors.png" class="icon3">
                </div>
                <h2 class="quanity">2834</h2>
                <h2 class="title2">Số lượng khách</h2>
            </div>

            <div class="view">
                <div class="img3">
                    <img src="resources/images/totalSales.png" class="icon3">
                </div>
                <h2 class="quanity">$2543</h2>
                <h2 class="title2">Tổng doanh thu</h2>
            </div>
        </div>

	<!-- trang quan ly don hang -->
	<div class="table-data">
        <div class="order">
            <div class="head">
                <h3>Recent Orders</h3>
                <i class='bx bx-search' ></i>
                <i class='bx bx-filter' ></i>
            </div>
            <table>
                <thead>
                    <tr>
                        <th>User</th>
                        <th>Date Order</th>
                        <th>Status</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>
                            <div class="username">
                                <img src="resources/images/people.png">
                                <p>John Doe</p>
                            </div>
                        </td>
                        <td>01-10-2021</td>
                        <td><span class="status completed">Completed</span></td>
                    </tr>
                    <tr>
                        <td>
                            <div class="username">
                                <img src="resources/images/people.png">
                                <p>John Doe</p>
                            </div>
                        </td>
                        <td>01-10-2021</td>
                        <td><span class="status pending">Pending</span></td>
                    </tr>
                    <tr>
                        <td>
                            <div class="username">
                                <img src="resources/images/people.png">
                                <p>John Doe</p>
                            </div>
                        </td>
                        <td>01-10-2021</td>
                        <td><span class="status process">Process</span></td>
                    </tr>
                    <tr>
                        <td>
                            <div class="username">
                                <img src="resources/images/people.png">
                                <p>John Doe</p>
                            </div>
                        </td>
                        <td>01-10-2021</td>
                        <td><span class="status pending">Pending</span></td>
                    </tr>
                    <tr>
                        <td>
                            <div class="username">
                                <img src="resources/images/people.png">
                                <p>John Doe</p>
                            </div>
                        </td>
                        <td>01-10-2021</td>
                        <td><span class="status completed">Completed</span></td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
	<!-- End recent orders -->

        <!--Chart container 1-->
        <div class="chart-container-1">
            <!--Biểu đồ cột (Bar Chart)-->
            <div class="bar-chart">
                <canvas id="barChart"></canvas>
                <div class="chart-title">Bar Chart</div>
            </div>
            <script>
                var ctx = document.getElementById('barChart').getContext('2d');
                var barChart = new Chart(ctx, {
                    type: 'bar',
                    data: {
                        labels: ['January', 'February', 'March', 'April', 'May', 'June', 'July'],
                        datasets: [{
                            label: 'Revenue1',
                            data: [1000, 2000, 1500, 2500, 1800, 2200, 3000],
                            backgroundColor: '#3A3651',
                            borderColor: 'rgba(131, 131, 131, 01)',
                            borderWidth: 1
                        }, {
                            label: 'Revenue2',
                            data: [2000, 2700, 1800, 3000, 1500, 1800, 2500],
                            backgroundColor: 'rgba(128, 128, 128, 1)',
                            borderColor: 'rgba(131, 131, 131, 1)',
                            borderWidth: 1
                        }]
                    },
                    options: {
                        scales: {
                            y: {
                                beginAtZero: true
                            }
                        }
                    }
                });
            </script>     
        </div>
    </div>
    <!--End main container-->

     <!--Right side bar-->
     <div id="rightSideBar" class="right-side-bar">
        <div class="right-side-container-chart">
            <!--Biểu đồ radar (Radar Chart)-->
            <iframe class="radar-chart" width="100%" height="360px" src="https://thoitiet.app/widget/embed/" id="widgeturl" scrolling="no" frameborder="0" allowtransparency="true" style="border:none;overflow:hidden;"></iframe>
<iframe src="https://calendar.google.com/calendar/embed?height=600&wkst=1&ctz=Asia%2FHo_Chi_Minh&bgcolor=%233a3651&showTitle=0&showPrint=0&showTz=0&showCalendars=0&src=dmkudmlldG5hbWVzZSNob2xpZGF5QGdyb3VwLnYuY2FsZW5kYXIuZ29vZ2xlLmNvbQ&color=%230B8043" style="border:solid 1px #9c9a9a" width="245" height="280" frameborder="0" scrolling="no" border-radius="30"></iframe>
        </div>
    </div>
    <!--End right side bar-->
</body> 
</html>
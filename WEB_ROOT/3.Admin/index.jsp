<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="loadDAO.Admin_Quan_Payments_DAO" %>
<%@ page import="loadDAO.Admin_Quan_TourManagenment_DAO" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Manager</title>
    <!--JS-->
    <script src="resources/js/core.js"></script>
    <!--performance-analysis-->
    <script src="resources/js/performance-analysis/number-of-service-orders.js"></script>
    <script src="resources/js/performance-analysis/number-of-services.js"></script>
    <script src="resources/js/performance-analysis/number-of-people-reached.js"></script>
    <!--account-management-->
    <script src="resources/js/account-management/number-of-new-accounts.js"></script>
    <script src="resources/js/account-management/customer-account.js"></script>
    <script src="resources/js/account-management/service-account.js"></script>
    <!--interface-management-->
    <script src="resources/js/interface-management/add-and-remove-utilities.js"></script>
    <script src="resources/js/interface-management/interface-layout.js"></script>
    <!--resource-management-->
    <script src="resources/js/resource-management/content-management.js"></script>
    <script src="resources/js/resource-management/system-management.js"></script>
    <!--financial-management-->
    <script src="resources/js/financial-management/currency-price-list.js"></script>
    <script src="resources/js/financial-management/currency-exchange-service.js"></script>
    <script src="resources/js/financial-management/revenue.js"></script>
    <!--contact-info-->
    <script src="resources/js/contact-info/contact-information-social-media-links.js"></script>
    <script src="resources/js/contact-info/cooperate.js"></script>
    <!--support-management-->
    <script src="resources/js/support-management/help.js"></script>
    <script src="resources/js/support-management/notification-mailbox.js"></script>
    <script src="resources/js/support-management/grant-access.js"></script>
    <script src="resources/js/support-management/track-manage-orders.js"></script>
    <script src="resources/js/support-management/manage-tour-information.js"></script>
    <script src="resources/js/support-management/statistics-reports.js"></script>
    <!--admin-page-->
    <script src="resources/js/admin-page/admin-profile.js"></script>
    <script src="resources/js/admin-page/contract-list.js"></script>
    <!--setting-page-->
    <script src="resources/js/setting-page/private.js"></script>
    <script src="resources/js/setting-page/setting.js"></script>
    <!--Other-->
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <script src="https://unpkg.com/leaflet/dist/leaflet.js"></script>
    <!--Style CSS-->
    <link rel="icon" href="/Web_Travel/3.Admin/login/assets/logo.png">
    <link rel="stylesheet" type="text/css" href="resources/css/core.css"/> 
    <link rel="stylesheet" type="text/css" href="resources/css/dark_mode.css"/> 
    <link rel="stylesheet" type="text/css" href="resources/css/interface-management.css"/>
    <link rel="stylesheet" href="https://unpkg.com/leaflet/dist/leaflet.css"/>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto&display=swap">
</head>
<body>
	<!-- Hiển thị thông báo nếu có -->
    <%
	    String message = (String) session.getAttribute("message");
	    if (message != null && !message.isEmpty()) {
	%>
	    <script>
	        alert("<%= message %>");
	    </script>
	<%
	        // Xóa thông điệp sau khi đã hiển thị
	        session.removeAttribute("message");
	    }
	%>
	
	<% 
        Map<String, Long> paymentMethodTotalMap = new Admin_Quan_Payments_DAO().getPaymentMethodTotal(); 
        long[] doanhThu = paymentMethodTotalMap.values().stream().mapToLong(Long::longValue).toArray();
        long[] loiNhuan = Arrays.stream(doanhThu).map(value -> (long) (value * 0.3)).toArray(); 
        long[] thue = Arrays.stream(loiNhuan).map(value -> (long) (value * 0.1)).toArray(); 
        
		Map<Integer, Integer> cateIDCount = new Admin_Quan_TourManagenment_DAO().getCateIDCount();
		long[] categories = cateIDCount.values().stream().mapToLong(Integer::longValue).toArray();
		
		Map<String, Integer> ordersCountByMonth = new Admin_Quan_TourManagenment_DAO().getOrdersCountByMonth();
		int[] orders = ordersCountByMonth.values().stream().mapToInt(Integer::intValue).toArray();
	%>
    
    <script>
	    var doanhThu = <%= Arrays.toString(doanhThu) %>;
	    var loiNhuan = <%= Arrays.toString(loiNhuan) %>;
	    var thue = <%= Arrays.toString(thue) %>;
	    
	    var categories = <%= Arrays.toString(categories) %>;
	    var orders = <%= Arrays.toString(orders) %>
    </script>

    <!--Top sidebar-->
    <div class="header"> 
        <div class="header-content">
            <!--Logo and name page-->
            <div class="title">
                <a href="index.jsp" title="Logo">
                    <img src="resources/images/logo.png" alt="logo" class="logo">
                </a>
                <h3 id="admin">Admin</h3>
            </div>

            <!--Search-->
            <div class="search">
                <input type="search" name="btnSearch" id="search" class="search-input" placeholder="Nhập ở đây">
                <img src="resources/images/search.svg" class="search-icon"></img>
            </div>

            <!--Notification-->
            <button id="notificationButton" class="notification">
                <img src="resources/images/notification.svg">
            </button>

            <!--Setting-->
            <button id="settingButton" class="setting">
                <img src="resources/images/setting.svg">
            </button>

            <!--Language-->
            <button id="languageButton" class="language">
                <img src="resources/images/VietNam.svg">
            </button>

            <!--Avatar and username-->
            <button id="adminButton" class="admin" onclick="toggleChevron('chevronIcon')">
                <img src="${sessionScope.adminInfo.avatar}" alt="Avatar" class="admin-avatar">
                <span class="admin-name">${sessionScope.adminInfo.name}</span>
                <img src="resources/images/chevron-down.svg" class="chevron-icon" id="chevronIcon">
            </button>

        </div>
    </div> 
    <!--End top sidebar-->

    <!--Function Page-->
    <!--Notification Page-->
	<div id="notificationPage" class="notification-page">
	    <h1>Thông báo hệ thống</h1>
	    <!-- Thông báo sẽ được hiển thị ở đây -->
	    <%
            List<String> allNotificationList = (List<String>) session.getAttribute("allNotificationList");
            if (allNotificationList != null && !allNotificationList.isEmpty()) {
            	for (int i = allNotificationList.size() - 1; i >= 0; i--) {
                    out.println("<p>" + allNotificationList.get(i) + "</p>");
                }
            } else {
                out.println("<p>Không có thông báo nào.</p>");
            }
        %>
	</div>

    <!--Settings Page-->
    <div id="settingsPage" class="settings-page">
        <!-- Nội dung của trang cài đặt -->
        <h2>Cài Đặt & Bảo Mật</h2>

        <button class="settings-page-button" onclick="loadSetting()">
            <img src="resources/images/tools.svg">
            <h4>Cài đặt</h4>
        </button>

        <button class="settings-page-button" onclick="loadPrivate() ">
            <img src="resources/images/shield-lock.svg">
            <h4>Riêng Tư</h4>
        </button>

        <button class="theme-toggle" onclick="toggleDarkMode()">
            <input type="checkbox" id="themeToggle">
            <label for="themeToggle">Chế độ tối</label>
        </button>
    </div>

    <!--Language Page-->
    <div id="languagePage" class="language-page" onclick="toggleLanguage()">
        <button id="switchLanguage" class="language">
            <img src="resources/images/america.svg">
        </button>
    </div>

    <!--Admin Page-->
    <div id="adminPage" class="admin-page">
        <div class="admin-page-avatar">
            <img src="${sessionScope.adminInfo.avatar}" class="admin-avatar">
            <span class="admin-page-name">${sessionScope.adminInfo.name}</span>
        </div>

        <button class="admin-page-button" onclick="loadAdminProfile()">
            <img src="resources/images/profile-admin.svg">
            <h4>Hồ Sơ Admin</h4>
        </button>

        <button class="admin-page-button" onclick="loadContactList()">
            <img src="resources/images/contract-icon.svg">
            <h4>Hợp Đồng</h4>
        </button>

        <a class="admin-page-button" href="login/index.jsp">
            <img src="resources/images/sign-out.svg">
            <h4>Đăng xuất</h4>
        </a>
    </div>
    <!--End function page-->

    <!--Left sidebar-->
    <div class="left-side-bar"> 
        <div class="sidebar-menu">
            <ul id="accordion-menu">

                <!--Phân tích hiệu suất-->
                <li class="dropdown">
                    <button class="dropdown-toggle" onclick="toggleChevron('chevronIcon2')">
                        <img src="resources/images/performance-analysis.svg">
                        <span>Phân Tích Hiệu Suất</span>
                        <img src="resources/images/chevron-down.svg" class="chevron-icon" id="chevronIcon2">
                    </button>
                    <ul class="submenu">
                        <li><a href="#Số-Lượng-Đơn-Đặt-Dịch-Vụ" onclick="loadNumberOfServiceOrdersPage()"><img src="resources/images/dash.svg"> Số Lượng Đơn Đặt Dịch Vụ</a></li>
                        <li><a href="#Số-Lượng-Dịch-Vụ-Cung-Cấp" onclick="loadNumberOfServicesPage()"><img src="resources/images/dash.svg"> Số Lượng Dịch Vụ Cung Cấp</a></li>
                        <li><a href="#Số-Lượng-Người-Tiếp-Cận" onclick="loadNumberOfPeopleReachedPage()"><img src="resources/images/dash.svg"> Số Lượng Người Tiếp Cận</a></li>
                    </ul>
                </li>

                <!--Quản lý tài khoản người dùng-->
                <li class="dropdown">
                    <button class="dropdown-toggle" onclick="toggleChevron('chevronIcon3')">
                        <img src="resources/images/manager accout.svg">
                        <span>Quản Lý Tài Khoản</span>
                        <img src="resources/images/chevron-down.svg" class="chevron-icon" id="chevronIcon3">
                    </button>
                    <ul class="submenu">
                        <li><a href="#Số-Lượng-Tài-Khoản-Mới" onclick="loadNumberOfNewAccounts()"><img src="resources/images/dash.svg"> Số Lượng Tài Khoản Mới</a></li>
                        <li><a href="#Tài-Khoản-Khách-Hàng" onclick="loadCustomerAccount()"><img src="resources/images/dash.svg"> Tài Khoản Khách Hàng</a></li>
                        <li><a href="#Tài-Khoản-Nhà-Cung-Cấp" onclick="loadServiceAccount()"><img src="resources/images/dash.svg"> Tài Khoản Nhà Cung Cấp</a></li>
                    </ul>
                </li>

                <!--Quản lý giao diện-->
                <li class="dropdown">
                    <button class="dropdown-toggle" onclick="toggleChevron('chevronIcon4')">
                        <img src="resources/images/manager-browser.svg">
                        <span>Quản Lý Giao Diện</span>
                        <img src="resources/images/chevron-down.svg" class="chevron-icon" id="chevronIcon4">
                    </button>
                    <ul class="submenu">
                        <li><a href="#Thêm-Xóa-Tiện-Ích" onclick="loadCustomUtilities()"><img src="resources/images/dash.svg"> Thêm / Xóa Tiện Ích</a></li>
                        <li><a href="#Bố-Cục-Giao-Diện" onclick="loadCustomInterFace()"><img src="resources/images/dash.svg"> Bố Cục Giao Diện</a></li>
                    </ul>
                </li>

                <!--Quản lý tài nguyên-->
                <li class="dropdown">
                    <button class="dropdown-toggle" onclick="toggleChevron('chevronIcon5')">
                        <img src="resources/images/manager-database.svg">
                        <span>Quản Lý Tài Nguyên</span>
                        <img src="resources/images/chevron-down.svg" class="chevron-icon" id="chevronIcon5">
                    </button>
                    <ul class="submenu">
                        <li><a href="#Quản-Lý-Nội-Dung" onclick="loadContentManagement()"><img src="resources/images/dash.svg"> Quản Lý Nội Dung</a></li>
                        <li><a href="#Quản-Lý-Hệ-Thống" onclick="loadSystemManagement()"><img src="resources/images/dash.svg"> Quản Lý Hệ Thống</a></li>
                    </ul>
                </li>

                <!--Quản lý tài chính-->
                <li class="dropdown">
                    <button class="dropdown-toggle" onclick="toggleChevron('chevronIcon6')">
                        <img src="resources/images/credit-card.svg">
                        <span>Quản Lý Tài Chính</span>
                        <img src="resources/images/chevron-down.svg" class="chevron-icon" id="chevronIcon6">
                    </button>
                    <ul class="submenu">
                        <li><a href="#Dịch-Vụ-Đổi-Tiền" onclick="loadCurrencyExchangeService()"><img src="resources/images/dash.svg"> Dịch Vụ Đổi Tiền</a></li>
						<c:if test="${sessionScope.adminInfo.position eq 'Admin'}">
						    <li><a href="#Doanh-Thu-Thuế" onclick="loadRevenue()"><img src="resources/images/dash.svg"> Doanh Thu / Thuế</a></li>
						</c:if>
                        <li><a href="#Bảng-Giá-Tiền-Tệ" onclick="loadCurrencyPriceList()"><img src="resources/images/dash.svg"> Bảng Giá Tiền Tệ</a></li>
                    </ul>
                </li>

                <!--Thông tin liên hệ-->
                <li class="dropdown">
                    <button class="dropdown-toggle" onclick="toggleChevron('chevronIcon7')">
                        <img src="resources/images/mail.svg">
                        <span>Thông Tin Liên Hệ</span>
                        <img src="resources/images/chevron-down.svg" class="chevron-icon" id="chevronIcon7">
                    </button>
                    <ul class="submenu">
                        <li><a href="#Thông-Tin-Liên-Hệ-Liên-Kết-Mạng-Xã-Hội" onclick="loadContactInFor()"><img src="resources/images/dash.svg"> Thông Tin Liên Hệ / Liên Kết Mạng Xã Hội</a></li>
                        <li><a href="#Hợp-Tác" onclick="loadCooperate()"><img src="resources/images/dash.svg"> Hợp Tác</a></li>
                    </ul>
                </li>

                <!--Hỗ trợ và quản lý-->
                <li class="dropdown">
                    <button class="dropdown-toggle" onclick="toggleChevron('chevronIcon8')">
                        <img src="resources/images/manager-support-.svg">
                        <span>Hỗ Trợ Và Quản Lý</span>
                        <img src="resources/images/chevron-down.svg" class="chevron-icon" id="chevronIcon8">
                    </button>
                    <ul class="submenu">
                        <li><a href="#Trợ-Giúp" onclick="loadHelp()"><img src="resources/images/dash.svg"> Trợ Giúp</a></li>
                        <li><a href="#Thông-Báo-Hòm-Thư" onclick="loadNotificationMailbox()"><img src="resources/images/dash.svg"> Thông Báo / Hòm Thư</a></li>
                        <c:if test="${sessionScope.adminInfo.position eq 'Admin'}">
                        	<li><a href="#Cấp-Quyền-Truy-Cập" onclick="loadGrantAccess()"><img src="resources/images/dash.svg"> Cấp Quyền Truy Cập</a></li>
                        </c:if>
                        <li><a href="#Theo-Dõi-Quản-Lý-Đơn" onclick="loadTrackOrders()"><img src="resources/images/dash.svg"> Theo Dõi / Quản Lý Đơn</a></li>
                        <li><a href="#Quản-Lý-Thông-Tin-Tour" onclick="loadManageTourInformation()"><img src="resources/images/dash.svg"> Quản Lý Thông Tin Tour</a></li>
                        <li><a href="#Thông-Kê-Báo-Cáo-Về-Hoạt-Động-Trang-Web" onclick="loadStatisticsReports()"><img src="resources/images/dash.svg"> Thông Kê / Báo Cáo Về Hoạt Động Trang Web</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>  
    <!--End top sidebar-->

    <!--Main container-->
    <div id="mainContent" class="main-container">
        <!--Map-->
        <div id="map" style="width: 100%; height: 200px;"></div>
        <script>
            var map = L.map('map').setView([21.0285, 105.8542], 13); // Tọa độ Hà Nội: [21.0285, 105.8542], với mức độ zoom mặc định là 13

            L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
                attribution: '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
            }).addTo(map);

            // Thêm một điểm đánh dấu tại Hà Nội
            L.marker([21.0285, 105.8542]).addTo(map)
                .bindPopup('Hà Nội')
                .openPopup();
        </script>
        <!--End map-->

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
                            backgroundColor: 'rgba(255, 99, 132, 0.2)',
                            borderColor: 'rgba(255, 99, 132, 1)',
                            borderWidth: 1
                        }, {
                            label: 'Revenue2',
                            data: [2000, 2700, 1800, 3000, 1500, 1800, 2500],
                            backgroundColor: 'rgba(54, 162, 235, 0.2)',
                            borderColor: 'rgba(54, 162, 235, 1)',
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
    
            <!--Biểu đồ bánh (Pie Chart)-->
            <div class="pie-chart">
                <canvas id="pieChart" width="200" height="200"></canvas>
                <div class="chart-title">Pie Chart</div>
            </div>
            <script>
                var ctx = document.getElementById('pieChart').getContext('2d');
                var pieChart = new Chart(ctx, {
                    type: 'pie',
                    data: {
                        labels: ['Red', 'Blue', 'Yellow'],
                        datasets: [{
                            label: 'My First Dataset',
                            data: [300, 50, 100],
                            backgroundColor: ['rgb(255, 99, 132)', 'rgb(54, 162, 235)', 'rgb(255, 205, 86)'],
                            hoverOffset: 4
                        }]
                    },
                    options: {
                        radius: 110,
                        cutout: '50%',
                    }
                });
            </script>
        </div>
        <!--End chart container 1-->

        <!--Chart-container-2-->
        <div class="chart-container-2">
            <!--Biểu đồ dòng (Line Chart)-->
            <div class="line-chart">
                <canvas id="lineChart"></canvas>
                <div class="chart-title">Line Chart</div>
            </div>
            <script>
                var ctx = document.getElementById('lineChart').getContext('2d');
                var lineChart = new Chart(ctx, {
                    type: 'line',
                    data: {
                        labels: ['January', 'February', 'March', 'April', 'May', 'June', 'July'],
                        datasets: [{
                            label: 'Revenue',
                            data: [1000, 2000, 1500, 2500, 1800, 2200, 3000],
                            fill: false,
                            borderColor: 'rgba(75, 192, 192, 1)',
                            tension: 0.1
                        },
                        {
                            label: 'Profit',
                            data: [800, 1500, 1200, 200, 1000, 1800, 2500],
                            fill: false,
                            borderColor: 'rgba(255, 99, 132, 1)',
                            tension: 0.1
                        },
                        {
                            label: 'Expenses',
                            data: [2000, 1000, 800, 1500, 1200, 1400, 1800],
                            fill: false,
                            borderColor: 'rgba(54, 162, 235, 1)',
                            tension: 0.1
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

            <!--Biểu đồ cột nằm ngang (Horizontal Bar Chart)-->
            <div class="horizontal-bar-chart">
                <canvas id="horizontalBarChart"></canvas> 
                <div class="chart-title">Horizontal Bar Chart</div>
            </div>
            <script>
                var ctx = document.getElementById('horizontalBarChart').getContext('2d'); 
                var barChart = new Chart(ctx, {
                    type: 'bar',
                    data: {
                        labels: ['January', 'February', 'March', 'April', 'May', 'June', 'July'],
                        datasets: [{
                            label: 'Revenue1',
                            data: [1000, 2000, 1500, 2500, 1800, 2200, 3000],
                            backgroundColor: 'rgba(255, 99, 132, 0.2)',
                            borderColor: 'rgba(255, 99, 132, 1)',
                            borderWidth: 1
                        }]
                    },
                    options: {
                        indexAxis: 'y',
                        scales: {
                            y: {
                                beginAtZero: true
                            }
                        }
                    }
                });
            </script>   
        </div>
        <!--End chart-container-2-->

        <!--Chart container-3-->
        <div class="chart-container-3">
            <!--Biểu đồ phân tán (Scatter Plot)-->
            <div class="scatter-plot">
                <canvas id="scatterChart"></canvas>
                <div class="chart-title">Scatter Plot</div>
            </div>
            <script>
                var ctx = document.getElementById('scatterChart').getContext('2d');
        
                // Tạo mảng chứa 20 điểm tọa độ
                var dataPoints = [];
                for (var i = 0; i < 20; i++) {
                    var x = Math.floor(Math.random() * 50); // Giá trị x ngẫu nhiên từ 0 đến 49
                    var y = Math.floor(Math.random() * 50); // Giá trị y ngẫu nhiên từ 0 đến 49
                    dataPoints.push({ x: x, y: y });
                }
        
                var scatterChart = new Chart(ctx, {
                    type: 'scatter',
                    data: {
                        datasets: [{
                            label: 'Random Data Points',
                            data: dataPoints,
                            backgroundColor: 'rgba(255, 99, 132, 0.5)',
                            pointRadius: 5
                        }, {
                            label: 'y = x',
                            data: [{ x: 0, y: 0 }, { x: 50, y: 50 }],
                            borderColor: 'rgba(54, 162, 235, 0.5)',
                            borderWidth: 2,
                            fill: false,
                            showLine: true
                        }]
                    },
                    options: {
                        scales: {
                            x: {
                                type: 'linear',
                                position: 'bottom'
                            },
                            y: {
                                type: 'linear',
                                position: 'left'
                            }
                        }
                    }
                });
            </script>

            <!--Biểu đồ dạng cột chồng (Stacked Bar Chart)-->
            <div class="stacked-bar-chart">
                <canvas id="stackedBarChart"></canvas>
                <div class="chart-title">Stacked Bar Chart</div>
            </div>
            <script>
                var ctx = document.getElementById('stackedBarChart').getContext('2d');
                var stackedBarChart = new Chart(ctx, {
                    type: 'bar',
                    data: {
                        labels: ['January', 'February', 'March', 'April', 'May'],
                        datasets: [{
                            label: 'Tour Type A',
                            data: [10, 20, 30, 40, 50],
                            backgroundColor: 'rgba(255, 99, 132, 0.5)'
                        }, {
                            label: 'Tour Type B',
                            data: [15, 25, 35, 45, 55],
                            backgroundColor: 'rgba(54, 162, 235, 0.5)'
                        }]
                    },
                    options: {
                        scales: {
                            x: { stacked: true },
                            y: { stacked: true }
                        }
                    }
                });
            </script>
        </div>
        <!--End chart container-3-->

        <!--Calendar-->
        <div class="calendar">
            <iframe src="https://calendar.google.com/calendar/embed?height=450&wkst=1&ctz=Asia%2FHo_Chi_Minh&bgcolor=%23ffffff&showTitle=0&showTz=0&showCalendars=0&showPrint=0&src=dnVtYW5ocXVhbjEzMDdAZ21haWwuY29t&src=YWRkcmVzc2Jvb2sjY29udGFjdHNAZ3JvdXAudi5jYWxlbmRhci5nb29nbGUuY29t&src=Y2xhc3Nyb29tMTA4NjUwMjY2NjQzNTUxMTAwMzE1QGdyb3VwLmNhbGVuZGFyLmdvb2dsZS5jb20&src=dmkudmlldG5hbWVzZSNob2xpZGF5QGdyb3VwLnYuY2FsZW5kYXIuZ29vZ2xlLmNvbQ&color=%23039BE5&color=%2333B679&color=%23202124&color=%230B8043" style="border:solid 1px #777" width="900" height="450" frameborder="0" scrolling="no"></iframe>
        </div>
        <!--End calendar-->
    </div>
    <!--End main container-->

     <!--Right side bar-->
     <div id="rightSideBar" class="right-side-bar">
        <div class="right-side-container-chart">
            <!--Biểu đồ radar (Radar Chart)-->
            <div class="radar-chart">
                <canvas id="radarChart"></canvas>
                <div class="chart-title">Rader Chart</div>
            </div>

            <script>
                var ctx = document.getElementById('radarChart').getContext('2d');
                var radarChart = new Chart(ctx, {
                    type: 'radar',
                    data: {
                        labels: ['A', 'B', 'C', 'D', 'E'],
                        datasets: [{
                            label: 'Tour 1',
                            data: [80, 70, 90, 85, 75],
                            backgroundColor: 'rgba(255, 99, 132, 0.5)'
                        }, {
                            label: 'Tour 2',
                            data: [20, 50, 85, 90, 80],
                            backgroundColor: 'rgba(54, 162, 235, 0.5)'
                        }]
                    },
                    options: {
                        elements: { line: { tension: 0, borderWidth: 3 }},
                        scales: { r: { beginAtZero: true }}
                    }
                });
            </script>

            <!--Biểu đồ bánh (Pie Chart)-->
            <div class="pie-chart-2">
                <canvas id="pieChart2"></canvas>
                <div class="chart-title">Pie Chart 2</div>
            </div>
            <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
            <script>
                var ctx = document.getElementById('pieChart2').getContext('2d');
                var pieChart = new Chart(ctx, {
                    type: 'pie',
                    data: {
                        labels: ['Grenn', 'Black', 'Violet'],
                        datasets: [{
                            label: 'My First Dataset',
                            data: [87, 120, 53],
                            backgroundColor: ['rgb(144, 238, 144)', 'rgb(0, 0, 0)', 'rgb(128, 0, 128)'],
                            hoverOffset: 4
                        }]
                    },
                    options: {
                        radius: 80,
                    }
                });
            </script>

        </div>
    </div>
    <!--End right side bar-->
</body> 
</html>
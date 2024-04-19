<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>Admin Manager</title>
    <!--JS-->
    <script src="https://cdn.jsdelivr.net/npm/chartjs-plugin-datalabels"></script>
    <script src="2.Admin/js/core.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <!--Style CSS-->
    <link rel="stylesheet" type="text/css" href="2.Admin/css/core.css" />
</head>
<body>
    <!--Top sidebar-->
    <div class="header"> 
        <div class="header-content">
            <!--Logo and name page-->
            <a href="#" title="Logo">
                <img src="2.Admin/images/ptit_logo.png" alt="logo" class="logo">
            </a>
            <h3 style="margin-left: 100px; top: 20px;">Trang quản trị viên</h3>

            <!--Search-->
            <div class="search">
                <input type="search" name="btnSearch" id="search" class="search-input" placeholder="Search here">
                <span class="search-icon"></span>
            </div>

            <!--Notification-->
            <button class="notification">
                <img src="2.Admin/images/notification.svg">
            </button>

            <!--Setting-->
            <button class="setting">
                <img src="2.Admin/images/setting.svg">
            </button>

            <!--Avatar and username-->
            <button class="admin" onclick="toggleChevron('chevronIcon')">
                <img src="2.Admin/images/admin_VMQ.jpg" alt="Avatar" class="admin-avatar">
                <span class="admin-name">Vũ Mạnh Quân</span>
                <img src="2.Admin/images/chevron-down.svg" class="chevron-icon" id="chevronIcon">
            </button>

        </div>
    </div> 
    <!--End top sidebar-->

    <!--Left sidebar-->
    <div class="left-side-bar"> 
        <div class="sidebar-menu">
            <ul id="accordion-menu">

                <!--Phân tích hiệu suất-->
                <li class="dropdown">
                    <button class="dropdown-toggle" onclick="toggleChevron('chevronIcon2')">
                        <img src="2.Admin/images/performance-analysis.svg">
                        <span>Phân Tích Hiệu Suất</span>
                        <img src="2.Admin/images/chevron-down.svg" class="chevron-icon" id="chevronIcon2">
                    </button>
                    <ul class="submenu">
                        <li><a href="index.html"><img src="2.Admin/images/dash.svg"> Số Lượng Đơn Đặt Dịch Vụ</a></li>
                        <li><a href="index2.html"><img src="2.Admin/images/dash.svg"> Số Lượng Dịch Vụ Cung Cấp</a></li>
                        <li><a href="index3.html"><img src="2.Admin/images/dash.svg"> Số Lượng Người Tiếp Cận</a></li>
                    </ul>
                </li>

                <!--Quản lý tài khoản người dùng-->
                <li class="dropdown">
                    <button class="dropdown-toggle" onclick="toggleChevron('chevronIcon3')">
                        <img src="2.Admin/images/manager accout.svg">
                        <span>Quản Lý Tài Khoản Người Dùng</span>
                        <img src="2.Admin/images/chevron-down.svg" class="chevron-icon" id="chevronIcon3">
                    </button>
                    <ul class="submenu">
                        <li><a href="index.html"><img src="2.Admin/images/dash.svg"> Số Lượng Tài Khoản Mới</a></li>
                        <li><a href="index2.html"><img src="2.Admin/images/dash.svg"> Tài Khoản Khách Hàng</a></li>
                        <li><a href="index3.html"><img src="2.Admin/images/dash.svg"> Tài Khoản Nhà Cung Cấp</a></li>
                    </ul>
                </li>

                <!--Quản lý giao diện-->
                <li class="dropdown">
                    <button class="dropdown-toggle" onclick="toggleChevron('chevronIcon4')">
                        <img src="2.Admin/images/manager-browser.svg">
                        <span>Quản Lý Giao Diện</span>
                        <img src="2.Admin/images/chevron-down.svg" class="chevron-icon" id="chevronIcon4">
                    </button>
                    <ul class="submenu">
                        <li><a href="index.html"><img src="2.Admin/images/dash.svg"> Thêm / Xóa Tiện Ích</a></li>
                        <li><a href="index2.html"><img src="2.Admin/images/dash.svg"> Bố Cục Giao Diện</a></li>
                    </ul>
                </li>

                <!--Quản lý tài nguyên-->
                <li class="dropdown">
                    <button class="dropdown-toggle" onclick="toggleChevron('chevronIcon5')">
                        <img src="2.Admin/images/manager-database.svg">
                        <span>Quản Lý Tài Nguyên</span>
                        <img src="2.Admin/images/chevron-down.svg" class="chevron-icon" id="chevronIcon5">
                    </button>
                    <ul class="submenu">
                        <li><a href="index.html"><img src="2.Admin/images/dash.svg"> Quản Lý Người Dùng</a></li>
                        <li><a href="index2.html"><img src="2.Admin/images/dash.svg"> Quản Lý Nội Dung</a></li>
                        <li><a href="index2.html"><img src="2.Admin/images/dash.svg"> Quản Lý Hệ Thống</a></li>
                    </ul>
                </li>

                <!--Quản lý tài chính-->
                <li class="dropdown">
                    <button class="dropdown-toggle" onclick="toggleChevron('chevronIcon6')">
                        <img src="2.Admin/images/credit-card.svg">
                        <span>Quản Lý Tài Chính</span>
                        <img src="2.Admin/images/chevron-down.svg" class="chevron-icon" id="chevronIcon6">
                    </button>
                    <ul class="submenu">
                        <li><a href="index.html"><img src="2.Admin/images/dash.svg"> Dịch Vụ Đổi Tiền</a></li>
                        <li><a href="index2.html"><img src="2.Admin/images/dash.svg"> Tài Khoản Ngân Hàng</a></li>
                        <li><a href="index2.html"><img src="2.Admin/images/dash.svg"> Bảng Giá Tiền Tệ</a></li>
                    </ul>
                </li>

                <!--Thông tin liên hệ-->
                <li class="dropdown">
                    <button class="dropdown-toggle" onclick="toggleChevron('chevronIcon7')">
                        <img src="2.Admin/images/mail.svg">
                        <span>Thông Tin Liên Hệ</span>
                        <img src="2.Admin/images/chevron-down.svg" class="chevron-icon" id="chevronIcon7">
                    </button>
                    <ul class="submenu">
                        <li><a href="index.html"><img src="2.Admin/images/dash.svg"> Thông Tin</a></li>
                        <li><a href="index2.html"><img src="2.Admin/images/dash.svg"> Liên Hệ</a></li>
                        <li><a href="index2.html"><img src="2.Admin/images/dash.svg"> Hợp Tác</a></li>
                        <li><a href="index2.html"><img src="2.Admin/images/dash.svg"> Liên Kết Mạng Xã Hội</a></li>
                    </ul>
                </li>

                <!--Hỗ trợ và quản lý-->
                <li class="dropdown">
                    <button class="dropdown-toggle" onclick="toggleChevron('chevronIcon8')">
                        <img src="2.Admin/images/manager-support-.svg">
                        <span>Hỗ Trợ Và Quản Lý</span>
                        <img src="2.Admin/images/chevron-down.svg" class="chevron-icon" id="chevronIcon8">
                    </button>
                    <ul class="submenu">
                        <li><a href="index.html"><img src="2.Admin/images/dash.svg"> Trợ Giúp</a></li>
                        <li><a href="index2.html"><img src="2.Admin/images/dash.svg"> Thông Báo / Hòm Thư</a></li>
                        <li><a href="index2.html"><img src="2.Admin/images/dash.svg"> Cấp Quyền Truy Cập</a></li>
                        <li><a href="index2.html"><img src="2.Admin/images/dash.svg"> Theo Dõi / Quản Lý Đơn</a></li>
                        <li><a href="index2.html"><img src="2.Admin/images/dash.svg"> Quản Lý Thông Tin Tour</a></li>
                        <li><a href="index2.html"><img src="2.Admin/images/dash.svg"> Thông Kê / Báo Cáo Về Hoạt Động Trang Web</a></li>
                        <li><a href="index2.html"><img src="2.Admin/images/dash.svg"> Quản Lý Nội Dung Và Thông Báo Trên Trang Web</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>  
    <!--End top sidebar-->

    <!--Main container-->
    <div class="main-container">
        <!--Chart container 1-->
        <div class="chart-container-1">
            <!--Biểu đồ cột (Bar Chart)-->
            <div class="bar-chart">
                <canvas id="barChart"></canvas>
                <div class="chart-title">Title Chart</div>
            </div>
            <script>
                var ctx = document.getElementById('barChart').getContext('2d');
                var barChart = new Chart(ctx, {
                    type: 'bar',
                    data: {
                        labels: ['January', 'February', 'March', 'April', 'May', 'June', 'July'],
                        datasets: [{
                            label: 'Revenue',
                            data: [1000, 2000, 1500, 2500, 1800, 2200, 3000],
                            backgroundColor: 'rgba(255, 99, 132, 0.2)',
                            borderColor: 'rgba(255, 99, 132, 1)',
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
            <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
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
                <canvas id="lineChart" width="100" height="50"></canvas>
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
        </div>
        <!--End chart-container-2-->

        <div class="chart-container-3">
            
        </div>

        <!--Chart container-3-->
        <div class="calendar">
            <iframe src="https://calendar.google.com/calendar/embed?height=400&wkst=1&ctz=Asia%2FHo_Chi_Minh&bgcolor=%23ffffff&showTitle=0&showPrint=0&showTz=0&showCalendars=0&src=dnVtYW5ocXVhbjEzMDdAZ21haWwuY29t&src=YWRkcmVzc2Jvb2sjY29udGFjdHNAZ3JvdXAudi5jYWxlbmRhci5nb29nbGUuY29t&src=Y2xhc3Nyb29tMTA4NjUwMjY2NjQzNTUxMTAwMzE1QGdyb3VwLmNhbGVuZGFyLmdvb2dsZS5jb20&src=dmkudmlldG5hbWVzZSNob2xpZGF5QGdyb3VwLnYuY2FsZW5kYXIuZ29vZ2xlLmNvbQ&color=%23039BE5&color=%2333B679&color=%23202124&color=%230B8043" style="border:solid 1px #777" width="1000" height="400" frameborder="0" scrolling="no"></iframe>
        </div>
        <!--End chart container-3-->
    </div>
     <!--End main container-->

     <!--Right side bar-->
     <div class="right-side-bar">
        <!--Begin Weather Widget --><iframe src="https://thoitiet.app/widget/embed/ha-noi?style=1&day=3&td=%23003870&ntd=%23ff0000&mvb=%23959dad&mv=%23ff0000&mdk=%23dddddd&htd=true" id="widgeturl" width="100%" height="360px" scrolling="no" frameborder="0" allowtransparency="true" style="border:none;overflow:hidden;"></iframe><!-- End Widget -->
    </div>
    <!--End right side bar-->
</body>
</html>
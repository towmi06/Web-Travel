<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="loadDAO.Admin_Quan_TourManagenment_DAO" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title></title>Thống Kê / Báo Cáo</title>
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
	
	<%
		Map<Integer, Integer> cateIDCount = new Admin_Quan_TourManagenment_DAO().getCateIDCount();
		long[] categories = cateIDCount.values().stream().mapToLong(Integer::longValue).toArray();
		long total = Arrays.stream(categories).sum();
		
		Map<String, Integer> ordersCountByMonth = new Admin_Quan_TourManagenment_DAO().getOrdersCountByMonth();
		int[] orders = ordersCountByMonth.values().stream().mapToInt(Integer::intValue).toArray();
		
		double percentBien = (double) categories[0] / total * 100;
		double percentThienNhien = (double) categories[1] / total * 100;
		double percentThamQuan = (double) categories[2] / total * 100;
	%>

    <!--Main container-->
    <div class="main-container">
        <div class="chart-container-1">
            <!--Biểu đồ đường (Line Chart)-->
            <div class="line-chart-2">
                <canvas id="lineChart2"></canvas>
                <div class="chart-title">Thống kê số đơn theo tháng</div>
            </div>
            <script>
                var ctx = document.getElementById('lineChart2').getContext('2d');
                var lineChart = new Chart(ctx, {
                    type: 'line',
                    data: {
                        labels: ['March', 'April', 'May', 'June'],
                        datasets: [{
                            label: 'Số lượng đơn',
                            data: <%= Arrays.toString(orders) %>,
                            fill: false,
                            borderColor: 'rgba(75, 192, 192, 1)',
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
    
            <!--Biểu đồ bánh (Pie Chart)-->
            <div class="pie-chart-3">
                <canvas id="pieChart3" width="200" height="200"></canvas>
                <div class="chart-title">Phân Bổ Thể Loại</div>
            </div>
            <script>
                var ctx = document.getElementById('pieChart3').getContext('2d');
                var pieChart = new Chart(ctx, {
                    type: 'pie',
                    data: {
                        labels: ['Biển', 'Thiên nhiên', 'Tham quan'],
                        datasets: [{
                            label: 'My First Dataset',
                            data: <%= Arrays.toString(categories) %>,
                            backgroundColor: ['rgb(54, 162, 235)', 'rgb(255, 99, 132)', 'rgb(255, 205, 86)'],
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

        <!--Báo cáo-->
        <div class="report">
            <h2>Báo Cáo về Trang Web Quản Lý Nội Dung</h2>
            <p>
                Trang web Quản Lý Nội Dung là một nền tảng quản lý thông tin được thiết kế để cung cấp cho người quản trị một công cụ mạnh mẽ để theo dõi và phân tích các hoạt động liên quan đến nội dung và dữ liệu. Trang web này tích hợp hai loại biểu đồ quan trọng để trực quan hóa dữ liệu thống kê:
            </p>
            <ul>
                <li>
                    <strong>Biểu đồ Thống kê (Line Chart):</strong> Biểu đồ đường hiển thị dữ liệu về Số lượng orders qua các tháng trong năm. Thông qua biểu đồ này, người quản trị có thể theo dõi và phân tích xu hướng tăng trưởng hoặc giảm sút của các chỉ số quan trọng, từ đó đưa ra các quyết định chiến lược.
                </li>
                <li>
                    <strong>Biểu đồ Phân bổ thể loại (Pie Chart):</strong> Biểu đồ bánh thể hiện phân phối tỷ lệ của thể loại trong tổng các tour khách hàng đặt. Loại tour Biển chiếm <%= String.format("%.2f", percentBien) %>%, loại tour Thiên nhiên chiếm <%= String.format("%.2f", percentThienNhien) %>%, loại tour Tham quan chiếm <%= String.format("%.2f", percentThamQuan) %>%.
                </li>
            </ul>
        </div>
        <!--End report-->
    </div>
    <!--End main container-->
</body>
</html>

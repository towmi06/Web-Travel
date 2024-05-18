<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    <!--Main container-->
    <div class="main-container">
        <div class="chart-container-1">
            <!--Biểu đồ đường (Line Chart)-->
            <div class="line-chart-2">
                <canvas id="lineChart2"></canvas>
                <div class="chart-title">Line Chart</div>
            </div>
            <script>
                var ctx = document.getElementById('lineChart2').getContext('2d');
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
    
            <!--Biểu đồ bánh (Pie Chart)-->
            <div class="pie-chart-3">
                <canvas id="pieChart3" width="200" height="200"></canvas>
                <div class="chart-title">Pie Chart</div>
            </div>
            <script>
                var ctx = document.getElementById('pieChart3').getContext('2d');
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

        <!--Báo cáo-->
        <div class="report">
            <h2>Báo Cáo về Trang Web Quản Lý Nội Dung</h2>
            <p>
                Trang web Quản Lý Nội Dung là một nền tảng quản lý thông tin được thiết kế để cung cấp cho người quản trị một công cụ mạnh mẽ để theo dõi và phân tích các hoạt động liên quan đến nội dung và dữ liệu. Trang web này tích hợp hai loại biểu đồ quan trọng để trực quan hóa dữ liệu thống kê:
            </p>
            <ul>
                <li>
                    <strong>Biểu đồ đường (Line Chart):</strong> Biểu đồ đường hiển thị dữ liệu về doanh thu, lợi nhuận và chi phí qua các tháng trong năm. Thông qua biểu đồ này, người quản trị có thể theo dõi và phân tích xu hướng tăng trưởng hoặc giảm sút của các chỉ số quan trọng, từ đó đưa ra các quyết định chiến lược.
                </li>
                <li>
                    <strong>Biểu đồ bánh (Pie Chart):</strong> Biểu đồ bánh thể hiện phân phối tỷ lệ của các phần trong một tập hợp, trong trường hợp này là phân phối màu sắc giữa ba màu chính: Đỏ, Xanh và Vàng. Biểu đồ này cung cấp một cái nhìn tổng quan về phân bổ hoặc phân phối của các yếu tố khác nhau, giúp người quản trị hiểu rõ hơn về cấu trúc của dữ liệu.
                </li>
            </ul>
            <p>
                Trang web Quản Lý Nội Dung là một công cụ hữu ích để quản lý và phân tích thông tin, giúp người quản trị đưa ra các quyết định thông minh và phát triển chiến lược hiệu quả dựa trên dữ liệu thống kê và phân tích.
            </p>
        </div>
        <!--End report-->
    </div>
    <!--End main container-->
</body>
</html>
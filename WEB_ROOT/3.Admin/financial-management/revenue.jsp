<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tài Khoản Ngân Hàng</title>
    <link rel="stylesheet" type="text/css" href="resources/css/financial-management.css"/> 
</head>
<body>
    <div class="main-container">
        <div class="chart-container-2">
            <!--Doanh thu-->
            <div class="bar-chart-3">
                <canvas id="barChart3"></canvas>
                <div class="chart-title">Bar Chart</div>
            </div>
            <script>
                var ctx = document.getElementById('barChart3').getContext('2d');
                var barChart = new Chart(ctx, {
                    type: 'bar',
                    data: {
                        labels: ['January', 'February', 'March', 'April', 'May', 'June', 'July'],
                        datasets: [{
                            label: 'Doanh Thu Từ Web',
                            data: [1000, 2000, 1500, 2500, 1800, 2200, 3000],
                            backgroundColor: 'rgba(255, 99, 132, 0.2)',
                            borderColor: 'rgba(255, 99, 132, 1)',
                            borderWidth: 1
                        }, {
                            label: 'Doanh Thu Từ TKLK',
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
            
            <!--Chi phí-->
            <div class="bar-chart-3">
                <canvas id="barChart4"></canvas>
                <div class="chart-title">Bar Chart</div>
            </div>
            <script>
                var ctx = document.getElementById('barChart4').getContext('2d');
                var barChart = new Chart(ctx, {
                    type: 'bar',
                    data: {
                        labels: ['January', 'February', 'March', 'April', 'May', 'June', 'July'],
                        datasets: [{
                            label: 'Chi Phí Marketing',
                            data: [1200, 2300, 1800, 3200, 900, 2700, 3000],
                            backgroundColor: 'rgba(255, 99, 132, 0.2)',
                            borderColor: 'rgba(255, 99, 132, 1)',
                            borderWidth: 1
                        }, {
                            label: 'Chi Phí Nhân viên',
                            data: [2000, 2700, 1800, 3000, 1500, 1800, 2500],
                            backgroundColor: 'rgba(54, 162, 235, 0.2)',
                            borderColor: 'rgba(54, 162, 235, 1)',
                            borderWidth: 1
                        } , {
                            label: 'Chi Phí Bảo Trì',
                            data: [600, 800, 500, 1200, 1500, 1800, 2500],
                            backgroundColor: 'rgba(54, 162, 235, 0.2)',
                            borderColor: 'rgba(34, 14652, 235, 1)',
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
            
            <!--Lợi nhuận-->
            <div class="bar-chart-3">
                <canvas id="barChart5"></canvas>
                <div class="chart-title">Bar Chart</div>
            </div>
            <script>
                var ctx = document.getElementById('barChart5').getContext('2d');
                var barChart = new Chart(ctx, {
                    type: 'bar',
                    data: {
                        labels: ['January', 'February', 'March', 'April', 'May', 'June', 'July'],
                        datasets: [{
                            label: 'Lợi nhuận',
                            data: [1500, 2300, -700, -200, 900, 2700, 3000],
                            backgroundColor: 'rgba(255, 99, 132, 0.2)',
                            borderColor: 'rgba(255, 99, 132, 1)',
                            borderWidth: 1
                        }, {
                            label: 'Thuế',
                            data: [2000, 2700, 0, 0, 1500, 1800, 2500],
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
        </div>
    </div>
</body>
</html>
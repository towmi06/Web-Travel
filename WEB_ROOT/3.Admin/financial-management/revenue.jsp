<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="loadDAO.Admin_Quan_Payments_DAO" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Doanh Thu</title>
    <!--JS-->
    <script src="resources/js/core.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <script src="https://unpkg.com/leaflet/dist/leaflet.js"></script>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto&display=swap">
    <!--Style CSS-->
    <link rel="stylesheet" type="text/css" href="resources/css/financial-management.css"/> 
    <link rel="stylesheet" href="https://unpkg.com/leaflet/dist/leaflet.css"/>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto&display=swap">
</head>
<body>

	<% 
        Map<String, Long> paymentMethodTotalMap = new Admin_Quan_Payments_DAO().getPaymentMethodTotal(); 
        long[] doanhThu = paymentMethodTotalMap.values().stream().mapToLong(Long::longValue).toArray();
        long[] loiNhuan = Arrays.stream(doanhThu).map(value -> (long) (value * 0.3)).toArray(); 
        long[] thue = Arrays.stream(loiNhuan).map(value -> (long) (value * 0.1)).toArray(); 
    %>

    <div class="main-container">
        <div class="chart-container-2">
            <!--Doanh thu-->
            <div class="bar-chart-3">
                <canvas id="barChart3"></canvas>
                <div class="chart-title">Tài Chính</div>
            </div>
            <script>
                var ctx = document.getElementById('barChart3').getContext('2d');
                var barChart = new Chart(ctx, {
                    type: 'bar',
                    data: {
                    	labels: ['credit_card', 'bank_transfer', 'cash', 'debit_card'],
                        datasets: [{
                            label: 'Doanh Thu Từ Web',
                            data: <%= Arrays.toString(doanhThu) %>,
                            backgroundColor: 'rgba(255, 99, 132, 0.2)',
                            borderColor: 'rgba(255, 99, 132, 1)',
                            borderWidth: 1
                        }, {
                            label: 'Lợi Nhuận',
                            data: <%= Arrays.toString(loiNhuan) %>,
                            backgroundColor: 'rgba(54, 162, 235, 0.2)',
                            borderColor: 'rgba(54, 162, 235, 1)',
                            borderWidth: 1
                        } , {
                            label: 'Thuế',
                            data: <%= Arrays.toString(thue) %>,
                            backgroundColor: 'rgba(255, 206, 86, 0.2)',
                            borderColor: 'rgba(255, 206, 86, 1)',
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
function loadStatisticsReports() {
    var xhr = new XMLHttpRequest();
    xhr.open('GET', 'support-management/statistics-reports.jsp', true);
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4 && xhr.status == 200) {
            document.getElementById('mainContent').innerHTML = xhr.responseText;
            renderCharts(categories, orders); 
        }
    };
    xhr.send();
}

function renderCharts(categories, orders) {
    // Biểu đồ đường
    var ctxLine = document.getElementById('lineChart2').getContext('2d');
    var lineChart = new Chart(ctxLine, {
        type: 'line',
        data: {
            labels: ['March', 'April', 'May', 'June'],
            datasets: [{
                label: 'Số lượng đơn',
                data: orders,
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

    // Biểu đồ bánh
    var ctxPie = document.getElementById('pieChart3').getContext('2d');
    var pieChart = new Chart(ctxPie, {
        type: 'pie',
        data: {
            labels: ['Biển', 'Thiên nhiên', 'Tham quan'],
            datasets: [{
                label: 'My First Dataset',
                data: categories,
                backgroundColor: ['rgb(255, 99, 132)', 'rgb(54, 162, 235)', 'rgb(255, 205, 86)'],
                hoverOffset: 4
            }]
        },
        options: {
            radius: 110,
            cutout: '50%',
        }
    });
}
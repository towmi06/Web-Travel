function loadStatisticsReports() {
    var xhr = new XMLHttpRequest();
    xhr.open('GET', 'support-management/statistics-reports.html', true);
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4 && xhr.status == 200) {
            document.getElementById('mainContent').innerHTML = xhr.responseText;
            renderCharts(); // Gọi hàm vẽ biểu đồ sau khi tải xong nội dung
        }
    };
    xhr.send();
}

function renderCharts() {
    // Biểu đồ đường
    var ctxLine = document.getElementById('lineChart2').getContext('2d');
    var lineChart = new Chart(ctxLine, {
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

    // Biểu đồ bánh
    var ctxPie = document.getElementById('pieChart3').getContext('2d');
    var pieChart = new Chart(ctxPie, {
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
}

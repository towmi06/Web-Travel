function loadRevenue() {
    // Sử dụng XMLHttpRequest hoặc fetch để tải nội dung từ tệp HTML
    var xhr = new XMLHttpRequest();
    xhr.open('GET', 'financial-management/revenue.html', true);
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4 && xhr.status == 200) {
            document.getElementById('mainContent').innerHTML = xhr.responseText;
            renderCharts2();
        }
    };
    xhr.send();
}

function renderCharts2() {
    // Biểu đồ doanh thu
    var ctx1 = document.getElementById('barChart3').getContext('2d');
    var barChart1 = new Chart(ctx1, {
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

    // Biểu đồ chi phí
    var ctx2 = document.getElementById('barChart4').getContext('2d');
    var barChart2 = new Chart(ctx2, {
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
            }, {
                label: 'Chi Phí Bảo Trì',
                data: [600, 800, 500, 1200, 1500, 1800, 2500],
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

    // Biểu đồ lợi nhuận
    var ctx3 = document.getElementById('barChart5').getContext('2d');
    var barChart3 = new Chart(ctx3, {
        type: 'bar',
        data: {
            labels: ['January', 'February', 'March', 'April', 'May', 'June', 'July'],
            datasets: [{
                label: 'Lợi nhuận',
                data: [1500, 2300, -700, -200, 900, 2700, 3000],
                backgroundColor: 'rgba(75, 192, 192, 0.2)', 
            borderColor: 'rgba(75, 192, 192, 1)',
                borderWidth: 1
            }, {
                label: 'Thuế',
                data: [2000, 2700, 0, 0, 1500, 1800, 2500],
                backgroundColor: 'rgba(153, 102, 255, 0.2)',
                borderColor: 'rgba(153, 102, 255, 1)', 
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
}
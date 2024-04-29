function loadSystemManagement() {
    // Sử dụng XMLHttpRequest hoặc fetch để tải nội dung từ tệp HTML
    var xhr = new XMLHttpRequest();
    xhr.open('GET', 'resource-management/system-management.html', true);
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4 && xhr.status == 200) {
            document.getElementById('mainContent').innerHTML = xhr.responseText;
            renderScatterChart();
            renderRadarChart2();
            renderBarChart2();
        }
    };
    xhr.send();
}

function renderScatterChart() {
    var ctx = document.getElementById('scatterChart').getContext('2d');

    // Tạo mảng chứa 20 điểm tọa độ
    var dataPoints = [];
    for (var i = 0; i < 20; i++) {
        var x = Math.floor(Math.random() * 50); // Giá trị x ngẫu nhiên từ 0 đến 49
        var y = Math.floor(Math.random() * 50); // Giá trị y ngẫu nhiên từ 0 đến 49
        dataPoints.push({ x: x, y: y });
    }

    if (window.scatterChart) {
        // Nếu biểu đồ đã tồn tại, hủy và tạo lại để cập nhật dữ liệu
        window.scatterChart.destroy();
    }

    window.scatterChart = new Chart(ctx, {
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
}

function renderRadarChart2() {
    var ctx = document.getElementById('radarChart2').getContext('2d');

    window.radarChart = new Chart(ctx, {
        type: 'radar',
        data: {
            labels: ['A', 'B', 'C', 'D', 'E', 'F'],
            datasets: [
                {
                    label: 'Tour 1',
                    data: [50, 10, 80, 85, 23, 33],
                    backgroundColor: 'rgba(192, 99, 132, 0.5)'
                },
                {
                    label: 'Tour 2',
                    data: [10, 20, 30, 90, 80, 65],
                    backgroundColor: 'rgba(54, 162, 235, 0.5)'
                },
                {
                    label: 'Tour 3',
                    data: [60, 34, 56, 25, 19, 47],
                    backgroundColor: 'rgba(255, 205, 86, 0.5)'
                }
            ]
        },
        options: {
            elements: {
                line: {
                    tension: 0, // Không sử dụng đường cong nối mượt
                    borderWidth: 3 // Độ dày của đường nối
                }
            },
            scales: {
                r: {
                    beginAtZero: true // Bắt đầu trục từ giá trị 0
                }
            }
        }
    });
}

function renderBarChart2() {
    var ctx = document.getElementById('barChart2').getContext('2d');

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
                borderWidth: 1,
                type: 'line',
                fill: false,
                yAxisID: 'y-axis-2'
            }]
        },
        options: {
            scales: {
                y: {
                    type: 'linear',
                    display: true,
                    position: 'left',
                    id: 'y-axis-1',
                    beginAtZero: true
                },
                y2: {
                    type: 'linear',
                    display: true,
                    position: 'right',
                    id: 'y-axis-2',
                    grid: {
                        drawOnChartArea: false
                    }
                }
            }
        }
    });
}
// Lưu trạng thái hiện tại của biểu đồ
var currentPieChart, currentHorizontalBarChart;

// Thay đổi nội dung trong Main container
function loadNumberOfServicesPage() {
    // Sử dụng XMLHttpRequest hoặc fetch để tải nội dung từ tệp HTML
    var xhr = new XMLHttpRequest();
    xhr.open('GET', 'performance-analysis/number-of-services.html', true);
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4 && xhr.status == 200) {
            // Thay đổi nội dung của phần tử mainContent 
            document.getElementById('mainContent').innerHTML = xhr.responseText;
            renderPieChart();   
            renderHorizontalBarChart();
        }
    };
    xhr.send();
}

// Render lại biểu đồ tròn
function renderPieChart() {
    var ctx = document.getElementById('pieChart').getContext('2d');
    if (currentPieChart) {
        currentPieChart.destroy();
    }
    currentPieChart = new Chart(ctx, {
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

function renderHorizontalBarChart() {
    var ctx = document.getElementById('horizontalBarChart').getContext('2d');
    if (currentHorizontalBarChart) {
        currentHorizontalBarChart.destroy();
    }
    currentHorizontalBarChart = new Chart(ctx, {
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
}

// Gọi hàm loadNumberOfServiceOrdersPage() khi cần chèn trang vào trang khác
loadNumberOfServicesPage();
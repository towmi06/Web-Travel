// Lưu trạng thái hiện tại của biểu đồ
var currentLineChart;

// Thay đổi nội dung trong Main container
function loadNumberOfPeopleReachedPage() {
    // Sử dụng XMLHttpRequest hoặc fetch để tải nội dung từ tệp HTML
    var xhr = new XMLHttpRequest();
    xhr.open('GET', 'performance-analysis/number-of-people-reached.html', true);
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4 && xhr.status == 200) {
            // Thay đổi nội dung của phần tử mainContent và rightSideBar bằng nội dung từ tệp HTML
            document.getElementById('mainContent').innerHTML = xhr.responseText;
            renderLineChart();
            
        }
    };
    xhr.send();
}

// Render lại biểu đồ dòng (Line Chart)
function renderLineChart() {
    var ctx = document.getElementById('lineChart').getContext('2d');
    if (currentLineChart) {
        currentLineChart.destroy();
    }
    currentLineChart = new Chart(ctx, {
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
}

// Gọi hàm loadNumberOfPeopleReachedPage() khi cần chèn trang vào trang khác
loadNumberOfPeopleReachedPage();
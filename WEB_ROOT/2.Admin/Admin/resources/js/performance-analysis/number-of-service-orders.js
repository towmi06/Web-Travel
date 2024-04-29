// Lưu trạng thái hiện tại của đồ thị cột và radar
var currentBarChart;

// Thay đổi nội dung trong Main container
function loadNumberOfServiceOrdersPage() {
    // Sử dụng XMLHttpRequest hoặc fetch để tải nội dung từ tệp HTML
    var xhr = new XMLHttpRequest();
    xhr.open('GET', 'performance-analysis/number-of-service-orders.html', true);
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4 && xhr.status == 200) {
            // Thay đổi nội dung của phần tử mainContent và rightSideBar bằng nội dung từ tệp HTML
            document.getElementById('mainContent').innerHTML = xhr.responseText;
            renderBarChart();
            
        }
    };
    xhr.send();
}

// Render lại đồ thị cột (Bar Chart)
function renderBarChart() {
    var ctx = document.getElementById('barChart').getContext('2d');
    if (currentBarChart) {
        currentBarChart.destroy();
    }
    currentBarChart = new Chart(ctx, {
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
// Gọi hàm loadNumberOfServiceOrdersPage() khi cần chèn trang vào trang khác
loadNumberOfServiceOrdersPage()
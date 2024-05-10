// Lưu trạng thái hiện tại của biểu đồ
var currentStackedBarChart;

// Thay đổi nội dung trong Main container
function loadNumberOfNewAccounts() {
    // Sử dụng XMLHttpRequest hoặc fetch để tải nội dung từ tệp HTML
    var xhr = new XMLHttpRequest();
    xhr.open('GET', 'account-management/number-of-new-accounts.html', true);
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4 && xhr.status == 200) {
            // Thay đổi nội dung của phần tử mainContent và rightSideBar bằng nội dung từ tệp HTML
            document.getElementById('mainContent').innerHTML = xhr.responseText;
            renderStackedBarChart();   
        }
    };
    xhr.send();
}

// Render lại biểu đồ cột chồng (Stacked Bar Chart)
function renderStackedBarChart() {
    var ctx = document.getElementById('stackedBarChart').getContext('2d');
    if (currentStackedBarChart) {
        currentStackedBarChart.destroy();
    }
    currentStackedBarChart = new Chart(ctx, {
        type: 'bar',
        data: {
            labels: ['January', 'February', 'March', 'April', 'May'],
            datasets: [{
                label: 'Tour Type A',
                data: [10, 20, 30, 40, 50],
                backgroundColor: 'rgba(255, 99, 132, 0.5)'
            }, {
                label: 'Tour Type B',
                data: [15, 25, 35, 45, 55],
                backgroundColor: 'rgba(54, 162, 235, 0.5)'
            }]
        },
        options: {
            scales: {
                x: { stacked: true },
                y: { stacked: true }
            }
        }
    });
}

// Gọi hàm loadNumberOfNewAccounts() khi cần chèn trang vào trang khác
loadNumberOfNewAccounts();
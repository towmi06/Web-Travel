function loadRevenue() {
    // Sử dụng XMLHttpRequest hoặc fetch để tải nội dung từ tệp HTML
    var xhr = new XMLHttpRequest();
    xhr.open('GET', 'financial-management/revenue.jsp', true);
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4 && xhr.status == 200) {
            document.getElementById('mainContent').innerHTML = xhr.responseText;
            renderCharts2(doanhThu, loiNhuan, thue);
        }
    };
    xhr.send();
}

function renderCharts2(doanhThu, loiNhuan, thue) {
    var ctx = document.getElementById('barChart3').getContext('2d');
    var barChart = new Chart(ctx, {
    type: 'bar',
    data: {
    	labels: ['credit_card', 'bank_transfer', 'cash', 'debit_card'],
        datasets: [{
        	label: 'Doanh Thu Từ Web',
			data: doanhThu,
            backgroundColor: 'rgba(255, 99, 132, 0.2)',
            borderColor: 'rgba(255, 99, 132, 1)',
            borderWidth: 1
        }, {
            label: 'Lợi Nhuận',
            data: loiNhuan,
            backgroundColor: 'rgba(54, 162, 235, 0.2)',
            borderColor: 'rgba(54, 162, 235, 1)',
            borderWidth: 1
        } , {
             label: 'Thuế',
             data: thue,
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
}
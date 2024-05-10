// Load currency price list
function loadCurrencyPriceList() {
    var xhr = new XMLHttpRequest();
    xhr.open('GET', 'financial-management/currency-price-list.html', true);
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4 && xhr.status == 200) {
            document.getElementById('mainContent').innerHTML = xhr.responseText;
            // After loading content, trigger the function to fetch exchange rates
            layTyGia();
        }
    };
    xhr.send();
}

// Fetch and display exchange rates based on the specified date
function layTyGia() {
    var ngay = document.getElementById('ngay').value;

    var url = 'https://portal.vietcombank.com.vn/UserControls/TVPortal.TyGia/pListTyGia.aspx?txttungay=' + ngay;

    fetch(url)
        .then(response => response.text())
        .then(data => {
            var parser = new DOMParser();
            var doc = parser.parseFromString(data, 'text/html');
            var table = doc.querySelector('#ctl00_Content_ExrateView');
            var rows = table.querySelectorAll('tr');
            var tbody = document.querySelector('#ketQua tbody');
            tbody.innerHTML = ''; // Clear previous results

            for (var i = rows.length - 1; i >= 0; i--) {
                var cells = rows[i].querySelectorAll('td');
                if (cells.length >= 5) {
                    var currencyCode = cells[1].textContent.trim();
                    var currencyName = cells[0].textContent.trim();
                    var buyCash = cells[2].textContent.trim();
                    var buyTransfer = cells[3].textContent.trim();
                    var sell = cells[4].textContent.trim();

                    var row = '<tr>';
                    row += '<td>' + currencyCode + '</td>';
                    row += '<td>' + currencyName + '</td>';
                    row += '<td>' + buyCash + '</td>';
                    row += '<td>' + buyTransfer + '</td>';
                    row += '<td>' + sell + '</td>';
                    row += '</tr>';

                    tbody.innerHTML += row;
                }
            }

            if (tbody.innerHTML === '') {
                tbody.innerHTML = '<tr><td colspan="5">Không có dữ liệu tỷ giá cho ngày ' + ngay + '</td></tr>';
            }
        })
        .catch(error => {
            console.error('Lỗi khi lấy tỷ giá:', error);
            var tbody = document.querySelector('#ketQua tbody');
            tbody.innerHTML = '<tr><td colspan="5">Đã xảy ra lỗi khi lấy tỷ giá.</td></tr>';
        });
}
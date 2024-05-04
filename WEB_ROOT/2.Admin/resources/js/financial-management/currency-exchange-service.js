function loadCurrencyExchangeService() {
    // Sử dụng XMLHttpRequest hoặc fetch để tải nội dung từ tệp HTML
    var xhr = new XMLHttpRequest();
    xhr.open('GET', 'financial-management/currency-exchange-service.html', true);
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4 && xhr.status == 200) {
            document.getElementById('mainContent').innerHTML = xhr.responseText;
            renderImages(); // Gọi hàm renderImages để tải lại ảnh
        }
    };
    xhr.send();
}


function toggleInput() {
    var operation = document.getElementById("operation").value;

    document.getElementById("buyCashInput").style.display = "none";
    document.getElementById("buyTransferInput").style.display = "none";
    document.getElementById("sellInput").style.display = "none";

    document.getElementById("buyCashOutput").style.display = "none";
    document.getElementById("buyTransferOutput").style.display = "none";
    document.getElementById("sellOutput").style.display = "none";

    if (operation === "buyCash") {
        document.getElementById("buyCashInput").style.display = "block";
        document.getElementById("buyCashOutput").style.display = "block";
    } else if (operation === "buyTransfer") {
        document.getElementById("buyTransferInput").style.display = "block";
        document.getElementById("buyTransferOutput").style.display = "block";
    } else if (operation === "sell") {
        document.getElementById("sellInput").style.display = "block";
        document.getElementById("sellOutput").style.display = "block";
    }
}

var exchangeRates = {}; // Đối tượng lưu trữ tỷ giá

// Hàm lấy tỷ giá từ trang web và lưu vào biến exchangeRates
function fetchExchangeRates() {
    var ngayInput = document.getElementById('ngay').value;
    var today = new Date();
    var ngay = ngayInput ? ngayInput : today.toISOString().slice(0, 10); // Sử dụng ngày hiện tại nếu không có ngày được chọn

    var url = 'https://portal.vietcombank.com.vn/UserControls/TVPortal.TyGia/pListTyGia.aspx?txttungay=' + ngay;

    fetch(url)
        .then(response => response.text())
        .then(data => {
            var parser = new DOMParser();
            var doc = parser.parseFromString(data, 'text/html');
            var table = doc.querySelector('#ctl00_Content_ExrateView');
            var rows = table.querySelectorAll('tr');

            for (var i = rows.length - 1; i >= 0; i--) {
                var cells = rows[i].querySelectorAll('td');
                if (cells.length >= 5) {
                    var currencyCode = cells[1].textContent.trim();
                    var buyCash = parseFloat(cells[2].textContent.trim().replace(/,/g, ''));
                    var buyTransfer = parseFloat(cells[3].textContent.trim().replace(/,/g, ''));
                    var sell = parseFloat(cells[4].textContent.trim().replace(/,/g, ''));

                    exchangeRates[currencyCode] = { buyCash: buyCash, buyTransfer: buyTransfer, sell: sell };
                }
            }

            // Sau khi lấy tỷ giá xong, tính toán kết quả cho trang web
            performCurrencyExchange();
        })
        .catch(error => {
            console.error('Lỗi khi lấy tỷ giá:', error);
        });
}

// Hàm tính toán kết quả dựa trên lựa chọn người dùng và tỷ giá hiện tại
function performCurrencyExchange() {
    var operation = document.getElementById('operation').value;
    var currency = document.getElementById('fromCurrency').value;
    var amount = parseFloat(document.getElementById('amount').value);

    var result = 0;
    if (operation === 'buyCash') {
        result = amount * exchangeRates[currency].buyCash;
    } else if (operation === 'buyTransfer') {
        result = amount * exchangeRates[currency].buyTransfer;
    } else if (operation === 'sell') {
        result = amount * exchangeRates[currency].sell;
    }

    // Hiển thị kết quả cho người dùng
    document.getElementById('result').innerText = result.toLocaleString('vi-VN', { style: 'currency', currency: 'VND' });
}

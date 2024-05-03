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
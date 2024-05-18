<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Chuyển Đổi Ngoại Tệ</title>
    <link rel="stylesheet" type="text/css" href="resources/css/financial-management.css"/>
    <script src="resources/js/financial-management/currency-exchange-service.js"></script>
</head>
<body>
    <div class="main-container">
        <h1>Chuyển Đổi Ngoại Tệ</h1>

        <select id="operation" onclick="toggleInput()">
            <option value="buyCash">Mua Tiền Mặt</option>
            <option value="buyTransfer">Mua Chuyển Khoản</option>
            <option value="sell">Bán</option>
        </select>

        <!--Nếu chọn Mua tiền mặt-->
        <div class="input" id="buyCashInput"> 
            <label for="amount">SỐ TIỀN QUÝ KHÁCH CẦN BÁN</label>
            <div class="select-input-container">
                <select id="fromCurrency">
                    <option value="USD">USD</option>
                    <option value="EUR">EUR</option>
                    <option value="GBP">GBP</option>
                    <option value="JPY">JPY</option>
                    <option value="AUD">AUD</option>
                    <option value="SGD">SGD</option>
                    <option value="THB">THB</option>
                    <option value="CAD">CAD</option>
                    <option value="CHF">CHF</option>
                    <option value="HKD">HKD</option>
                    <option value="CNY">CNY</option>
                    <option value="DKK">DKK</option>
                    <option value="INR">INR</option>
                    <option value="KRW">KRW</option>
                    <option value="KWD">KWD</option>
                    <option value="MYR">MYR</option>
                    <option value="NOK">NOK</option>
                    <option value="RUB">RUB</option>
                    <option value="SAR">SAR</option>
                    <option value="SEK">SEK</option>
                </select>                 
        
                <input type="number" id="amount">
            </div>
        </div>

        <div id="buyCashOutput" class="output">
            <label for="amount">SỐ TIỀN QUÝ KHÁCH SẼ NHẬN</label>
            <div class="select-output-container">
                <h4>VND</h4>
                <h4 id="result1"></h4>
            </div>
        </div>

        <!--Nếu chọn Mua chuyên khoản-->
        <div id="buyTransferInput" class="input" style="display:none;">
            <label for="amount">SỐ TIỀN QUÝ KHÁCH CẦN BÁN</label>
            <div class="select-input-container">
                <select id="fromCurrency">
                    <option value="USD">USD</option>
                    <option value="EUR">EUR</option>
                    <option value="GBP">GBP</option>
                    <option value="JPY">JPY</option>
                    <option value="AUD">AUD</option>
                    <option value="SGD">SGD</option>
                    <option value="THB">THB</option>
                    <option value="CAD">CAD</option>
                    <option value="CHF">CHF</option>
                    <option value="HKD">HKD</option>
                    <option value="CNY">CNY</option>
                    <option value="DKK">DKK</option>
                    <option value="INR">INR</option>
                    <option value="KRW">KRW</option>
                    <option value="KWD">KWD</option>
                    <option value="MYR">MYR</option>
                    <option value="NOK">NOK</option>
                    <option value="RUB">RUB</option>
                    <option value="SAR">SAR</option>
                    <option value="SEK">SEK</option>
                </select>                          
        
                <input type="number" id="amount">
            </div>
        </div>

        <div id="buyTransferOutput" class="output" style="display:none;">
            <label for="amount">SỐ TIỀN QUÝ KHÁCH SẼ NHẬN</label>
            <div class="select-output-container">
                <h4>VND</h4>
                <h4 id="result2"></h4>
            </div>
        </div>

        <!--Nếu chọn Bán-->
        <div id="sellInput" class="input" style="display:none;"> 
            <label for="amount">SỐ TIỀN QUÝ KHÁCH CẦN MUA</label>

            <div class="select-input-container">
                <select id="fromCurrency">
                    <option value="USD">USD</option>
                    <option value="EUR">EUR</option>
                    <option value="GBP">GBP</option>
                    <option value="JPY">JPY</option>
                    <option value="AUD">AUD</option>
                    <option value="SGD">SGD</option>
                    <option value="THB">THB</option>
                    <option value="CAD">CAD</option>
                    <option value="CHF">CHF</option>
                    <option value="HKD">HKD</option>
                    <option value="CNY">CNY</option>
                    <option value="DKK">DKK</option>
                    <option value="INR">INR</option>
                    <option value="KRW">KRW</option>
                    <option value="KWD">KWD</option>
                    <option value="MYR">MYR</option>
                    <option value="NOK">NOK</option>
                    <option value="RUB">RUB</option>
                    <option value="SAR">SAR</option>
                    <option value="SEK">SEK</option>
                </select>                          
        
                <input type="number" id="amount">
            </div>
        </div>

        <div id="sellOutput" class="output" style="display:none;">
            <label for="amount">SỐ TIỀN QUÝ KHÁCH SẼ TRẢ</label>
            <div class="select-output-container">
                <h4>VND</h4>
                <h4 id="result3"></h4>
            </div>
        </div>

        <button class="button2" onclick="performCurrencyExchange()">Thực Hiện Giao Dịch</button>
    </div>
</body>
</html>
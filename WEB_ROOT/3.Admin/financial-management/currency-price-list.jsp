<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lấy Tỷ Giá Ngoại Tệ</title>
    <link rel="stylesheet" type="text/css" href="resources/css/financial-management.css"/> 
</head>
<body>
    <div class="main-container">
        <h1>Tỷ Giá Ngoại Tệ</h1>

        <label for="ngay">Ngày (dd/mm/yyyy):</label>
        <input type="text" id="ngay">
        <script>
            function getDate() {
                var today = new Date();
                var dd = String(today.getDate()).padStart(2, '0');
                var mm = String(today.getMonth() + 1).padStart(2, '0');
                var yyyy = today.getFullYear();

                today = dd + '/' + mm + '/' + yyyy;
                document.getElementById('ngay').value = getDate();
            }
        </script>
        <br><br>
        <button onclick="layTyGia()">Lấy Tỷ Giá</button>
        <br><br>
        <table id="ketQua">
            <thead>
                <tr>
                    <th>Mã Ngoại Tệ</th>
                    <th>Tên Ngoại Tệ</th>
                    <th>Mua Tiền Mặt</th>
                    <th>Mua Chuyển Khoản</th>
                    <th>Bán</th>
                </tr>
            </thead>
            <tbody></tbody>
        </table>
    </div>

    <script>
        loadCurrencyPriceList();
    </script>
</body>
</html>
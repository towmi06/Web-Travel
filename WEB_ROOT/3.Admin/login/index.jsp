<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Login Example</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link rel="icon" href="/Web_Travel/2.Service/login/assets/logo.png">
    <link href="https://fonts.googleapis.com/css2?family=Poppins&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/path/to/style.css">
    <link rel="stylesheet" href="/Web_Travel/3.Admin/login/style.css">
</head>

<body>
	<!-- Hiển thị thông báo lỗi nếu có -->
    <% String errorMessage = (String) request.getAttribute("errorMessage"); %>
       	<% if (errorMessage != null && !errorMessage.isEmpty()) { %>
            <script>
                 alert("<%= errorMessage %>");
             </script>
    <% } %>

    <div class="form-wrapper">
        <main class="form-side">
            <a href="#" title="Logo">
                <img src="/Web_Travel/3.Admin/login/assets/logo.png" alt="Laplace Logo" class="logo">
            </a>
            <form class="my-form" method="post" action="/Web_Travel/svlLogin">
                <div class="form-welcome-row">
                    <h1>Chào mừng bạn &#128079;</h1>
                    <h2>Lựa chọn vai trò của bạn</h2>
                </div>
                <div class="socials-row">
                    <input type="radio" id="customer" name="role" value="customer">
                    <label for="customer">Khách hàng</label>
                </div>
                <div class="socials-row">
                    <input type="radio" id="service" name="role" value="service">
                    <label for="service">Nhà Cung Cấp</label>
                </div>
                <div class="socials-row">
                    <input type="radio" id="admin" name="role" value="admin">
                    <label for="admin">Admin</label>
                </div>
                <div class="divider">
                    <div class="divider-line"></div>
                </div>
                <div class="text-field">
                    <label for="email">Email</label>
                    <input type="email" id="email" name="email" autocomplete="off" placeholder="you@gmail.com"
                        required>
                    <div class="error-message">Email in incorrect format</div>
                </div>
                <div class="text-field">
                    <label for="password">Mật khẩu</label>
                    <input id="password" type="password" name="password" placeholder="Mật khẩu">
                </div>
                <button class="my-form__button" type="submit" name="btnLogin">
                    Đăng nhập
                </button>
                <div class="my-form__actions">
                    <div class="my-form__row">
                        <span>Bạn chưa có tài khoản ?</span>
                        <a href="#" title="Reset Password">
                            Đăng ký ngay
                        </a>
                    </div>
                </div>
            </form>
        </main>
        <aside class="info-side"></aside>
    </div>
</body>

</html>
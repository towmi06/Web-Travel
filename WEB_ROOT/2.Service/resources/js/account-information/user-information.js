function loadUserInformation() {
    // Sử dụng XMLHttpRequest hoặc fetch để tải nội dung từ tệp HTML
    var xhr = new XMLHttpRequest();
    xhr.open('GET', 'account-information/user-information.html', true);
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4 && xhr.status == 200) {
            document.getElementById('mainContent').innerHTML = xhr.responseText;
        }
    };
    xhr.send();
}
document.addEventListener('DOMContentLoaded', function() {
    const inforServiceButton = document.getElementById('inforServiceButton');
    const inforServicePage = document.getElementById('inforServicePage');

    inforServiceButton.addEventListener('click', function() {
        togglePage(inforServicePage);
    });

    function togglePage(page) {
        // Nếu trang đã mở, đóng lại
        if (page.style.display === 'block') {
            page.style.display = 'none';
        } else {
            // Nếu trang chưa mở, tắt tất cả các trang khác và mở trang được chọn
            const allPages = document.querySelectorAll('.infor-service');
            allPages.forEach(function(page) {
                page.style.display = 'none';
            });
            page.style.display = 'block';
        }
    }
});
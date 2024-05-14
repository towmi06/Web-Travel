function loadPageLayout() {
    // Sử dụng XMLHttpRequest hoặc fetch để tải nội dung từ tệp HTML
    var xhr = new XMLHttpRequest();
    xhr.open('GET', 'settings-page/page-layout.jsp', true);
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4 && xhr.status == 200) {
            document.getElementById('mainContent').innerHTML = xhr.responseText;
        }
    };
    xhr.send();
}
  

function toggleSubMenu(id) {
    var submenu1 = document.getElementById(id);
    if (submenu1.style.display === "none") {
      submenu1.style.display = "block";
    } else {
      submenu1.style.display = "none";
    }
  }
function loadCustomInterFace() {
    // Sử dụng XMLHttpRequest hoặc fetch để tải nội dung từ tệp HTML
    var xhr = new XMLHttpRequest();
    xhr.open('GET', 'interface-management/interface-layout.html', true);
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4 && xhr.status == 200) {
            document.getElementById('mainContent').innerHTML = xhr.responseText;
            renderImages(); // Gọi hàm renderImages để tải lại ảnh
        }
    };
    xhr.send();
}

//để ẩn hoặc hiển thị một tính năng bằng cách thêm hoặc xóa class "active".
function toggleFeature(feature) {
    var element = document.querySelector('.' + feature);
    var isActive = element.classList.toggle('active');
    if (isActive) {
        saveFeatureState(feature, 'active');
        adjustLayoutOnToggle(feature, true);
    } else {
        saveFeatureState(feature, '');
        adjustLayoutOnToggle(feature, false);
    }
}

//Lưu trạng thái của tính năng vào localStorage.
function saveFeatureState(feature, state) {
    localStorage.setItem(feature, state);
}

//Trả về trạng thái của tính năng từ localStorage.
function getFeatureState(feature) {
    return localStorage.getItem(feature);
}

// Điều chỉnh bố cục của các phần tử khi tính năng được ẩn hoặc hiển thị.
function adjustLayoutOnToggle(feature, isActive) {
    var mainContainer = document.querySelector('.main-container');
    var leftSideBar = document.querySelector('.left-side-bar');
    var rightSideBar = document.querySelector('.right-side-bar');
    
    if (feature === 'header') {
        if (isActive) {
            mainContainer.style.top = '0';
            leftSideBar.style.top = '0';
            rightSideBar.style.top = '0';
        } else {
            mainContainer.style.top = '80px';
            leftSideBar.style.top = '80px';
            rightSideBar.style.top = '80px';
        }
    } else if (feature === 'left-side-bar') {
        if (isActive) {
            mainContainer.style.left = '0';
            mainContainer.style.width = '80%';
        } else {
            mainContainer.style.left = '20%';
            mainContainer.style.width = '60%';
        }
    } else if (feature === 'right-side-bar') {
        if (isActive) {
            mainContainer.style.right = '0';
            mainContainer.style.width = '80%';
        } else {
            mainContainer.style.right = '20%';
            mainContainer.style.width = '60%';
        }
    }
}

//Hàm này được gọi khi trang được tải, và nó khôi phục trạng thái của các tính năng từ localStorage.
window.onload = function() {
    var features = ['header', 'left-side-bar', 'right-side-bar'];
    features.forEach(function(feature) {
        var state = getFeatureState(feature);
        if (state === 'active') {
            document.querySelector('.' + feature).classList.add('active');
            adjustLayoutOnToggle(feature, true);
        }
    });
};
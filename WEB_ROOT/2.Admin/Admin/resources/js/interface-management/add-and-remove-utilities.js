function loadCustomUtilities() {
    // Sử dụng XMLHttpRequest hoặc fetch để tải nội dung từ tệp HTML
    var xhr = new XMLHttpRequest();
    xhr.open('GET', 'interface-management/add-and-remove-utilities.html', true);
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4 && xhr.status == 200) {
            document.getElementById('mainContent').innerHTML = xhr.responseText;
            renderImages(); // Gọi hàm renderImages để tải lại ảnh
        }
    };
    xhr.send();
}

// Bật hoặc ẩn các tính năng
function toggleFeature(feature) {
    var element = document.querySelector('.' + feature);
    var isActive = element.classList.toggle('active');
    
    // Lưu trạng thái của tính năng vào localStorage
    if (isActive) {
        saveFeatureState(feature, 'active');
    } else {
        saveFeatureState(feature, '');
    }
}

// Lưu trạng thái của tính năng vào localStorage
function saveFeatureState(feature, state) {
    localStorage.setItem(feature, state);
}

// Trả về trạng thái của tính năng từ localStorage
function getFeatureState(feature) {
    return localStorage.getItem(feature);
}

// Hàm này được gọi khi trang được tải, và nó khôi phục trạng thái của các tính năng từ localStorage.
window.onload = function() {
    var features = ['search', 'notification', 'setting', 'language', 'map', 'calendar'];
    features.forEach(function(feature) {
        var state = getFeatureState(feature);
        if (state === 'active') {
            document.querySelector('.' + feature).classList.add('active');
        }
    });
};

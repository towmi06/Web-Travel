function loadContentManagement() {
    // Sử dụng XMLHttpRequest hoặc fetch để tải nội dung từ tệp HTML
    var xhr = new XMLHttpRequest();
    xhr.open('GET', 'resource-management/content-management.html', true);
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4 && xhr.status == 200) {
            document.getElementById('mainContent').innerHTML = xhr.responseText;
            renderMap();
        }
    };
    xhr.send();
}

function renderMap() {
    var mapContainer = document.getElementById('map');

    if (mapContainer) {
        // Kiểm tra xem bản đồ đã được khởi tạo trước đó chưa
        if (!mapContainer.hasChildNodes()) {
            // Tạo bản đồ mới chỉ khi chưa có bản đồ trong mapContainer
            var map = L.map('map').setView([22.8265, 104.9835], 8);

            L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
                attribution: '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
            }).addTo(map);

            L.marker([22.8265, 104.9835]).addTo(map)
                .bindPopup('Hà Giang')
                .openPopup();
        } else {
            // Đã có bản đồ trong mapContainer, không cần tạo lại
            console.log('Bản đồ đã được khởi tạo trước đó.');
        }
    } else {
        console.error('Không tìm thấy phần tử có id="map".');
    }
}

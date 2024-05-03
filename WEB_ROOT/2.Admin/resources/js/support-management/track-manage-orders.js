function loadTrackOrders() {
    var xhr = new XMLHttpRequest();
    xhr.open('GET', 'support-management/track-manage-orders.html', true);
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4 && xhr.status == 200) {
            document.getElementById('mainContent').innerHTML = xhr.responseText;
        }
    };
    xhr.send();
}
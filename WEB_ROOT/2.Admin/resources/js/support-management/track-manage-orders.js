function loadTrackOrders() {
    var xhr = new XMLHttpRequest();
    xhr.open('GET', 'support-management/track-manage-orders.jsp', true);
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4 && xhr.status == 200) {
            document.getElementById('mainContent').innerHTML = xhr.responseText;
        }
    };
    xhr.send();
}
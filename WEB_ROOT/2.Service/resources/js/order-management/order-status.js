function loadRevenue() {
    var xhr = new XMLHttpRequest();
    xhr.open('GET', 'orders'.jsp, true);
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4 && xhr.status == 200) {
            document.getElementById('mainContent').innerHTML = xhr.responseText;
            renderCharts2();
        }
    };
    xhr.send();
}
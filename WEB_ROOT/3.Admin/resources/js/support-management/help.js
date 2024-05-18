function loadHelp() {
    var xhr = new XMLHttpRequest();
    xhr.open('GET', 'support-management/help.jsp', true);
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4 && xhr.status == 200) {
            document.getElementById('mainContent').innerHTML = xhr.responseText;
        }
    };
    xhr.send();
}
function loadNotificationMailbox() {
    var xhr = new XMLHttpRequest();
    xhr.open('GET', 'support-management/notification-mailbox.html', true);
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4 && xhr.status == 200) {
            document.getElementById('mainContent').innerHTML = xhr.responseText;
        }
    };
    xhr.send();
}
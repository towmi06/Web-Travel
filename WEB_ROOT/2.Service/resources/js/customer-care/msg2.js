document.addEventListener('DOMContentLoaded', function() {
    const notifButton = document.getElementById('notifButton');
    const notificationPagemsg = document.getElementById('notificationPagemsg');

    notifButton.addEventListener('click', function() {
        toggleNotificationPagemsg(notificationPagemsg);
    });

    function toggleNotificationPagemsg(page) {
        if (page.style.display === 'block') {
            page.style.display = 'none';
        } else {
            const allPages = document.querySelectorAll('.notification-pagemsg');
            allPages.forEach(function(p) {
                p.style.display = 'none';
            });
            page.style.display = 'block';
        }
    }
});

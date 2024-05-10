function toggleDropdown() {
    var dropdownMenu = document.getElementById("dropdown-menu");
    dropdownMenu.classList.toggle("open");
}
function toggleDropdown() {
    var dropdownMenu = document.getElementById("dropdown-menu");
    dropdownMenu.classList.toggle("open");
}

// Bắt sự kiện khi click ra ngoài dropdown
window.addEventListener('click', function(event) {
    var dropdownMenu = document.getElementById("dropdown-menu");
    if (!event.target.matches('.dropdown-toggle')) {
        if (dropdownMenu.classList.contains('open')) {
            dropdownMenu.classList.remove('open');
        }
    }
});

// Bắt sự kiện khi click vào một mục trong dropdown
document.querySelectorAll('.dropdown-content a').forEach(function(item) {
    item.addEventListener('click', function() {
        var dropdownMenu = document.getElementById("dropdown-menu");
        dropdownMenu.classList.remove('open');
    });
});

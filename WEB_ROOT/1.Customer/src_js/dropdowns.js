document.addEventListener("DOMContentLoaded", function() {
    var dropdownBtn = document.querySelector(".dropbtn");
    var dropdownContent = document.getElementById("dropdown-content");

    // Khi người dùng di chuột qua hoặc nhấp vào mục tiện ích
    dropdownBtn.addEventListener("mouseover", function() {
        showDropdown();
    });

    dropdownBtn.addEventListener("click", function() {
        toggleDropdown();
    });

    // Khi người dùng di chuột ra khỏi mục tiện ích
    dropdownContent.addEventListener("mouseleave", function() {
        hideDropdown();
    });

    // Hiển thị dropdown
    function showDropdown() {
        dropdownContent.style.display = "block";
    }

    // Ẩn dropdown
    function hideDropdown() {
        dropdownContent.style.display = "none";
    }

    // Chuyển đổi trạng thái hiển thị của dropdown
    function toggleDropdown() {
        if (dropdownContent.style.display === "block") {
            hideDropdown();
        } else {
            showDropdown();
        }
    }
});

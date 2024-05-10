// Lấy input và dropdown menu tương ứng
const searchInput = document.getElementById('searchInput');
const locationDropdown = document.querySelector('.localtion .dropdown-menu');

// Thêm sự kiện click vào input
searchInput.addEventListener('click', function() {
    // Kiểm tra trạng thái hiện tại của dropdown menu
    const displayStyle = getComputedStyle(locationDropdown).display;

    // Nếu dropdown menu đang ẩn, hiển thị nó
    if (displayStyle === 'none') {
        locationDropdown.style.display = 'block';
    } else {
        // Nếu dropdown menu đang hiển thị, ẩn nó đi
        locationDropdown.style.display = 'none';
    }
});

// Lấy tất cả các mục trong dropdown menu
const dropdownItems = document.querySelectorAll('.localtion .dropdown-menu .SearchBox_dropdown-item');

// Lặp qua từng mục để gắn sự kiện click
dropdownItems.forEach(item => {
    item.addEventListener('click', function() {
        // Lấy nội dung của mục được chọn
        const selectedOption = this.textContent;
        
        // Hiển thị nội dung đã chọn trong input
        searchInput.value = selectedOption;

        // Ẩn dropdown menu sau khi chọn
        locationDropdown.style.display = 'none';
    });
});

// Lấy input và dropdown menu tương ứng cho mức giá
const priceInput = document.getElementById('priceInput');
const priceDropdown = document.querySelector('.Price .dropdown-menu');

// Thêm sự kiện click vào input cho mức giá
priceInput.addEventListener('click', function() {
    // Kiểm tra trạng thái hiện tại của dropdown menu
    const displayStyle = getComputedStyle(priceDropdown).display;

    // Nếu dropdown menu đang ẩn, hiển thị nó
    if (displayStyle === 'none') {
        priceDropdown.style.display = 'block';
    } else {
        // Nếu dropdown menu đang hiển thị, ẩn nó đi
        priceDropdown.style.display = 'none';
    }
});

// Lấy tất cả các mục trong dropdown menu của mức giá
const priceDropdownItems = document.querySelectorAll('.Price .dropdown-menu .SearchBox_dropdown-item');

// Lặp qua từng mục để gắn sự kiện click
priceDropdownItems.forEach(item => {
    item.addEventListener('click', function() {
        // Lấy nội dung của mục được chọn
        const selectedOption = this.textContent;
        
        // Hiển thị nội dung đã chọn trong input
        priceInput.value = selectedOption;

        // Ẩn dropdown menu sau khi chọn
        priceDropdown.style.display = 'none';
    });
});

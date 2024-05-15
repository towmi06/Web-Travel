function loadContactInFor() {
    // Sử dụng XMLHttpRequest hoặc fetch để tải nội dung từ tệp HTML
    var xhr = new XMLHttpRequest();
    xhr.open('GET', 'contact-info/contact-information-social-media-links.jsp', true);
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4 && xhr.status == 200) {
            document.getElementById('mainContent').innerHTML = xhr.responseText;
        }
    };
    xhr.send();
}


function loadContactEditPage() {
	// Sử dụng XMLHttpRequest hoặc fetch để tải nội dung từ tệp HTML
	var xhr = new XMLHttpRequest();
	xhr.open('GET', 'contact-info/contact-information-social-media-links-edit.jsp', true);
	xhr.onreadystatechange = function () {
		if (xhr.readyState == 4 && xhr.status == 200) {
			document.getElementById('mainContent').innerHTML = xhr.responseText;
	    }
	};
	xhr.send();
}
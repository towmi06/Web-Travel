document.addEventListener("DOMContentLoaded", function() {
    var selectElement = document.getElementById("countries");
    var flagImage = document.querySelector(".selected-flag");

    selectElement.addEventListener("change", function() {
        var selectedOption = selectElement.options[selectElement.selectedIndex];
        var imageCSS = selectedOption.getAttribute("data-imagecss");
        flagImage.src = imageCSS;
    });
});

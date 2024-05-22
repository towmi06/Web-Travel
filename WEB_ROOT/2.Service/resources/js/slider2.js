var SlideShow2 = function() {
  
  var
    slider2,
    slides2,
    nextButton2,
    prevButton2,
    dots2,
    slideAmount2,
    currentIndex2;
  
  var _init = function () {
    slider2      = document.querySelector('.slider2');
    slides2      = document.querySelectorAll('.slide2');
    slideAmount2 = slides2.length;
    nextButton2  = document.querySelector('.next2');
    prevButton2  = document.querySelector('.prev2');   
    dots2       = document.querySelectorAll('.dot2'); 
    currentIndex2 = 0;
    
    _eventHandlers2();
    showSlides2(currentIndex2);
  }
  
  var _eventHandlers2 = function() {
    nextButton2.addEventListener('click', function() { _slideNext2(2); });
    prevButton2.addEventListener('click', function() { _slidePrev2(-2); });
    dots2.forEach(function(dot2, index) {
      dot2.addEventListener('click', function() { currentSlide2(index + 1); });
    });
  } 
  
  var _slideNext2 = function(n) {  
    showSlides2(currentIndex2 += n);  
  }
  
  var _slidePrev2= function(n) {
    showSlides2(currentIndex2 -= n);
  }
  
  var showSlides2 = function(n) {
    var i;
    if (n >= slideAmount2) { currentIndex2 = 0; }
    if (n < 0) { currentIndex2 = slideAmount2 - 2; }
    for (i = 0; i < slideAmount2; i++) {
        slides2[i].style.display = "none";  
    }
    for (i = 0; i < dots2.length; i++) {
        dots2[i].className = dots2[i].className.replace(" active", "");
    }
    slides2[currentIndex2].style.display = "block";  
    slides2[currentIndex2 + 1].style.display = "block";
    dots2[currentIndex2/2].className += " active";
  }

  var currentSlide2 = function(n) {
    showSlides2(currentIndex2 = (n - 1) * 2);
  }
  
  return {
    init: _init
  }
  
}();

SlideShow2.init();
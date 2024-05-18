var SlideShow = function() {
  
  var
    slider,
    slides,
    nextButton,
    prevButton,
    dots,
    slideAmount,
    currentIndex;
  
  var _init = function () {
    slider      = document.querySelector('.slider');
    slides      = document.querySelectorAll('.slide');
    slideAmount = slides.length;
    nextButton  = document.querySelector('.next');
    prevButton  = document.querySelector('.prev');   
    dots        = document.querySelectorAll('.dot'); 
    currentIndex = 0;
    
    _eventHandlers();
    showSlides(currentIndex);
  }
  
  var _eventHandlers = function() {
    nextButton.addEventListener('click', function() { _slideNext(2); });
    prevButton.addEventListener('click', function() { _slidePrev(-2); });
    dots.forEach(function(dot, index) {
      dot.addEventListener('click', function() { currentSlide(index + 1); });
    });
  } 
  
  var _slideNext = function(n) {  
    showSlides(currentIndex += n);  
  }
  
  var _slidePrev = function(n) {
    showSlides(currentIndex -= n);
  }
  
  var showSlides = function(n) {
    var i;
    if (n >= slideAmount) { currentIndex = 0; }
    if (n < 0) { currentIndex = slideAmount - 2; }
    for (i = 0; i < slideAmount; i++) {
        slides[i].style.display = "none";  
    }
    for (i = 0; i < dots.length; i++) {
        dots[i].className = dots[i].className.replace(" active", "");
    }
    slides[currentIndex].style.display = "block";  
    slides[currentIndex + 1].style.display = "block";
    dots[currentIndex/2].className += " active";
  }

  var currentSlide = function(n) {
    showSlides(currentIndex = (n - 1) * 2);
  }
  
  return {
    init: _init
  }
  
}();

SlideShow.init();

document.addEventListener('DOMContentLoaded', function() {
  const dropdownToggles = document.querySelectorAll('.dropdown-toggle');

  dropdownToggles.forEach(function(toggle) {
    toggle.addEventListener('click', function() {
      this.classList.toggle('active');
    });
  });

  const closeSidebar = document.querySelector('.close-sidebar');
  const leftSidebar = document.querySelector('.left-side-bar');
  const mobileMenuOverlay = document.querySelector('.mobile-menu-overlay');

  closeSidebar.addEventListener('click', function() {
    leftSidebar.classList.remove('open');
    mobileMenuOverlay.style.display = 'none';
  });

  document.addEventListener('click', function(event) {
    if (!leftSidebar.contains(event.target) && !event.target.classList.contains('ion-close-round')) {
      leftSidebar.classList.remove('open');
      mobileMenuOverlay.style.display = 'none';
    }
  });
});

//đảo ngược chevron-down
function toggleChevron(iconId) {
  const chevronIcon = document.getElementById(iconId);
  chevronIcon.classList.toggle('active');
}

function toggleSubMenu(element) {
  element.querySelector('.submenu').classList.toggle('active');
}

//Hightchart Table
$(document).ready(function() {
  $('table.highchart').highchartTable();
});
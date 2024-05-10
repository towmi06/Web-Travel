document.addEventListener('DOMContentLoaded', function() {
	const dropdownToggles = document.querySelectorAll('.dropdown-toggle');
  
	dropdownToggles.forEach(function(toggle) {
	  toggle.addEventListener('click', function() {
		this.classList.toggle('active');
	  });
	});
  
	const closeSidebar = document.querySelector('.close-sidebar');
	const leftSidebar = document.querySelector('.left-side-bar');
  const rightBar = document.querySelector('.right-bar');
	const mobileMenuOverlay = document.querySelector('.mobile-menu-overlay');
  
	closeSidebar.addEventListener('click', function() {
	  leftSidebar.classList.remove('open');
    rightBar.classList.remove('open')
	  mobileMenuOverlay.style.display = 'none';
	});
  
	document.addEventListener('click', function(event) {
	  if (!leftSidebar.contains(event.target) && !event.target.classList.contains('ion-close-round')) {
		leftSidebar.classList.remove('open');
    rightBar.classList.remove('open')
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
  
//Hiển thị  notificationPage || adminPage khi click vào nút setting và ngược lại
document.addEventListener('DOMContentLoaded', function() {
    const notificationButton = document.getElementById('notificationButton');
    const notificationPage = document.getElementById('notificationPage');
	const adminButton = document.getElementById('adminButton');
    const adminPage = document.getElementById('adminPage');
    notificationButton.addEventListener('click', function() {
        togglePage(notificationPage);
    });

	adminButton.addEventListener('click', function() {
        togglePage(adminPage);
    });

    function togglePage(page) {
        if (page.style.display === 'block') {
            page.style.display = 'none';
        } else {
            const allPages = document.querySelectorAll('.notification-page' , '.admin-page');
            allPages.forEach(function(page) {
                page.style.display = 'none';
            });
            page.style.display = 'block';
        }
    }
});


//Bật dark mode
function toggleDarkMode() {
  var darkModeStyle = document.getElementById('dark-mode-style');
  var body = document.body;
  var header = document.querySelector('.header');
  var title = document.querySelector('.title');
  var searchBar = document.querySelector('.search-input');
  var leftSideBar = document.querySelector('.left-side-bar')
  var mainContainer = document.querySelector('.main-container');
  var rightSideBar = document.querySelector('.right-side-bar');
  var notification = document.querySelector('.notification');
  var setting = document.querySelector('.setting');
  var adminButton = document.querySelector('.admin');
  var adminPage = document.querySelector('.admin-page');
  var adminPageButton = document.querySelectorAll('.admin-page-button');
  var adminPageName = document.querySelector('.admin-page-name');
  var notificationPage = document.querySelector('.notification-page');
  var settingPage = document.querySelector('.settings-page');
  var settingPageButtons = document.querySelectorAll('.settings-page-button');
  var dropdownToggle = document.querySelectorAll('.dropdown-toggle');
  var sideBarMenu = document.querySelector('sidebar-menu');
  // Thêm hoặc loại bỏ lớp dark-mode từ body
  body.classList.toggle('dark-mode');
  header.classList.toggle('dark-mode');
  title.classList.toggle('dark-mode');
  searchBar.classList.toggle('dark-mode');
  leftSideBar.classList.toggle('dark-mode');
  mainContainer.classList.toggle('dark-mode');
  rightSideBar.classList.toggle('dark-mode');
  notification.classList.toggle('dark-mode');
  setting.classList.toggle('dark-mode');
  adminButton.classList.toggle('dark-mode');
  adminPage.classList.toggle('dark-mode');
  notificationPage.classList.toggle('dark-mode');
  settingPage.classList.toggle('dark-mode');
  adminPageName.classList.toggle('dark-mode');
  sideBarMenu.classList.toggle('dark-mode');
  dropdownToggle.forEach(function(button) {
    button.classList.toggle('dark-mode');
  });
  adminPageButton.forEach(function(button) {
    button.classList.toggle('dark-mode');
  });
  settingPageButtons.forEach(function(button) {
    button.classList.toggle('dark-mode');
  });
}

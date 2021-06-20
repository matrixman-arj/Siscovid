var DECEX = DECEX || {};

DECEX.onSidebarToggleRequest = function(event) {
  event.preventDefault();
  $(this).blur();

  $('.js-sidebar, .js-content').toggleClass('is-toggled');
};

DECEX.onSearchModalShowRequest = function(event) {
  event.preventDefault();

  $('.js-search-modal').fadeIn('slow');
  $('body').addClass('decex-no-scroll');
  
  $('.js-search-modal-input').val('').select();
  
};

DECEX.onSearchModalCloseRequest = function(event) {
  event.preventDefault();

  $('.js-search-modal').hide();
  $('body').removeClass('decex-no-scroll');
};

//DECEX.onFormLoadingSubmit = function(event) {
  //event.preventDefault();

  //DECEX.showLoadingComponent();

  //setTimeout(function() {
  //  DECEX.hideLoadingComponent();
  //}, 2000);
//};

DECEX.showLoadingComponent = function() {
  $('.js-loading-overlay').css('display', 'table').hide().fadeIn('slow');
};

DECEX.hideLoadingComponent = function() {
  $('.js-loading-component').fadeOut('fast');
};

DECEX.initStickyTableHeaders = function() {
  if ($(window).width() >= 992) { 
    var stickyRef = $('.js-sticky-reference');
    var stickyTable = $('.js-sticky-table');

    if (stickyRef && stickyTable) {
      stickyTable.stickyTableHeaders({fixedOffset: stickyRef});
    }
  }
};

DECEX.onMenuGroupClick = function(event) {
  var subItems = $(this).parent().find('ul');

  if (subItems.length) {
    event.preventDefault();
    $(this).parent().toggleClass('is-expanded');
  }
};

DECEX.initMenu = function() {
  $('.js-menu > ul > li > a').bind('click', DECEX.onMenuGroupClick);
  $('.decex-menu__item .is-active').parents('.decex-menu__item').addClass('is-expanded is-active');
};

$(function() {
  if (DECEX.init) {
    DECEX.init();
  }

  DECEX.initMenu();
  DECEX.initStickyTableHeaders();
  
  // Enable Bootstrap tooltip
  $('.js-tooltip').tooltip();
  
  // Bind events
  $('.js-sidebar-toggle').bind('click', DECEX.onSidebarToggleRequest);
  $('.js-search-modal-trigger-show').bind('click', DECEX.onSearchModalShowRequest);
  $('.js-search-modal-close').bind('click', DECEX.onSearchModalCloseRequest);
  //$('.js-form-loading').bind('submit', DECEX.onFormLoadingSubmit);
});
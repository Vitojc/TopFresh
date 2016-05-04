jQuery(document).ready(function ($) {
    //居中
    $(window).resize(function () {
        $('.mycenter').css({
            position: 'fixed',
            left: ($(window).width() - $('.mycenter').outerWidth()) / 2,
            top: ($(window).height() - $('.mycenter').outerHeight()) * 0.3 + $(document).scrollTop()
        });
    });
    $(window).resize();
});
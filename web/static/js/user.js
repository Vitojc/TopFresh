jQuery(document).ready(function ($) {
    //居中
    $(window).resize(function () {
        //duplicate jquery selector：IDEA提示重复的选择器，应缓存起来
        var myCenter = $('.mycenter');
        myCenter.css({
            position: 'fixed',
            left: ($(window).width() - myCenter.outerWidth()) / 2,
            top: ($(window).height() - myCenter.outerHeight()) * 0.3 + $(document).scrollTop()
        });
    });
    $(window).resize();

    //active
    if (typeof (addMyClass) == 'function')addMyClass();
});
$(function () {
    $('.collapse_all').on('show.bs.collapse',function () {
        var a = $('.collapse_all').prev();
        var i =a.children();
        i.removeClass('icon-21');
        i.addClass('icon-758bianjiqi_fengexian');
    })
    $('.collapse_all').on('hidden.bs.collapse',function () {
        var a = $('.collapse_all').prev();
        var i =a.children();
        i.removeClass('icon-758bianjiqi_fengexian');
        i.addClass('icon-21');
    })

    $(".collapse_all > li > a ").click(function (element) {
        element.preventDefault();//禁用a标签
        var $this = $(this);
        $(".collapse_all > li > a").removeClass("navactive");
        $this.addClass("navactive");
        $("#iframe-contant").attr('src',$this.data("iframesrc"))

        var text = $this.text();

        var pre_text =  $this.parent().parent().prev().text();

        $('#path_nav > .breadcrumb > li:last-child').html(text);
        $('#path_nav > .breadcrumb > li:last-child').prev().html(pre_text);
    })


});
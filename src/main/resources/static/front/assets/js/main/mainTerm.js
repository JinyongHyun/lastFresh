let $tit = $('.box_tit');
let $view = $('.box_view');

$tit.each(function (i, e) {
    $(e).click(function () {
        $($view[i]).slideToggle("slow");
    });
});
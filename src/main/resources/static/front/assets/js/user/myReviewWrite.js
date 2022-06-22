$('.link').each(function (i,btn) {
    $(btn).on("click",function () {
        $($(".layer").get(i)).show();
    })
})

$('.btn_ok').each(function (i,ok) {
    $(ok).on("click",function () {
        $($(".layer").get(i)).hide();
    })
})

$('.btn_close').each(function (i,close) {
    $(close).on("click",function () {
        $($(".layer").get(i)).hide();
    })
})
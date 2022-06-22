$('.btn_choice').each(function (i,btn) {
    $(btn).on("click",function () {
        $($(".layer").get(i)).show();
        $($(".bg_dim").get(i)).show();
    })
})

$('.btn_ok').each(function (i,ok) {
    $(ok).on("click",function () {
        $($(".layer").get(i)).hide();
        $($(".bg_dim").get(i)).hide();
    })
})

$('.btn_close').each(function (i,close) {
    $(close).on("click",function () {
        $($(".layer").get(i)).hide();
        $($(".bg_dim").get(i)).hide();
    })
})
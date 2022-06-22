$("a.layout-pagination-number").click(function (e) {
    e.preventDefault();
    if($(this).find("code").attr("id") == "nowPage"){return;}
    $(pageForm).find("input[name='pageNum']").val($(this).attr("href"));
    $(pageForm).submit();
})

$(".pagination-number").each(function (i,page) {
    if(pageNum==$(page).children().text()){
        $(page).addClass("__active");
    };
})


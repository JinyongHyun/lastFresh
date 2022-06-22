let $sideSnb = $('.inner_snb li a');

$.each($sideSnb, function (i, e) {
    let index = 0;
    $(e).click(function () {
        index = i

        for (let j = 0; j < $sideSnb.length; j++){
            $sideSnb[j].classList.remove("menuClicked")
        }

        $sideSnb[index].classList.add("menuClicked");
    });
});

/*div 높이 변화시, 전체 높이 변경*/
let $pageDiv = $('.page_section');

$pageDiv.change(function () {
    let height = $('.page_section').height() + 100;

    $('.sellMenuRegister').css("height", height);
});

/*페이지 이동*/
$("a.changePage").click(function(e){
    e.preventDefault();
    $(pageForm).find("input[name='pageNum']").val($(this).attr("href"));
    let $pageNum = $('.page-pageNum').val();
    console.log($pageNum);
    let $amount = $('.page-amount').val();
    console.log($amount);
    console.log(($pageNum - 1) * $amount);
    $('.page-limit').val(($pageNum - 1) * $amount);
    $(pageForm).submit();
});

//등록된 메뉴 삭제
// let pageInfo = [[${pageDTO.criteria.listLink}]];
$("#deleteForm .product-delete").on("click", function(e){
    e.preventDefault();
    let sellProductNum = $(this).find('a').attr("href");

    $('input[name=sellProductNum]').val(sellProductNum);

    $('#deleteForm').submit();
});

/* 메뉴 수정 */
$("#modifyForm .product-modify").on("click", function(e){
    e.preventDefault();
    let sellProductNum = $(this).find('a').attr("href");

    $('input[name=sellProductNum]').val(sellProductNum);

    $('#modifyForm').submit();
});


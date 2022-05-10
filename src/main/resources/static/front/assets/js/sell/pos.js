/* 조리 시간 닫기 버튼*/
let $closeBtn = $('.cookingTime-close-btn');

/* 조리 시간 모달창*/
let $cookingModal = $('.cookingTime-wrapper');

/* 조리 시간*/
let $cookingTime = $('.cookingTime-real-wrapper');

/* 접수 버튼*/
let $receptionBtn = $('.order-reception-btn');

/* 조리 시간 리셋 버튼*/
let $resetBtn = $('.cookingTime-reset');

/* 조리 시간 플러스 버튼*/
let $plusBtn = $('.cookingTime-plus');

/* 조리 시간 마이너스 버튼*/
let $minusBtn = $('.cookingTime-minus');

/* 조리 시간 리얼 타임*/
let cookingTime = 0;

/* 사이드바 메뉴들*/
let $sideBars = $('.sideBars');


/* 조리 시간 닫기*/
$closeBtn.on("click", function () {
    $cookingModal.hide();
    cookingTime = 0;
    $cookingTime.find('.cookingTime-real').text(cookingTime);
});

/* 조리 시간 열기*/
$receptionBtn.on("click", function () {
    $cookingModal.show();
});

/* 조리 시간 리셋*/
$resetBtn.on("click", function () {
    cookingTime = 0;
    $cookingTime.find('.cookingTime-real').text(cookingTime);
});

/* 조리 시간 늘리기*/
$plusBtn.on("click", function () {
    cookingTime += 10;
    $cookingTime.find('.cookingTime-real').text(cookingTime);
});

/* 조리 시간 줄이기*/
$minusBtn.on("click", function () {
    if(cookingTime == 0){return;}
    cookingTime -= 10;
    $cookingTime.find('.cookingTime-real').text(cookingTime);
});

$.each($sideBars, function (i, e) {
    let index = 0;
    $(e).click(function () {
        index = i

        for (let j = 0; j < $sideBars.length; j++){
            $sideBars[j].classList.remove("sellClicked")
        }

        $sideBars[index].classList.add("sellClicked");
    });
});
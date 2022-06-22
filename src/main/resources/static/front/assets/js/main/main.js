let cart = $(".cart_option");
let button = $(".half");
let submit = $(".submit");

// $(submit).click(function () {
//     let receiveMethod=parseInt($(".receiveMethodHidden").val());
//
//     console.log(receiveMethod)
//
//     if(receiveMethod=="0"){
//         alert("옵션을 선택해주세요")
//         return false;
//
//     }else {
//         alert("장바구니에 상품을 담았습니다.")
//     }
// });

$(".innerLatChanceCart").click(function () {
    $(cart).removeClass("off");
    $(cart).css("opacity", "1");
    $(".bg_loading").css("display", "block");
    $("#cartPut").css("display", "block");
});

$(".innerCart").click(function () {
    $(cart).removeClass("off");
    $(cart).css("opacity", "1");
    $(".bg_loading").css("display", "block");
    $("#cartPut").css("display", "block");
});

$(button).click(function () {
    $(cart).addClass("off");
    $(cart).css("opacity", "0");
    $(".bg_loading").css("display", "none");
    $(".basketQuantity").val(1);
    $("#pickUpB").css("opacity", "0.2").css("border", "none").css("background-color", "black")
    $("#deliveryB").css("opacity", "0.2").css("border", "none").css("background-color", "black")
    $("#shippingB").css("opacity", "0.2").css("border", "none").css("background-color", "black")
    parseInt($(".receiveMethodHidden").val(0));
    //픽업 status
        $("#pickUpB").css("display", "");
        $(".receiveMethod").css("padding-left", "");
    //배달 status
        $("#deliveryB").css("display", "");
        $(".receiveMethod").css("padding-left", "");
    //배송 status
        $("#shippingB").css("display", "");
        $(".receiveMethod").css("padding-left", "");
});

//마감날짜
let today = new Date();
let year = today.getFullYear(); // 년도
let month = today.getMonth() + 1;  // 월
let date = today.getDate();  // 날짜
let calender = "&nbsp;" + "&nbsp;" + "~" + year + "/" + month + "/" + date
document.getElementById("lastChanceDate").innerHTML = calender
console.log("calender", calender)

//장바구니 가격 표시
function  AddComma(num)
{
    let regexp = /\B(?=(\d{3})+(?!\d))/g;
    return num.toString().replace(regexp, ',');
}


$(".toBasket").each(function (i, item) {
    let price = AddComma($(".newPrice")[i].innerHTML);
    let beforePrice = ($(".dcPriceNum")[i].innerHTML);
    let beforePriceWithCom =AddComma ($(".dcPriceNum")[i].innerHTML);
    let productName = ($(".productName")[i].innerHTML);
    let pno = ($(".pno")[i].innerHTML);
    let stocks = ($(".stocks")[i].innerHTML);
    let pickUpStatus = ($(".pickUpStatus")[i].innerHTML);
    let deliveryStatus = ($(".deliveryStatus")[i].innerHTML);
    let shippingStatus = ($(".shippingStatus")[i].innerHTML);

    $(this).click(function () {
        //상품명
        $(".name").html(productName);
        //상품 번호
        $(".pnoHidden").val(pno);
        //상품 최대 개수
        $(".stocksHidden").val(stocks);
        //상품 개수
        $(".basketQuantity").val(1);
        //옵션 선택
        parseInt($(".receiveMethodHidden").val(0));
        //픽업 status
        if(pickUpStatus==1){
            $("#pickUpB").css("display", "none");
            $(".receiveMethod").css("padding-left", "203px");
        }
        //배달 status
        if(deliveryStatus==0){
            $("#deliveryB").css("display", "none");
            $(".receiveMethod").css("padding-left", "203px");
        }
        //배송 status
        if(shippingStatus==0){
            $("#shippingB").css("display", "none");
            $(".receiveMethod").css("padding-left", "203px");
        }
        //픽업 배달status
        if(pickUpStatus==1&deliveryStatus==0){
            $("#pickUpB").css("display", "none");
            $(".receiveMethod").css("padding-left", "250px");
        }
        //배달 배송status
        if(deliveryStatus==0&shippingStatus==0){
            $("#deliveryB").css("display", "none");
            $(".receiveMethod").css("padding-left", "250px");
        }
        //배송 픽업status
        if(shippingStatus==0&pickUpStatus==1){
            $("#shippingB").css("display", "none");
            $(".receiveMethod").css("padding-left", "250px");
        }
        //일반 금액
        $(".dc_price").html(price);
        $(".fixedHiddenNum").val(beforePrice);
        //합계 전 가격
        $(".num").html(beforePriceWithCom);
        $(".totalMoneyHidden").val(beforePrice);
    })
});

// 더하기/빼기
function count(type) {
    // 더하기/빼기
    let afterPrice = $(".num");
    let resultElement = $(".basketQuantity");
    let number = $(".basketQuantity").val();
    let hiddenAfPrice = $(".totalMoneyHidden");
    let hiddenTotalPrice = parseInt($(".totalMoneyHidden").val());
    let fixedHiddenNum = parseInt($(".fixedHiddenNum").val());
    let maxStock=parseInt($(".stocksHidden").val());
    let total;
    if (type === 'plus') {
        number = parseInt(number) + 1;
        total = hiddenTotalPrice + fixedHiddenNum;
        if (number ==  maxStock+1) {
            return false
        }
    } else if (type === 'minus') {
        number = parseInt(number) - 1;
        total = hiddenTotalPrice - fixedHiddenNum;
        if (number ==0) {
            return
        }
    }
    resultElement.val(number);
    hiddenAfPrice.val(total);
    afterPrice.html(AddComma(total));
}
// 전달방식
document.getElementById("pickUpB").addEventListener("click", function () {
    $("#pickUpB").css("opacity", "1").css("border", "2px solid  #DA291C").css("background-color", "#DA291C")
    $("#deliveryB").css("opacity", "0.2").css("border", "none").css("background-color", "black")
    $("#shippingB").css("opacity", "0.2").css("border", "none").css("background-color", "black")
    $(".receiveMethodHidden").val(1)
   
})
document.getElementById("deliveryB").addEventListener("click", function () {
    $("#deliveryB").css("opacity", "1").css("border", "2px solid  #DA291C").css("background-color", "#DA291C")
    $("#pickUpB").css("opacity", "0.2").css("border", "none").css("background-color", "black")
    $("#shippingB").css("opacity", "0.2").css("border", "none").css("background-color", "black")
    $(".receiveMethodHidden").val(2)
   
})
document.getElementById("shippingB").addEventListener("click", function () {
    $("#shippingB").css("opacity", "1").css("border", "2px solid  #DA291C").css("background-color", "#DA291C")
    $("#pickUpB").css("opacity", "0.2").css("border", "none").css("background-color", "black")
    $("#deliveryB").css("opacity", "0.2").css("border", "none").css("background-color", "black")
    $(".receiveMethodHidden").val(3)

})

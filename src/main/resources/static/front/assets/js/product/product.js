var width = 500; //팝업의 너비
var height = 600; //팝업의 높이

// 주소 찾기(Daum API)
function find() {
    new daum.Postcode({
        width: width, //생성자에 크기 값을 명시적으로 지정
        height: height,

        oncomplete: function (data) {
            var addr = ''; // 주소 변수
            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                addr = data.roadAddress;
            } else { // 사용자가 지번 주소를 선택했을 경우(J)
                addr = data.jibunAddress;
            }

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('zipcode').value = data.zonecode;
            document.getElementById("address").value = addr;
            // 커서를 상세주소 필드로 이동한다.
            document.getElementById("addressDetail").focus();
        }
    }).open({
        left: (window.screen.width / 2) - (width / 2),
        top: (window.screen.height / 2) - (height / 2)
    });

}


$(document).ready(function(){
    //sido option 추가
    $.each(hangjungdong.sido, function(idx, code){
        //append를 이용하여 option 하위에 붙여넣음
        $('#sido').append(fn_option(code.sido, code.codeNm));
    });

    //sido 변경시 시군구 option 추가
    $('#sido').change(function(){
        $('#sigugun').show();
        $('#sigugun').empty();
        $('#sigugun').append(fn_option('','선택')); //
        $.each(hangjungdong.sigugun, function(idx, code){
            if($('#sido > option:selected').val() == code.sido)
                $('#sigugun').append(fn_option(code.sigugun, code.codeNm));
        });

        //세종특별자치시 예외처리
        //옵션값을 읽어 비교
        if($('#sido option:selected').val() == '36'){
            $('#sigugun').hide();
            //index를 이용해서 selected 속성(attr)추가
            //기본 선택 옵션이 최상위로 index 0을 가짐
            $('#sigugun option:eq(1)').attr('selected', 'selected');
            //trigger를 이용해 change 실행
            $('#sigugun').trigger('change');
        }
    });

    //시군구 변경시 행정동 옵션추가
    $('#sigugun').change(function(){
        //option 제거
        $('#dong').empty();
        $.each(hangjungdong.dong, function(idx, code){
            if($('#sido > option:selected').val() == code.sido && $('#sigugun > option:selected').val() == code.sigugun)
                $('#dong').append(fn_option(code.dong, code.codeNm));
        });
        //option의 맨앞에 추가
        $('#dong').prepend(fn_option('','선택'));
        //option중 선택을 기본으로 선택
        $('#dong option:eq("")').attr('selected', 'selected');

    });

    $('#dong').change(function(){
        var sido = $('#sido option:selected').val();
        var sigugun = $('#sigugun option:selected').val();
        var dong = $('#dong option:selected').val();
        var dongCode = sido + sigugun + dong + '00';

    });
});

function fn_option(code, name){
    return '<option value="' + code +'">' + name +'</option>';

}
///////////////////////////////////////////////////////////
var cart = $(".cart_option");
var cart1 = $(".cart_option1");

var button = $(".cancel");
var button1 = $(".cancel1");
let submit = $(".submit");
$(submit).click(function () {
    let receiveMethod=parseInt($(".receiveMethodHidden").val());

    if(receiveMethod=="0") {
        alert("옵션을 선택해주세요");
        return false;
    }if(userNumber==null){
        alert("로그인 후 이용하실 수 있습니다.");
        return false;
    }else {
        alert("장바구니에 상품을 담았습니다.")
    }
});

$(".group_btn").click(function(){
    $(cart).removeClass("off");
    $(cart).css("opacity", "1");
    $(".bg_loading").css("display", "block");
});
$(".areabutton").click(function(){
    $(cart1).removeClass("off");
    $(cart1).css("opacity", "1");
    $(".bg_loading").css("display", "block");
});

$(button).click(function(){
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

$(button1).click(function(){
    $(cart1).addClass("off");
    $(cart1).css("opacity", "0");
    $(".bg_loading").css("display", "none");
});
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

//장바구니 가격 표시
function  AddComma(num)
{
    let regexp = /\B(?=(\d{3})+(?!\d))/g;
    return num.toString().replace(regexp, ',');
}
$(".btn_cart").each(function (i, item) {
    let price = AddComma(($(".dcPriceNum")[i].innerHTML));
    let beforePrice = parseInt($(".dcPriceNum")[i].innerHTML);
    let pno = ($(".pno")[i].innerHTML);
    let stocks = ($(".stocks")[i].innerHTML);
    let pickUpStatus = ($(".pickUpStatus")[i].innerHTML);
    let deliveryStatus = ($(".deliveryStatus")[i].innerHTML);
    let shippingStatus = ($(".shippingStatus")[i].innerHTML);
    let productName = ($(".name")[i].innerHTML);
    console.log(pickUpStatus)
    console.log(shippingStatus)
    console.log(deliveryStatus)


    $(this).click(function () {
        //상품명
        $(".productBasketName").html(productName);
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
        $(".num").html(price);
        //합계
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
$(document).ready(function() {
    var pick =document.getElementById("pickUpB");
    var delivery =document.getElementById("deliveryB");
    var shipping=document.getElementById("shippingB");
    if(pick){
        pick.addEventListener("click", function () {
            $("#pickUpB").css("opacity", "1").css("border", "2px solid  #DA291C").css("background-color", "#DA291C")
            $("#deliveryB").css("opacity", "0.2").css("border", "none").css("background-color", "black")
            $("#shippingB").css("opacity", "0.2").css("border", "none").css("background-color", "black")
            $(".receiveMethodHidden").val(1)

        })
    }
    if(delivery){
        delivery.addEventListener("click", function () {
            $("#deliveryB").css("opacity", "1").css("border", "2px solid  #DA291C").css("background-color", "#DA291C")
            $("#pickUpB").css("opacity", "0.2").css("border", "none").css("background-color", "black")
            $("#shippingB").css("opacity", "0.2").css("border", "none").css("background-color", "black")
            $(".receiveMethodHidden").val(2)

        })
    }
    if(shipping){
        shipping.addEventListener("click", function () {
            $("#shippingB").css("opacity", "1").css("border", "2px solid  #DA291C").css("background-color", "#DA291C")
            $("#pickUpB").css("opacity", "0.2").css("border", "none").css("background-color", "black")
            $("#deliveryB").css("opacity", "0.2").css("border", "none").css("background-color", "black")
            $(".receiveMethodHidden").val(3)
        })
    }
    // document.getElementById("pickUpB").addEventListener("click", function () {
    //     $("#pickUpB").css("opacity", "1").css("border", "2px solid  #DA291C").css("background-color", "#DA291C")
    //     $("#deliveryB").css("opacity", "0.2").css("border", "none").css("background-color", "#03A9F4")
    //     $("#shippingB").css("opacity", "0.2").css("border", "none").css("background-color", "#FFC107")
    //     $(".receiveMethodHidden").val(1)
    //
    // })
// document.getElementById("deliveryB").addEventListener("click", function () {
//     $("#deliveryB").css("opacity", "1").css("border", "2px solid  #DA291C").css("background-color", "#DA291C")
//     $("#pickUpB").css("opacity", "0.2").css("border", "none").css("background-color", "#8BC34A")
//     $("#shippingB").css("opacity", "0.2").css("border", "none").css("background-color", "#FFC107")
//     $(".receiveMethodHidden").val(2)
//
// })
// document.getElementById("shippingB").addEventListener("click", function () {
//     $("#shippingB").css("opacity", "1").css("border", "2px solid  #DA291C").css("background-color", "#DA291C")
//     $("#pickUpB").css("opacity", "0.2").css("border", "none").css("background-color", "#8BC34A")
//     $("#deliveryB").css("opacity", "0.2").css("border", "none").css("background-color", "#03A9F4")
//     $(".receiveMethodHidden").val(3)
// })
})
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

/*동 찾기 주소*/
$(document).ready(function(){
    //sido option 추가
    $.each(hangjungdong.sido, function(idx, code){
        //append를 이용하여 option 하위에 붙여넣음
        $('.sido1').append(fn_option(code.sido, code.codeNm));
    });

    //sido 변경시 시군구 option 추가
    $('.sido1').change(function(){
        $('.sigugun1').show();
        $('.sigugun1').empty();
        $('.sigugun1').append(fn_option('','선택')); //
        $.each(hangjungdong.sigugun, function(idx, code){
            if($('.sido1 > option:selected').val() == code.sido)
                $('.sigugun1').append(fn_option(code.sigugun, code.codeNm));
        });

        //세종특별자치시 예외처리
        //옵션값을 읽어 비교
        if($('.sido1 option:selected').val() == '36'){
            $('.sigugun1').hide();
            //index를 이용해서 selected 속성(attr)추가
            //기본 선택 옵션이 최상위로 index 0을 가짐
            $('.sigugun1 option:eq(1)').attr('selected', 'selected');
            //trigger를 이용해 change 실행
            $('.sigugun1').trigger('change');
        }
    });

    //시군구 변경시 행정동 옵션추가
    $('.sigugun1').change(function(){
        //option 제거
        $('.dong1').empty();
        $.each(hangjungdong.dong, function(idx, code){
            if($('.sido1 > option:selected').val() == code.sido && $('.sigugun1 > option:selected').val() == code.sigugun)
                $('.dong1').append(fn_option(code.dong, code.codeNm));
        });
        //option의 맨앞에 추가
        $('.dong1').prepend(fn_option('','선택'));
        //option중 선택을 기본으로 선택
        $('.dong1 option:eq("")').attr('selected', 'selected');

    });

    $('.dong1').change(function(){
        var sido = $('.sido1 option:selected').val();
        var sigugun = $('.sigugun1 option:selected').val();
        var dong = $('.dong1 option:selected').val();
        var dongCode = sido + sigugun + dong + '00';

    });
});


$(document).ready(function(){
    //sido option 추가
    $.each(hangjungdong.sido, function(idx, code){
        //append를 이용하여 option 하위에 붙여넣음
        $('.sido2').append(fn_option(code.sido, code.codeNm));
    });

    //sido 변경시 시군구 option 추가
    $('.sido2').change(function(){
        $('.sigugun2').show();
        $('.sigugun2').empty();
        $('.sigugun2').append(fn_option('','선택')); //
        $.each(hangjungdong.sigugun, function(idx, code){
            if($('.sido2 > option:selected').val() == code.sido)
                $('.sigugun2').append(fn_option(code.sigugun, code.codeNm));
        });

        //세종특별자치시 예외처리
        //옵션값을 읽어 비교
        if($('.sido2 option:selected').val() == '36'){
            $('.sigugun2').hide();
            //index를 이용해서 selected 속성(attr)추가
            //기본 선택 옵션이 최상위로 index 0을 가짐
            $('.sigugun2 option:eq(1)').attr('selected', 'selected');
            //trigger를 이용해 change 실행
            $('.sigugun2').trigger('change');
        }
    });

    //시군구 변경시 행정동 옵션추가
    $('.sigugun2').change(function(){
        //option 제거
        $('.dong2').empty();
        $.each(hangjungdong.dong, function(idx, code){
            if($('.sido2 > option:selected').val() == code.sido && $('.sigugun2 > option:selected').val() == code.sigugun)
                $('.dong2').append(fn_option(code.dong, code.codeNm));
        });
        //option의 맨앞에 추가
        $('.dong2').prepend(fn_option('','선택'));
        //option중 선택을 기본으로 선택
        $('.dong2 option:eq("")').attr('selected', 'selected');

    });

    $('.dong2').change(function(){
        var sido = $('.sido2 option:selected').val();
        var sigugun = $('.sigugun2 option:selected').val();
        var dong = $('.dong2 option:selected').val();
        var dongCode = sido + sigugun + dong + '00';

    });
});


$(document).ready(function(){
    //sido option 추가
    $.each(hangjungdong.sido, function(idx, code){
        //append를 이용하여 option 하위에 붙여넣음
        $('.sido3').append(fn_option(code.sido, code.codeNm));
    });

    //sido 변경시 시군구 option 추가
    $('.sido3').change(function(){
        $('.sigugun3').show();
        $('.sigugun3').empty();
        $('.sigugun3').append(fn_option('','선택')); //
        $.each(hangjungdong.sigugun, function(idx, code){
            if($('.sido3 > option:selected').val() == code.sido)
                $('.sigugun3').append(fn_option(code.sigugun, code.codeNm));
        });

        //세종특별자치시 예외처리
        //옵션값을 읽어 비교
        if($('.sido3 option:selected').val() == '36'){
            $('.sigugun3').hide();
            //index를 이용해서 selected 속성(attr)추가
            //기본 선택 옵션이 최상위로 index 0을 가짐
            $('.sigugun3 option:eq(1)').attr('selected', 'selected');
            //trigger를 이용해 change 실행
            $('.sigugun3').trigger('change');
        }
    });

    //시군구 변경시 행정동 옵션추가
    $('.sigugun3').change(function(){
        //option 제거
        $('.dong3').empty();
        $.each(hangjungdong.dong, function(idx, code){
            if($('.sido3 > option:selected').val() == code.sido && $('.sigugun3 > option:selected').val() == code.sigugun)
                $('.dong3').append(fn_option(code.dong, code.codeNm));
        });
        //option의 맨앞에 추가
        $('.dong3').prepend(fn_option('','선택'));
        //option중 선택을 기본으로 선택
        $('.dong3 option:eq("")').attr('selected', 'selected');

    });

    $('.dong3').change(function(){
        var sido = $('.sido3 option:selected').val();
        var sigugun = $('.sigugun3 option:selected').val();
        var dong = $('.dong3 option:selected').val();
        var dongCode = sido + sigugun + dong + '00';

    });
});

function fn_option(code, name){
    return '<option value="' + code +'">' + name +'</option>';
}



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

/*상품명 글자 제한*/
let $productNameInput = $('input[name=sellProductName]');

function letterLength() {
    let $letterSpan = $('.text-primary');

    let letterLength = $productNameInput.val().length;

    $letterSpan.text(letterLength);
}

$.each($productNameInput, function(index, item) {
    $(item).on('keyup', function() {
        letterLength();
    });
});


/*상품 설명 글자 제한*/
let $productDescriptionInput = $('input[name=sellProductDescription]');

function letterLengthDescription() {
    let $letterSpan = $('.text-primary-description');

    let letterLength = $productDescriptionInput.val().length;

    $letterSpan.text(letterLength);
}

$.each($productDescriptionInput, function(index, item) {
    $(item).on('keyup', function() {
        letterLengthDescription();
    });
});




// let $textEle = $('textarea');
//
// /*텍스트에어리어 높이조절*/
// function adjustHeight() {
//
//     $.each($textEle, function(index, item) {
//         $(item).css("height", "auto");
//
//         let textEleHeight = $(item).prop('scrollHeight');
//
//         $(item).css('height', textEleHeight);
//         if(textEleHeight > 191){
//             $(item).css('height', 191);
//         }
//     });
// };
//
// //         타자시 함수 작동
//
// $.each($textEle, function(index, item) {
//     $(item).on('keyup', function() {
//         adjustHeight();
//     });
// });


/*핸드폰 번호 하이푼*/
$('.sellProductPhoneNum').keydown(function(event) {
    let key = event.charCode || event.keyCode || 0;
    $text = $(this);
    if (key !== 8 && key !== 9) {
        if ($text.val().length === 3) {
            $text.val($text.val() + '-');
        }
        if ($text.val().length === 8) {
            $text.val($text.val() + '-');
        }
    }

    return (key == 8 || key == 9 || key == 46 || (key >= 48 && key <= 57) || (key >= 96 && key <= 105));
});



// 파일 첨부시 썸네일 변화 기능
$(".thumbnailImg").change(function(e){
    let file = e.target.files[0];
    let img = $(this).find("img");
    let reader = new FileReader();
    reader.readAsDataURL(file);

    reader.onload = function(e){
        if(e.target.result.indexOf("image") != -1){
            img.attr("src", e.target.result)
            $(img).css("width", "100px");
            $(img).css("height", "100px");
        }else{
            img.attr("src", contextPath+"/images/expert/solo/비어서빈파일.png");
            img.css("width", "100px");
            img.css("height", "100px");
        }
    }
});

// 파일 첨부시 썸네일 변화 기능
$(".detailImg").change(function(e){
    let file = e.target.files[0];
    let img = $(this).find("img");
    let reader = new FileReader();
    reader.readAsDataURL(file);

    reader.onload = function(e){
        if(e.target.result.indexOf("image") != -1){
            img.attr("src", e.target.result)
            $(img).css("width", "100px");
            $(img).css("height", "100px");
        }else{
            img.attr("src", contextPath+"/images/expert/solo/비어서빈파일.png");
            img.css("width", "100px");
            img.css("height", "100px");
        }
    }
});




/* 파일 첨부 삭제*/

let defaultFileImg = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAOEAAADhCAMAAAAJbSJIAAAAPFBMVEX///8AAACTk5Ph4eEvLy83Nzeenp4rKyuampqXl5eKiore3t7q6upPT08bGxsgICCnp6dVVVWCgoLKyspE041KAAABLklEQVR4nO3YS04CURRFUUShwB9+5j9XY8dEK7H1kscu1hrAzdndu9sBAAAAAAAAALfl8e6vp9mTBtuvCu9nTxpMYZ/CPoV9CvsU9insU9insE9hn8I+hX0K+xT2KexT2KewT2Gfwj6FfQr7FPYp7FPYp7BPYZ/CPoV9CvsU9insU9insE9h3/YLT6vC59mTfrwsDwO8rgqHnL28DSg8rLZdk6NChQqnU6hQ4XwKFSqcT6HCb8vsiH+dBhQe9wOc31fbPs4jDn8OKBzjvCq8ni/GGNv/RCnsU9insE9hn8I+hX0K+xT2KexT2KewT2Gfwj6FfQr7FPYp7FPYp7BPYZ/CPoV9CvsU9insU9insE9hn8I+hX0K+xT2KezbfuFxOfx22VohAAAAAAAAbMEXTtsa+A/Y6sQAAAAASUVORK5CYII=";

function cancelFile(fileName){
    let $label = $("label[for='" + fileName + "'] img");

    $("input#" + fileName).val("");
    $label.attr("src", defaultFileImg);
    $label.css("width", "100px");
    $label.css("height", "100px");
}


/* 파일 첨부 이미지만*/

function chk_file_type(obj) {
    let file_kind = obj.value.lastIndexOf('.');
    let file_name = obj.value.substring(file_kind+1,obj.length);
    let file_type = file_name.toLowerCase();


    let check_file_type = new Array('jpg','gif','png','jpeg','bmp');

    if(check_file_type.indexOf(file_type) == -1){
        alert('이미지 파일만 선택할 수 있습니다.');
        var parent_Obj=obj.parentNode
        var node = parent_Obj.replaceChild(obj.cloneNode(true),obj);
        return false;
    }
}





/* 라이더 사용 유무 창*/
let $RiderList = $('.menu-deliveryRider-wrapper');

/*배달 불가능 클릭시*/
function deliveryNoUsing() {
    let $RiderUsingBtn = $('input[name=sellProductDeliveryRider]');
    console.log($RiderUsingBtn);
    $RiderUsingBtn.prop('checked', false);
    riderReset();
    $RiderList.hide();
    $deliveryList.hide()
}

/*배달 가능 클릭시*/
function deliveryUsing() {
    $RiderList.show();
}


/* 배달 동네 창*/
let $deliveryList = $('.sellAddress-delivery');

/*라이더 사용*/
function riderUsing() {
    $deliveryList.show();
}

function riderReset() {
    for (let i = 0; i < 3; i++){
        console.log(i+1);
        $(".sido" + (i+1) + " option").prop("selected", false);
        $(".sigugun" + (i+1) + " option").prop("selected", false);
        $(".dong" + (i+1) + " option").prop("selected", false);
    }
}

/*라이더 사용 X */
function riderNoUsing() {
    riderReset()
    $deliveryList.hide()
}


let $shippingRiderList = $('.menu-shippingRider-wrapper');

/*배송 가능 시*/
function shippingUsing() {
    $shippingRiderList.show()
}

/*배송 불가능 시*/
function shippingNoUsing() {
    $shippingRiderList.hide()
}
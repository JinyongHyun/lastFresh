/* 파일 첨부 시 업로드 */
$("input[type='file']").change(function(e){
    let inputFile = $("input[name='sellProductImageInput']");
    let files1 = inputFile[0].files;
    let files2 = inputFile[1].files;

    if(files2.length == 0 || files1.length == 0) {
        return;
    }

    if (!checkFile(files1[0].name) || !checkFile(files2[0].name)) {
        swal("이미지 파일만 넣어 주세요")
        return;
    }

    let formData = new FormData();

    console.log("파일 첨부 시")

    for(let i = 0; i < 2; i++){
        // if(!checkFile(inputFile[i].files[0].name, inputFile[i].files[0].size)){
        //     continue;
        // }
        console.log(inputFile[i].files[0])
        formData.append("uploadFile", inputFile[i].files[0]);
    }

    $.ajax({
        url: "/sell/uploadAjaxAction",
        data: formData,
        type: "POST",
        // 현재 설정된 헤더 설정을 기본 방식으로 변경하지 못하도록 false로 설정
        processData: false,
        contentType: false,
        success: function(data){
            $('input[name=sellProductThumbnail]').val(data.sellProductThumbnail);
            $('input[name=sellProductImage]').val(data.sellProductImage);
            $('input[name=sellProductImageUploadPath]').val(data.sellProductImageUploadPath);
            $('input[name=sellProductImageUuid]').val(data.sellProductImageUuid);
        },
        error: function (request,status,error) {
            swal(request.responseText);
        }
    });
});

/* 파일 형식 및 사이즈 체크*/
function checkFile(fileName){
    let regex = new RegExp("(.*?)\.(exe|sh|zip|alz)$");

    if(regex.test(fileName)){
        return false;
    }

    return true;
}


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

$(document).ready(function(){
    //sido option 추가
    $.each(hangjungdong.sido, function(idx, code){
        //append를 이용하여 option 하위에 붙여넣음
        $('.sido4').append(fn_option(code.sido, code.codeNm));
    });

    //sido 변경시 시군구 option 추가
    $('.sido4').change(function(){
        $('.sigugun4').show();
        $('.sigugun4').empty();
        $('.sigugun4').append(fn_option('','선택')); //
        $.each(hangjungdong.sigugun, function(idx, code){
            if($('.sido4 > option:selected').val() == code.sido)
                $('.sigugun4').append(fn_option(code.sigugun, code.codeNm));
        });

        //세종특별자치시 예외처리
        //옵션값을 읽어 비교
        if($('.sido4 option:selected').val() == '36'){
            $('.sigugun4').hide();
            //index를 이용해서 selected 속성(attr)추가
            //기본 선택 옵션이 최상위로 index 0을 가짐
            $('.sigugun4 option:eq(1)').attr('selected', 'selected');
            //trigger를 이용해 change 실행
            $('.sigugun4').trigger('change');
        }
    });

    //시군구 변경시 행정동 옵션추가
    $('.sigugun4').change(function(){
        //option 제거
        $('.dong4').empty();
        $.each(hangjungdong.dong, function(idx, code){
            if($('.sido4 > option:selected').val() == code.sido && $('.sigugun4 > option:selected').val() == code.sigugun)
                $('.dong4').append(fn_option(code.dong, code.codeNm));
        });
        //option의 맨앞에 추가
        $('.dong4').prepend(fn_option('','선택'));
        //option중 선택을 기본으로 선택
        $('.dong4 option:eq("")').attr('selected', 'selected');

    });

    $('.dong4').change(function(){
        var sido = $('.sido4 option:selected').val();
        var sigugun = $('.sigugun4 option:selected').val();
        var dong = $('.dong4 option:selected').val();
        var dongCode = sido + sigugun + dong + '00';
    });
});

function fn_option(code, name){
    return '<option value="' + code +'">' + name +'</option>';
}



var width = 500; //팝업의 너비
var height = 600; //팝업의 높이

// 주소 찾기(Daum API)
// function find() {
//     new daum.Postcode({
//         width: width, //생성자에 크기 값을 명시적으로 지정
//         height: height,
//
//         oncomplete: function (data) {
//             var addr = ''; // 주소 변수
//             if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
//                 addr = data.jibunAddress;
//             } else { // 사용자가 지번 주소를 선택했을 경우(J)
//                 addr = data.jibunAddress;
//             }
//
//             // 우편번호와 주소 정보를 해당 필드에 넣는다.
//             document.getElementById('zipcode').value = data.zonecode;
//             document.getElementById("address").value = addr;
//             // 커서를 상세주소 필드로 이동한다.
//             document.getElementById("addressDetail").focus();
//         }
//     }).open({
//         left: (window.screen.width / 2) - (width / 2),
//         top: (window.screen.height / 2) - (height / 2)
//     });
//
// }
// function find() {
//     new daum.Postcode({
//         oncomplete: function(data) {
//             // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
//
//             // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
//             // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
//             var roadAddr = data.roadAddress; // 도로명 주소 변수
//             var extraRoadAddr = ''; // 참고 항목 변수
//
//             // 법정동명이 있을 경우 추가한다. (법정리는 제외)
//             // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
//             if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
//                 extraRoadAddr += data.bname;
//             }
//             // 건물명이 있고, 공동주택일 경우 추가한다.
//             if(data.buildingName !== '' && data.apartment === 'Y'){
//                 extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
//             }
//             // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
//             if(extraRoadAddr !== ''){
//                 extraRoadAddr = ' (' + extraRoadAddr + ')';
//             }
//
//             // 우편번호와 주소 정보를 해당 필드에 넣는다.
//             document.getElementById('zipcode').value = data.zonecode;
//             // document.getElementById("sample4_roadAddress").value = roadAddr;
//             document.getElementById("address").value = data.jibunAddress;
//
//             // 참고항목 문자열이 있을 경우 해당 필드에 넣는다.
//             // if(roadAddr !== ''){
//             //     document.getElementById("sample4_extraAddress").value = extraRoadAddr;
//             // } else {
//             //     document.getElementById("sample4_extraAddress").value = '';
//             // }
//
//             var guideTextBox = document.getElementById("guide");
//             // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
//             if(data.autoRoadAddress) {
//                 var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
//                 // guideTextBox.innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
//                 // guideTextBox.style.display = 'block';
//
//             } else if(data.autoJibunAddress) {
//                 var expJibunAddr = data.autoJibunAddress;
//                 document.getElementById("address").value = expJibunAddr;
//                 // guideTextBox.innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
//                 // guideTextBox.style.display = 'block';
//             } else {
//                 // guideTextBox.innerHTML = '';
//                 // guideTextBox.style.display = 'none';
//             }
//         }
//     }).open();
// }

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
        swal('이미지 파일만 선택할 수 있습니다.');
        var parent_Obj=obj.parentNode
        var node = parent_Obj.replaceChild(obj.cloneNode(true),obj);
        return false;
    }
}





/* 라이더 사용 유무 창*/
let $RiderList = $('.menu-deliveryRider-wrapper');
let $label1 = $('label[for=sellProductDelivery-false]');
let $label2 = $('label[for=sellProductDelivery-true]');

/*배달 불가능 클릭시*/
function deliveryNoUsing() {
    let $RiderUsingBtn = $('input[name=sellProductDeliveryRider]');

    // $label1.css('border-bottom', '4px solid #DA291C');
    // $label2.css('border-bottom', '1px solid #e0e4e6');

    $RiderUsingBtn.prop('checked', false);
    riderReset();

    $RiderList.hide();
    $deliveryList.hide()
}

/*배달 가능 클릭시*/
function deliveryUsing() {
    // $label1.css('border-bottom', '1px solid #e0e4e6');
    // $label2.css('border-bottom', '4px solid #DA291C');
    $RiderList.show();
}


/* 배달 동네 창*/
let $deliveryList = $('.sellAddress-delivery');

/*라이더 사용*/
function riderUsing() {
    $deliveryList.show();
}

/*라이더 사용 X */
function riderNoUsing() {
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

let $shippingRiderList = $('.menu-shippingRider-wrapper');
let $label3 = $('label[for=-false]');
let $label4 = $('label[for=-true]');

/*배송 가능 시*/
function shippingUsing() {
    // $label3.css('border-bottom', '1px solid #e0e4e6');
    // $label4.css('border-bottom', '4px solid #DA291C');
    $shippingRiderList.show()
}

/*배송 불가능 시*/
function shippingNoUsing() {
    // $label3.css('border-bottom', '4px solid #DA291C');
    // $label4.css('border-bottom', '1px solid #e0e4e6');
    $shippingRiderList.hide()
}

$('input[name=sellProductShippingMethod]').change(function () {
    let inputCheck1 = $('#sellProductShippingRider-true').is(':checked');
    let inputCheck2 = $('#sellProductShippingRider-false').is(':checked');
    let inputCheck3 = $('#sellProductShipping-true').is(':checked');
    let $label = $('label[for=sellProductShipping-true]');

    $label.css('border-bottom', '1px solid #e0e4e6');

    if(inputCheck3) {
        $label.css('border-bottom', '4px solid #DA291C');
    }

    if(inputCheck1 || inputCheck2) {
        $shippingRiderList.show();
        $label.css('border-bottom', '4px solid #DA291C');
    }

});

$('input[name=sellProductDeliveryMethod]').change(function () {
    let inputCheck1 = $('#sellProductDeliveryRider-true').is(':checked');
    let inputCheck2 = $('#sellProductDeliveryRider-false').is(':checked');
    let inputCheck3 = $('#sellProductDelivery-true').is(':checked');
    let $label = $('label[for=sellProductDelivery-true]');

    $label.css('border-bottom', '1px solid #e0e4e6');

    if(inputCheck3) {
        $label.css('border-bottom', '4px solid #DA291C');
    }

    if(inputCheck1 || inputCheck2) {
        $RiderList.show();
        $label.css('border-bottom', '4px solid #DA291C');
    }
});

/* 메뉴 등록 */
function menuRegister() {
    deliverySum();

    let $category = $('select[name=sellProductCategory] option:checked');
    if($category.val() == "" || $category.val() == null) {
        swal("카테고리를 선택 해주세요");
        return;
    }

    if(!validateInput("sellProductName", "상품명을 입력 해주세요")) {
        return;
    }

    if(!validateInput("sellProductOriginPrice", "정상 판매가를 입력 해주세요")) {
        return;
    }

    if(!validateInput("sellProductDiscountPrice", "할인 판매가를 입력 해주세요")) {
        return;
    }

    if(!validateInput("sellProductExpireDay", "판매 기간를 선택 해주세요")) {
        return;
    }

    if(!validateInput("sellProductStock", "재고 수량을 입력 해주세요")) {
        return;
    }

    let $sellProductPickup = $('input[name=sellProductPickup]:checked');
    if($sellProductPickup.val() == "" || $sellProductPickup.val() == null) {
        swal("픽업 유무 선택 해주세요");
        return;
    }

    let $sellProductDeliveryMethod = $('input[name=sellProductDeliveryMethod]:checked');
    if($sellProductDeliveryMethod.val() == "" || $sellProductDeliveryMethod.val() == null) {
        swal("라이더 이용 유무 선택 해주세요");
        return;
    }


    let $deliveryCheckRiderUsing = $('#sellProductDeliveryRider-true').is(':checked');
    let $delivery1_1 = $('select[name=sellProductDeliveryAddress1_1] option:checked');
    let $delivery1_2 = $('select[name=sellProductDeliveryAddress1_2] option:checked');
    let $delivery1_3 = $('select[name=sellProductDeliveryAddress1_3] option:checked');

    let $delivery2_1 = $('select[name=sellProductDeliveryAddress2_1] option:checked');
    let $delivery2_2 = $('select[name=sellProductDeliveryAddress2_2] option:checked');
    let $delivery2_3 = $('select[name=sellProductDeliveryAddress2_3] option:checked');

    let $delivery3_1 = $('select[name=sellProductDeliveryAddress3_1] option:checked');
    let $delivery3_2 = $('select[name=sellProductDeliveryAddress3_2] option:checked');
    let $delivery3_3 = $('select[name=sellProductDeliveryAddress3_3] option:checked');

    let str1 = $delivery1_1.text() + " " + $delivery1_2.text() + " " + $delivery1_3.text();
    let str2 = $delivery2_1.text() + " " + $delivery2_2.text() + " " + $delivery2_3.text();
    let str3 = $delivery3_1.text() + " " + $delivery3_2.text() + " " + $delivery3_3.text();
    let unSelectStr = "선택 선택 선택";
    let checkStr1 = str1 == unSelectStr;
    let checkStr2 = str2 == unSelectStr;
    let checkStr3 = str3 == unSelectStr;

    // console.log($deliveryCheckRiderUsing);

    if((checkStr1 || checkStr2 || checkStr3) && $deliveryCheckRiderUsing) {
        swal("배달할 지역을 선택해주세요")
        return;
    }


    let $sellProductShippingMethod = $('input[name=sellProductShippingMethod]:checked');
    if($sellProductShippingMethod.val() == "" || $sellProductShippingMethod.val() == null) {
        swal("라이더 이용 유무 선택 해주세요");
        return;
    }

    let checked1 = $('#sellProductPickup-false:checked').is(':checked');
    let checked2 = $('#sellProductDelivery-false:checked').is(':checked');
    let checked3 = $('#sellProductShipping-false:checked').is(':checked');

    if (checked1 && checked2 && checked3) {
        swal("픽업 또는 배달 또는 배송 중 한가지를 선택 해주세요")
        return;
    }

    let $delivery4_1 = $('select[name=sellProductDeliveryAddress4_1] option:checked');
    let $delivery4_2 = $('select[name=sellProductDeliveryAddress4_2] option:checked');
    let $delivery4_3 = $('select[name=sellProductDeliveryAddress4_3] option:checked');

    let str4 = $delivery4_1.text() + " " + $delivery4_2.text() + " " + $delivery4_3.text();
    let unMainAddress = "'시/도'를 선택해주세요 '시/군/구'를 선택해주세요 '동'을 선택해주세요";
    let checkStr4 = str4 == unMainAddress;
    console.log(checkStr4);
    console.log(str4);
    if (checkStr4) {
        swal("주소를 입력해주세요");
        return;
    }

    if(!validateInput("sellProductAddressDetail", "상세 주소를 입력 해주세요")) {
        return;
    }

    if(!validateInput("sellProductDescription", "상품 설명를 입력 해주세요")) {
        return;
    }

    if(!validateInput("sellProductPhoneNum", "핸드폰 번호를 입력 해주세요")) {
        return;
    }
    // console.log($('#sellProductThumbnail').val());
    // console.log($('#sellProductImage').val());
    if(!validateInputFile("sellProductThumbnail", "대표 이미지를 첨부 해주세요")) {
        return;
    }

    if(!validateInputFile("sellProductImage", "상세 이미지를 첨부 해주세요")) {
        return;
    }

    $('#menu-register-form').submit();
}

function validateInput(name, wordding) {
    let $name = $('input[name=' + name + ']');
    // console.log($name)
    // console.log($name.val())
    if($name.val() == "" || $name.val() == null) {
        swal(wordding);
        return false;
    }
    return true;
}

function validateInputFile(name, wordding) {
    let $name = $('#' + name);
    if($name.val() == "" || $name.val() == null) {
        swal(wordding);
        return false;
    }
    return true;
}


/* 배달 시 군 동 합치기*/
function deliverySum() {
    let $delivery1_1 = $('select[name=sellProductDeliveryAddress1_1] option:checked');
    let $delivery1_2 = $('select[name=sellProductDeliveryAddress1_2] option:checked');
    let $delivery1_3 = $('select[name=sellProductDeliveryAddress1_3] option:checked');

    let $delivery2_1 = $('select[name=sellProductDeliveryAddress2_1] option:checked');
    let $delivery2_2 = $('select[name=sellProductDeliveryAddress2_2] option:checked');
    let $delivery2_3 = $('select[name=sellProductDeliveryAddress2_3] option:checked');

    let $delivery3_1 = $('select[name=sellProductDeliveryAddress3_1] option:checked');
    let $delivery3_2 = $('select[name=sellProductDeliveryAddress3_2] option:checked');
    let $delivery3_3 = $('select[name=sellProductDeliveryAddress3_3] option:checked');

    let $delivery4_1 = $('select[name=sellProductDeliveryAddress4_1] option:checked');
    let $delivery4_2 = $('select[name=sellProductDeliveryAddress4_2] option:checked');
    let $delivery4_3 = $('select[name=sellProductDeliveryAddress4_3] option:checked');

    let str1 = $delivery1_1.text() + " " + $delivery1_2.text() + " " + $delivery1_3.text();  
    let str2 = $delivery2_1.text() + " " + $delivery2_2.text() + " " + $delivery2_3.text();
    let str3 = $delivery3_1.text() + " " + $delivery3_2.text() + " " + $delivery3_3.text();
    let str4 = $delivery4_1.text() + " " + $delivery4_2.text() + " " + $delivery4_3.text();

    let delivery1 = $('input[name=sellProductDeliveryAddress1]');
    let delivery2 = $('input[name=sellProductDeliveryAddress2]');
    let delivery3 = $('input[name=sellProductDeliveryAddress3]');
    let delivery4 = $('input[name=sellProductAddress]');

    delivery1.val(str1);
    delivery2.val(str2);
    delivery3.val(str3);
    delivery4.val(str4);
}


/*div 높이 변화시, 전체 높이 변경*/
let $pageDiv = $('.page_section');

$pageDiv.change(function () {
    console.log('길이조절');
    let height = $('.page_section').height() + 100;
    console.log(height);

    $('.sellMenuRegisterModify').css("height", height);
});

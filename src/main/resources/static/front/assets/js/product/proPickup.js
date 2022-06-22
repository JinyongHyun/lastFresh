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

var cart = $(".cart_option");
var cart1 = $(".cart_option1");

var button = $(".cancel");
var button1 = $(".cancel1");

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
});

$(button1).click(function(){
    $(cart1).addClass("off");
    $(cart1).css("opacity", "0");
    $(".bg_loading").css("display", "none");
});

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
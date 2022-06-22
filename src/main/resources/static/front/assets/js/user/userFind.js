
function showemaildiv() {
    $('.email_box').show();
    $('.email_verification').css("color","#da291c");
    $('.phone_box').hide();
    $('.hp_verification').css("color","#333");
    $('.hp_verification').css("box-shadow","none");
    $('.email_verification').css("box-shadow","inset 0px -2px 0px 0px #DA291C");
    $("#el059co4").css("display", "none");
    $(".check").css("display", "none");
    $(".check1").css("display", "none");
    $("#emailCheck").css("display", "block");
    $("#findId1").css("display", "none");
    $("#findId").css("display", "none");
    $("#result").text("");
    $("#result_email").text("");
}

function showphonediv() {
    $('.phone_box').show();
    $('.email_verification').css("color","#333");
    $('.email_box').hide();
    $('.hp_verification').css("color","#DA291C");
    $('.email_verification').css("box-shadow","none");
    $('.hp_verification').css("box-shadow","inset 0px -2px 0px 0px #DA291C");
    $("#el059co3").css("display", "none");
    $(".check1").css("display", "none");
    $("#phoneCheck").css("display", "block");
    $("#findId1").css("display", "none");
    $("#findId").css("display", "none");
    $("#result").text("");
    $("#result_phone").text("");

}

$( document ).ready(function() {
    $('.email_box').hide();
    // $("button").click(function(){
    // });
});

function find(){
    $(".authentication_number").css("display", "flex");
    $("#el059co3").css("display", "block");
    $("#emailCheck").css("display", "none");
    $(".check1").css("display", "block");
}
function find1(){
    $(".authentication_number").css("display", "flex");
    $("#el059co4").css("display", "block");
    $("#phoneCheck").css("display", "none");
    $("#phoneCheck1").css("display", "none");
    $(".check").css("display", "block");
}

/*  cool sns 아이디 문자인증*/
$('#phoneCheck').click(function(){
    let phoneNumber = $('#phone').val();
    let userId = $('#id').val();

    if(!userId){
        $("#result").text("이름을 입력해주세요.");
        $("#result").css("color", "red");
        if(userId){
            $("#result").text("");
        }

    }
    if(!phoneNumber){
        $("#result_phone").text("휴대폰 번호를 입력해주세요.");
        $("#result_phone").css("color", "red");
        if(phoneNumber){
            $("#result").text("");
        }

    }else {
        Swal.fire('인증번호 발송 완료!');
        $.ajax({
            type: "GET",
            url: "/find/check/sendSMS",
            data: {
                "phoneNumber" : phoneNumber
            },
            success: function(res){
                $('#check').click(function(){
                    if($.trim(res) ==$('#inputCertifiedPhone').val()){

                        $(cart1).removeClass("off");
                        $(cart1).css("opacity", "1");
                        $(".bg_loading").css("display", "block");
                        /* location.href = "/user/manage/userId"*/
                        $.ajax({
                            type: "GET",
                            url: "/find/phoneNumber",
                            data: {
                                "userPhone" : $('#phone').val()
                            },
                            success: function(data){
                                $('#findId_css').text(data);
                            }

                        })
                    }else{
                        Swal.fire({
                            icon: 'error',
                            title: '인증오류',
                            text: '인증번호가 올바르지 않습니다!',
                            footer: '<a href="/main/main">다음에 인증하기</a>'
                        })
                    }
                })


            }
        })

    }
});
/*  cool sns 비밀번호 문자인증*/
$('#phoneCheck1').click(function(){
    let phoneNumber = $('#phone').val();
    Swal.fire('인증번호 발송 완료!')
    let id = $('#id').val();
    console.log(id);
    $.ajax({
        type: "GET",
        url: "/find/check/sendSMS",
        data: {
            "phoneNumber" : phoneNumber
        },
        success: function(res){
            $('#check').click(function(){
                if($.trim(res) ==$('#inputCertifiedPhone').val()){
                    $.ajax({
                        type: "GET",
                        url: "/find/phoneNumber",
                        data: {
                            "userPhone" : $('#phone').val()
                        },
                    })
                    window.location.href = "/user/manage/userNewPw?id=" + id
                }else{
                    Swal.fire({
                        icon: 'error',
                        title: '인증오류',
                        text: '인증번호가 올바르지 않습니다!',
                        footer: '<a href="/main/main">다음에 인증하기</a>'
                    })
                }
            })


        }
    })
});

var cart = $(".cart_option");
var cart1 = $(".cart_option1");

var button = $(".cancel");
var button1 = $(".cancel1");

/*$(".check").click(function(){
    $(cart1).removeClass("off");
    $(cart1).css("opacity", "1");
    $(".bg_loading").css("display", "block");
});*/

/* 아이디 이메일 */
$(document).ready(function() {
    $("#emailCheck").click(function() {
        const email = $("#input_email").val();
        let userId = $('#id').val();
        if(!userId){
            $("#result").text("이름을 입력해주세요.");
            $("#result").css("color", "red");
        }
        if (email == "") {
            $("#result_email").text("이메일을 입력해주세요.");
            $("#result_email").css("color", "red");

        }else {
            alert(email +"로 전송하였습니다");
            $.ajax({
                url: "/find/id/sendUsernames",
                type: "POST",
                data: {
                    email : email
                }
            })
                .done(function() {
                    const html =
                        `<div class="send_email">
					<div>
						<h3>${email}</h3>
						<span>으로 아이디를 전송했습니다</span><br>
						<div>가입한 적이 없는 이메일 주소나 올바르지 않은 이메일 주소를 입력하신 경우에는 메일을 받을 수 없습니다.</div>
						<button class="back_btn">돌아가기</button>
					</div>
				</div>`;

                    $("main").html(html);

                })
                .fail(function() {
                    alert("에러가 발생했습니다");
                })
        }
    })


    $(document).on("click", ".back_btn", function() {
        location.href = "/login";
    })
})

/* 비밀번호 이메일 */
$(document).ready(function() {
    $("#emailCheckPw").click(function() {
        let id = $('#id').val();
        const email = $("#input_email").val();
        let userId = $('#id').val();
        if(!userId){
            $("#result").text("아이디을 입력해주세요.");
            $("#result").css("color", "red");
        }
        if (email == "") {
            $("#result_email").text("이메일을 입력해주세요.");
            $("#result_email").css("color", "red");

        }else {
            alert(email +"로 전송하였습니다");
            $.ajax({
                url: "/find/pw/sendUsernames",
                type: "POST",
                data: {
                    email : email, id : id
                }
            })


                .done(function() {
                    const html =
                        `<div class="send_email">
					<div>
						<h3>${email}</h3>
						<span>으로 아이디를 전송했습니다</span><br>
						<div>가입한 적이 없는 이메일 주소나 올바르지 않은 이메일 주소를 입력하신 경우에는 메일을 받을 수 없습니다.</div>
						<button class="back_btn">돌아가기</button>
					</div>
				</div>`;

                    $("main").html(html);

                })
                .fail(function() {
                    alert("에러가 발생했습니다");
                })
        }
    })


    $(document).on("click", ".back_btn", function() {
        location.href = "/login";
    })
})

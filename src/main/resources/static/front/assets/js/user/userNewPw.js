const id = $(".id").val();
console.log(id)
$('.setup_checkWrapper').click(function(){
    let pw = $('#password').val();
    let pwConfirm = $('#passwordConfirm').val();
    let id = $('.id').val();
    if(pw != pwConfirm){
        $("#result").text("비밀번호가 일치하지 않습니다.");
        $("#result").css("color", "red");

    } else {
        alert('패스워드가 변경되었습니다. \n로그인 창으로 이동합니다.');
        document.location.href="http://localhost:11111/user/manage/userLogin";
        $.ajax({
            type: "POST",
            url: "/find/changePw",
            data: { id : id, pw :pw}
        })
    }
});

 function send(){
     window.location.href = "/user/manage/userNewPw?id=" + id
 }
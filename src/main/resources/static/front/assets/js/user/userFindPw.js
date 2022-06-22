
function showemaildiv() {
    $('.email_box').show();
    $('.email_verification').css("color","#DA291C");
    $('.phone_box').hide();
    $('.hp_verification').css("color","#333");
    $('.hp_verification').css("box-shadow","none");
    $('.email_verification').css("box-shadow","inset 0px -2px 0px 0px #DA291C");

}
function showphonediv() {
    $('.phone_box').show();
    $('.email_verification').css("color","#333");
    $('.email_box').hide();
    $('.hp_verification').css("color","#DA291C");
    $('.email_verification').css("box-shadow","none");
    $('.hp_verification').css("box-shadow","inset 0px -2px 0px 0px #DA291C");
}
$( document ).ready(function() {
    $('.email_box').hide();
    $("button").click(function(){
    });
});
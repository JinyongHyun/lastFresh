
// $( document ).ready(function() {
//     $('.myLabel').get(i).css("background-color",'red').css("color",'white');
//     $('.myLabel').click(function(){
//     });
// });


// $('input[type=radio]').each(function (i,radio) {
//     $(radio).on("click",function () {
//         if(라디오버튼이 체크){
//             해당 라디오버튼의 라벨의 css변경
//             $($(".myLabel").get(i)).css('background-color','#DA291C').css("color",'white');
//         }
//     })
// })

$('input[type=radio]').each(function (i,radio) {
    $(radio).on("click", function () {
        $(".myLabel").css('background-color','#fff').css("color",'#333');
        if($(radio).prop("checked")){
            console.log($(this).next());
            $(this).next().css('background-color','#DA291C').css("color",'white');
            //왜 this로 해야 하는지 질문,,,반복문 돈 뒤~
        }
    })
})

// $('input[type=radio]').each(function (i,radio) {
//     $(radio).on("click",function () {
//         if( $(radio).removeAttr("checked")){
//             $($(".myLabel").get(i)).css('background-color','white').css("color",'black');
//         }
//     })
// })

function sendSelect() {
    selectForm.submit();
}

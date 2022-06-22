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

var sum = 0;

//최종 결제 금액을 계산하는 function
function doSum() {
    $('.price').each(function () {
        console.log($(this).text());
        sum += parseInt($(this).text().replace(",", ""));
    });
    console.log("my Sum : " + sum);

    $('.productsTotalPrice').text(sum.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ','));
    $('.paper_settlement').text(sum.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ','));
    $('.finalPrice').val(sum);
    //$("input[name='orderer_email']").val(sum);

}

$(document).ready(function() {
    doSum();
});


let $openIcon = $('.open-icon');
let $before = $('.before');

$openIcon.each(function (i, e) {
    $(e).click(function () {
        $($before[i]).slideToggle("slow");
    });
});
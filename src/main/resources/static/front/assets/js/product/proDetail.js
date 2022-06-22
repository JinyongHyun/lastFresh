


let sell_price;
let amount;
let num=$('#basketMaxQuantity').val();
function init () {
    sell_price = document.form.sell_price.value;
    amount = document.form.amount.value;
    $("input[name=sum]").val(sell_price.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ','));
    //  document.form.sum.value = sell_price;

    change();
}
$("#basketQuantity").val(1);
let basketQuantity=$("#basketQuantity").val();
function add() {
    hm = document.form.amount;
    let stockNum=hm.value
    console.log("hm",hm.value)
    console.log("num",num)
    sum = document.form.sum;
    if(num!=stockNum){
        basketQuantity++;
        hm.value ++ ;
    }else {return}
    $('#finalPrice').val(sum);
    $("input[name=sum]").val((parseInt(hm.value) * sell_price).toString().replace(/\B(?=(\d{3})+(?!\d))/g, ','));
    //  sum.value = (parseInt(hm.value) * sell_price).toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',');
    $('#finalPrice').val(parseInt(hm.value) * sell_price);

    doSum();

}

function del() {
    hm = document.form.amount;
    sum = document.form.sum;
    if (hm.value > 1) {
        basketQuantity--;
        hm.value -- ;
        $("input[name=sum]").val((parseInt(hm.value) * sell_price).toString().replace(/\B(?=(\d{3})+(?!\d))/g, ','));
        //    sum.value = (parseInt(hm.value) * sell_price).toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',');
        $('#finalPrice').val(parseInt(hm.value) * sell_price);

        doSum();

    }
}

function change () {
    hm = document.form.amount;
    sum = document.form.sum;

    if (hm.value < 0) {
        hm.value = 0;
    }
}

$(document).ready(function() {
    init();
    $('#totalProduct').text(document.getElementsByClassName('prod').length);
});
var mySum = 0;
// 결제 금액
function doSum() {
    console.log("들어옴")
    $('input[name="sum"]').each(function () {
        console.log("val : " + $(this).text());
        mySum += parseInt($(this).val().replace(",", ""));

        console.log("sum : " + mySum);

    });

    /* $('#sumOrderProduct').text(mySum.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ','));
     $('#sumProduct').text(mySum.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ','));
     $('#finalPrice').val(mySum);*/
    $('#che').val(mySum);
    //$('#finalPrice').value(sum);
    mySum = 0;
}

// 후기
const $btn = $(".tr_line");
const $groups = $(".review_view");
var check = false;
$.each($btn, function(index, item){
    $(item).click(function(){
        if(check == false){
            $($groups[index]).css("display", "block");
            check = true;

        }else{
            $($groups[index]).css("display", "none");
            check = false;
        };
    })
});

const $infomation = $("#infomation");
const $review = $("#review")
const $a1 = $("#infomation_a");
const $a2 = $("#review_a");

console.log("a1"+$a1);
console.log("a2"+$a2);
$infomation.click(function (){
    $a1.addClass("__active");
    $a2.removeClass("__active");
})
$review.click(function (){
    $a2.addClass("__active");
    $a1.removeClass("__active");
})

// 전달방식
document.getElementById("pickUpP").addEventListener("click", function () {
    $("#pickUpP").css("opacity", "1").css("border", "none").css("background-color", "#DA291C")
    $("#deliveryP").css("opacity", "0.2").css("border", "none").css("background-color", "black")
    $("#shippingP").css("opacity", "0.2").css("border", "none").css("background-color", "black")
    $(".receiveMethodHidden").val(1)

})
document.getElementById("deliveryP").addEventListener("click", function () {
    $("#deliveryP").css("opacity", "1").css("border", "none").css("background-color", "#DA291C")
    $("#pickUpP").css("opacity", "0.2").css("border", "none").css("background-color", "black")
    $("#shippingP").css("opacity", "0.2").css("border", "none").css("background-color", "black")
    $(".receiveMethodHidden").val(2)

})
document.getElementById("shippingP").addEventListener("click", function () {
    $("#shippingP").css("opacity", "1").css("border", "none").css("background-color", "#DA291C")
    $("#pickUpP").css("opacity", "0.2").css("border", "none").css("background-color", "black")
    $("#deliveryP").css("opacity", "0.2").css("border", "none").css("background-color", "black")
    $(".receiveMethodHidden").val(3)

})

function  AddComma(num)
{
    let regexp = /\B(?=(\d{3})+(?!\d))/g;
    return num.toString().replace(regexp, ',');
}
$("#basketDeliveryMethod").val(0);


/*


$(".plus").click(function() {
    console.log(this.value); // price for one

    console.log( $(this).siblings(".amount2").val());
    $(this).siblings(".amount2").val( parseInt($(this).siblings(".amount2").val()) + 1);
    var amount = $(this).siblings(".amount2").val();

    $(this).parent().siblings(".price").children(".priceNum").val((this.value * amount).toString().replace(/\B(?=(\d{3})+(?!\d))/g, ','));
    $(this).parent().siblings(".chekbox").val(this.value * amount);
    //console.log("// " + $(this).parent().siblings(".price").children(".priceNum").val());
    //console.log("check : " + $(this).parent().siblings(".chekbox").val());
   // doSum();
    doTotal();
    /!*  hm = document.form.amount;
      sum = document.form.sum;
      hm.value ++ ;
      $('#finalPrice').val(sum);
      $("input[name=sum]").val((parseInt(hm.value) * sell_price).toString().replace(/\B(?=(\d{3})+(?!\d))/g, ','));
      //  sum.value = (parseInt(hm.value) * sell_price).toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',');
      $('#finalPrice').val(parseInt(hm.value) * sell_price);

      doSum(this);
      doTotal(this);*!/
})

$(".minus").click(function() {
    //console.log(this.value); // price for one

    //console.log( $(this).siblings(".amount2").val());
    $(this).siblings(".amount2").val( parseInt($(this).siblings(".amount2").val()) - 1);
    var amount = $(this).siblings(".amount2").val();

    $(this).parent().siblings(".price").children(".priceNum").val((this.value * amount).toString()(item.sellProductDiscountPrice * item.basketQuantity).replace(/\B(?=(\d{3})+(?!\d))/g, ','));
    $(this).parent().siblings(".chekbox").val(this.value * amount);
    //  console.log("// " + $(this).parent().siblings(".price").children(".priceNum").val());
    //console.log("check : " + $(this).parent().siblings(".chekbox").val());


 //   doSum();
    doTotal();
})*/


$(document).ready(function() {
   /* $(".priceNum").each(function (i, item){
        let currentVal =  $(this).val();
        let amount = $(this).parent().siblings(".count").children(".amount2").val();
        console.log("my amount : " + amount);
        $(this).val((currentVal * amount).toString().replace(/\B(?=(\d{3})+(?!\d))/g, ','))
    })*/

    //  init ();
    $('#totalProduct').text(document.getElementsByClassName('prod').length);

    doTotal();
   // doSum();
});



/*function selectAll(selectAll)  {
    const checkboxes
        = document.getElementsByName('product');

    checkboxes.forEach((checkbox) => {
        checkbox.checked = selectAll.checked;
    })
    $('#howManyChecks').text($("input:checkbox[name=product]:checked").length);
    doTotal();
}*/


$('input[name="product"]').change(function()
{
    if($("input:checkbox[name=product]:checked").length == document.getElementsByName('product').length){
        $("#allCheck").prop('checked', true);

    }else{
        $("#allCheck").prop('checked', false);
    }
    $('#howManyChecks').text($("input:checkbox[name=product]:checked").length);
    doTotal();
});


var mySum = 0;
// 결제 금액
/*function doSum() {

    $('input[name="sum"]').each(function () {
        console.log("val : " + $(this).text());
        mySum += parseInt($(this).val().replace(",", ""));

        console.log("sum : " + mySum);

    });

    /!* $('#sumOrderProduct').text(mySum.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ','));
     $('#sumProduct').text(mySum.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ','));
     $('#finalPrice').val(mySum);*!/
    $('#che').val(mySum);
    //$('#finalPrice').value(sum);
    mySum = 0;
}*/


function doTotal() {
    var total = 0;
    console.log("doTotal enter");
    var count = document.getElementsByClassName('prod').length;
    for (var i = 0; i < count; i++) {
        if ($(".chekbox")[i].checked == true) {
            total += parseInt(($(".priceNum")[i].value).replace(",", ""));
            // total += parseInt($(".chekbox")[i].siblings('.price').children('.priceNum').val());

        }
    }
    //  console.log(total);

    $('#sumOrderProduct').text(total.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ','));
    $('#sumProduct').text(total.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ','));
    //$('#finalPrice').val(totsumProductal);

    total = 0;
}

/*

    var total = 0;
    function doTotal(){
        //console.log($("input:checkbox[name=product]:checked").length);
        $(".prod").each(function () {
            if( $(this).find('input:checkbox[name=product]:checked')){

                console.log("here" + $(this).find('input[name="sum"]').val());
            }else{
                console.log("no");
            }

        });
*/


/*
        $("input:checkbox[name=product]:checked").each(function () {
            console.log($(this).find('input[name="sum"]').val());
            console.log("here : " + $(this).find('input[name="sum"]').val());

            total += parseInt($(this).find('input[name="sum"]'));

           // console.log("total : " + total);
        });
        $('#sumOrderProduct').text(total.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ','));
        $('#sumProduct').text(total.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ','));
        $('#finalPrice').val(total);
    }

 */

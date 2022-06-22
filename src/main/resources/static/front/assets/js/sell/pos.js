/* 조리 시간 닫기 버튼*/
let $closeBtn = $('.cookingTime-close-btn');

/* 조리 시간 모달창*/
let $cookingModal = $('.cookingTime-wrapper');

/* 조리 시간*/
let $cookingTime = $('.cookingTime-real-wrapper');

/* 접수 버튼*/
let $receptionBtn = $('.order-reception-btn');

/* 조리 시간 리셋 버튼*/
let $resetBtn = $('.cookingTime-reset');

/* 조리 시간 플러스 버튼*/
let $plusBtn = $('.cookingTime-plus');

/* 조리 시간 마이너스 버튼*/
let $minusBtn = $('.cookingTime-minus');

/* 조리 시간 리얼 타임*/
let cookingTime = 0;

/* 사이드바 메뉴들*/
let $sideBars = $('.sideBars');


/* 조리 시간 닫기*/
$closeBtn.on("click", function () {
    $cookingModal.hide();
    cookingTime = 0;
    $cookingTime.find('.cookingTime-real').text(cookingTime);
});

/* 조리 시간 리셋*/
function resetCooking() {
    cookingTime = 0;
    $cookingTime.find('.cookingTime-real').text(cookingTime);
}

// $resetBtn.on("click", function () {
//     cookingTime = 0;
//     $cookingTime.find('.cookingTime-real').text(cookingTime);
// });

/* 조리 시간 늘리기*/
$plusBtn.on("click", function () {
    cookingTime += 10;
    $cookingTime.find('.cookingTime-real').text(cookingTime);
});

/* 조리 시간 줄이기*/
$minusBtn.on("click", function () {
    if (cookingTime == 0) {
        return;
    }
    cookingTime -= 10;
    $cookingTime.find('.cookingTime-real').text(cookingTime);
});

$.each($sideBars, function (i, e) {
    let index = 0;
    $(e).click(function () {
        index = i

        for (let j = 0; j < $sideBars.length; j++) {
            $sideBars[j].classList.remove("sellClicked")
        }

        $sideBars[index].classList.add("sellClicked");
    });
});

let pageNum = 1;
let amount = 4;
let billStatus = 0;
let currentCount = 0;

showList(pageNum, billStatus);

function showList(page, billStatus) {
    pageNum = page || 1;
    let amount = 4;
    let limit = (page - 1) * amount;

    $.ajax({
        type: "GET",
        url: "/pos/list/" + billStatus + "?pageNum=" + pageNum +
            "&amount=" + amount + "&limit=" + limit,
        success: function (result) {

            let str = "";
            let $orderList = $('.order-content');
            let $noorder = $('.noorder');

            // if(list == null || list.size == 0){
            //     $orderList.html("<p>주문이 없습니다.</p>");
            //     return;
            // }

            $.each(result.list, function (i, item) {
                let orderDate = item.billOrderDate + " " + item.billOrderDateTime;
                let orderCookingTime = item.billCookingTime;
                let date = new Date(orderDate);
                let years = date.getFullYear();
                let month = "" + (date.getMonth() + 1);
                let day = "" + (date.getDate());

                if (month.length < 2) {
                    month = '0' + month;
                }

                if (day.length < 2) {
                    day = '0' + day;
                }

                let days = month + "-" + day;

                date.setMinutes(date.getMinutes() + orderCookingTime);
                let hour = "" + date.getHours();
                let minute = "" + date.getMinutes();
                let expectedYears = date.getFullYear();
                let expectedMonth = "" + (date.getMonth() + 1);
                let expectedDay = "" + date.getDate();


                if (hour.length < 2) {
                    hour = '0' + hour;
                }

                if (minute.length < 2) {
                    minute = '0' + minute;
                }

                if (expectedMonth.length < 2) {
                    expectedMonth = '0' + expectedMonth;
                }

                if (expectedDay.length < 2) {
                    expectedDay = '0' + expectedDay;
                }

                let expectedDays = expectedMonth + "-" + expectedDay;
                let time = hour + ":" + minute;

                str += '<div class="order-list-wrapper">';
                str += '<div class="order-list">';
                str += '<div class="order-info3">';
                str += '<div class="order-years">';
                if (item.billStatus == '0' || item.billStatus == '3' || item.billStatus == '-1') {
                    str += '<p>' + years + '</p>';
                    str += '<p>' + days + '</p>';
                } else if (item.billStatus == '1' || item.billStatus == '2' || item.billStatus == '4') {
                    str += '<p>' + expectedYears + '</p>';
                    str += '<p>' + expectedDays + '</p>';
                }
                str += '</div>';
                str += '</div>';
                str += '<div class="order-info1">';
                str += '<div class="order-time">';
                if (item.billStatus == '0' || item.billStatus == '3' || item.billStatus == '-1') {
                    str += '<p>주문 접수 시간</p>';
                    str += '<p>' + item.billOrderDateTime + '</p>';
                } else if (item.billStatus == '1' || item.billStatus == '2' || item.billStatus == '4') {
                    str += '<p>예상 완료 시간</p>';
                    str += '<p>' + time + '</p>';
                }

                str += '</div>';
                if (item.billDeliveryMethod == 1) {
                    str += '<div class="order-method pickUp">';
                    str += '포장';
                } else if (item.billDeliveryMethod == 2) {
                    str += '<div class="order-method delivery">';
                    str += '배달';
                } else if (item.billDeliveryMethod == 3) {
                    str += '<div class="order-method shipping">';
                    str += '배송';
                }
                str += '</div>';
                str += '</div>';
                str += '<div class="order-info2">';
                str += '<div class="order-menu">';
                str += '<p class="order-price">' + item.billProductPrice.toLocaleString('ko-KR') + '원</p>';
                str += '<p class="order-menuInfo">' + item.sellProductName + ' ' + item.billProductQuantity + '개</p>';
                str += '</div>';
                str += '<br>';
                str += '<div class="order-address">';
                str += item.billDeliveryAddress + ' ' + item.billDeliveryAddressDetail;
                str += '</div>';
                str += '<div class="order-phoneNum">';
                str += item.userPhone;
                str += '</div>';
                str += '</div>';
                str += '<div class="order-accept">';
                if (item.billStatus == '0' && item.sellProductPickup == '0' && item.billDeliveryMethod == 1) {
                    str += '<button class="delivery-pickUp-btn"><a class="acceptPickUp" href="' + item.billProductListNum + '">픽업' +
                        '대기</a></button>';
                    str += '<button class="order-cancel-btn"><a class="cancelOrder" href="' + item.billProductListNum + '" data-stock="' + item.billProductQuantity + '" data-product="' + item.sellProductNum + '">취소</a></button>';
                } else if (item.billStatus == '0') {
                    str += '<button class="order-reception-btn"><a class="acceptOrder" href="' + item.billProductListNum + '">접수' +
                        '하기</a></button>';
                    str += '<button class="order-cancel-btn"><a class="cancelOrder" href="' + item.billProductListNum + '" data-stock="' + item.billProductQuantity + '" data-product="' + item.sellProductNum + '">취소</a></button>';
                } else if (item.billStatus == '1' && item.billDeliveryMethod == '2' && item.sellProductDeliveryMethod == '2') {
                    str += '<button class="order-selfReady-btn"><a class="selfReadyOrder" href="' + item.billProductListNum + '">배달' +
                        '시작</a></button>';
                } else if (item.billStatus == '1' && item.billDeliveryMethod == '3' && item.sellProductShippingMethod == '2') {
                    str += '<button class="order-selfReady-btn"><a class="selfReadyOrder" href="' + item.billProductListNum + '">배송' +
                        '시작</a></button>';
                } else if (item.billStatus == '2' && item.billDeliveryMethod == '2' && item.sellProductDeliveryMethod == '2') {
                    str += '<button class="order-selfDelivery-btn"><a class="acceptSelfDeliveryOrder" href="' + item.billProductListNum + '">배달' +
                        '완료</a></button>';
                } else if (item.billStatus == '2' && item.billDeliveryMethod == '3' && item.sellProductShippingMethod == '2') {
                    str += '<button class="order-selfDelivery-btn"><a class="acceptSelfDeliveryOrder" href="' + item.billProductListNum + '">배송' +
                        '완료</a></button>';
                } else if (item.billStatus == '1') {
                    str += '<button class="order-ready-btn">준비중</button>';
                } else if (item.billStatus == '4') {
                    str += '<button class="order-riderReady-btn">라이더' +
                        '대기</button>';
                } else if (item.billStatus == '2') {
                    str += '<button class="order-delivery-btn">배송중</button>';
                } else if (item.billStatus == '3') {
                    str += '<button class="delivery-complete-btn">주문' +
                        '완료</button>';
                } else if (item.billStatus == '-1') {
                    str += '<button class="delivery-cancel-btn">주문' +
                        '취소</button>';
                }
                str += '</div>';
                str += '</div>';
                str += '<hr>';
                str += '</div>';
            });

            getCount(0);
            getCount(1);
            getCount(2);

            if (result.orderCount == 0) {
                str += '<img src="https://cdn.discordapp.com/attachments/969471931575320587/969481005150908456/7d8afc2c848b9d71.png">';
                str += '<p>즐거운 하루 보내세요!</p>'

                let $pagingTag = $("div.paging");

                $noorder.html(str);
                $pagingTag.html("");
                $orderList.html("");
            } else {
                $orderList.html(str);
                $noorder.html("");
                showOrderPage(result.orderCount);
            }
        },
        error: function (error, status, msg) {
            alert("상태코드 " + status + "에러메시지" + msg)
        }
    });
}

function showOrderPage(orderCount) {
    let endNum = Math.ceil(pageNum / 10.0) * 10;
    let startNum = endNum - 9;
    let realEnd = Math.ceil(orderCount / 4.0);


    let str = "";

    let $pagingTag = $("div.paging");

    if (endNum > realEnd) {
        endNum = realEnd;
    }

    let prev = startNum > 1;
    let next = endNum * 4 < orderCount;
    if (prev) {
        str += "<a class='changePage' href='" + (startNum - 1) + "'><code>&lt;</code></a>"
    }

    for (let i = startNum; i <= endNum; i++) {
        if (pageNum == i) {
            str += "<code class='selectedPage'>" + i + "</code>";
            continue;
        }
        str += "<a class='changePage' href='" + i + "'><code>" + i + "</code></a>";
    }

    if (next) {
        str += "<a class='changePage' href='" + (endNum + 1) + "'><code>&gt;</code></a>"
    }

    $pagingTag.html(str);
}

/*페이지 이동*/
$(".paging").on("click", "a.changePage", function (e) {
    e.preventDefault();
    pageNum = $(this).attr("href");
    showList(pageNum, billStatus);
});

//접수 창 열기
$(".order-content").on("click", "button.order-reception-btn", function (e) {
    e.preventDefault();
    let billProductListNum = $(this).find('a').attr("href");

    $cookingModal.show();

    $('.billProductListNum').val(billProductListNum);

});

//접수 하기
$(".cookingTime-reception").on("click", function (e) {

    let billProductListNum = $('.billProductListNum').val();

    let billCookingTime = $('.cookingTime-real').text();

    $.ajax({
        type: "PATCH",
        url: "/pos/accept/",
        data: JSON.stringify({"billProductListNum": billProductListNum, "billCookingTime": billCookingTime}),
        contentType: "application/json; charset=utf-8",
        success: function (result) {
            swal(result);
            showList(pageNum, billStatus);
        },
        error: function (error, status, msg) {
            swal("상태코드 " + status + "에러메시지" + msg)
        }
    });

    resetCooking()
    $cookingModal.hide();
});

//취소 하기
$(".order-content").on("click", "button.order-cancel-btn", function (e) {
    e.preventDefault();
    let billProductListNum = $(this).find('a.cancelOrder').attr("href");
    let billProductQuantity = $($(this).find('a.cancelOrder')).data("stock");
    let sellProductNum = $($(this).find('a.cancelOrder')).data("product");

    swal({
        title: "주문을 취소하시겠습니까",
        text: "취소 시 되돌릴 수 없습니다",
        buttons: ["아니오", "취소하기"]
    }).then(function (result) {
        if (result) {
            $.ajax({
                type: "PATCH",
                url: "/pos/cancel/",
                data: JSON.stringify({
                    "billProductListNum": billProductListNum,
                    "billProductQuantity": billProductQuantity,
                    "sellProductNum": sellProductNum
                }),
                contentType: "application/json; charset=utf-8",
                success: function (result) {
                    swal(result);
                    showList(pageNum, billStatus);
                },
                error: function (error, status, msg) {
                    swal("상태코드 " + status + "에러메시지" + msg)
                }
            });
        }
    });
});

//픽업 접수 하기
$(".order-content").on("click", "button.delivery-pickUp-btn", function (e) {
    e.preventDefault();
    let billProductListNum = $(this).find('a.acceptPickUp').attr("href");

    swal({
        title: "포장 주문을 완료 하시겠습니까",
        text: "포장 완료시 되돌릴 수 없습니다",
        buttons: ["아니오", "포장완료"]
    }).then(function (result) {
        if (result) {
            $.ajax({
                type: "PATCH",
                url: "/pos/acceptPickUp/",
                data: JSON.stringify({"billProductListNum": billProductListNum}),
                contentType: "application/json; charset=utf-8",
                success: function (result) {
                    swal(result);
                    showList(pageNum, billStatus);
                },
                error: function (error, status, msg) {
                    swal("상태코드 " + status + "에러메시지" + msg)
                }
            });
        }
    });
});

//자가 라이더시 준비중 클릭
$(".order-content").on("click", "button.order-selfReady-btn", function (e) {
    e.preventDefault();
    let billProductListNum = $(this).find('a.selfReadyOrder').attr("href");

    swal({
        title: "주문 준비가 완료되었습니까",
        text: "완료 시 배달 및 배송이 시작됩니다",
        buttons: ["아니오", "완료"]
    }).then(function (result) {
        if (result) {
            $.ajax({
                type: "PATCH",
                url: "/pos/selfReady/",
                data: JSON.stringify({"billProductListNum": billProductListNum}),
                contentType: "application/json; charset=utf-8",
                success: function (result) {
                    swal(result);
                    showList(pageNum, billStatus);
                },
                error: function (error, status, msg) {
                    swal("상태코드 " + status + "에러메시지" + msg)
                }
            });
        }
    });
});

//자가 라이더시 배송중 클릭
$(".order-content").on("click", "button.order-selfDelivery-btn", function (e) {
    e.preventDefault();
    let billProductListNum = $(this).find('a.acceptSelfDeliveryOrder').attr("href");

    swal({

        title: "배송이 완료되었습니까",
        text: "완료 시 주문이 되돌릴 수 없습니다",
        buttons: ["아니오", "완료"]

    }).then(function (result) {

        if (result) {
            $.ajax({
                type: "PATCH",
                url: "/pos/selfDelivery/",
                data: JSON.stringify({"billProductListNum": billProductListNum}),
                contentType: "application/json; charset=utf-8",
                success: function (result) {
                    swal(result);
                    showList(pageNum, billStatus);
                },
                error: function (error, status, msg) {
                    swal("상태코드 " + status + "에러메시지" + msg)
                }
            });
        }

    });
});

/*접수대기 클릭 시*/
function orderReady(num) {
    billStatus = num;
    pageNum = 1
    showList(pageNum, billStatus);
}

/*처리중 클릭 시*/
function orderProcessing(num) {
    billStatus = num;
    pageNum = 1
    showList(pageNum, billStatus);
}

/*완료 클릭 시*/
function orderCompleted(num) {
    billStatus = num;
    pageNum = 1
    showList(pageNum, billStatus);
}

/*billStatus에 따른 총개수*/
function getCount(num) {
    $.ajax({
        type: "GET",
        url: "/pos/count/" + num,
        success: function (result) {
            if (num == '0') {
                $('.preparedOrder').text(result);
                $('.reception-new').text("new");
            }

            if (currentCount != result && num == '0') {
                showList(pageNum, billStatus);
                currentCount = result;
            }

            if (result == 0 && num == '0') {
                $('.reception-new').text("");
            }

            if (num == '1') {
                $('.processingOrder').text(result);
            }

            if (num == '2') {
                $('.completedOrder').text(result);
            }
        },
        error: function (error, status, msg) {
            swal("상태코드 " + status + "에러메시지" + msg)
        }
    });
}

let time = 60000; //1초(1000) * 60
setInterval("getCount(0)", time);



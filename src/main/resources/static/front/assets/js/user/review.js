/*
*  review modules
* */

console.log("Review Modules......");

let reviewService = (function () {
//    댓글 목록
    function reviewGetList(param, callback, error) {
        let sellProductNum = param.sellProductNum;
        let page = param.page || 1;

        $.getJSON("/reviews/list/" + sellProductNum + "/" + page, function (reviewPageDTO){
            if (callback){
                callback(reviewPageDTO.reviewCount, reviewPageDTO.list);
            }
        }).fail(function (xhr, status, er) {
            if(error){
                error(er);
            }
        });
        // $.ajax({
        //     type: "GET",
        //     url: "/reviews/list/" + sellProductNum + "/" + page,
        //     success: function (list) {
        //         if(callback){
        //             callback(list);
        //         }
        //     },
        //     error: function (xhr, status, er) {
        //         if (error) {
        //             error(er);
        //         }
        //     }
        // });
    }

    //댓글 조회
    function readReview(reviewNum, callback, error) {
    $.get("/reviews/" + reviewNum, function (result) {
        if(callback){
            callback(result);
        }
    }).fail(function (xhr, status, er) {
        if(error){
            error(er);
        }
    })
        
    }
    //댓글 작성 시간(Controller)
    function getReviewDateByController(reviewDate, callback, error) {
        $.ajax({
            type: "GET",
            url: "/time",
            data: {reviewDate : reviewDate},
            success: function (date) {
                if(callback){
                    callback(date);
                }
            },
            error: function (xhr, status, er) {
                if (error){
                    error(er);
                }
            }
        });
    }

    //댓글 작성 시간(Javascript)
    function getReviewDateByJavascript(reviewDate) {
        let today = new Date();
        let rDate = new Date(reviewDate);
        let gap = today.getTime() - rDate.getTime();

        if(gap < 1000 * 60 * 60 * 24){
            let h = rDate.getHours();
            let mm = rDate.getMinutes();
            let s = rDate.getSeconds();

            return [(h < 10 ? '0' : '') + h, ':', (mm < 10 ? '0' : '') + mm, ':', (s < 10 ? '0' : '') + s].join("");
        }else{
            let y = rDate.getFullYear();
            let m = rDate.getMonth() + 1;
            let d = rDate.getDate();

            return [y, '-', (m < 10 ? '0' : '') + m, '-', (d < 10 ? '0' : '') + d].join("");
        }
    }
    return {reviewGetList: reviewGetList, readReview: readReview, getReviewDateByController: getReviewDateByController, getReviewDateByJavascript: getReviewDateByJavascript}
})();

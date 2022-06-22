package com.example.lastfresh.controller.user;

import com.example.lastfresh.domain.dto.ReviewPageDTO;
import com.example.lastfresh.domain.vo.CriteriaProduct;
import com.example.lastfresh.domain.vo.ReviewVO;
import com.example.lastfresh.service.user.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/reviews/*")
public class ReviewController {
    private final ReviewService reviewService;

    //    리뷰 전체 조회
    @GetMapping("/list/{sellProductNum}/{pageNum}")
    public ReviewPageDTO getReviewList(@PathVariable("sellProductNum") Long sellProductNum, @PathVariable("pageNum") int pageNum){
        log.info("getReviewList............"+ sellProductNum +"," + pageNum);
        return new ReviewPageDTO(reviewService.getTotal(sellProductNum), reviewService.getReviewList(sellProductNum, new CriteriaProduct(pageNum,6)));
    }

    //    리뷰 한개 조회
    @GetMapping("/{reviewNum}")
    public ReviewVO readReview(@PathVariable("reviewNum") Long reviewNum){
        log.info("readReview....." + reviewNum);
        return reviewService.readReview(reviewNum);
    }

    @GetMapping("/total/{sellProductNum}")
    public Integer getTotal(@PathVariable Long sellProductNum){
        return reviewService.getTotal(sellProductNum);
    }
}

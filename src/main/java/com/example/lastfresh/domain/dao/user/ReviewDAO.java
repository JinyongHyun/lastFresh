package com.example.lastfresh.domain.dao.user;


import com.example.lastfresh.domain.dto.ReviewDTO;
import com.example.lastfresh.domain.vo.CriteriaProduct;
import com.example.lastfresh.domain.vo.ReviewVO;
import com.example.lastfresh.mapper.user.ReviewMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Slf4j
public class ReviewDAO {
    private final ReviewMapper reviewMapper;


    public void insert(Long userNum, Long productNum) { reviewMapper.insert(userNum, productNum); }

    public List<ReviewVO> getUnWritten(Long userNum){return reviewMapper.getUnWritten(userNum);}

    public List<ReviewVO> getWritten(Long userNum){return reviewMapper.getWritten(userNum);}

    public void update(ReviewVO reviewVO){reviewMapper.update(reviewVO);}

    public void delete(Long reviewNum){reviewMapper.delete(reviewNum);}

//    public int register( ){
//
//    }
//
//    public void read( ){
//
//    }
//
    public ReviewVO readReview(Long reviewNum){
        log.info("readReview...."+ reviewNum);
        return reviewMapper.readReview(reviewNum);
    }

    public List<ReviewDTO> getReviewList(Long sellProductNum, CriteriaProduct criteriaProduct){
        log.info("getReviewList...."+ sellProductNum);
        return reviewMapper.getReviewList(sellProductNum, criteriaProduct);
    }
    //
//    public int remove( ){
//
//    }
//
//    public int modify( ){
//
//    }
//
//
    public int getTotal(Long sellProductNum){
        log.info("review get total.....");
        return reviewMapper.getTotal(sellProductNum);
    }

}













package com.example.lastfresh.service.user;

import com.example.lastfresh.domain.dao.user.ReviewDAO;
import com.example.lastfresh.domain.dto.ReviewDTO;
import com.example.lastfresh.domain.vo.CriteriaProduct;
import com.example.lastfresh.domain.repository.ReviewRepository;
import com.example.lastfresh.domain.repository.UserRepository;
import com.example.lastfresh.domain.vo.ProductVO;
import com.example.lastfresh.domain.vo.ReviewVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReviewService {
    private final ReviewDAO reviewDAO;
    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;

    //리뷰 1개 조회(read)
    public ReviewVO readReview(Long reviewNum) {
        return reviewDAO.readReview(reviewNum);
    }

    //리뷰 목록(getList)
    public List<ReviewDTO> getReviewList(Long sellProductNum, CriteriaProduct criteriaProduct) {
        return reviewDAO.getReviewList(sellProductNum, criteriaProduct);
    }
    //리뷰 전체 조회(getTotal)
    public int getTotal(Long sellProductNum) {
        return reviewDAO.getTotal(sellProductNum);
    }


    public void insert(Long userNum, Long productNum){
        reviewDAO.insert(userNum, productNum);
    }

    public List<ReviewVO> getReview(Long userNum){
        //return reviewDAO.getUnWritten(userNum);
        return userRepository.getById(userNum).getReviews();
    }

    public ProductVO getProduct(Long reviewNum){
        return reviewRepository.getById(reviewNum).getProductVO();
    }

    public ReviewVO getOneReview(Long reviewNum){
        //return reviewDAO.getUnWritten(userNum);
        return reviewRepository.getById(reviewNum);
    }

    public void update(ReviewVO reviewVO){
        reviewDAO.update(reviewVO);
    }

    public void delete(Long reviewNum){
        reviewDAO.delete(reviewNum);
    }

}

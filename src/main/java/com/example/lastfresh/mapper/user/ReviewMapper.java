package com.example.lastfresh.mapper.user;

import com.example.lastfresh.domain.dto.ReviewDTO;
import com.example.lastfresh.domain.vo.CriteriaProduct;
import com.example.lastfresh.domain.vo.ReviewVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

import java.util.List;

@Mapper
public interface ReviewMapper {
    //    //댓글 등록(insert)
    public void insert(Long userNum, Long productNum);
    public List<ReviewVO> getUnWritten(Long userNum);
    public List<ReviewVO> getWritten(Long userNum);
    public void update(ReviewVO reviewVO);
    public void delete(Long reviewNum);
//    //댓글 등록(insert)
//    public int insert( );
//
    //리뷰 1개 조회(read)
    public ReviewVO readReview(Long reviewNum);
    //
//    //댓글 1개 삭제(delete)
//    public int delete( );
//
//    //댓글 1개 수정(update)
//    public int update( );
//
//    //리뷰 목록(getList)
//    기존의 게시물 페이징 처리 + 특정 게시물 번호를 전달해야 한다.
//    MyBatis에 두 개 이상의 데이터를 파라미터로 전달할 때에는
//    별도의 객체로 구성하거나 Map을 이용, @Param을 이용한다.
//    2.6.6버전에서는 처리를 안해도 자동으로 매핑된다.
//    public List<ReviewVO> getReviewList(@Param("sellProductNum") Long sellProductNum, @Param("criteriaProduct") CriteriaProduct criteriaProduct);
    public List<ReviewDTO> getReviewList(Long sellProductNum, CriteriaProduct criteriaProduct);
    //
    //댓글 개수(getTotal)
    public int getTotal(Long sellProductNum);
}



package com.example.lastfresh.domain.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Data
public class ReviewDTO {

    private Long sellProductNum;
    private Long userNum;
    private Long reviewNum;
    private String reviewTitle;
    private String reviewContent;
    private String userId;
    private Date reviewDate;

    public ReviewDTO() {;}

    public ReviewDTO(Long sellProductNum, Long userNum, Long reviewNum, String reviewTitle, String reviewContent, String userId, Date reviewDate) {
        this.sellProductNum = sellProductNum;
        this.userNum = userNum;
        this.reviewNum = reviewNum;
        this.reviewTitle = reviewTitle;
        this.reviewContent = reviewContent;
        this.userId = userId;
        this.reviewDate = reviewDate;
    }


}

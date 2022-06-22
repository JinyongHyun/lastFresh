package com.example.lastfresh.domain.vo;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TBL_REVIEW")
@Getter
@Setter
@ToString(exclude ={"productVO", "userVO"})
@NoArgsConstructor
public class ReviewVO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "REVIEW_NUM")
    private Long reviewNum;
    @Column(name = "REVIEW_TITLE")
    private String reviewTitle;
    @Column(name = "REVIEW_CONTENT")
    private String reviewContent;
    @Column(name = "REVIEW_DATE")
    private Date reviewDate;

    @ManyToOne // 다대일
    @JoinColumn(name = "SELL_PRODUCT_NUM")
    private ProductVO productVO;

    @ManyToOne // 다대일
    @JoinColumn(name = "USER_NUM")
    private UserVO userVO;

    @Builder
    public ReviewVO(Long reviewNum, String reviewTitle, String reviewContent, Date reviewDate) {
        this.reviewNum = reviewNum;
        this.reviewTitle = reviewTitle;
        this.reviewContent = reviewContent;
        this.reviewDate = reviewDate;
    }
}

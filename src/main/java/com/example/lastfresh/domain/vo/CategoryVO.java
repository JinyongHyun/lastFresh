package com.example.lastfresh.domain.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "TBL_PRODUCT_CATEGORY")
@Getter
@ToString
@NoArgsConstructor
public class CategoryVO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CATEGORY_NUM")
    private Long categoryProductNum;
    @Column(name = "CATEGORY_NAME")
    private String categoryName;

    @Builder
    public CategoryVO(Long categoryProductNum, String categoryName) {
        this.categoryProductNum = categoryProductNum;
        this.categoryName = categoryName;
    }
}

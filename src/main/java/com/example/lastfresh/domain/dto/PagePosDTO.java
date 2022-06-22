package com.example.lastfresh.domain.dto;

import com.example.lastfresh.domain.vo.Criteria;
import com.example.lastfresh.domain.vo.CriteriaPos;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class PagePosDTO {
    private int startPage;
    private int endPage;
    private int realEnd;
    private boolean prev;
    private boolean next;

    private CriteriaPos criteriaPos;
    private int total;
    private int pageCount;

    public PagePosDTO() {;}

    public PagePosDTO(CriteriaPos criteria, int total) {
        this(criteria, total, 10);
    }

    public PagePosDTO(CriteriaPos criteriaPos, int total, int pageCount){
        this.criteriaPos = criteriaPos;
        this.total = total;
        this.pageCount = pageCount;

        this.endPage = (int)(Math.ceil(criteriaPos.getPageNum() / 10.0)) * pageCount;
        this.startPage = endPage - pageCount + 1;

        /*realEnd 구하기*/
        this.realEnd = (int)Math.ceil(total / (double)criteriaPos.getAmount());

        /*endPage와 비교*/
        if(this.endPage > this.realEnd) {
            this.endPage = this.realEnd == 0 ? 1 : this.realEnd;
        }

        /*prev, next 구하기*/
        this.prev = this.startPage > 1;
        this.next = this.endPage < this.realEnd;

    }

}

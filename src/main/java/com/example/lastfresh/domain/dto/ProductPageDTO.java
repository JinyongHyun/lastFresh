package com.example.lastfresh.domain.dto;

import com.example.lastfresh.domain.vo.CriteriaProduct;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Criteria;
import org.springframework.stereotype.Component;

@Component
@Data
@Slf4j
public class ProductPageDTO {
    private int startPage;
    private int endPage;
    private int realEnd;
    private boolean prev, next;

    private CriteriaProduct criteriaProduct;
    private int total;
    private int pageCount;


    public ProductPageDTO() {;}

    public ProductPageDTO(CriteriaProduct criteriaProduct, int total) {
        this(criteriaProduct, total, 10);
    }

    public ProductPageDTO(CriteriaProduct criteriaProduct, int total, int pageCount){
        this.criteriaProduct = criteriaProduct;
        this.total = total;
        this.pageCount = pageCount;

        this.endPage = (int) Math.ceil(criteriaProduct.getPageNum() / 10.0) * pageCount;
        this.startPage = endPage - pageCount +1;

        realEnd = (int)Math.ceil(total / (double)criteriaProduct.getAmount());

        if(this.endPage > realEnd) {
            this.endPage = realEnd == 0 ? 1 : realEnd;
        }

        this.prev = this.startPage >= 1;
        this.next = this.endPage <= realEnd;

        log.info(startPage + "");
        log.info(endPage + "");
        log.info(realEnd + "");
        log.info(criteriaProduct.getPageNum() + "");
        log.info(total + "");
        log.info(pageCount + "");
    }
}

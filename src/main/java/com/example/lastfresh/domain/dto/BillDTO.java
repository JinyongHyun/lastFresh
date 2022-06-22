package com.example.lastfresh.domain.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class BillDTO {
    private Long orderNum;
    private Long userNum;

    public BillDTO(){;}

    public BillDTO(Long orderNum, Long userNum) {
        this.orderNum = orderNum;
        this.userNum = userNum;
    }
}

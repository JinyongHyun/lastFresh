package com.example.lastfresh.domain.dto;

import com.example.lastfresh.domain.vo.ReviewVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
@AllArgsConstructor
public class ReviewPageDTO {
    private int reviewCount;
    private List<ReviewDTO> list;

    public ReviewPageDTO(){;}
}

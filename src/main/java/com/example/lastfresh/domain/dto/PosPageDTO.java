package com.example.lastfresh.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
@AllArgsConstructor
public class PosPageDTO {
    private int orderCount;
    private List<PosDTO> list;

    public PosPageDTO() {;}
}

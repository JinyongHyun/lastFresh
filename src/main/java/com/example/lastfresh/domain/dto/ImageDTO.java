package com.example.lastfresh.domain.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;

@Getter
@Setter
@ToString
public class ImageDTO {
    private String sellProductThumbnail;

    private String sellProductImage;

    private String sellProductImageUploadPath;

    private String sellProductImageUuid;
}

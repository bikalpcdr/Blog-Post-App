package com.bikalp.blogApp.converter;

import com.bikalp.blogApp.DTO.ImageDto;
import com.bikalp.blogApp.Entity.Image;
import org.springframework.stereotype.Component;

@Component
public class ImageDtoConverter {

    public Image toEntity(ImageDto dto) {
        if (dto == null) return null;

        Image entity = new Image();
        entity.setId(dto.getId());
        entity.setUrl(dto.getUrl());

        return entity;
    }

    public ImageDto toDto(Image entity) {
        if (entity == null) return null;

        ImageDto dto = new ImageDto();
        dto.setId(entity.getId());
        dto.setUrl(entity.getUrl());
        return dto;
    }



}

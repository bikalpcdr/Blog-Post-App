package com.bikalp.blogApp.converter;

import com.bikalp.blogApp.DTO.PostDto;
import com.bikalp.blogApp.Entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PostDtoConverter {

    @Autowired
    private ImageDtoConverter imageDtoConverter;

    public Post toEntity(PostDto dto) {
        if (dto == null) return null;

        Post entity = new Post();
        entity.setTittle(dto.getTittle());
        entity.setContent(dto.getContent());
        entity.setThumbnail(imageDtoConverter.toEntity(dto.getThumbnail()));

        return entity;
    }

    public PostDto toDto(Post entity) {
        if (entity == null) return null;

        PostDto dto = new PostDto();
        dto.setTittle(entity.getTittle());
        dto.setContent(entity.getContent());
        dto.setThumbnail(imageDtoConverter.toDto(entity.getThumbnail()));
        return dto;
    }

    public List<Post> toEntity(List<PostDto> dtos) {
        if (dtos == null) return null;
        return dtos.stream().map(this::toEntity).collect(Collectors.toList());
    }

    public List<PostDto> toDto(List<Post> posts) {
        if (posts == null) return null;
        return posts.stream().map(this::toDto).collect(Collectors.toList());

    }
}

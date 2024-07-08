package com.bikalp.blogApp.DTO;

import com.bikalp.blogApp.Entity.Comment;
import com.bikalp.blogApp.Entity.Image;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {
    private Long id;

    private String tittle;

    private String content;

    private List<Comment> comments = new ArrayList<>();

    private ImageDto thumbnail;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public ImageDto getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(ImageDto thumbnail) {
        this.thumbnail = thumbnail;
    }
}

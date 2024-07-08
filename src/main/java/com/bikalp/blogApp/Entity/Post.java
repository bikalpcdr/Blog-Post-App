package com.bikalp.blogApp.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "post_tb")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "post_seq_gen")
    @SequenceGenerator(name = "post_seq_gen",sequenceName = "seq_gen",initialValue = 1,allocationSize = 1)
    private Long id;

    //@Column(nullable = false)
    private String tittle;

    //@Column(nullable = false)
    private String content;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Comment> comments = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "image_id", referencedColumnName = "id")
    private Image thumbnail;

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

    public Image getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Image thumbnail) {
        this.thumbnail = thumbnail;
    }
}

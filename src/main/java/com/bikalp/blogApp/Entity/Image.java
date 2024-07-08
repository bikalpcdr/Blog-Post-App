package com.bikalp.blogApp.Entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "image_tb")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "image_seq_gen")
    @SequenceGenerator(name = "image_seq_gen",sequenceName = "seq_gen",initialValue = 1,allocationSize = 1)
    private Long id;

    @Column(nullable = false)
    private String url;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}

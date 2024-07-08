package com.bikalp.blogApp.Controller;

import com.bikalp.blogApp.DTO.PostDto;
import com.bikalp.blogApp.Service.PostService;
import com.bikalp.blogApp.converter.PostDtoConverter;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/post")
public class PostController {

    private final PostService postService;
    private final PostDtoConverter postDtoConverter;

    public PostController(PostService postService, PostDtoConverter postDtoConverter) {
        this.postService = postService;
        this.postDtoConverter = postDtoConverter;
    }

    @PreAuthorize("hasRole('USER')")
    @PostMapping("/create")
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto) {
        return ResponseEntity.ok(postDtoConverter.toDto(postService.createPost(postDtoConverter.toEntity(postDto))));
    }

    @PutMapping("/update{id}")
    public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto, Long id) {
        return ResponseEntity.ok(postDtoConverter.toDto(postService.updatePost(postDtoConverter.toEntity(postDto), id)));
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable Long id) {
        return ResponseEntity.ok(postDtoConverter.toDto(postService.getPostId(id)));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<PostDto>> getAllPost() {
        return ResponseEntity.ok(postDtoConverter.toDto(postService.getAllPost()));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deletePost(@PathVariable Long id) {
        return ResponseEntity.ok(postService.deletePost(id));
    }

}

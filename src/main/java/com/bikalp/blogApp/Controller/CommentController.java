package com.bikalp.blogApp.Controller;

import com.bikalp.blogApp.DTO.CommentDto;
import com.bikalp.blogApp.Service.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comment")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PreAuthorize("hasRole('USER')")
    @PostMapping("/add")
    public ResponseEntity<CommentDto> addComment(@RequestBody CommentDto commentDto){
        return ResponseEntity.ok(commentService.addComment(commentDto));
    }

    @PreAuthorize("hasRole('USER')")
    @PutMapping("/update/{id}")
    public ResponseEntity<CommentDto> updateComment(@RequestBody CommentDto commentDto, @PathVariable Long id){
        return ResponseEntity.ok(commentService.updateComment(commentDto, id));
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<CommentDto> getCommentById(@PathVariable Long id){
        return ResponseEntity.ok(commentService.getCommentById(id));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<CommentDto>> getAllComment(){
        return ResponseEntity.ok(commentService.getAllComment());
    }

    @PreAuthorize("hasRole('USER')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteComment(@PathVariable Long id){
        return ResponseEntity.ok(commentService.deleteComment(id));
    }
}

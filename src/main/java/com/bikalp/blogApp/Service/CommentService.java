package com.bikalp.blogApp.Service;

import com.bikalp.blogApp.DTO.CommentDto;
import com.bikalp.blogApp.Entity.Comment;

import java.util.List;

public interface CommentService {

    CommentDto addComment(CommentDto commentDto);

    CommentDto updateComment(CommentDto commentDto, Long id);

    CommentDto getCommentById(Long id);

    List<CommentDto> getAllComment();

    boolean deleteComment(Long id);
}

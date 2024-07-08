package com.bikalp.blogApp.Service.Implementation;

import com.bikalp.blogApp.DTO.CommentDto;
import com.bikalp.blogApp.DTO.UserDto;
import com.bikalp.blogApp.Entity.Comment;
import com.bikalp.blogApp.Entity.User;
import com.bikalp.blogApp.Exception.ResourceNotFoundException;
import com.bikalp.blogApp.Repository.CommentRepo;
import com.bikalp.blogApp.Service.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class CommentServiceImpl implements CommentService {


    private final CommentRepo commentRepo;
    private final ModelMapper modelMapper;

    public CommentServiceImpl(CommentRepo commentRepo, ModelMapper modelMapper) {
        this.commentRepo = commentRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public CommentDto addComment(CommentDto commentDto) {
        this.modelMapper.map(commentDto, CommentDto.class);
        Comment comment = this.modelMapper.map(commentDto, Comment.class);
        Comment newComment = this.commentRepo.save(comment);
        return this.modelMapper.map(newComment, CommentDto.class);
    }

    @Override
    public CommentDto updateComment(CommentDto commentDto, Long id) {
        Comment comment = this.commentRepo.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Comment", "Id",id));
        if (comment.getContent() != null) {
            comment.setContent(comment.getContent());
        }
        if (comment.getPost() !=null) {
            comment.setPost(comment.getPost());
        }
        if (comment.getUser() != null) {
            comment.setUser(comment.getUser());
        }
        Comment updatedComment = this.commentRepo.save(comment);
        return this.modelMapper.map(updatedComment, CommentDto.class);
    }

    @Override
    public CommentDto getCommentById(Long id) {
        Comment comment = this.commentRepo.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Comment","Id",id));
        return this.modelMapper.map(comment, CommentDto.class);
    }

    @Override
    public List<CommentDto> getAllComment() {
        List<Comment> comments = this.commentRepo.findAll();
        return comments.stream()
                .map(comment -> this.modelMapper.map(comment, CommentDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public boolean deleteComment(Long id) {
        commentRepo.deleteById(id);
        return true;
    }
}

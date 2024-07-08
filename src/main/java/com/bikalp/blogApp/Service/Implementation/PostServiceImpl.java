package com.bikalp.blogApp.Service.Implementation;

import com.bikalp.blogApp.DTO.PostDto;
import com.bikalp.blogApp.Entity.Post;
import com.bikalp.blogApp.Exception.ResourceNotFoundException;
import com.bikalp.blogApp.Repository.PostRepo;
import com.bikalp.blogApp.Service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepo postRepo;
    private final ModelMapper modelMapper;

    public PostServiceImpl(PostRepo postRepo, ModelMapper modelMapper) {
        this.postRepo = postRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public Post createPost(Post post) {
        return postRepo.save(post);
    }

    @Override
    public Post updatePost(Post post, Long id) {
        Post entity = this.postRepo.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Post", "Id",id));

        if (post.getComments() != null)
        entity.setComments(post.getComments());
        entity.setContent(post.getContent());
        entity.setTittle(post.getTittle());
        entity.setThumbnail(post.getThumbnail());
        return postRepo.save(entity);
    }

    @Override
    public Post getPostId(Long id) {
        return postRepo.findById(id).orElseThrow(
                //() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Post not found with id: " + id));
                ()-> new ResourceNotFoundException("Post", "Id",id));
    }

    @Override
    public List<Post> getAllPost() {
        return postRepo.findAll();
    }

    @Override
    public boolean deletePost(Long id) {
        Post post = getPostId(id);
        postRepo.delete(post);
        return true;
    }
}

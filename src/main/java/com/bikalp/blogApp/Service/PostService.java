package com.bikalp.blogApp.Service;

import com.bikalp.blogApp.DTO.PostDto;
import com.bikalp.blogApp.Entity.Post;

import java.util.List;


public interface PostService {

    Post createPost(Post post);

    Post updatePost(Post post, Long id);

    Post getPostId(Long id);

    List<Post> getAllPost();

    boolean deletePost(Long id);
}

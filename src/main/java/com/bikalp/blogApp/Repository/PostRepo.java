package com.bikalp.blogApp.Repository;

import com.bikalp.blogApp.Entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepo extends JpaRepository<Post, Long> {
}

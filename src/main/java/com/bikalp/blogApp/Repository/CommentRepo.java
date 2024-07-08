package com.bikalp.blogApp.Repository;

import com.bikalp.blogApp.Entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<Comment, Long> {
}

package com.bikalp.blogApp.Repository;

import com.bikalp.blogApp.Entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepo extends JpaRepository<Image, Long> {
}

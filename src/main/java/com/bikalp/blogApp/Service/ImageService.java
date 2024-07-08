package com.bikalp.blogApp.Service;

import com.bikalp.blogApp.Entity.Image;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ImageService {

    Image addImage(MultipartFile image);

    Image updateImage(Image image, Long id);

    Image getImageById(Long id);

    List<Image> getAllImage();

    boolean deleteImage(Long id);
}

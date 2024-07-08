package com.bikalp.blogApp.Controller;

import com.bikalp.blogApp.Entity.Image;
import com.bikalp.blogApp.Service.ImageService;
import com.bikalp.blogApp.Service.Implementation.ImageServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/image")
public class ImageController {

    private final ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @PreAuthorize("hasRole('USER')")
    @PostMapping("/add")
    public ResponseEntity<?> addImage(@RequestParam("Image") MultipartFile file) {
        if (file.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("The file is empty.File must be valid file.");
        }

        try {
            Image savedImage = imageService.addImage(file);
            return ResponseEntity.ok(savedImage);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred while uploading the file.");
        }
    }

    @PreAuthorize("hasRole('USER')")
    @PutMapping("/update/{id}")
    public ResponseEntity<Image> updateImage(@RequestBody Image image, @PathVariable Long id){
        return ResponseEntity.ok(imageService.updateImage(image, id));
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Image> getImageById(@PathVariable Long id){
        return ResponseEntity.ok(imageService.getImageById(id));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Image>> getAllImage(){
        return ResponseEntity.ok(imageService.getAllImage());
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteImage(@PathVariable Long id){
        return ResponseEntity.ok(imageService.deleteImage(id));
    }
}

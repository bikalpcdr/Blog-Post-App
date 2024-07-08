package com.bikalp.blogApp.Service.Implementation;

import com.bikalp.blogApp.Entity.Image;
import com.bikalp.blogApp.Exception.ResourceNotFoundException;
import com.bikalp.blogApp.Repository.ImageRepo;
import com.bikalp.blogApp.Service.ImageService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.List;

@Service
public class ImageServiceImpl implements ImageService {

    private final ImageRepo imageRepo;
    final String UPLOAD_DIR = "C:\\Users\\dell\\Desktop\\blogApp\\src\\main\\resources\\static\\Image";

    public ImageServiceImpl(ImageRepo imageRepo) {
        this.imageRepo = imageRepo;
    }

    @Override
    public Image addImage(MultipartFile multipartFile) {

        String fileUrl = uploadImage(multipartFile);
        // Save the file path in the Image entity
        Image image = new Image();
        image.setUrl(fileUrl);

        // Save the Image entity to the repository
        return imageRepo.save(image);
    }

    private String  uploadImage(MultipartFile multipartFile) {
        String fileUrl = UPLOAD_DIR + File.separator +System.currentTimeMillis()+multipartFile.getOriginalFilename();
        try (InputStream is = multipartFile.getInputStream();
             FileOutputStream fos = new FileOutputStream(fileUrl)) {
            byte[] data = new byte[is.available()];
            is.read(data);
            fos.write(data);
           return fileUrl;
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to store file " + multipartFile.getOriginalFilename());
        }

    }

//        // Directory where the file will be saved
//        File directory = new File("C:\\Users\\dell\\Documents\\photos");
//
//        // Create the directory if it doesn't exist
//        if (!directory.exists()) {
//            directory.mkdirs();
//        }
//
//        // File where the content will be written
//        File file = new File(directory, multipartFile.getOriginalFilename());
//
//        try (FileOutputStream fos = new FileOutputStream(file)) {
//            fos.write(multipartFile.getBytes());
//        } catch (IOException e) {
//            e.printStackTrace();
//            throw new RuntimeException("Failed to store file " + multipartFile.getOriginalFilename(), e);
//        }
//
//        Image image = new Image();
//        image.setUrl(file.getAbsolutePath());

//        return imageRepo.save(image);

    @Override
    public Image updateImage(Image image, Long id) {
        return imageRepo.save(image);
    }

    @Override
    public Image getImageById(Long id) {
        return imageRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Image","Id",id));
    }

    @Override
    public List<Image> getAllImage() {
        return imageRepo.findAll();
    }

    @Override
    public boolean deleteImage(Long id) {
        imageRepo.deleteById(id);
        return true;
    }
}

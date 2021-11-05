package com.smrtgrdyn.smrtgrdyn.Garden.Image;

import com.smrtgrdyn.smrtgrdyn.Garden.Notifications.NotificationType;
import com.smrtgrdyn.smrtgrdyn.Garden.Notifications.NotificationUtil;
import com.smrtgrdyn.smrtgrdyn.Garden.Repository.GardenImageRepository;
import com.smrtgrdyn.smrtgrdyn.Garden.Util.SGFileUtils;
import com.smrtgrdyn.smrtgrdyn.Garden.Util.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

@Service
public class GardenImageService {

    GardenImageRepository imageRepository;

    private String filename;
    private String uploadDir;
    private final ValidationUtil validationUtil;
    private final NotificationUtil notificationUtil;

    @Autowired
    public GardenImageService(GardenImageRepository imageRepository, ValidationUtil validationUtil, NotificationUtil notificationUtil) {
        this.imageRepository = imageRepository;
        this.validationUtil = validationUtil;
        this.notificationUtil = notificationUtil;
    }

    public void saveImage(GardenImage gardenImage, MultipartFile multipartFile){

        setGardenImageFilepath(gardenImage, multipartFile.getOriginalFilename());

        storeImageInfo(gardenImage);

        try {
            uploadImage(multipartFile);
            generateNotification(gardenImage);
        } catch (IOException ioe) {

            dropImageInfo(gardenImage);

            throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "Unable to save file", ioe);
        }
    }

    private void setGardenImageFilepath(GardenImage gardenImage, String filename){

        //Get the given filename
        this.filename = StringUtils.cleanPath(filename);
        //Build uploadDirectory name
        uploadDir = SGFileUtils.buildUploadDir(gardenImage);
        //Set filepath for image
        gardenImage.setFilepath(uploadDir + "/" + filename);
    }

    private void storeImageInfo(GardenImage gardenImage){

        validationUtil.validateImage(gardenImage);
        //Save Image
        imageRepository.save(gardenImage);
    }

    private void generateNotification(GardenImage gardenImage){
        //Notification: GardenId, Timestamp, Type
        notificationUtil.generateNotification(gardenImage.getGardenId(), gardenImage.getTimestamp(), NotificationType.ANIMAL);

    }
    private void dropImageInfo(GardenImage gardenImage){
        imageRepository.delete(gardenImage);
    }

    private void uploadImage(MultipartFile multipartFile) throws IOException {
        SGFileUtils.saveFile(uploadDir, filename, multipartFile);
    }


    public ResponseEntity<byte[]> getImage(GardenImage gardenImage){

        GardenImageId id = new GardenImageId(gardenImage.getGardenId(), gardenImage.getTimestamp());
        imageRepository.findAll();
        Optional<GardenImage> optionalGardenImage = imageRepository.findById(id);


        if (optionalGardenImage.isPresent()){

            GardenImage gardenImage1 = optionalGardenImage.get();
            byte[] image;

            try {
                image = org.apache.commons.io.FileUtils.readFileToByteArray(new File(gardenImage1.getFilepath()));

            } catch (IOException e) {

                throw new ImageNotFoundException();
            }

            return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(image);
        }

        throw new ImageNotFoundException();

    }
    @ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Image Not Found")
    public static class ImageNotFoundException extends RuntimeException{
    }




}

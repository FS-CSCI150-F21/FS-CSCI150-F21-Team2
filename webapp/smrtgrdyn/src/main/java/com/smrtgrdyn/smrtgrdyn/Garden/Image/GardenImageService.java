package com.smrtgrdyn.smrtgrdyn.Garden.Image;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class GardenImageService {

    private final String FILE_PATH_ROOT = "garden-photos/";

    GardenImageRepository imageRepository;

    @Autowired
    public GardenImageService(GardenImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    public void saveImage(GardenImage gardenImage, MultipartFile multipartFile) throws IOException {

        //GardenId is the folder for this garden
        String gardenId = gardenImage.getGardenId().toString();
        //Get the given filename
        String filename = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        //Build uploadDirectory name
        String uploadDir = FILE_PATH_ROOT + gardenId;
        //Set filepath for image
        gardenImage.setFilepath(uploadDir + "/" + filename);
        //Save Image
        imageRepository.save(gardenImage);

        //Finish Uploading Image
        FileUploadUtil.saveFile(uploadDir, filename, multipartFile);
        System.out.println(gardenImage.toString());
    }

    private void validateImage(GardenImage gardenImage){

        //If no timestamp given, generate one
        if(gardenImage.getTimestamp() == null){
            gardenImage.setTimestamp(new Timestamp(System.currentTimeMillis()));
        }

        // Check the UUID to verify registration
    }

    public ResponseEntity<byte[]> getImage(GardenImage gardenImage){

        GardenImageId id = new GardenImageId(gardenImage.getGardenId(), gardenImage.getTimestamp());
        imageRepository.findAll();
        Optional<GardenImage> optionalGardenImage = imageRepository.findById(id);


        if (optionalGardenImage.isPresent()){

            GardenImage gardenImage1 = optionalGardenImage.get();
            byte[] image = new byte[0];

            try {
                image = FileUtils.readFileToByteArray(new File(gardenImage1.getFilepath()));
            } catch (IOException e) {
                throw new ImageNotFoundException();
            }

            return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(image);
        }

        throw new ImageNotFoundException();

    }
    @ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Image Not Found")
    public class ImageNotFoundException extends RuntimeException{
    }



}

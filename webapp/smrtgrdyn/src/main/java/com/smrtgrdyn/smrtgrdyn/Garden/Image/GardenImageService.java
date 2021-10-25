package com.smrtgrdyn.smrtgrdyn.Garden.Image;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class GardenImageService {

    @Autowired
    GardenImageRepository imageRepository;

    public void saveImage(GardenImage gardenImage, MultipartFile multipartFile) throws IOException {
        //GardenId is the folder for this garden
        String gardenId = gardenImage.getGardenId().toString();
        //Get the given filename
        String filename = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        //Build uploadDirectory name
        String uploadDir = "garden-photos/" + gardenId;
        //Set filepath for image
        gardenImage.setFilepath(uploadDir + "/" + filename);
        //Save Image
        imageRepository.save(gardenImage);

        //Finish Uploading Image
        FileUploadUtil.saveFile(uploadDir, filename, multipartFile);
    }

}

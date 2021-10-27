package com.smrtgrdyn.smrtgrdyn.Garden.Image;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;

@RestController
//@RequestMapping
public class GardenImageController {

    @Autowired
    private GardenImageService service;

    @PostMapping(path = "api/v1/garden_images", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    public void saveImage(@ModelAttribute GardenImage gardenImage,@RequestParam("image")MultipartFile multipartFile) throws IOException {

        service.saveImage(gardenImage, multipartFile);
    }

    //maybe? because its submitted via form data
    @GetMapping("api/v1/garden_images")
    public ResponseEntity<byte[]> getImage(@ModelAttribute GardenImage gardenImage){

        return service.getImage(gardenImage);
    }


}

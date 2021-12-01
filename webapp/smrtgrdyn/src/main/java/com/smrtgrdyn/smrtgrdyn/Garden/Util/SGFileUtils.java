package com.smrtgrdyn.smrtgrdyn.Garden.Util;

import com.smrtgrdyn.smrtgrdyn.Garden.Image.GardenImage;
import org.springframework.http.HttpStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class SGFileUtils {

    private static final String FILE_PATH_ROOT = "garden-photos/";

    public static void saveFile(String uploadDir, String filename, MultipartFile file) throws IOException {

        System.out.println("Attempting to upload file");
        Path uploadPath = Paths.get(uploadDir);

        if(!Files.exists(uploadPath)){
            Files.createDirectories(uploadPath);
        }

        try(InputStream inputStream = file.getInputStream()){
            Path filepath = uploadPath.resolve(filename);
            Files.copy(inputStream, filepath, StandardCopyOption.REPLACE_EXISTING);
        }catch (IOException ioe){
            throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "Unable to save file", ioe);
        }
    }

    public static boolean doesFileExist(String filepath){

        return new File(filepath).exists();

    }

    public static String buildUploadDir(GardenImage gardenImage){
        return FILE_PATH_ROOT + gardenImage.getGardenId().toString() + "/";
    }

}

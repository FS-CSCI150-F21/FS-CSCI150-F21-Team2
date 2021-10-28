package com.smrtgrdyn.smrtgrdyn.Garden.Image;

import org.springframework.http.HttpStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FileUploadUtil {

    public static void saveFile(String uploadDir, String filename, MultipartFile file) throws IOException {

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
}

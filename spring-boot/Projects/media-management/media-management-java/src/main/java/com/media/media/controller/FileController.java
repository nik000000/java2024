package com.media.media.controller;

import com.media.media.entities.FileEntity;
import com.media.media.entities.ImageResponse;
import com.media.media.services.FileUploadService;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/file")
public class FileController {
    private static final Set<String> ALLOWED_PICTURE_TYPES = new HashSet<>(Arrays.asList("jpg", "jpeg", "png", "gif"));
    private final FileUploadService fileService;

    public FileController(FileUploadService fileService) {
        this.fileService = fileService;
    }
    public static boolean isPictureFile(String fileName) {
        String extension = getFileExtension(fileName);
        return extension != null && ALLOWED_PICTURE_TYPES.contains(extension);
    }

    public static String getFileExtension(String fileName) {
        if (fileName == null || fileName.lastIndexOf('.') == -1) {
            return null;
        }
        return fileName.substring(fileName.lastIndexOf('.') + 1).toLowerCase();
    }

    @PostMapping("/upload")
    public ResponseEntity<String> upload(@RequestParam("file") MultipartFile file){
        if (isPictureFile(file.getOriginalFilename())) {
            System.out.println(file.getOriginalFilename() + " is a valid picture file.");
        } else {
            System.out.println(file.getOriginalFilename() + " is not a valid picture file.");
            return ResponseEntity.status(HttpStatus.FAILED_DEPENDENCY).body("only images allowed to be uploaded.");
        }

        try {
            FileEntity savedFile = fileService.uploadFile(file);
            return ResponseEntity.ok().body("Saved file successfully..."+savedFile.getId());
        }catch(IOException e){
            return ResponseEntity.status(500).body("Failed to upload file: "+e.getMessage());
        }
    }

    @GetMapping("/download/{fileId}")
    public ResponseEntity<ImageResponse> download(@PathVariable Integer fileId){
        ImageResponse file = fileService.getFile(fileId);

        return ResponseEntity.ok(file);
    }


    @GetMapping("/all")
    public ResponseEntity<List<ImageResponse>> getAll(){
        List<ImageResponse> imageResponses = fileService.getAllFiles();
        return ResponseEntity.ok(imageResponses);
    }
}

package com.media.media.services;

import com.media.media.entities.FileEntity;
import com.media.media.entities.ImageResponse;
import com.media.media.repositories.FileUpload;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FileUploadService {
    private final FileUpload uploadFile;
    private final FileUpload fileUpload;

    public FileUploadService(FileUpload uploadFile, FileUpload fileUpload) {
        this.uploadFile = uploadFile;
        this.fileUpload = fileUpload;
    }

    public FileEntity uploadFile(MultipartFile file) throws IOException {
        FileEntity fileEntity = new FileEntity();
        fileEntity.setFileName(file.getOriginalFilename());
        fileEntity.setContentType(file.getContentType());
        fileEntity.setFileBytes(file.getBytes());

        return fileUpload.save(fileEntity);
    }

    public ImageResponse getFile(int fileId){
        Optional<FileEntity> file = fileUpload.findById(fileId);
        if(file.isPresent()){
            FileEntity image = file.get();
            return new ImageResponse(
                    image.getId(),
                    image.getFileName(),
                    image.getContentType(),
                    "/api/v1/images/" + image.getId(),
                    Base64.getEncoder().encodeToString(image.getFileBytes())
            );
        }else {
            return null;
        }

    }

    public List<ImageResponse> getAllFiles(){
        List<FileEntity> images = fileUpload.findAll();
        return images.stream()
                .map(image -> new ImageResponse(
                        image.getId(),
                        image.getFileName(),
                        image.getContentType(),
                        "/api/v1/images/" + image.getId(),
                        Base64.getEncoder().encodeToString(image.getFileBytes())
                ))
                .collect(Collectors.toList());

    }
}

package com.media.media.repositories;

import com.media.media.entities.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileUpload extends JpaRepository<FileEntity,Integer> {
}

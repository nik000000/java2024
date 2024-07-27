package com.media.media.entities;

import jakarta.persistence.*;

@Entity
public class FileEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    private String fileName;
    private String contentType;
    @Lob
    @Column(name = "file_bytes", columnDefinition = "LONGBLOB")
    private byte[] fileBytes;

    public FileEntity() {
    }

    public FileEntity(int id, String fileName, String contentType, byte[] fileBytes) {
        this.id = id;
        this.fileName = fileName;
        this.contentType = contentType;
        this.fileBytes = fileBytes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public byte[] getFileBytes() {
        return fileBytes;
    }

    public void setFileBytes(byte[] fileBytes) {
        this.fileBytes = fileBytes;
    }
}

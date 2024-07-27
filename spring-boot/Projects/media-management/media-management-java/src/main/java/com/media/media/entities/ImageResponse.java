package com.media.media.entities;

public class ImageResponse {
    private int id;
    private String name;
    private String type;
    private String url;
    private String fileBytes; // Change to String for Base64

    public ImageResponse(int id, String name, String type, String url, String fileBytes) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.url = url;
        this.fileBytes = fileBytes;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFileBytes() {
        return fileBytes;
    }

    public void setFileBytes(String fileBytes) {
        this.fileBytes = fileBytes;
    }
}

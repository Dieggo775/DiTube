package com.DiTube.dto;

import com.DiTube.model.Video;

public class VideoResponseDTO {
    private Long id;
    private String title;
    private String description;

    public VideoResponseDTO(Video video) {
        this.id = video.getId();
        this.title = video.getTitle();
        this.description = video.getDescription();
    }

    // Getters
    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
}
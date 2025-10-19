package com.DiTube.dto;

public class VideoRequestDTO {
    private String title;
    private String description;
    private String videoUrl;
    private String thumbnailUrl;
    private boolean isShort;
    private Long channelId;

    // Getters e Setters
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getVideoUrl() { return videoUrl; }
    public void setVideoUrl(String videoUrl) { this.videoUrl = videoUrl; }

    public String getThumbnailUrl() { return thumbnailUrl; }
    public void setThumbnailUrl(String thumbnailUrl) { this.thumbnailUrl = thumbnailUrl; }

    public boolean isShort() { return isShort; }
    public void setShort(boolean aShort) { isShort = aShort; }

    public Long getChannelId() { return channelId; }
    public void setChannelId(Long channelId) { this.channelId = channelId; }
}
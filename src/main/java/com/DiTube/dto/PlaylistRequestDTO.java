package com.DiTube.dto;

import java.util.List;

public class PlaylistRequestDTO {
    private String name;
    private String description;
    private Long ownerId;
    private List<Long> videoIds;

    // Getters e Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Long getOwnerId() { return ownerId; }
    public void setOwnerId(Long ownerId) { this.ownerId = ownerId; }

    public List<Long> getVideoIds() { return videoIds; }
    public void setVideoIds(List<Long> videoIds) { this.videoIds = videoIds; }
}
package com.DiTube.dto;

public class CommentRequestDTO {
    private String content;
    private Long videoId;
    private Long userId;

    // Getters e Setters
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public Long getVideoId() { return videoId; }
    public void setVideoId(Long videoId) { this.videoId = videoId; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
}
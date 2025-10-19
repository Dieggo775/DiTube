package com.DiTube.controller;

import com.DiTube.dto.VideoRequestDTO;
import com.DiTube.model.Channel;
import com.DiTube.model.Video;
import com.DiTube.repository.ChannelRepository;
import com.DiTube.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/videos")
public class VideoController {

    @Autowired
    private VideoRepository videoRepository;

    @Autowired
    private ChannelRepository channelRepository;

    @GetMapping
    public List<Video> getAllVideos() {
        return videoRepository.findAll();
    }

    @GetMapping("/feed")
    public List<Video> getFeed(
            @RequestParam(required = false) Long channelId,
            @RequestParam(required = false) Boolean isShort,
            @RequestParam(required = false) String title
    ) {
        if (channelId != null) {
            return videoRepository.findByChannelId(channelId);
        } else if (isShort != null && isShort) {
            return videoRepository.findByIsShortTrue();
        } else if (title != null && !title.isEmpty()) {
            return videoRepository.findByTitleContainingIgnoreCase(title);
        } else {
            return videoRepository.findAllOrderByCreatedAtDesc();
        }
    }

    @PostMapping
    public Video createVideo(@RequestBody VideoRequestDTO dto) {
        Channel channel = channelRepository.findById(dto.getChannelId())
                .orElseThrow(() -> new RuntimeException("Canal não encontrado"));

        Video video = new Video();
        video.setTitle(dto.getTitle());
        video.setDescription(dto.getDescription());
        video.setVideoUrl(dto.getVideoUrl());
        video.setThumbnailUrl(dto.getThumbnailUrl());
        video.setShort(dto.isShort());
        video.setCreatedAt(LocalDateTime.now());
        video.setChannel(channel);

        return videoRepository.save(video);
    }
}
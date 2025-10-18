package com.DiTube.repository;

import com.DiTube.model.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface VideoRepository extends JpaRepository<Video, Long> {
    List<Video> findByChannelId(Long channelId);
    List<Video> findByTitleContainingIgnoreCase(String title);
    List<Video> findByIsShortTrue();
}

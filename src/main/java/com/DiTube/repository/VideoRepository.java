package com.DiTube.repository;

import com.DiTube.model.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VideoRepository extends JpaRepository<Video, Long> {

    List<Video> findByChannelId(Long channelId);

    List<Video> findByIsShortTrue();

    List<Video> findByTitleContainingIgnoreCase(String title);

    @Query("SELECT v FROM Video v ORDER BY v.createdAt DESC")
    List<Video> findAllOrderByCreatedAtDesc();
}
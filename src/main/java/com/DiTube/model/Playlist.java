package com.DiTube.model;

import jakarta.persistence.*;
import jakarta.persistence.ManyToMany;

import java.util.List;

@Entity
public class Playlist {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany
    @JoinTable(
            name = "playlist_videos",
            joinColumns = @JoinColumn(name = "playlist_id"),
            inverseJoinColumns = @JoinColumn(name = "video_id")
    )
    private List<Video> videos;
}

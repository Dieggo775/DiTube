package com.DiTube.model;

import jakarta.persistence.*;
import jakarta.persistence.ManyToOne;

import java.util.List;

@Entity
public class Short {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String videoUrl;
    private String thumbnailUrl;

    @ManyToOne
    private Channel channel;
}

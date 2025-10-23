package com.DiTube.controller;

import com.DiTube.dto.PlaylistRequestDTO;
import com.DiTube.model.Playlist;
import com.DiTube.model.User;
import com.DiTube.model.Video;
import com.DiTube.repository.PlaylistRepository;
import com.DiTube.repository.UserRepository;
import com.DiTube.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/playlists")
public class PlaylistController {

    @Autowired
    private PlaylistRepository playlistRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private VideoRepository videoRepository;

    @PostMapping
    public Playlist createPlaylist(@RequestBody PlaylistRequestDTO dto) {
        User owner = userRepository.findById(dto.getOwnerId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado"));

        List<Video> videos = dto.getVideoIds() != null
                ? dto.getVideoIds().stream()
                .map(id -> videoRepository.findById(id)
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Vídeo não encontrado: " + id)))
                .collect(Collectors.toList())
                : List.of();

        Playlist playlist = new Playlist();
        playlist.setName(dto.getName());
        playlist.setDescription(dto.getDescription());
        playlist.setOwner(owner);
        playlist.setVideos(videos);

        return playlistRepository.save(playlist);
    }

    @GetMapping
    public List<Playlist> getAllPlaylists() {
        return playlistRepository.findAll();
    }

    @GetMapping("/{id}")
    public Playlist getPlaylistById(@PathVariable Long id) {
        return playlistRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Playlist não encontrada"));
    }

    @PutMapping("/{id}")
    public Playlist updatePlaylist(@PathVariable Long id, @RequestBody PlaylistRequestDTO dto) {
        Playlist playlist = playlistRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Playlist não encontrada"));

        playlist.setName(dto.getName());
        playlist.setDescription(dto.getDescription());

        if (dto.getVideoIds() != null) {
            List<Video> videos = dto.getVideoIds().stream()
                    .map(videoId -> videoRepository.findById(videoId)
                            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Vídeo não encontrado: " + videoId)))
                    .collect(Collectors.toList());
            playlist.setVideos(videos);
        }

        return playlistRepository.save(playlist);
    }

    @DeleteMapping("/{id}")
    public void deletePlaylist(@PathVariable Long id) {
        playlistRepository.deleteById(id);
    }
}
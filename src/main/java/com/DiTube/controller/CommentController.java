package com.DiTube.controller;

import com.DiTube.dto.CommentRequestDTO;
import com.DiTube.model.Comment;
import com.DiTube.model.User;
import com.DiTube.model.Video;
import com.DiTube.repository.CommentRepository;
import com.DiTube.repository.UserRepository;
import com.DiTube.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private VideoRepository videoRepository;

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public Comment createComment(@RequestBody CommentRequestDTO dto) {
        Video video = videoRepository.findById(dto.getVideoId())
                .orElseThrow(() -> new RuntimeException("Vídeo não encontrado"));

        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Comment comment = new Comment();
        comment.setContent(dto.getContent());
        comment.setCreatedAt(LocalDateTime.now());
        comment.setVideo(video);
        comment.setUser(user);

        return commentRepository.save(comment);
    }

    @GetMapping("/video/{videoId}")
    public List<Comment> getCommentsByVideo(@PathVariable Long videoId) {
        return commentRepository.findByVideoIdOrderByCreatedAtDesc(videoId);
    }

    @GetMapping
    public List<Comment> getAllComment() {
        return commentRepository.findAll();
    }
}
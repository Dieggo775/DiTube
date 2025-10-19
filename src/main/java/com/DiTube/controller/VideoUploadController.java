package com.DiTube.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;

@RestController
@RequestMapping("/api/upload")
public class VideoUploadController {

    @Value("${upload.directory}")
    private String uploadDirectory;

    @PostMapping("/video")
    public ResponseEntity<String> uploadVideo(@RequestParam("file") MultipartFile file) {
        try {
            String filename = System.currentTimeMillis() + "_" + file.getOriginalFilename();
            Path path = Paths.get(uploadDirectory + File.separator + filename);
            Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
            String fileUrl = "/videos/" + filename;
            return ResponseEntity.ok(fileUrl);
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Erro ao salvar o video.");
        }
    }
}

package com.DiTube.controller;

import com.DiTube.dto.ChannelRequestDTO;
import com.DiTube.model.Channel;
import com.DiTube.repository.ChannelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/channels")
public class ChannelController {

    @Autowired
    private ChannelRepository channelRepository;

    @GetMapping
    public List<Channel> getAllChannels() {
        return channelRepository.findAll();
    }

    @PostMapping
    public Channel createChannel(@RequestBody ChannelRequestDTO dto) {
        Channel channel = new Channel();
        channel.setName(dto.getName());
        channel.setDescription(dto.getDescription());
        return channelRepository.save(channel);
    }
}
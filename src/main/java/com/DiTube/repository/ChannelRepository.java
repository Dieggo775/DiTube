package com.DiTube.repository;

import com.DiTube.model.Channel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ChannelRepository extends JpaRepository<Channel, Long> {
    List<Channel> findByOwnerId(Long ownerId);
}

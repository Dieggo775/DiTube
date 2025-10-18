package com.DiTube.repository;

import com.DiTube.model.Short;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ShortRepository extends JpaRepository<Short, Long> {
    List<Short> findByChannelId(Long channelId);
}

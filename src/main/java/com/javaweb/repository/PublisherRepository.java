package com.javaweb.repository;

import com.javaweb.repository.entity.PublisherEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PublisherRepository extends JpaRepository<PublisherEntity, Long> {
    List<PublisherEntity> findByPublishernameContaining(String publishername);
}

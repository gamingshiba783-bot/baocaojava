package com.javaweb.repository.custom;

import com.javaweb.builder.PublisherSearchBuilder;
import com.javaweb.repository.entity.PublisherEntity;

import java.util.List;

public interface PublisherRepositoryCustom {
    List<PublisherEntity> findAll(PublisherSearchBuilder searchBuilder);
}

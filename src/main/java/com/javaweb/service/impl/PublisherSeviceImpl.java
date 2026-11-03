package com.javaweb.service.impl;

import com.javaweb.repository.PublisherRepository;
import com.javaweb.repository.entity.PublisherEntity;
import com.javaweb.service.Publishersevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class PublisherSeviceImpl implements Publishersevice {

    @Autowired
    private PublisherRepository publisherRepository;
    @Override
    public Map<Long, String> getpublishers() {
        Map<Long, String> publishers = new HashMap<>();
        List<PublisherEntity> publisherEntities = publisherRepository.findAll();
        for(PublisherEntity item : publisherEntities) {
            publishers.put(item.getId(), item.getPublishername());
        }
        return publishers;
    }
}

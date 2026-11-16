package com.javaweb.service.impl;

import com.javaweb.repository.ReaderRepository;
import com.javaweb.repository.entity.ReaderEntity;
import com.javaweb.service.ReaderSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class ReaderSeviceImpl implements ReaderSevice {
    @Autowired
    private ReaderRepository readerRepository;
    @Override
    public Map<Long, String> getreader() {
        Map<Long, String> reader = new HashMap<>();
        List<ReaderEntity> readerEntities = readerRepository.findAll();
        for(ReaderEntity item : readerEntities) {
            reader.put(item.getId(),item.getFullname());
        }
        return reader;
    }
}

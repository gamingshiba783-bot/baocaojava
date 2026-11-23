package com.javaweb.service.impl;

import com.javaweb.builder.ReaderSearchBuilder;
import com.javaweb.converter.ReaderCoverter;
import com.javaweb.converter.ReaderSearchConverter;
import com.javaweb.model.ReaderDTO;
import com.javaweb.repository.ReaderRepository;
import com.javaweb.repository.entity.ReaderEntity;
import com.javaweb.service.ReaderSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class ReaderSeviceImpl implements ReaderSevice {
    @Autowired
    private ReaderRepository readerRepository;
    @Autowired
    private ReaderCoverter readerCoverter;
    @Override
    public Map<Long, String> getreader() {
        Map<Long, String> reader = new HashMap<>();
        List<ReaderEntity> readerEntities = readerRepository.findAll();
        for(ReaderEntity item : readerEntities) {
            reader.put(item.getId(),item.getFullname());
        }
        return reader;
    }

    @Override
    public List<ReaderDTO> findAll(Map<String, Object> params) {
        ReaderSearchBuilder readerSearchBuilder = new ReaderSearchConverter().toreadersearch(params);
        List<ReaderEntity> readerEntities = readerRepository.findAll(readerSearchBuilder);
        List<ReaderDTO> readerDTOs = new ArrayList<>();
        for(ReaderEntity item : readerEntities) {
            ReaderDTO readerDTO = readerCoverter.toReaderDTO(item);
            readerDTOs.add(readerDTO);
        }
        return readerDTOs;
    }

    @Override
    public void isnsertReader(ReaderDTO readerDTO) {
        ReaderEntity readerEntity = readerCoverter.toInsertReader(readerDTO);
        readerRepository.save(readerEntity);
    }

    @Override
    public void updateReader(ReaderDTO readerDTO) {
        ReaderEntity readerEntity = readerCoverter.toUpdateReader(readerDTO);
        readerRepository.save(readerEntity);
    }

    @Override
    public void deleteReader(Long id) {
        readerRepository.deleteById(id);
    }

    @Override
    public ReaderDTO findReaderById(Long id) {
        return readerCoverter.toReaderDTO(readerRepository.findById(id).get());
    }

    @Override
    public Long coutreader() {
        return readerRepository.count();
    }
}

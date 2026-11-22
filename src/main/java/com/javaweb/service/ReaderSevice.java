package com.javaweb.service;

import com.javaweb.model.ReaderDTO;
import com.javaweb.repository.entity.BookEntity;

import java.util.List;
import java.util.Map;

public interface ReaderSevice {
    Map<Long,String> getreader();
    List<ReaderDTO> findAll(Map<String,Object>  params);
    void isnsertReader(ReaderDTO readerDTO);
    void updateReader(ReaderDTO readerDTO);
    void deleteReader(Long id);
    ReaderDTO findReaderById(Long id);

}

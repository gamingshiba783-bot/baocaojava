package com.javaweb.service;

import com.javaweb.model.CategoryDTO;
import com.javaweb.model.PublishDTO;

import java.util.List;
import java.util.Map;

public interface Publishersevice {
    Map<Long,String> getpublishers();
    List<PublishDTO> findAll(Map<String,Object> params);
    void updatePublisher(Long id,PublishDTO publishDTO);
    void insertPublisher(PublishDTO publishDTO);
    void deletePublisher(Long id);
    PublishDTO findbyid(Long id);
}

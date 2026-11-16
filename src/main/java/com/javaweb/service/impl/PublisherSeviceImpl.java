package com.javaweb.service.impl;

import com.javaweb.builder.PublisherSearchBuilder;
import com.javaweb.converter.PublisherSearchConverter;
import com.javaweb.converter.Publisherconverter;
import com.javaweb.model.CategoryDTO;
import com.javaweb.model.PublishDTO;
import com.javaweb.repository.BookRepository;
import com.javaweb.repository.CategoryRepository;
import com.javaweb.repository.PublisherRepository;
import com.javaweb.repository.entity.PublisherEntity;
import com.javaweb.service.Publishersevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class PublisherSeviceImpl implements Publishersevice {

    @Autowired
    private PublisherRepository publisherRepository;
    @Autowired
    private Publisherconverter publisherconverter;
    @Autowired
    private BookRepository bookRepository;
    @Override
    public Map<Long, String> getpublishers() {
        Map<Long, String> publishers = new HashMap<>();
        List<PublisherEntity> publisherEntities = publisherRepository.findAll();
        for(PublisherEntity item : publisherEntities) {
            publishers.put(item.getId(), item.getPublishername());
        }
        return publishers;
    }

    @Override
    public List<PublishDTO> findAll(Map<String, Object> params) {
        PublisherSearchBuilder publisherSearchBuilder = new PublisherSearchConverter().toPublisher(params);
        List<PublisherEntity> publisherEntities = publisherRepository.findAll(publisherSearchBuilder);
        List<PublishDTO> result = new ArrayList<>();
        for(PublisherEntity item : publisherEntities) {
            PublishDTO dto = publisherconverter.toDTO(item);
            result.add(dto);
        }
        return result;
    }

    @Override
    public void updatePublisher(Long id, PublishDTO publishDTO) {
        PublisherEntity publisherEntity = publisherconverter.toupdatepublisher(id,publishDTO);
        publisherRepository.save(publisherEntity);
    }

    @Override
    public void insertPublisher(PublishDTO publishDTO) {
        PublisherEntity publisherEntity = publisherconverter.toinsertpublisher(publishDTO);
        publisherRepository.save(publisherEntity);
    }

    @Override
    public void deletePublisher(Long id) {
        if (bookRepository.existsByPublisher_Id(id)) {
            throw new IllegalStateException("Nhà xuất bản đang có sách, không thể xóa");
        }
        publisherRepository.deleteById(id);
    }

    @Override
    public PublishDTO findbyid(Long id) {
        return publisherconverter.toDTO(publisherRepository.findById(id).get());
    }

}

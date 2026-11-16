package com.javaweb.converter;

import com.javaweb.model.PublishDTO;
import com.javaweb.repository.PublisherRepository;
import com.javaweb.repository.entity.PublisherEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Publisherconverter {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private PublisherRepository publisherRepository;
    public PublishDTO toDTO(PublisherEntity entity) {
        PublishDTO publishDTO = modelMapper.map(entity, PublishDTO.class);
        publishDTO.setId(entity.getId());
        publishDTO.setPublishername(entity.getPublishername());
        publishDTO.setAddress(entity.getAddress());
        publishDTO.setPhone(entity.getPhone());
        publishDTO.setEmail(entity.getEmail());
        return publishDTO;
    }
    public PublisherEntity toinsertpublisher(PublishDTO publishDTO) {
        PublisherEntity publisherEntity = new PublisherEntity();
        publisherEntity.setId(publishDTO.getId());
        publisherEntity.setPublishername(publishDTO.getPublishername());
        publisherEntity.setAddress(publishDTO.getAddress());
        publisherEntity.setPhone(publishDTO.getPhone());
        publisherEntity.setEmail(publishDTO.getEmail());
        return publisherEntity;
    }
    public PublisherEntity toupdatepublisher(Long id,PublishDTO publishDTO) {
        PublisherEntity publisherEntity = publisherRepository.findById(publishDTO.getId()).get();
        publisherEntity.setPublishername(publishDTO.getPublishername());
        publisherEntity.setAddress(publishDTO.getAddress());
        publisherEntity.setPhone(publishDTO.getPhone());
        publisherEntity.setEmail(publishDTO.getEmail());
        return publisherEntity;
    }

}

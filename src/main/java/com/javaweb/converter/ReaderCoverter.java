package com.javaweb.converter;

import com.javaweb.enums.GenderReader;
import com.javaweb.enums.ReaderStatus;
import com.javaweb.model.ReaderDTO;
import com.javaweb.repository.ReaderRepository;
import com.javaweb.repository.entity.ReaderEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
@Component
public class ReaderCoverter {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ReaderRepository readerRepository;
    public ReaderDTO toReaderDTO(ReaderEntity readerEntity) {
        ReaderDTO dto = modelMapper.map(readerEntity, ReaderDTO.class);
        dto.setId(readerEntity.getId());
        dto.setFullname(readerEntity.getFullname());
        dto.setDataofbirth(readerEntity.getDataofbirth());
        dto.setAddress(readerEntity.getAddress());
        dto.setPhone(readerEntity.getPhone());
        dto.setRegistrationdate(readerEntity.getRegistrationdate());
        dto.setExpirydate(readerEntity.getExpirydate());
        String code = readerEntity.getGender();
        if(code != null && !code.isEmpty()) {
            dto.setGender(code);
            dto.setGendername(GenderReader.valueOf(code).getValue());
        }
        ReaderStatus st = ReaderStatus.getByCode(readerEntity.getStatus());
        if(readerEntity.getExpirydate() != null && readerEntity.getExpirydate().isBefore(java.time.LocalDate.now())) {
            st = ReaderStatus.OFFLINE;
        }
        dto.setStatus(st.getCode());
        dto.setStatusCode(st.getCode());
        dto.setStatusName(st.getValue());
        return dto;

    }
    public ReaderEntity toInsertReader(ReaderDTO readerEntity) {
        ReaderEntity reader = new ReaderEntity();
        reader.setFullname(readerEntity.getFullname());
        reader.setDataofbirth(readerEntity.getDataofbirth());
        reader.setAddress(readerEntity.getAddress());
        reader.setPhone(readerEntity.getPhone());
        reader.setRegistrationdate(readerEntity.getRegistrationdate());
        reader.setExpirydate(readerEntity.getExpirydate());
        reader.setStatus(readerEntity.getStatus());
        reader.setGender(readerEntity.getGender());
        return reader;
    }
    public ReaderEntity toUpdateReader(ReaderDTO readerEntity) {
        ReaderEntity reader = readerRepository.findById(readerEntity.getId()).get();
        reader.setFullname(readerEntity.getFullname());
        reader.setDataofbirth(readerEntity.getDataofbirth());
        reader.setAddress(readerEntity.getAddress());
        reader.setPhone(readerEntity.getPhone());
        reader.setRegistrationdate(readerEntity.getRegistrationdate());
        reader.setExpirydate(readerEntity.getExpirydate());
        reader.setStatus(readerEntity.getStatus());
        reader.setGender(readerEntity.getGender());
        return reader;
    }
}

package com.javaweb.service.impl;

import com.javaweb.builder.LoanDetailSearchBuilder;
import com.javaweb.converter.LoanDetailConverter;
import com.javaweb.converter.LoanDetailSearchConverter;
import com.javaweb.model.LoanDetailDTO;
import com.javaweb.repository.LoanDetailRepository;
import com.javaweb.repository.entity.LoandetailEntity;
import com.javaweb.service.LoanDetailSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@Service
public class LoanDetailSeviceImpl implements LoanDetailSevice {
    @Autowired
    private LoanDetailRepository loanDetailRepository;
    @Autowired
    private LoanDetailConverter loanDetailConverter;
    @Override
    public List<LoanDetailDTO> findAll(Map<String, Object> params) {
        LoanDetailSearchBuilder loanDetailSearchBuilder = new LoanDetailSearchConverter().toloandetailsearchbuilder(params);
        List<LoandetailEntity> loandetailEntities = loanDetailRepository.findAll(loanDetailSearchBuilder);
        List<LoanDetailDTO> result = new ArrayList<>();
        for(LoandetailEntity loandetailEntity : loandetailEntities) {
            LoanDetailDTO loanDetailDTO = loanDetailConverter.toloandetail(loandetailEntity);
            result.add(loanDetailDTO);
        }
        return result;
    }

    @Override
    public void insertLoanDetail(LoanDetailDTO loanDetailDTO) {
        LoandetailEntity loandetailEntity = loanDetailConverter.insertdetail(loanDetailDTO);
        loanDetailRepository.save(loandetailEntity);
    }

    @Override
    public void updateLoanDetail(LoanDetailDTO loanDetailDTO) {
        LoandetailEntity loandetailEntity = loanDetailConverter.updatedetail(loanDetailDTO);
        loanDetailRepository.save(loandetailEntity);
    }

    @Override
    public void deleteLoanDetail(Long id) {
        loanDetailRepository.deleteById(id);
    }

    @Override
    public LoanDetailDTO findbyid(Long id) {
        return loanDetailConverter.toloandetail(loanDetailRepository.findById(id).get());
    }
}

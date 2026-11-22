package com.javaweb.service.impl;

import com.javaweb.builder.LoanSearchBuilder;
import com.javaweb.converter.LoanConverter;
import com.javaweb.converter.LoanSearchConverter;
import com.javaweb.model.LoanDTO;
import com.javaweb.model.PublishDTO;
import com.javaweb.repository.LoanRepository;
import com.javaweb.repository.entity.LoanEntity;
import com.javaweb.service.Booksevice;
import com.javaweb.service.LoanSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class LoanSeviceImpl implements LoanSevice {
    @Autowired
    private LoanRepository loanRepository;
    @Autowired
    private LoanConverter loanConverter;

    @Override
    public Map<Long, String> getloan() {
        Map<Long, String> loans = new HashMap<>();
        List<LoanEntity> loanEntities = this.loanRepository.findAll();
        for (LoanEntity loanEntity : loanEntities) {
            loans.put(loanEntity.getId(),String.valueOf(loanEntity.getId()));
        }
        return loans;
    }

    @Override
    public List<LoanDTO> findAll(Map<String, Object> params) {
        LoanSearchBuilder loanSearchBuilder = new LoanSearchConverter().toLoanSearchBuilder(params);
        List<LoanEntity> loanEntities = loanRepository.findAll(loanSearchBuilder);
        List<LoanDTO> result = new ArrayList<>();
        for(LoanEntity loanEntity : loanEntities){
            LoanDTO loanDTO = loanConverter.toloan(loanEntity);
            result.add(loanDTO);
        }
        return result;
    }

    @Override
    public void insertLoan(LoanDTO loanDTO) {
        System.out.println("DTO BorrowDate: " + loanDTO.getBorrowdate());
        System.out.println("DTO DueDate: " + loanDTO.getDuedate());

        LoanEntity loanEntity = loanConverter.insertloan(loanDTO);
        System.out.println("Entity BorrowDate: " + loanEntity.getBorrowdate());
        loanRepository.save(loanEntity);
    }

    @Override
    public void updateLoan(Long id,LoanDTO loanDTO) {
        LoanEntity loanEntity = loanConverter.updateloan(loanDTO);
        loanRepository.save(loanEntity);
    }

    @Override
    public void deleteLoan(Long id) {
        loanRepository.deleteById(id);
    }

    @Override
    public LoanDTO findbyid(Long id) {
        return loanConverter.toloan(loanRepository.findById(id).get());
    }

    @Override
    public List<LoanDTO> findbyids() {
        List<LoanDTO> result = new ArrayList<>();
        for(LoanEntity loanEntity : loanRepository.findTop5ByOrderByBorrowdateDescIdDesc()){
            result.add(loanConverter.toloan(loanEntity));
        }
        return result;
    }
    @Override
    public Long coutloan() {
        return loanRepository.count();
    }

    @Override
    public Long statusloan() {
        if()
        return 0L;
    }
}

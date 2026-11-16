package com.javaweb.service;

import com.javaweb.model.LoanDetailDTO;
import com.javaweb.repository.entity.LoandetailEntity;

import java.util.List;
import java.util.Map;

public interface LoanDetailSevice {
    List<LoanDetailDTO> findAll(Map<String, Object> params);
    void insertLoanDetail(LoanDetailDTO loanDetailDTO);
    void updateLoanDetail(LoanDetailDTO loanDetailDTO);
    void deleteLoanDetail(Long id);
    LoanDetailDTO findbyid(Long id);
}

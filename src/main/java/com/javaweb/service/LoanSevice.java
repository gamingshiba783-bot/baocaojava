package com.javaweb.service;

import com.javaweb.enums.Loanstatus;
import com.javaweb.model.LoanDTO;
import com.javaweb.model.PublishDTO;

import java.util.List;
import java.util.Map;

public interface LoanSevice {
    Map<Long,String> getloan();
    List<LoanDTO> findAll(Map<String,Object> params);
    void insertLoan(LoanDTO loanDTO);
    void updateLoan(Long id,LoanDTO loanDTO);
    void deleteLoan(Long id);
    LoanDTO findbyid(Long id);
}

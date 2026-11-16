package com.javaweb.converter;

import com.javaweb.enums.Loanstatus;
import com.javaweb.model.LoanDTO;
import com.javaweb.repository.LoanRepository;
import com.javaweb.repository.ReaderRepository;
import com.javaweb.repository.entity.BookEntity;
import com.javaweb.repository.entity.LoanEntity;
import com.javaweb.repository.entity.ReaderEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class LoanConverter {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private LoanRepository loanRepository;
    public LoanDTO toloan(LoanEntity loanEntity) {
        LoanDTO loanDTO = modelMapper.map(loanEntity, LoanDTO.class);
        loanDTO.setId(loanEntity.getId());
        loanDTO.setBorrowdate(loanEntity.getBorrowdate());
        loanDTO.setDuedate(loanEntity.getDuedate());
        if (loanEntity.getReader() != null) {
            loanDTO.setReaders(loanEntity.getReader().getFullname());
        }
        Loanstatus st = Loanstatus.fromCode(loanEntity.getStatus());
        if( loanEntity.getDuedate() != null && loanEntity.getDuedate().isBefore(java.time.LocalDate.now())) {
            st= Loanstatus.OVERDUE;
        }
        loanDTO.setStatus(st.getCode());
        loanDTO.setStatuscode(st.getCode());
        loanDTO.setStatusname(st.getStatusname());

        return loanDTO;
    }
    public LoanEntity insertloan(LoanDTO loanDTO) {
        LoanEntity loan = new LoanEntity();
        loan.setId(loanDTO.getId());
        loan.setBorrowdate(loanDTO.getBorrowdate());
        loan.setDuedate(loanDTO.getDuedate());
        loan.setStatus(loanDTO.getStatus());
        ReaderEntity reader = new ReaderEntity();
        reader.setId(loanDTO.getReaderid());
        loan.setReader(reader);
        return loan;
    }
    public LoanEntity updateloan(LoanDTO loanDTO) {
        LoanEntity loan = loanRepository.findById(loanDTO.getId()).get();
        loan.setBorrowdate(loanDTO.getBorrowdate());
        loan.setDuedate(loanDTO.getDuedate());
        loan.setStatus(loanDTO.getStatus());
        ReaderEntity reader = new ReaderEntity();
        reader.setId(loanDTO.getReaderid());
        loan.setReader(reader);
        return loan;
    }
}

package com.javaweb.converter;

import com.javaweb.enums.LoanDetail;
import com.javaweb.enums.Loanstatus;
import com.javaweb.model.LoanDetailDTO;
import com.javaweb.repository.LoanDetailRepository;
import com.javaweb.repository.entity.BookEntity;
import com.javaweb.repository.entity.CategoryEntity;
import com.javaweb.repository.entity.LoanEntity;
import com.javaweb.repository.entity.LoandetailEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class LoanDetailConverter {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private LoanDetailRepository loanDetailRepository;
    public LoanDetailDTO toloandetail(LoandetailEntity loandetailEntity) {
        LoanDetailDTO loanDetailDTO = modelMapper.map(loandetailEntity, LoanDetailDTO.class);
        loanDetailDTO.setId(loandetailEntity.getId());
        loanDetailDTO.setBookid(loandetailEntity.getBook().getId());
        loanDetailDTO.setLoanid(loandetailEntity.getLoan().getId());
        loanDetailDTO.setBooks(loandetailEntity.getBook().getBookname());
        loanDetailDTO.setActualReturnDate(loandetailEntity.getActualReturnDate());
        loanDetailDTO.setReturnCondition(loandetailEntity.getReturnCondition());
        String code = loandetailEntity.getReturnCondition();
        if (code != null && !code.isEmpty()) {
            loanDetailDTO.setReturnCondition(code);
            loanDetailDTO.setReturnname(LoanDetail.valueOf(code).getNameReturnCondition());
        }
        return loanDetailDTO;
    }
    public  LoandetailEntity insertdetail(LoanDetailDTO loanDetailDTO) {
        LoandetailEntity loandetailEntity = new LoandetailEntity();
        loandetailEntity.setId(loanDetailDTO.getId());
        loandetailEntity.setActualReturnDate(loanDetailDTO.getActualReturnDate());
        loandetailEntity.setReturnCondition(loanDetailDTO.getReturnCondition());
        BookEntity book = new BookEntity();
        book.setId(loanDetailDTO.getBookid());
        loandetailEntity.setBook(book);
        LoanEntity loan = new LoanEntity();
        loan.setId(loanDetailDTO.getLoanid());
        loandetailEntity.setLoan(loan);
        return loandetailEntity;
    }
    public LoandetailEntity updatedetail(LoanDetailDTO loanDetailDTO) {
        LoandetailEntity loandetailEntity = loanDetailRepository.findById(loanDetailDTO.getId()).get();
        loandetailEntity.setId(loanDetailDTO.getId());
        loandetailEntity.setActualReturnDate(loanDetailDTO.getActualReturnDate());
        loandetailEntity.setReturnCondition(loanDetailDTO.getReturnCondition());
        BookEntity book = new BookEntity();
        book.setId(loanDetailDTO.getBookid());
        loandetailEntity.setBook(book);
        LoanEntity loan = new LoanEntity();
        loan.setId(loanDetailDTO.getLoanid());
        loandetailEntity.setLoan(loan);
        return loandetailEntity;
    }

}

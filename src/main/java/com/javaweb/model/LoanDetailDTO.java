package com.javaweb.model;

import javax.persistence.Column;
import java.time.LocalDate;

public class LoanDetailDTO {
    private Long id;
    private LocalDate actualReturnDate;
    private String returnCondition;
    private String loans;
    private String books;
    private Long loanid;
    private Long bookid;
    private Integer returncode;
    private String returnname;

    public Integer getReturncode() {
        return returncode;
    }

    public void setReturncode(Integer returncode) {
        this.returncode = returncode;
    }

    public String getReturnname() {
        return returnname;
    }

    public void setReturnname(String returnname) {
        this.returnname = returnname;
    }

    public Long getLoanid() {
        return loanid;
    }

    public void setLoanid(Long loanid) {
        this.loanid = loanid;
    }

    public Long getBookid() {
        return bookid;
    }

    public void setBookid(Long bookid) {
        this.bookid = bookid;
    }

    public String getLoans() {
        return loans;
    }

    public void setLoans(String loans) {
        this.loans = loans;
    }

    public String getBooks() {
        return books;
    }

    public void setBooks(String books) {
        this.books = books;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getActualReturnDate() {
        return actualReturnDate;
    }

    public void setActualReturnDate(LocalDate actualReturnDate) {
        this.actualReturnDate = actualReturnDate;
    }

    public String getReturnCondition() {
        return returnCondition;
    }

    public void setReturnCondition(String returnCondition) {
        this.returnCondition = returnCondition;
    }
}

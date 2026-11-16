package com.javaweb.repository.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Loandetail")
public class LoandetailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "BookID")
    private BookEntity book;
    @ManyToOne
    @JoinColumn(name = "LoanID")
    private LoanEntity loan;
    @Column(name="ActualReturnDate")
    private LocalDate actualReturnDate;
    @Column(name="ReturnCondition")
    private String returnCondition;

    public BookEntity getBook() {
        return book;
    }

    public void setBook(BookEntity book) {
        this.book = book;
    }

    public LoanEntity getLoan() {
        return loan;
    }

    public void setLoan(LoanEntity loan) {
        this.loan = loan;
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

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

}

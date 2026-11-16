package com.javaweb.builder;

import java.time.LocalDate;

public class LoanDetailSearchBuilder {
    private Long id;
    private LocalDate actualReturnDate;
    private String returnCondition;
    private LoanDetailSearchBuilder (Builder builder){
        this.id=builder.id;
        this.actualReturnDate=builder.actualReturnDate;
        this.returnCondition=builder.returnCondition;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getActualReturnDate() {
        return actualReturnDate;
    }

    public String getReturnCondition() {
        return returnCondition;
    }
    public static class Builder{
        private Long id;
        private LocalDate actualReturnDate;
        private String returnCondition;

        public  Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Builder setActualReturnDate(LocalDate actualReturnDate) {
            this.actualReturnDate = actualReturnDate;
            return this;
        }

        public Builder setReturnCondition(String returnCondition) {
            this.returnCondition = returnCondition;
            return this;
        }
        public LoanDetailSearchBuilder build(){
            return new LoanDetailSearchBuilder(this);
        }
    }
}

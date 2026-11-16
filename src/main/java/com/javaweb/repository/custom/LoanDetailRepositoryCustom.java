package com.javaweb.repository.custom;

import com.javaweb.builder.LoanDetailSearchBuilder;
import com.javaweb.repository.entity.LoandetailEntity;

import java.util.List;

public interface LoanDetailRepositoryCustom {
    List<LoandetailEntity> findAll(LoanDetailSearchBuilder loanDetailSearchBuilder);

}

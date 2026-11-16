package com.javaweb.repository.custom;

import com.javaweb.builder.LoanSearchBuilder;
import com.javaweb.repository.entity.LoanEntity;
import java.util.List;

public interface LoanRepositoryCustom {
    List<LoanEntity> findAll(LoanSearchBuilder loanSearchBuilder);
}
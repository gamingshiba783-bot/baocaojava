package com.javaweb.repository;

import com.javaweb.repository.custom.LoanDetailRepositoryCustom;
import com.javaweb.repository.entity.CategoryEntity;
import com.javaweb.repository.entity.LoanEntity;
import com.javaweb.repository.entity.LoandetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanDetailRepository extends JpaRepository<LoandetailEntity, Long>, LoanDetailRepositoryCustom {
}

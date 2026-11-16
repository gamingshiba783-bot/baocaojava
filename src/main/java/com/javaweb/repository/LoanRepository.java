package com.javaweb.repository;

import com.javaweb.repository.custom.LoanRepositoryCustom;
import com.javaweb.repository.entity.LoanEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<LoanEntity, Long>, LoanRepositoryCustom {
}
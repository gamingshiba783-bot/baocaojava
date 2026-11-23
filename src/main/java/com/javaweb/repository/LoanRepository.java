package com.javaweb.repository;

import com.javaweb.repository.custom.LoanRepositoryCustom;
import com.javaweb.repository.entity.LoanEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoanRepository extends JpaRepository<LoanEntity, Long>, LoanRepositoryCustom {
    List<LoanEntity> findTop5ByOrderByBorrowdateDescIdDesc();
    Long countByStatus(int status);
}
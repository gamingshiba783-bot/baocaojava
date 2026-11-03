package com.javaweb.repository;

import java.util.List;
import java.util.Map;

import com.javaweb.builder.LoanSearchBuilder;
import com.javaweb.repository.entity.LoanEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository{
	List<LoanEntity> findAll(LoanSearchBuilder builder);
}

package com.javaweb.repository;

import java.util.List;
import java.util.Map;

import com.javaweb.repository.entity.LoanEntity;

public interface LoanRepository {
	List<LoanEntity> find(Map<String,Object>params);
}

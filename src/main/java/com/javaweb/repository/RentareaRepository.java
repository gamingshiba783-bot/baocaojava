package com.javaweb.repository;

import java.util.List;

import com.javaweb.repository.entity.RentareaEntity;

public interface RentareaRepository {
	List<RentareaEntity> findByBuildingId(Long buildingid);
}

package com.javaweb.repository;

import java.util.List;
import java.util.Map;

import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.converter.BuildingSearchConverter;
import com.javaweb.repository.entity.Buildingentity;

public interface BuildingRepository {
	List<Buildingentity> search(BuildingSearchBuilder builder);
}

package com.javaweb.service;

import java.util.List;
import java.util.Map;

import com.javaweb.converter.BuildingSearchConverter;
import com.javaweb.model.buildingbean;
import com.javaweb.repository.entity.Buildingentity;

public interface Buildingservice {
	List<buildingbean> search(Map<String,Object> params,List<String> typecode);
}

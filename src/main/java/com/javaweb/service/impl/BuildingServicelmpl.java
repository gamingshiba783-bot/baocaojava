package com.javaweb.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.converter.BuildingDTOConverter;
import com.javaweb.converter.BuildingSearchConverter;
import com.javaweb.model.buildingbean;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.entity.Buildingentity;
import com.javaweb.repository.impl.JDBCBuildingRepositorylmpl;
import com.javaweb.service.Buildingservice;

@Service
public class BuildingServicelmpl implements Buildingservice{
	@Autowired
	private BuildingRepository  buildingRepository;
	@Autowired
	private BuildingDTOConverter buildingDTOConverter;
	@Autowired
	private BuildingSearchConverter buildingSearchConverter;
	@Autowired
	private JDBCBuildingRepositorylmpl buildingRepositorylmpl;
	@Override
	public List<buildingbean> search(Map<String,Object> params,List<String> typecode) {
		// TODO Auto-generated method stub
		BuildingSearchBuilder builder = buildingSearchConverter.toBuildingSearchBuilder(params, typecode);
		List<Buildingentity> buildingentitys = buildingRepositorylmpl.search(builder);
		List<buildingbean> result=new ArrayList<buildingbean>();
		for(Buildingentity item : buildingentitys) {

		    buildingbean building = buildingDTOConverter.tobuilding(item);
		    result.add(building);
		}
		return result;
	}
}

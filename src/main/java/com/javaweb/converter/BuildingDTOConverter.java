package com.javaweb.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.javaweb.model.buildingbean;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.DistrictRepository;
import com.javaweb.repository.RentareaRepository;
import com.javaweb.repository.entity.Buildingentity;
import com.javaweb.repository.entity.DistrictEntity;
import com.javaweb.repository.entity.RentareaEntity;
@Component
public class BuildingDTOConverter {
	@Autowired
	private ModelMapper modelMapper;
	public buildingbean tobuilding(Buildingentity item) {
		buildingbean building = modelMapper.map(item,buildingbean.class);
	    List<RentareaEntity> rentareaEntities = item.getItems();
	   String areaResult = rentareaEntities.stream().map(it->it.getValue().toString()).collect(Collectors.joining(" ,"));
	    building.setName(item.getName());
	    building.setAdress(item.getStreet()+","+item.getWard()+","+item.getDistrict().getName());
	    building.setNumberofbasement(item.getNumberofbasement());
	    building.setRentArea(areaResult);
	    return building;

	}
}

package com.javaweb.converter;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.utils.MapUtil;
@Component
public class BuildingSearchConverter {
	public BuildingSearchBuilder toBuildingSearchBuilder (Map<String,Object>params,List<String>typecode) {
		BuildingSearchBuilder buildingSearchBuilder = new BuildingSearchBuilder.Builder().setName(MapUtil.getObject(params, "name", String.class))
																						 .setFloorArea(MapUtil.getObject(params, "floorarea", Long.class))
																						 .setWard(MapUtil.getObject(params, "ward", String.class))
																						 .setStreet(MapUtil.getObject(params, "street", String.class))
																						 .setDistrictid(MapUtil.getObject(params, "districtid", Long.class))
																						 .setNumberofbasement(MapUtil.getObject(params, "numberofbasement", Integer.class))
																						 .setTypecode(typecode)
																						 .setManagername(MapUtil.getObject(params, "managername", String.class))
																						 .setManagerphone(MapUtil.getObject(params, "managerphone", String.class))
																						 .setRentPriceFrom(MapUtil.getObject(params, "rentPriceFrom", Long.class))
																						 .setRentPriceTo(MapUtil.getObject(params, "rentPriceTo", Long.class))
																						 .setRentAreaFrom(MapUtil.getObject(params, "rentAreaFrom", Long.class))
																						 .setRentAreaTo(MapUtil.getObject(params, "rentAreaTo", Long.class))
																						 .setStaffid(MapUtil.getObject(params, "staffid", Long.class))
																						 .build();
		return buildingSearchBuilder;
	}
}

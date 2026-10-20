package com.javaweb.repository.impl;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Repository;

import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.entity.Buildingentity;
import com.javaweb.utils.ConnectJDBCUntil;

@Repository
@PropertySource("classpath:application.properties")
public class JDBCBuildingRepositorylmpl implements BuildingRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Value("${spring.datasource.url}")
	private String DB_URL;
	
	@Value("${spring.datasource.username}")
	private String USER;
	
	@Value("${spring.datasource.password}")
	private String PASS;
	public static void queryNomal(BuildingSearchBuilder builder,StringBuilder where) {
		try {
			Field[] fields = BuildingSearchBuilder.class.getDeclaredFields();
		for(Field item : fields) {
			item.setAccessible(true);
			String fielname = item.getName();
			if(!fielname.equals("staffid") && !fielname.equals("typecode") && !fielname.startsWith("rent") && !fielname.startsWith("rentPrice")) {
				Object value = item.get(builder);
				if(value!=null) {
					if(item.getType().getName().equals("java.lang.Integer") || item.getType().getName().equals("java.lang.Long") || item.getType().getName().equals("java.lang.Float")) {
						where.append(" AND b."+fielname+" = "+value);
					}else if(item.getType().getName().equals("java.lang.String")){
						where.append(" AND b."+fielname+" LIKE '%"+value+"%' ");
					}
				}
			}
		}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	public static void queryspecial(BuildingSearchBuilder builder,StringBuilder where) {
		Long staffid = builder.getStaffid();
		if(staffid!=null) {
			where.append(" AND ab.staffid = "+staffid);
		}
		Long rentAreaTo = builder.getRentAreaTo();
		Long rentAreaFrom = builder.getRentAreaFrom();
		if(rentAreaFrom!=null || rentAreaTo!=null) {
			if(rentAreaFrom!=null) {
				where.append(" AND r.value >= "+rentAreaFrom);
			}
			if(rentAreaTo!=null) {
				where.append(" AND r.value <= "+rentAreaTo);
			}
		}
		Long rentPriceTo = builder.getRentPriceTo();
		Long rentPriceFrom = builder.getRentPriceFrom();
		if(rentPriceFrom!=null || rentPriceTo!=null) {
			if(rentPriceFrom!=null) {
				where.append( "AND b.rentprice >= "+rentPriceFrom);
			}
			if(rentPriceTo!=null) {
				where.append(" AND b.rentprice <= "+rentPriceTo);
			}
		}
		//java 7
//		if(typecode != null && typecode.size() !=0 ) {
//			List<String> code = new ArrayList<>();
//			for(String item : typecode) {
//				code.add("'"+item+"'");
//			}
//			where.append(" AND renttype.code IN(" + String.join(",", code) + ") ");
//		}
//java 8
		List<String> typecode = builder.getTypecode();
		if(typecode != null && typecode.size() !=0) {
			where.append(" AND EXISTS (SELECT * FROM buildingrenttype tp WHERE b.id = tp.buildingid ");
			where.append(" AND EXISTS (SELECT * FROM renttype rt WHERE tp.renttypeid = rt.id ");
			where.append(" AND ( ");
			String sql = typecode.stream().map(type -> " rt.code LIKE "+"'%"+type+"%' ").collect(Collectors.joining(" OR "));
			where.append(sql);
			where.append("))) ");
		}
	}
	@Override
	public List<Buildingentity> search(BuildingSearchBuilder builder) {
		 StringBuilder sql = new StringBuilder(
		            "SELECT b.id,b.name,b.districtid,b.street,b.ward,b.numberofbasement,b.floorarea,b.managername,b.managerphone,b.direction,b.level,b.rentprice,b.servicefee,b.brokeragefee "
		            + "FROM building b "
		        );
		 StringBuilder where = new StringBuilder("WHERE 1=1 ");
		 queryNomal(builder, where);
		 queryspecial(builder,where);
		 where.append(" GROUP BY b.id ;");
		 sql.append(where);
		 Query query = entityManager.createNativeQuery(sql.toString(),Buildingentity.class);
		 return query.getResultList();
	}
}
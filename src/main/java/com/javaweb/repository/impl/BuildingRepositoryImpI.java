package com.javaweb.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.entity.Buildingentity;

@Repository
@Primary
public class BuildingRepositoryImpI implements BuildingRepository{
	@PersistenceContext
	private EntityManager entityManager;
	@Override
	public List<Buildingentity> search(BuildingSearchBuilder builder) {
		// TODO Auto-generated method stub
		//jpql
//		String sql = "FROM Buildingentity b WHERE b.id =1 ";
//		Query query = entityManager.createQuery(sql,Buildingentity.class);
//		return query.getResultList();
		//sql native
		String name = builder.getName();
		StringBuilder sql = new StringBuilder("SELECT * FROM building b WHERE b.name ");
		String getname = "LIKE '%"+name+"%' ";
		sql.append(getname);
		Query query = entityManager.createNativeQuery(sql.toString(),Buildingentity.class);
		return query.getResultList();
	}
	
}

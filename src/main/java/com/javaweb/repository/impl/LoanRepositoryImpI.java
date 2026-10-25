package com.javaweb.repository.impl;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;


import com.javaweb.builder.LoanSearchBuilder;
import com.javaweb.repository.LoanRepository;
import com.javaweb.repository.entity.LoanEntity;

@Repository
public class LoanRepositoryImpI implements LoanRepository {
	@PersistenceContext
	EntityManager entityManager;
	public static void QueryNomal(LoanSearchBuilder builder,StringBuilder where) {
		try {
			Field[] fields = LoanSearchBuilder.class.getDeclaredFields();
			for(Field item : fields) {
				item.setAccessible(true);
				String fielsname = item.getName();
				Object value = item.get(builder);
				if(item.getType().getName().equals(Integer.class) || item.getType().getName().equals(Long.class)) {
					where.append("AND b."+fielsname+" = "+value);
				}else if(item.getType().getName().equals(LocalDate.class)) {
					where.append("AND b."+fielsname+"= '"+value+"' ");
				}else if(item.getType().getName().equals(String.class)) {
					where.append("AND b."+fielsname+" LIKE '%"+value+"%' ");
				}
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	@Override
	public List<LoanEntity> find(Map<String, Object> params) {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder("SELECT * FROM loan lo ");
		StringBuilder where = new StringBuilder("WHERE 1=1");
		return null;
	}
	
}

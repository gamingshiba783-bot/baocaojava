package com.javaweb.repository.impl;

import java.lang.reflect.Field;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.javaweb.builder.BookSearchBuilder;
import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.repository.BookRepository;
import com.javaweb.repository.entity.BookEntity;
//@Repository
//public class BookRepositoryImpI implements BookRepository{
//	@PersistenceContext
//	private EntityManager entityManager;
//	public static void querynomal(BookSearchBuilder bookSearchBuilder,StringBuilder where) {
//		try {
//			Field[] fields = BookSearchBuilder.class.getDeclaredFields();
//			for(Field item : fields) {
//				item.setAccessible(true);
//				String fieldname = item.getName();
//				Object value = item.get(bookSearchBuilder);
//			    if (value == null) {
//	                continue;
//	            }
//				if(item.getType().getName().equals("java.lang.Integer") || item.getType().getName().equals("java.lang.Long")) {
//					where.append("AND b."+fieldname+" = "+value);
//				}
//				if(item.getType().getName().equals("java.lang.String")) {
//					where.append("AND b."+fieldname+" LIKE '%"+value+"%'");
//				}
//			}
//			
//		}catch(Exception ex) {
//			ex.getStackTrace();
//		}
//	}
//	
//	//@Override
//	public List<BookEntity> find(BookSearchBuilder bookSearchBuilder) {
//		System.out.println("Repository class: " + this.getClass());
//		System.out.println("EntityManager: " + entityManager);
//		StringBuilder sql = new StringBuilder("SELECT * FROM book b ");
//		StringBuilder where = new StringBuilder("WHERE 1=1 ");
//		querynomal(bookSearchBuilder,where);
//		sql.append(where);
//		System.out.println("EntityManager: " + entityManager);
//		System.out.println("SQL: " + sql.toString());
//		Query query = entityManager.createNativeQuery(sql.toString(),BookEntity.class);
//		// TODO Auto-generated method stub
//		return query.getResultList();
//	}
//	
//}

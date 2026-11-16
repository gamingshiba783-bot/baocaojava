package com.javaweb.repository.impl;

import com.javaweb.builder.CategorySearchBuilder;
import com.javaweb.repository.custom.CategoryRepositoryCustom;
import com.javaweb.repository.entity.CategoryEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.lang.reflect.Field;
import java.util.List;

public class CategoryRepositoryImpl implements CategoryRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;

    public static void querynomal(CategorySearchBuilder builder,StringBuilder where) {
        try{
            Field[] fields =   CategorySearchBuilder.class.getDeclaredFields();
            for(Field field : fields){
                field.setAccessible(true);
                String fieldName = field.getName();
                Object value = field.get(builder);
                if(value == null){
                    continue;
                }
                if(field.getType().getName().equals("java.lang.Integer")  || field.getType().getName().equals("java.lang.Long")){
                    where.append(" AND c."+fieldName+"="+value);
                }
                if(field.getType().getName().equals("java.lang.String")){
                    where.append(" AND c."+fieldName+" LIKE '%"+value+"%' ");
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    @Override
    public List<CategoryEntity> findAll(CategorySearchBuilder builder) {
        StringBuilder sql = new StringBuilder("SELECT * FROM category c ");
        StringBuilder where = new StringBuilder("WHERE 1=1 ");
        querynomal(builder, where);
        sql.append(where);
        System.out.println("EntityManager: " + entityManager);
        System.out.println("SQL: " + sql.toString());
        Query query = entityManager.createNativeQuery(sql.toString(),CategoryEntity.class);
        return query.getResultList();
    }
}

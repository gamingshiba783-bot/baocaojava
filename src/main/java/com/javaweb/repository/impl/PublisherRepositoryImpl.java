package com.javaweb.repository.impl;

import com.javaweb.builder.PublisherSearchBuilder;
import com.javaweb.repository.custom.PublisherRepositoryCustom;
import com.javaweb.repository.entity.PublisherEntity;
import com.javaweb.repository.entity.ReaderEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

public class PublisherRepositoryImpl implements PublisherRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;
    public static void querynomal(PublisherSearchBuilder publisherSearchBuilder,StringBuilder where){
        try{
            Field[] fields = publisherSearchBuilder.getClass().getDeclaredFields();
            for(Field field : fields){
                field.setAccessible(true);
                String fieldName = field.getName();
                Object value = field.get(publisherSearchBuilder);
                if(value == null){
                    continue;
                }
                if(field.getType().getName().equals("java.lang.Integer")  || field.getType().getName().equals("java.lang.Long")){
                    where.append("AND r."+fieldName+" = "+value);
                }
                if(field.getType().getName().equals("java.lang.String")){
                    where.append("AND r."+fieldName+" LIKE '%"+value+"%' ");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Override
    public List<PublisherEntity> findAll(PublisherSearchBuilder publisherSearchBuilder) {
        StringBuilder sql = new StringBuilder("SELECT * FROM publisher r ");
        StringBuilder where = new StringBuilder("WHERE 1=1 ");
        querynomal(publisherSearchBuilder,where);
        sql.append(where);
        Query query = entityManager.createNativeQuery(sql.toString(), PublisherEntity.class);
        return query.getResultList();
    }
}

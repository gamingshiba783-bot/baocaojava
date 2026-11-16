package com.javaweb.repository.impl;

import com.javaweb.builder.ReaderSearchBuilder;
import com.javaweb.repository.custom.ReaderRepositoryCustom;
import com.javaweb.repository.entity.ReaderEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
@Repository
public class ReaderRepositoryImpl implements ReaderRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;
    public void querynomal(ReaderSearchBuilder readerSearchBuilder,StringBuilder where){
        try{
            Field[] fields = readerSearchBuilder.getClass().getDeclaredFields();
            for(Field field : fields){
                field.setAccessible(true);
                String fieldName = field.getName();
                Object value = field.get(readerSearchBuilder);
                if(value == null){
                    continue;
                }
                if(field.getType().equals(Integer.class) || field.getType().equals(Long.class)){
                    where.append(" AND r."+fieldName+" = "+value);
                }
                if(field.getType().equals(String.class)){
                    where.append(" AND r."+fieldName+" LIKE '%"+value+"%' ");
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public List<ReaderEntity> findAll(ReaderSearchBuilder readerSearchBuilder) {
        StringBuilder sql = new StringBuilder("SELECT * FROM reader r ");
        StringBuilder where = new StringBuilder(" WHERE 1=1 ");
        querynomal(readerSearchBuilder,where);
        sql.append(where);
        Query query = entityManager.createNativeQuery(sql.toString(),ReaderEntity.class);
        return query.getResultList();
    }
}

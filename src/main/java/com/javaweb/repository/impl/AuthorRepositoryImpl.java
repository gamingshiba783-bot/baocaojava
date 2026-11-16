package com.javaweb.repository.impl;

import com.javaweb.builder.AuthorSearchBuilder;
import com.javaweb.repository.AuthorRepository;
import com.javaweb.repository.custom.AuthorRepositoryCustom;
import com.javaweb.repository.entity.AuthorEntity;
import org.springframework.boot.autoconfigure.validation.ValidationAutoConfiguration;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.lang.reflect.Field;
import java.util.List;
@Repository
public class AuthorRepositoryImpl implements AuthorRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;
    public static void  querynomal(AuthorSearchBuilder authorSearchBuilder,StringBuilder where)
    {
        try{
            Field[] fields = AuthorSearchBuilder.class.getDeclaredFields();
            for(Field field : fields) {
                field.setAccessible(true);
                String fieldName = field.getName();
                Object value = field.get(authorSearchBuilder);
                if(value == null)
                {
                    continue;
                }
                if(field.getType().getName().equals("java.lang.Integer") || field.getType().getName().equals("java.lang.Long")){
                    where.append(" AND a."+fieldName+" = "+value );
                }
                if(field.getType().getName().equals("java.lang.String")){
                    where.append(" AND a."+fieldName+" LIKE '%"+value+"%' ");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Override
    public List<AuthorEntity> findAll(AuthorSearchBuilder authorSearchBuilder) {
        StringBuilder sql = new StringBuilder("SELECT * FROM author a ");
        StringBuilder where = new StringBuilder("WHERE 1=1 ");
        querynomal(authorSearchBuilder,where);
        sql.append(where);
        Query query = entityManager.createNativeQuery(sql.toString(),AuthorEntity.class);
        return query.getResultList();
    }
}

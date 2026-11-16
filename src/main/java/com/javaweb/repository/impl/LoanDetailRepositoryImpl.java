package com.javaweb.repository.impl;

import com.javaweb.builder.LoanDetailSearchBuilder;
import com.javaweb.repository.custom.LoanDetailRepositoryCustom;
import com.javaweb.repository.entity.LoandetailEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.List;

public class LoanDetailRepositoryImpl implements LoanDetailRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;
    public static void querynomal(LoanDetailSearchBuilder loanDetailSearchBuilder,StringBuilder where) {
        try{
            Field[] fields = loanDetailSearchBuilder.getClass().getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                String fieldName = field.getName();
                Object value = field.get(loanDetailSearchBuilder);
                if (value == null) {
                    continue;
                }
                if(field.getType().getName().equals(Long.class) || field.getType().getName().equals(Integer.class)) {
                    where.append(" AND loan."+fieldName+" = "+value);
                }
                if(field.getType().getName().equals(LocalDate.class)){
                    where.append(" AND loan."+fieldName+" = '"+value+"' ");
                }
                if(field.getType().getName().equals(String.class)){
                    where.append(" AND loan."+fieldName+" LIKE '%"+value+"%' ");
                }

            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    @Override
    public List<LoandetailEntity> findAll(LoanDetailSearchBuilder loanDetailSearchBuilder) {
        StringBuilder sql = new StringBuilder("SELECT * FROM loandetail loan ");
        StringBuilder where = new StringBuilder("WHERE 1=1 ");
        querynomal(loanDetailSearchBuilder,where);
        sql.append(where);
        Query query = entityManager.createNativeQuery(sql.toString(), LoandetailEntity.class);
        return query.getResultList();
    }
}

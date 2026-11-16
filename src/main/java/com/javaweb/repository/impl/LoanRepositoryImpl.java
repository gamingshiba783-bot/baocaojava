package com.javaweb.repository.impl;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.javaweb.builder.LoanSearchBuilder;
import com.javaweb.repository.custom.LoanRepositoryCustom;
import com.javaweb.repository.entity.LoanEntity;

@Repository
public class LoanRepositoryImpl implements LoanRepositoryCustom {
	@PersistenceContext
	private EntityManager entityManager;

	public static void QueryNomal(LoanSearchBuilder builder, StringBuilder where) {
		try {
			Field[] fields = LoanSearchBuilder.class.getDeclaredFields();
			for (Field item : fields) {
				item.setAccessible(true);
				String fieldname = item.getName();
				Object value = item.get(builder);

				if (value == null || (value instanceof String && ((String) value).trim().isEmpty())) {
					continue;
				}
				if (fieldname.equals("readers")) {
					continue;
				}

				if (item.getType().equals(Integer.class) || item.getType().equals(Long.class) || item.getType().equals(LocalDate.class)) {
					where.append(" AND lo." + fieldname + " = " + value);
				}if (item.getType().equals(String.class)) {
					where.append(" AND lo."+fieldname+" LIKE '%"+value+"%' ");
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	public static void Queryspecial(LoanSearchBuilder builder, StringBuilder where) {
		try {
			String readers = builder.getReaders();
			if(readers != null && !readers.trim().isEmpty()) {
				where.append(" AND r.FullName  LIKE '%"+readers.trim()+"%' ");
			}
		}catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public List<LoanEntity> findAll(LoanSearchBuilder builder) {
		StringBuilder sql = new StringBuilder(
				"SELECT DISTINCT lo.* FROM loan lo " +
						"LEFT JOIN reader r ON lo.ReaderID = r.id ");
		StringBuilder where = new StringBuilder(" WHERE 1=1 ");
		QueryNomal(builder, where);
		Queryspecial(builder, where);
		sql.append(where);
		Query query = entityManager.createNativeQuery(sql.toString(),LoanEntity.class);
		return query.getResultList();
	}
}
package com.javaweb.converter;

import java.nio.file.attribute.AclEntry.Builder;
import java.time.LocalDate;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.javaweb.builder.LoanSearchBuilder;
import com.javaweb.utils.MapUtil;

@Component
public class LoanSearchConverter {
	public LoanSearchBuilder toLoanSearchBuilder(Map<String,Object> params) {
		LoanSearchBuilder loanSearchBuilder = new LoanSearchBuilder.Builder().setId(MapUtil.getObject(params, "id", Long.class))
																			.setReaderid(MapUtil.getObject(params, "readerid", Integer.class))
																			.setDuedate(MapUtil.getObject(params, "duedate", LocalDate.class))
																			.setBorrowdate(MapUtil.getObject(params, "borrowdate", LocalDate.class))
																			.setStatus(MapUtil.getObject(params, "status", Integer.class)).build();
		return loanSearchBuilder;
																			
							
	}
}

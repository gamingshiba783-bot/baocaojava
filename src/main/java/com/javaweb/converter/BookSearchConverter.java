package com.javaweb.converter;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.javaweb.builder.BookSearchBuilder;
import com.javaweb.utils.MapUtil;

@Component
public class BookSearchConverter {
	public BookSearchBuilder tobBookSearchBuilder(Map<String,Object>params) {
		BookSearchBuilder bookSearchBuilder = new BookSearchBuilder.Builder().setId(MapUtil.getObject(params, "id", Long.class))
																			.setBookname(MapUtil.getObject(params, "bookname", String.class))
																			.setBooktitle(MapUtil.getObject(params, "booktitle", String.class))
																			.setPublisherid(MapUtil.getObject(params,"publisherid", Long.class))
																			.setPublishyear(MapUtil.getObject(params,"publshiyear", Integer.class))
																			.build();
		return bookSearchBuilder;
	}
}

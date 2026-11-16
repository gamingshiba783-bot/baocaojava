package com.javaweb.converter;

import com.javaweb.builder.CategorySearchBuilder;
import com.javaweb.utils.MapUtil;
import org.springframework.stereotype.Component;

import java.awt.print.Book;
import java.util.Map;
public class CategorySearchConverter {
    public CategorySearchBuilder toCategorySearch(Map<String, Object> params ) {
        CategorySearchBuilder categorySearchBuilder = new CategorySearchBuilder.Builder().setId(MapUtil.getObject(params,"id", Long.class))
                .setCategoryname(MapUtil.getObject(params,"categoryname",String.class)).build();
        return categorySearchBuilder;
    }
}

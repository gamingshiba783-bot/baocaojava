package com.javaweb.service;

import com.javaweb.builder.CategorySearchBuilder;
import com.javaweb.model.CategoryDTO;

import java.util.List;
import java.util.Map;

public interface CategorySevice {
    Map<Long,String> getCategory();
    List<CategoryDTO> fillAll(Map<String,Object> params);
    void insertCategory(CategoryDTO categoryDTO);
    void updateCategory(Long id,CategoryDTO categoryDTO);
    void deleteCategory(Long id);
    CategoryDTO CategoryByID(Long id);
}

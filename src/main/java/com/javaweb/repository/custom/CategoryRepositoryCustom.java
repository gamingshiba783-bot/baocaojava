package com.javaweb.repository.custom;

import com.javaweb.builder.CategorySearchBuilder;
import com.javaweb.repository.entity.CategoryEntity;

import java.util.List;

public interface CategoryRepositoryCustom {
    List<CategoryEntity> findAll(CategorySearchBuilder builder);
}

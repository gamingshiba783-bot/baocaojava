package com.javaweb.service.impl;

import com.javaweb.repository.CategoryRepository;
import com.javaweb.repository.entity.CategoryEntity;
import com.javaweb.service.CategorySevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class CategorySeviceImpl implements CategorySevice {
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public Map<Long, String> getCategory() {
        Map<Long,String> categorys = new HashMap<>();
        List<CategoryEntity> categoryEntities = categoryRepository.findAll();
        for(CategoryEntity categoryEntity : categoryEntities) {
            categorys.put(categoryEntity.getId(),categoryEntity.getCategoryname());
        }
        return categorys;
    }
}

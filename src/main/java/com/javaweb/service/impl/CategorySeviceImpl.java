package com.javaweb.service.impl;

import com.javaweb.builder.CategorySearchBuilder;
import com.javaweb.converter.CategoryConverter;
import com.javaweb.converter.CategorySearchConverter;
import com.javaweb.model.CategoryDTO;
import com.javaweb.repository.CategoryRepository;
import com.javaweb.repository.entity.CategoryEntity;
import com.javaweb.service.CategorySevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class CategorySeviceImpl implements CategorySevice {
    @Autowired
    private CategoryConverter categoryConverter;
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

    @Override
    public List<CategoryDTO> fillAll(Map<String,Object> params) {
        CategorySearchBuilder builder = new CategorySearchConverter().toCategorySearch(params);
        List<CategoryEntity> categoryEntities = categoryRepository.findAll(builder);
        List<CategoryDTO> result = new ArrayList<>();
        for(CategoryEntity item : categoryEntities) {
            CategoryDTO categoryDTO = categoryConverter.toDTO(item);
            result.add(categoryDTO);
        }
        return result;
    }

    @Override
    public void insertCategory(CategoryDTO categoryDTO) {
        CategoryEntity categoryEntity = categoryConverter.toCategoryinsert(categoryDTO);
        categoryRepository.save(categoryEntity);
    }

    @Override
    public void updateCategory(Long id,CategoryDTO categoryDTO) {
        CategoryEntity categoryEntity = categoryConverter.toCategoryupdate(categoryDTO);
        categoryRepository.save(categoryEntity);
    }

    @Override
    public void deleteCategory(Long id) {
       categoryRepository.deleteById(id);
    }

    @Override
    public CategoryDTO CategoryByID(Long id) {
        return categoryConverter.toDTO(categoryRepository.findById(id).get());
    }
}

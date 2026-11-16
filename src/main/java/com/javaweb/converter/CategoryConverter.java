package com.javaweb.converter;

import com.javaweb.model.CategoryDTO;
import com.javaweb.repository.AuthorRepository;
import com.javaweb.repository.CategoryRepository;
import com.javaweb.repository.entity.CategoryEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CategoryConverter {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private CategoryRepository categoryRepository;
    public CategoryDTO toDTO(CategoryEntity categoryEntity) {
        CategoryDTO categoryDTO = modelMapper.map(categoryEntity, CategoryDTO.class);
        categoryDTO.setId(categoryEntity.getId());
        categoryDTO.setCategoryname(categoryEntity.getCategoryname());
        return categoryDTO;
    }
    public CategoryEntity toCategoryinsert(CategoryDTO categoryDTO) {
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setId(categoryDTO.getId());
        categoryEntity.setCategoryname(categoryDTO.getCategoryname());
        return categoryEntity;
    }
    public  CategoryEntity toCategoryupdate(CategoryDTO categoryDTO) {
        CategoryEntity categoryEntity = categoryRepository.findById(categoryDTO.getId()).get();
        categoryEntity.setCategoryname(categoryDTO.getCategoryname());
        return categoryEntity;
    }

}

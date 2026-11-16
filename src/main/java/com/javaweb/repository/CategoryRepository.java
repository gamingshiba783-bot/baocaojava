package com.javaweb.repository;

import com.javaweb.repository.custom.CategoryRepositoryCustom;
import com.javaweb.repository.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long>, CategoryRepositoryCustom {
}

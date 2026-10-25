package com.javaweb.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaweb.builder.BookSearchBuilder;
import com.javaweb.repository.custom.BookRepositoryCustom;
import com.javaweb.repository.entity.BookEntity;

public interface BookRepository extends JpaRepository<BookEntity, Long> ,BookRepositoryCustom{
	void deleteByIdIn(Long[] ids);
	List<BookEntity> findByBooknameContainingAndPublishyear(String name,Integer PublishYear );
}

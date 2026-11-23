package com.javaweb.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaweb.builder.BookSearchBuilder;
import com.javaweb.repository.custom.BookRepositoryCustom;
import com.javaweb.repository.entity.BookEntity;

public interface BookRepository extends JpaRepository<BookEntity, Long> ,BookRepositoryCustom{
	List<BookEntity> findByBooknameContaining(String bookName);
	boolean existsByPublisher_Id(Long id);
	long count();
}
package com.javaweb.repository;

import com.javaweb.repository.entity.BookAuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookAuthorRepository extends JpaRepository<BookAuthorEntity, Long> {
}

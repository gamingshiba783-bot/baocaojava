package com.javaweb.repository;

import com.javaweb.repository.custom.ReaderRepositoryCustom;
import com.javaweb.repository.entity.BookEntity;
import com.javaweb.repository.entity.ReaderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReaderRepository extends JpaRepository<ReaderEntity, Integer>, ReaderRepositoryCustom {
}

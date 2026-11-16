package com.javaweb.repository;

import com.javaweb.builder.AuthorSearchBuilder;
import com.javaweb.repository.custom.AuthorRepositoryCustom;
import com.javaweb.repository.entity.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepository extends JpaRepository<AuthorEntity, Long>, AuthorRepositoryCustom {
}

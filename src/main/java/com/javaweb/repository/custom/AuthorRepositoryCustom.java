package com.javaweb.repository.custom;

import com.javaweb.builder.AuthorSearchBuilder;
import com.javaweb.repository.entity.AuthorEntity;

import java.util.List;

public interface AuthorRepositoryCustom {
    List<AuthorEntity> findAll(AuthorSearchBuilder authorSearchBuilder);
}

package com.javaweb.repository.custom;

import com.javaweb.builder.ReaderSearchBuilder;
import com.javaweb.repository.entity.ReaderEntity;
import com.javaweb.utils.MapUtil;

import java.util.List;
import java.util.Map;

public interface ReaderRepositoryCustom {
    List<ReaderEntity> findAll(ReaderSearchBuilder readerSearchBuilder);
}

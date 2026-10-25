package com.javaweb.repository.custom;

import java.util.List;

import com.javaweb.repository.entity.BookEntity;

public interface BookRepositoryCustom {
	List<BookEntity> findByPublishyearBetween(Integer statryear,Integer endyear);
}

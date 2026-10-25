package com.javaweb.service;

import java.util.List;
import java.util.Map;

import com.javaweb.model.BookDTO;

public interface Booksevice {
		List<BookDTO> find(Map<String,Object> params);
}

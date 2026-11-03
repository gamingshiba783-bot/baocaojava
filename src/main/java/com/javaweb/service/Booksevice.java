package com.javaweb.service;

import java.util.List;
import java.util.Map;

import com.javaweb.model.BookDTO;

public interface Booksevice {

	List<BookDTO> findAll(Map<String, Object> params);
	void insertBook(BookDTO bookDTO);
	void  updateBook(BookDTO bookDTO);
	void deleteBook(BookDTO bookDTO);
}

package com.javaweb.service;

import java.util.List;
import java.util.Map;

import com.javaweb.model.BookDTO;
import org.springframework.web.bind.annotation.PathVariable;

public interface Booksevice {
	Map<Long,String> getbook();
	List<BookDTO> findAll(Map<String, Object> params);
	void insertBook(BookDTO bookDTO);
	void updateBook(Long id,BookDTO bookDTO);

	void deleteBook(Long id);
	BookDTO findByid(Long id);
	Long countBooks();
}

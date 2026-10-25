package com.javaweb.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaweb.builder.BookSearchBuilder;
import com.javaweb.converter.BookConverter;
import com.javaweb.converter.BookSearchConverter;
import com.javaweb.model.BookDTO;
import com.javaweb.repository.BookRepository;
import com.javaweb.repository.entity.BookEntity;
import com.javaweb.service.Booksevice;
@Service
public class BookSeviceImpI implements Booksevice{
	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private BookConverter bookConverter;
	@Override
	public List<BookDTO> find(Map<String, Object> params) {
		// TODO Auto-generated method stub
		BookSearchBuilder Builder = new BookSearchConverter().tobBookSearchBuilder(params);
		BookEntity bookEntities = bookRepository.findById(1L).get();
		List<BookDTO> result = new ArrayList<BookDTO>();
//		for(BookEntity item : bookEntities) {
//			BookDTO books = bookConverter.tobook(item);
//			result.add(books);
//		}
		return result;
	}
		
	
}

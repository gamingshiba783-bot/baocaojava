package com.javaweb.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.javaweb.repository.AuthorRepository;
import com.javaweb.repository.BookAuthorRepository;
import com.javaweb.repository.CategoryRepository;
import com.javaweb.repository.entity.AuthorEntity;
import com.javaweb.repository.entity.BookAuthorEntity;
import com.javaweb.repository.entity.PublisherEntity;
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
	private AuthorRepository authorRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private BookConverter bookConverter;
	@Autowired
	private BookAuthorRepository bookAuthorRepository;

	@Override
	public Map<Long, String> getbook() {
		Map<Long, String> bookss = new HashMap<>();
		List<BookEntity> books = bookRepository.findAll();
		for(BookEntity book : books){
			bookss.put(book.getId(),book.getBookname());
		}
		return bookss;
	}

	public List<BookDTO> findAll(Map<String, Object> params) {
		// TODO Auto-generated method stub
		BookSearchBuilder Builder = new BookSearchConverter().tobBookSearchBuilder(params);
		List<BookEntity> bookEntities = bookRepository.findAll(Builder);
		List<BookDTO> result = new ArrayList<>();
		for(BookEntity item : bookEntities) {
			BookDTO books = bookConverter.tobook(item);
			result.add(books);
		}
		return result;
	}

	@Override
	public void insertBook(BookDTO bookDTO) {
		BookEntity bookEntity = new BookEntity();
		bookEntity.setBookname(bookDTO.getBookname());
		bookEntity.setBooktitle(bookDTO.getBooktitle());
		bookEntity.setPublishyear(bookDTO.getPublishyear());
		PublisherEntity publisherEntity = new PublisherEntity();
		publisherEntity.setId(bookDTO.getPublisherid());
		bookEntity.setPublisher(publisherEntity);
		bookRepository.save(bookEntity);
		if (bookDTO.getAuthor() != null && !bookDTO.getAuthor().isEmpty()) {
			authorRepository.findById(Long.valueOf(bookDTO.getAuthor()))
					.ifPresent(author -> {
						BookAuthorEntity ba = new BookAuthorEntity();
						ba.setBook(bookEntity);
						ba.setAuthor(author);
						ba.setRole(bookDTO.getRole());
						bookAuthorRepository.save(ba);
					});
		}
		Long categoryId = Long.valueOf(bookDTO.getCategory());
		categoryRepository.findById(categoryId).ifPresent(e -> bookEntity.getCategorys().add(e));
		bookRepository.save(bookEntity);
		System.out.print("đã cập nhật");
	}
	@Override
	public void updateBook(Long id, BookDTO bookDTO) {
		BookEntity bookEntity = bookRepository.findById(id).get();
		bookEntity.setBookname(bookDTO.getBookname());
		bookEntity.setBooktitle(bookDTO.getBooktitle());
		bookEntity.setPublishyear(bookDTO.getPublishyear());
		PublisherEntity publisherEntity = new PublisherEntity();
		publisherEntity.setId(bookDTO.getPublisherid());
		bookEntity.setPublisher(publisherEntity);
		bookEntity.getAuthors().clear();
		if (bookDTO.getAuthor() != null && !bookDTO.getAuthor().isEmpty()) {
			authorRepository.findById(Long.valueOf(bookDTO.getAuthor()))
					.ifPresent(author -> {
						BookAuthorEntity ba = new BookAuthorEntity();
						ba.setBook(bookEntity);
						ba.setAuthor(author);
						ba.setRole(bookDTO.getRole());
						bookAuthorRepository.save(ba);
					});
		}
		bookEntity.getCategorys().clear();
		Long categoryId = Long.valueOf(bookDTO.getCategory());
		categoryRepository.findById(categoryId).ifPresent(e -> bookEntity.getCategorys().add(e));
		bookRepository.save(bookEntity);
	}

	@Override
	public void deleteBook(Long id) {
		bookRepository.deleteById(id);
	}

	@Override
	public BookDTO findByid(Long id) {
		return bookConverter.tobook(bookRepository.findById(id).get());
	}

	@Override
	public Long countBooks() {
		return bookRepository.count();
	}
}

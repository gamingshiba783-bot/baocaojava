package com.javaweb.converter;

import com.javaweb.enums.BookAuthorRole;
import com.javaweb.repository.entity.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.javaweb.model.BookDTO;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookConverter {
	@Autowired
	private ModelMapper modelMapper;
	public BookDTO tobook(BookEntity bookEntity) {
		BookDTO bookDTO = modelMapper.map(bookEntity, BookDTO.class);
		bookDTO.setBooktitle(bookEntity.getBooktitle());
		if(bookEntity.getPublisher() != null) {
			bookDTO.setPublisher(bookEntity.getPublisher().getPublishername());
		}
		if (bookEntity.getAuthors() != null) {
			bookDTO.setAuthor(bookEntity.getAuthors().stream().map(item -> item.getAuthor().getAuthorname()).collect(Collectors.joining(", ")));
		}
		if(bookEntity.getCategorys() != null) {
			bookDTO.setCategory(bookEntity.getCategorys().stream()
					.map(CategoryEntity::getCategoryname)
					.collect(Collectors.joining(", ")));
		}
		bookDTO.setRole(
				bookEntity.getAuthors().stream()
						.map(BookAuthorEntity::getRole)
						.collect(Collectors.joining(", "))
		);
		return bookDTO;
	}

}

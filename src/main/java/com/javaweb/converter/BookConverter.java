package com.javaweb.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.javaweb.model.BookDTO;
import com.javaweb.repository.entity.BookEntity;
@Component
public class BookConverter {
	@Autowired
	private ModelMapper modelMapper;
	public BookDTO tobook(BookEntity bookEntity) {
		BookDTO bookDTO = modelMapper.map(bookEntity, BookDTO.class);
		bookDTO.setBooktitle(bookEntity.getBooktitle());
		bookDTO.setPublisherid(bookEntity.getPublisher().getId());
		bookDTO.setInformation(bookEntity.getPublisher().getAddress()+","+bookEntity.getPublisher().getEmail());
		return bookDTO;
	}
}

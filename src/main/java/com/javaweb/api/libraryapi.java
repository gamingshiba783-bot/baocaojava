package com.javaweb.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javaweb.converter.BookConverter;
import com.javaweb.model.BookDTO;
import com.javaweb.repository.BookRepository;
import com.javaweb.repository.entity.BookEntity;
import com.javaweb.repository.entity.PublisherEntity;
import com.javaweb.service.Booksevice;
@Transactional
@RestController
public class libraryapi {
	@Autowired
	private Booksevice booksevice;
	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private BookConverter  bookConverter;
	@Autowired
	private ModelMapper modelMapper;
	@PersistenceContext
	private EntityManager entityManager;
	@GetMapping(value = "/api/book")
    public List<BookDTO> getbookbean(@RequestParam Map<String,Object> params) {
    	List<BookDTO> result = booksevice.find(params);
    	return result;
    }
	@DeleteMapping(value = "/api/book/{ids}")
	public void deletebookbean(@PathVariable Long[] ids){
		bookRepository.deleteByIdIn(ids);
	}
	@GetMapping(value = "/api/book/{name}/{PublishYear}")
	public List<BookDTO> getnameandpublishyear(@PathVariable String name,@PathVariable Integer PublishYear){
		List<BookDTO> result = new ArrayList<>();
		List<BookEntity> boEntities=bookRepository.findByBooknameContainingAndPublishyear(name, PublishYear);
		for(BookEntity item : boEntities) {
			BookDTO bookDTO = bookConverter.tobook(item);
			result.add(bookDTO);
		}
		return result;
		
	}
	@GetMapping(value = "api/book/year")
	public List<BookDTO> getyear(@RequestParam Integer statryear,@RequestParam  Integer endyear){
		List<BookDTO> result = new ArrayList<>();
		List<BookEntity> bookEntities= bookRepository.findByPublishyearBetween(statryear, endyear);
		for(BookEntity item : bookEntities) {
			BookDTO bookDTO = bookConverter.tobook(item);
			result.add(bookDTO);
		}
		return result;
	}
	@PutMapping(value="api/book")
	public void insertbookbean(@RequestBody BookDTO bookDTO) {
		BookEntity bookEntity = new BookEntity();
		bookEntity.setBookname(bookDTO.getBookname());
		bookEntity.setBooktitle(bookDTO.getBooktitle());
		bookEntity.setPublishyear(bookDTO.getPublishyear());
		PublisherEntity publisherEntity = new PublisherEntity();
		publisherEntity.setId(bookDTO.getPublisherid());
		bookEntity.setPublisher(publisherEntity);
		bookRepository.save(bookEntity);
		System.out.print("đã cập nhật");
	}
	@PostMapping(value = "api/book")
	public void updatebookbean(@RequestBody BookDTO bookDTO) {
		BookEntity bookEntity = bookRepository.findById(bookDTO.getId()).get();
		bookEntity.setBookname(bookDTO.getBookname());
		bookEntity.setBooktitle(bookDTO.getBooktitle());
		bookEntity.setPublishyear(bookDTO.getPublishyear());
		PublisherEntity publisherEntity = new PublisherEntity();
		publisherEntity.setId(bookDTO.getPublisherid());
		bookEntity.setPublisher(publisherEntity);
		bookRepository.save(bookEntity);
		System.out.print("đã cập nhật");
	}
}

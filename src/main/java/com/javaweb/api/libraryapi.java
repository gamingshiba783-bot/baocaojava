package com.javaweb.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.javaweb.model.*;
import com.javaweb.service.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javaweb.converter.BookConverter;
import com.javaweb.repository.BookRepository;
import com.javaweb.repository.entity.BookEntity;
import com.javaweb.repository.entity.PublisherEntity;

@Transactional
@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class libraryapi {
	@Autowired
	private Booksevice booksevice;
	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private BookConverter  bookConverter;
	@Autowired
	private AuthorSevice authorSevice;
	@Autowired
	private CategorySevice categorySevice;
	@Autowired
	private Publishersevice publishersevice;
	@Autowired
	private LoanSevice loanSevice;
	@Autowired
	private LoanDetailSevice loanDetailSevice;
	@DeleteMapping(value = "/api/book/{id}")
	public void deletebookbean(@PathVariable Long id){
		booksevice.deleteBook(id);
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
	@GetMapping(value = "api/loandetail/book")
	public List<LoanDetailDTO> getloandetail(Map<String,Object> params){
		List<LoanDetailDTO> result = loanDetailSevice.findAll(params);;
		return result;
	}
	@PutMapping(value="/api/book")
	public BookDTO updatebookbean(@RequestBody BookDTO bookDTO) {
		booksevice.updateBook(bookDTO.getId(), bookDTO);
		return bookDTO;
	}
	@PostMapping("/api/book")
	public BookDTO inserttbook(@RequestBody BookDTO bookDTO) {
			booksevice.insertBook(bookDTO);
		return bookDTO;
	}
	@PostMapping(value = "/api/author")
	public AuthorDTO insertauthor(@RequestBody AuthorDTO authorDTO) {
		authorSevice.insertAuthor(authorDTO);
		return authorDTO;
	}
	@PutMapping(value = "/api/author")
	public AuthorDTO updateauthor(@RequestBody AuthorDTO authorDTO) {
		authorSevice.updateAuthor(authorDTO.getId(), authorDTO);
		return authorDTO;
	}
	@DeleteMapping(value = "/api/author/{id}")
	public void deleteauthor(@PathVariable Long id) {
		authorSevice.deleteAuthor(id);
	}
	@PostMapping(value = "/api/category")
	public CategoryDTO insertcategory(@RequestBody CategoryDTO categoryDTO) {
		categorySevice.insertCategory(categoryDTO);
		return categoryDTO;
	}
	@PutMapping(value = "/api/category")
	public CategoryDTO updatecategory(@RequestBody CategoryDTO categoryDTO) {
		categorySevice.updateCategory(categoryDTO.getId(), categoryDTO);
		return categoryDTO;
	}
	@DeleteMapping(value = "/api/category/{id}")
	public void deletecategory(@PathVariable Long id) {
		categorySevice.deleteCategory(id);
	}
	@PostMapping(value = "/api/publish")
	public PublishDTO insertpublish(@RequestBody PublishDTO publishDTO) {
		publishersevice.insertPublisher(publishDTO);
		return publishDTO;
	}
	@PutMapping(value = "/api/publish")
	public PublishDTO updatepublish(@RequestBody PublishDTO publishDTO) {
		publishersevice.updatePublisher(publishDTO.getId(), publishDTO);
		return publishDTO;
	}
	@DeleteMapping(value = "/api/publish/{id}")
	public void deletepublish(@PathVariable Long id) {
		publishersevice.deletePublisher(id);
	}

	@PostMapping(value = "/api/loan")
	public LoanDTO insertreader(@RequestBody LoanDTO loanDTO) {
		loanSevice.insertLoan(loanDTO);
		return loanDTO;
	}
	@PutMapping(value = "/api/loan")
	public LoanDTO updateloan(@RequestBody LoanDTO loanDTO) {
		loanSevice.updateLoan(loanDTO.getId(), loanDTO);
		return loanDTO;
	}
	@DeleteMapping(value="/api/loan/{id}")
	public void deleteloan(@PathVariable Long id) {
		loanSevice.deleteLoan(id);
	}

	@PostMapping(value = "/api/loandetail")
	public LoanDetailDTO insertloandetail(@RequestBody LoanDetailDTO loanDetailDTO) {
		loanDetailSevice.insertLoanDetail(loanDetailDTO);
		return loanDetailDTO;
	}
	@PutMapping(value = "/api/loandetail")
	public LoanDetailDTO updatelandetail(@RequestBody LoanDetailDTO loanDetailDTO) {
		loanDetailSevice.updateLoanDetail(loanDetailDTO);
		return loanDetailDTO;
	}
	@DeleteMapping(value = "/api/loandetail/{id}")
	public void deleteloandetail(@PathVariable Long id) {
		loanDetailSevice.deleteLoanDetail(id);
	}
}

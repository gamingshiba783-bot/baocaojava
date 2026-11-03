package com.javaweb.model;

import java.util.List;

public class BookDTO {
	private Long id;
	private String bookname;
	private String booktitle;
	private Long publisherid;
	private Integer publishyear;
	private String information;
	private String publisher;
	private String author;
	private String Category;
	public String getCategory() {
		return Category;
	}
	public void setCategory(String category) {
		Category = category;
	}

	public String getAuthor() { return author; }
	public void setAuthor(String author) { this.author = author; }

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getInformation() {
		return information;
	}
	public void setInformation(String information) {
		this.information = information;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getBooktitle() {
		return booktitle;
	}
	public void setBooktitle(String booktitle) {
		this.booktitle = booktitle;
	}
	public Long getPublisherid() {
		return publisherid;
	}
	public void setPublisherid(Long publisherid) {
		this.publisherid = publisherid;
	}
	public Integer getPublishyear() {
		return publishyear;
	}
	public void setPublishyear(Integer publishyear) {
		this.publishyear = publishyear;
	}
}

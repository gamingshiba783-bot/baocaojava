package com.javaweb.repository.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name ="Book")

public class BookEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "Bookname")
	private String bookname;
	@Column(name = "Booktitle")
	private String booktitle;
	@Column(name = "publishyear")
	private Integer publishyear;
	
	@ManyToOne
	@JoinColumn(name="PublisherID")
	private PublisherEntity publisher;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name="BookCategory",
	joinColumns = @JoinColumn(name ="BookID",unique = false),
	inverseJoinColumns = @JoinColumn(name="CategoryID",unique = false))
	private List<CategoryEntity> categorys = new ArrayList<>();
	
	
	public PublisherEntity getPublisher() {
		return publisher;
	}
	public void setPublisher(PublisherEntity publisher) {
		this.publisher = publisher;
	}
	public List<CategoryEntity> getCategorys() {
		return categorys;
	}
	public void setCategorys(List<CategoryEntity> categorys) {
		this.categorys = categorys;
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
	public Integer getPublishyear() {
		return publishyear;
	}
	public void setPublishyear(Integer publishyear) {
		this.publishyear = publishyear;
	}
	
	
	
	
}

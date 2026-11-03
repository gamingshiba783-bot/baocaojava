package com.javaweb.repository.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name ="Author")
public class AuthorEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name ="Authorname")
	private String authorname;
	@Column(name = "Address")
	private String address;
	@Column(name ="BirthYear")
	private Integer birthyear;
	@ManyToMany(mappedBy = "authors",fetch = FetchType.LAZY)
	private List<BookEntity> books = new ArrayList<>();

	public List<BookEntity> getBooks() {
		return books;
	}

	public void setBooks(List<BookEntity> books) {
		this.books = books;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAuthorname() {
		return authorname;
	}
	public void setAuthorname(String authorname) {
		this.authorname = authorname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getBirthyear() {
		return birthyear;
	}
	public void setBirthyear(Integer birthyear) {
		this.birthyear = birthyear;
	}
	
	
	
	
}

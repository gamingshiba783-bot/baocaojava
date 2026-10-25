package com.javaweb.builder;

public class BookSearchBuilder {
	private Long id;
	private String bookname;
	private String booktitle;
	private Long publisherid;
	private Integer publishyear;
	
	private BookSearchBuilder(Builder builder) {
		this.id= builder.id;
		this.bookname= builder.bookname;
		this.booktitle= builder.booktitle;
		this.publisherid = builder.publisherid;
		this.publishyear= builder.publishyear;
	}
	
	
	public Long getId() {
		return id;
	}


	public String getBookname() {
		return bookname;
	}


	public String getBooktitle() {
		return booktitle;
	}


	public Long getPublisherid() {
		return publisherid;
	}


	public Integer getPublishyear() {
		return publishyear;
	}


	public static class Builder{
		private Long id;
		private String bookname;
		private String booktitle;
		private Long publisherid;
		private Integer publishyear;
		public Builder setId(Long id) {
			this.id = id;
			return this;
		}
		public Builder setBookname(String bookname) {
			this.bookname = bookname;
			return this;
		}
		public Builder setBooktitle(String booktitle) {
			this.booktitle = booktitle;
			return this;
		}
		public Builder setPublisherid(Long publisherid) {
			this.publisherid = publisherid;
			return this;
		}
		public Builder setPublishyear(Integer publishyear) {
			this.publishyear = publishyear;
			return this;
		}
		
		public BookSearchBuilder build() {
			return new BookSearchBuilder(this);
		}
	}
}

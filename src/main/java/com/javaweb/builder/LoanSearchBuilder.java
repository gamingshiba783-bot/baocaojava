package com.javaweb.builder;

import java.nio.file.attribute.AclEntry.Builder;
import java.time.LocalDate;

public class LoanSearchBuilder {
	private Long id;
	private Integer readerid;
	private LocalDate borrowdate;
	private LocalDate duedate;
	private Integer status;
	
	private LoanSearchBuilder(Builder builder) {
		this.id = builder.id;
		this.readerid=builder.readerid;
		this.borrowdate = builder.borrowdate;
		this.duedate = builder.duedate;
		this.status = builder.status;
				
	}
	
	public Long getId() {
		return id;
	}

	public Integer getReaderid() {
		return readerid;
	}

	public LocalDate getBorrowdate() {
		return borrowdate;
	}

	public LocalDate getDuedate() {
		return duedate;
	}

	public Integer getStatus() {
		return status;
	}

	public static class Builder{
		private Long id;
		private Integer readerid;
		private LocalDate borrowdate;
		private LocalDate duedate;
		private Integer status;
		public Builder setId(Long id) {
			this.id = id;
			return this;
		}
		public Builder setReaderid(Integer readerid) {
			this.readerid = readerid;
			return this;
		}
		public Builder setBorrowdate(LocalDate borrowdate) {
			this.borrowdate = borrowdate;
			return this;
		}
		public Builder setDuedate(LocalDate duedate) {
			this.duedate = duedate;
			return this;
		}
		public Builder setStatus(Integer status) {
			this.status = status;
			return this;
		}
		
		public LoanSearchBuilder build() {
			return new LoanSearchBuilder(this);
		}
	}
}

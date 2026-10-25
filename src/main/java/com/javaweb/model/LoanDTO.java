package com.javaweb.model;

import java.time.LocalDate;

public class LoanDTO {
	private Long id;
	private Integer readerid;
	private LocalDate borrowdate;
	private LocalDate duedate;
	private Integer status;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getReaderid() {
		return readerid;
	}
	public void setReaderid(Integer readerid) {
		this.readerid = readerid;
	}
	public LocalDate getBorrowdate() {
		return borrowdate;
	}
	public void setBorrowdate(LocalDate borrowdate) {
		this.borrowdate = borrowdate;
	}
	public LocalDate getDuedate() {
		return duedate;
	}
	public void setDuedate(LocalDate duedate) {
		this.duedate = duedate;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
}

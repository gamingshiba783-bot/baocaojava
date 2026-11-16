package com.javaweb.model;

import java.time.LocalDate;
import java.util.List;

public class LoanDTO {
	private Long id;
	private Long readerid;
	private LocalDate borrowdate;
	private LocalDate duedate;
	private Integer status;
	private String statusname;
	private Integer statuscode;
	private String readers;
	public String getReaders() {
		return readers;
	}

	public void setReaders(String readers) {
		this.readers = readers;
	}

	public String getStatusname() {
		return statusname;
	}

	public void setStatusname(String statusname) {
		this.statusname = statusname;
	}

	public Integer getStatuscode() {
		return statuscode;
	}

	public void setStatuscode(Integer statuscode) {
		this.statuscode = statuscode;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getReaderid() {
		return readerid;
	}
	public void setReaderid(Long readerid) {
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

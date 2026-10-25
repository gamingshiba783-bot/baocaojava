package com.javaweb.repository.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name ="loan")
public class LoanEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="BorrowDate")
	private LocalDate borrowdate;
	@Column(name ="DueDate")
	private LocalDate duedate;
	@Column(name ="Status")
	private Integer status;
	
	@OneToMany(mappedBy = "loans",fetch = FetchType.LAZY)
	List<ReaderEntity> readers = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public List<ReaderEntity> getReaders() {
		return readers;
	}

	public void setReaders(List<ReaderEntity> readers) {
		this.readers = readers;
	}
	
	
}

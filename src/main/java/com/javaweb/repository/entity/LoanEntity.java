package com.javaweb.repository.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

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

	@ManyToOne
	@JoinColumn(name = "Readerid")
	private ReaderEntity reader;

	@OneToMany(mappedBy = "loan", cascade = CascadeType.REMOVE)
	private List<LoandetailEntity> loandetailEntities = new ArrayList<>();

	public List<LoandetailEntity> getLoandetailEntities() {
		return loandetailEntities;
	}

	public void setLoandetailEntities(List<LoandetailEntity> loandetailEntities) {
		this.loandetailEntities = loandetailEntities;
	}

	public ReaderEntity getReader() {
		return reader;
	}

	public void setReader(ReaderEntity reader) {
		this.reader = reader;
	}

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


	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getStatus() {
		return status;
	}
}

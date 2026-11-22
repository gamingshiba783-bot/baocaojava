package com.javaweb.repository.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.*;

@Entity
@Table(name = "reader")
public class ReaderEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "Fullname")
	private String fullname;
	
	@Column(name = "DateOfBirth")
	private LocalDate dataofbirth;
	
	@Column(name = "Gender")
	private String gender;
	
	@Column(name ="Address")
	private String address;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "RegistrationDate")
	private LocalDate registrationdate;
	
	@Column(name = "ExpiryDate")
	private LocalDate expirydate;
	
	@Column(name = "Status")
	private Integer status;

	@OneToMany(mappedBy = "reader", cascade = CascadeType.REMOVE)
	private List<LoanEntity> loan = new ArrayList<>();

	public List<LoanEntity> getLoan() {
		return loan;
	}

	public void setLoan(List<LoanEntity> loan) {
		this.loan = loan;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public LocalDate getDataofbirth() {
		return dataofbirth;
	}

	public void setDataofbirth(LocalDate dataofbirth) {
		this.dataofbirth = dataofbirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public LocalDate getRegistrationdate() {
		return registrationdate;
	}

	public void setRegistrationdate(LocalDate registrationdate) {
		this.registrationdate = registrationdate;
	}

	public LocalDate getExpirydate() {
		return expirydate;
	}

	public void setExpirydate(LocalDate expirydate) {
		this.expirydate = expirydate;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}

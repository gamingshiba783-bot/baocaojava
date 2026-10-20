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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Building")
public class Buildingentity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name ="name")
	private String name;
	@Column(name ="numberofbasement")
	private Integer numberofbasement;
	@Column(name ="managername")
	private String managername;
	@Column(name ="managerphone")
	private String managerphone;
	@Column(name ="floorarea")
	private Integer floorarea;
	@Column(name ="rentprice")
	private Integer rentprice;
	@Column(name ="servicefee")
	private String servicefee;
	@Column(name ="brokeragefee")
	private Float brokeragefee;
	@Column(name ="street")
	private String street;
	@Column(name ="ward")
	private String ward;
	
	@ManyToOne
	@JoinColumn(name = "districtid")
	private DistrictEntity district;
	
	@OneToMany(mappedBy = "building",fetch = FetchType.LAZY)
	private List<RentareaEntity> items = new ArrayList<>();
	
	
	public List<RentareaEntity> getItems() {
		return items;
	}
	public void setItems(List<RentareaEntity> items) {
		this.items = items;
	}
	public DistrictEntity getDistrict() {
		return district;
	}
	public void setDistrict(DistrictEntity district) {
		this.district = district;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getNumberofbasement() {
		return numberofbasement;
	}
	public void setNumberofbasement(Integer numberofbasement) {
		this.numberofbasement = numberofbasement;
	}
	public String getManagername() {
		return managername;
	}
	public void setManagername(String managername) {
		this.managername = managername;
	}
	public String getManagerphone() {
		return managerphone;
	}
	public void setManagerphone(String managerphone) {
		this.managerphone = managerphone;
	}
	public Integer getFloorarea() {
		return floorarea;
	}
	public void setFloorarea(Integer floorarea) {
		this.floorarea = floorarea;
	}
	public Integer getRentprice() {
		return rentprice;
	}
	public void setRentprice(Integer rentprice) {
		this.rentprice = rentprice;
	}
	public String getServicefee() {
		return servicefee;
	}
	public void setServicefee(String servicefee) {
		this.servicefee = servicefee;
	}
	public Float getBrokeragefee() {
		return brokeragefee;
	}
	public void setBrokeragefee(Float brokeragefee) {
		this.brokeragefee = brokeragefee;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getWard() {
		return ward;
	}
	public void setWard(String ward) {
		this.ward = ward;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
}

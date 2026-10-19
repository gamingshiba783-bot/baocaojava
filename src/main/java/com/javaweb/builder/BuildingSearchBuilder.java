package com.javaweb.builder;

import java.util.ArrayList;
import java.util.List;

public class BuildingSearchBuilder {
	private String name;
	private Long floorArea;
	private String ward;
	private String street;
	private Long districtid;
	private Integer numberofbasement;
	private List<String> typecode = new ArrayList<>();
	private String managername;
	private String managerphone;
	private Long rentPriceFrom;
	private Long rentPriceTo;
	private Long rentAreaFrom;
	private Long rentAreaTo;
	private Long staffid;
	
	private BuildingSearchBuilder(Builder builder) {
		this.name = builder.name;
		this.floorArea = builder.floorArea;
		this.ward = builder.ward;
		this.numberofbasement=builder.numberofbasement;
		this.street = builder.street;
		this.districtid = builder.districtid;
		this.typecode = builder.typecode;
		this.managername = builder.managername;
		this.managerphone = builder.managerphone;
		this.rentPriceFrom = builder.rentPriceFrom;
		this.rentPriceTo = builder.rentPriceTo;
		this.rentAreaFrom = builder.rentAreaFrom;
		this.rentAreaTo= builder.rentAreaTo;
		this.staffid= builder.staffid;	
	}
	public String getName() {
		return name;
	}
	public Long getFloorArea() {
		return floorArea;
	}
	public String getWard() {
		return ward;
	}
	public String getStreet() {
		return street;
	}
	public Long getDistrictid() {
		return districtid;
	}
	public Integer getNumberofbasement() {
		return numberofbasement;
	}
	public List<String> getTypecode() {
		return typecode;
	}
	public String getManagername() {
		return managername;
	}
	public String getManagerphone() {
		return managerphone;
	}
	public Long getRentPriceFrom() {
		return rentPriceFrom;
	}
	public Long getRentPriceTo() {
		return rentPriceTo;
	}
	public Long getRentAreaFrom() {
		return rentAreaFrom;
	}
	public Long getRentAreaTo() {
		return rentAreaTo;
	}
	public Long getStaffid() {
		return staffid;
	}
	
	public static class Builder{
		private String name;
		private Long floorArea;
		private String ward;
		private String street;
		private Long districtid;
		private Integer numberofbasement;
		private List<String> typecode = new ArrayList<>();
		private String managername;
		private String managerphone;
		private Long rentPriceFrom;
		private Long rentPriceTo;
		private Long rentAreaFrom;
		private Long rentAreaTo;
		private Long staffid;
		public Builder setName(String name) {
			this.name = name;
			return this;
		}
		public Builder setFloorArea(Long floorArea) {
			this.floorArea = floorArea;
			return this;
		}
		public Builder setWard(String ward) {
			this.ward = ward;
			return this;
		}
		public Builder setStreet(String street) {
			this.street = street;
			return this;
		}
		public Builder setDistrictid(Long districtid) {
			this.districtid = districtid;
			return this;
		}
		public Builder setNumberofbasement(Integer numberofbasement) {
			this.numberofbasement = numberofbasement;
			return this;
		}
		public Builder setTypecode(List<String> typecode) {
			this.typecode = typecode;
			return this;
		}
		public Builder setManagername(String managername) {
			this.managername = managername;
			return this;
		}
		public Builder setManagerphone(String managerphone) {
			this.managerphone = managerphone;
			return this;
		}
		public Builder setRentPriceFrom(Long rentPriceFrom) {
			this.rentPriceFrom = rentPriceFrom;
			return this;
		}
		public Builder setRentPriceTo(Long rentPriceTo) {
			this.rentPriceTo = rentPriceTo;
			return this;
		}
		public Builder setRentAreaFrom(Long rentAreaFrom) {
			this.rentAreaFrom = rentAreaFrom;
			return this;
		}
		public Builder setRentAreaTo(Long rentAreaTo) {
			this.rentAreaTo = rentAreaTo;
			return this;
		}
		public Builder setStaffid(Long staffid) {
			this.staffid = staffid;
			return this;
		}
		public BuildingSearchBuilder build() {
			return new BuildingSearchBuilder(this);
		}
		
		
	}
	
	
}

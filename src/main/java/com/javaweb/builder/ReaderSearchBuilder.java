package com.javaweb.builder;

import com.javaweb.service.Booksevice;

import java.time.LocalDate;

public class ReaderSearchBuilder {
    private Long id;
    private String fullname;
    private LocalDate dataofbirth;
    private String gender;
    private String address;
    private String phone;
    private LocalDate registrationdate;
    private LocalDate expirydate;
    private Integer status;
    public ReaderSearchBuilder(Builder builder) {
        this.id=builder.id;
        this.fullname=builder.fullname;
        this.dataofbirth=builder.dataofbirth;
        this.gender=builder.gender;
        this.address=builder.address;
        this.phone=builder.phone;
        this.registrationdate=builder.registrationdate;
        this.expirydate=builder.expirydate;
        this.status=builder.status;
    }

    public Long getId() {
        return id;
    }

    public String getFullname() {
        return fullname;
    }

    public LocalDate getDataofbirth() {
        return dataofbirth;
    }

    public String getAddress() {
        return address;
    }

    public String getGender() {
        return gender;
    }

    public String getPhone() {
        return phone;
    }

    public LocalDate getRegistrationdate() {
        return registrationdate;
    }

    public LocalDate getExpirydate() {
        return expirydate;
    }

    public Integer getStatus() {
        return status;
    }
    public static class Builder{
        private Long id;
        private String fullname;
        private LocalDate dataofbirth;
        private String gender;
        private String address;
        private String phone;
        private LocalDate registrationdate;
        private LocalDate expirydate;
        private Integer status;
        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Builder setFullname(String fullname) {
            this.fullname = fullname;
            return this;
        }
        public Builder setDataofbirth(LocalDate dataofbirth) {
            this.dataofbirth = dataofbirth;
            return this;
        }
        public Builder setGender(String gender) {
            this.gender = gender;
            return this;
        }
        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }
        public Builder setPhone(String phone) {
            this.phone = phone;
            return this;
        }
        public Builder setRegistrationdate(LocalDate registrationdate) {
            this.registrationdate = registrationdate;
            return this;
        }
        public Builder setExpirydate(LocalDate expirydate) {
            this.expirydate = expirydate;
            return this;
        }
        public Builder setStatus(Integer status) {
            this.status = status;
            return this;
        }
        public ReaderSearchBuilder build() {
            return new ReaderSearchBuilder(this);
        }
    }
}

package com.javaweb.model;

import javax.persistence.Column;

public class AuthorDTO {
    private Long id;
    private String authorname;

    private String address;

    private Integer birthyear;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthorname() {
        return authorname;
    }

    public String getAddress() {
        return address;
    }

    public Integer getBirthyear() {
        return birthyear;
    }

    public void setAuthorname(String authorname) {
        this.authorname = authorname;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setBirthyear(Integer birthyear) {
        this.birthyear = birthyear;
    }
}

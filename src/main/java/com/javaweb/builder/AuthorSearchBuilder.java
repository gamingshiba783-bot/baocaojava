package com.javaweb.builder;

public class AuthorSearchBuilder {
    private Long id;
    private String authorname;
    private String address;
    private Integer birthyear;
    private AuthorSearchBuilder(Builder builder) {
        this.id=builder.id;
        this.authorname=builder.authorname;
        this.address=builder.address;
        this.birthyear=builder.birthyear;
    }
    public String getAuthorname() {
        return authorname;
    }
    public Long getId() {
        return id;
    }
    public String getAddress() {
        return address;
    }
    public Integer getBirthyear() {
        return birthyear;
    }
    public static class Builder {
        private Long id;
        private String authorname;
        private String address;
        private Integer birthyear;

        public Builder setAuthorname(String authorname) {
            this.authorname = authorname;
            return this;
        }
        public Builder setId(Long id) {
            this.id = id;
            return this;
        }
        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }
        public Builder setBirthyear(Integer birthyear) {
            this.birthyear = birthyear;
            return this;
        }
        public AuthorSearchBuilder build() {
            return new AuthorSearchBuilder(this);
        }
    }
}

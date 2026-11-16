package com.javaweb.builder;


public class PublisherSearchBuilder {
    private Long id;
    private String publishername;
    private String address;
    private String phone;
    private String email;
    private PublisherSearchBuilder(Builder builder) {
        this.id=builder.id;
        this.publishername=builder.publishername;
        this.address=builder.address;
        this.phone=builder.phone;
        this.email=builder.email;
    }

    public Long getId() {
        return id;
    }

    public String getPublishername() {
        return publishername;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public static class Builder{
        private Long id;
        private String publishername;
        private String address;
        private String phone;
        private String email;

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Builder setPublishername(String publishername) {
            this.publishername = publishername;
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

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }
        public PublisherSearchBuilder build() {
            return new PublisherSearchBuilder(this);
        }
    }
}

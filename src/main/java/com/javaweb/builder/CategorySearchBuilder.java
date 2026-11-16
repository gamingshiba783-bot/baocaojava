package com.javaweb.builder;

public class CategorySearchBuilder {
    private Long id;
    private String categoryname;
    private CategorySearchBuilder (Builder builder) {
        this.id=builder.id;
        this.categoryname=builder.categoryname;
    }
    public Long getId() {
        return id;
    }
    public String getCategoryname() {
        return categoryname;
    }
    public static class Builder{
        private Long id;
        private String categoryname;

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Builder setCategoryname(String categoryname) {
            this.categoryname = categoryname;
            return this;
        }
        public CategorySearchBuilder build() {
            return new CategorySearchBuilder(this);
        }
    }
}

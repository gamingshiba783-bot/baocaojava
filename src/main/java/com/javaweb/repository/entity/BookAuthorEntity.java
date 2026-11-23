package com.javaweb.repository.entity;

import javax.persistence.*;

@Entity
@Table(name = "bookauthor")
public class BookAuthorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "bookid")
    private BookEntity book;
    @ManyToOne
    @JoinColumn(name = "authorid")
    private AuthorEntity author;
    @Column(name="role")
    private String role;

    public BookEntity getBook() {
        return book;
    }

    public void setBook(BookEntity book) {
        this.book = book;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public AuthorEntity getAuthor() {
        return author;
    }

    public void setAuthor(AuthorEntity author) {
        this.author = author;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}

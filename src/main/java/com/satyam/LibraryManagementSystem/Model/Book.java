package com.satyam.LibraryManagementSystem.Model;

import jakarta.persistence.*;

@Entity()
//@Table(name = "book_table")
public class Book {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "book_name")
    private String bookName;
    @Column(name = "author_name")
    private String author;
    @Column(name = "page_count")
    private int pages;

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }



    public Book(int id, String bookName, String author,int pages) {
        this.id = id;
        this.bookName = bookName;
        this.author = author;
        this.pages=pages;
    }

    public Book() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}

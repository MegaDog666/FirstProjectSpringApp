package org.example.models;

import jakarta.validation.constraints.*;

public class Book {
    private int id;
    @NotEmpty(message = "Title must not be empty")
    @Size(min = 2, max = 30, message = "Title must be between 2 and 30 characters")
    private String title;
    @NotEmpty(message = "Author must not be empty")
    @Size(min = 2, max = 30, message = "Author must be between 2 and 30 characters")
    private String author;
    @NotNull(message = "Year must not be null")
    @Min(value = 1900, message = "Year must be greater than 1900")
    @Max(value = 2100, message = "Year must be less than 2100")
    private int year;

    public Book(int id, String title, String author, int year) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
    }
    public Book() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}

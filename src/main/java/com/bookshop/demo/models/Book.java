package com.bookshop.demo.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;

@Entity
@Document(collection = "books")
@NoArgsConstructor
@Data
public class Book {
    @Id private String bookId;
    private String bookName;
    private int year;
    private String description;
    private String imageUrl;

    public Book(String bookName, int year, String description, String imageUrl) {
        this.bookName = bookName;
        this.year = year;
        this.description = description;
        this.imageUrl = imageUrl;
    }
}

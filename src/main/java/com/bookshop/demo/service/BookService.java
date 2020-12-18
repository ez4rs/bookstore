package com.bookshop.demo.service;

import com.bookshop.demo.models.Order;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BookService {
    ResponseEntity getBooks();

    ResponseEntity createBook(String uuid, String bookName, int year, String description, String imageUrl);

    ResponseEntity editBook(String uuid, String bookId, String bookName, int year, String description, String imageUrl);

    ResponseEntity deleteBook(String uuid, String bookId);

    ResponseEntity makeOrder(Order order);
}

package com.bookshop.demo.controller;

import com.bookshop.demo.models.Order;
import com.bookshop.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@CrossOrigin
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public ResponseEntity getBooks() {
        return bookService.getBooks();
    }

    @PostMapping
    public ResponseEntity createBook(@RequestParam String uuid, @RequestParam String bookName,
                             @RequestParam int year, @RequestParam String description,
                             @RequestParam String imageUrl) {
        return bookService.createBook(uuid, bookName, year, description, imageUrl);
    }

    @PutMapping
    public ResponseEntity editBook(@RequestParam String uuid, @RequestParam String bookId,
                           @RequestParam(required = false) String bookName, @RequestParam(required = false) int year,
                           @RequestParam(required = false) String description, @RequestParam(required = false) String imageUrl) {
        return bookService.editBook(uuid, bookId, bookName, year, description, imageUrl);
    }

    @DeleteMapping
    public ResponseEntity deleteBook(@RequestParam String uuid, @RequestParam String bookId) {
        return bookService.deleteBook(uuid, bookId);
    }

    @PostMapping("/order")
    public ResponseEntity makeOrder(@RequestBody Order order) {
        return bookService.makeOrder(order);
    }
}

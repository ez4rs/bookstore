package com.bookshop.demo.repository;

import com.bookshop.demo.models.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends MongoRepository<Book, String> {
    Book findByBookId(String bookId);

    Book deleteByBookId(String bookId);
}

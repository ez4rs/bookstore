package com.bookshop.demo.service;

import com.bookshop.demo.exception.RequestException;
import com.bookshop.demo.models.Book;
import com.bookshop.demo.models.Order;
import com.bookshop.demo.repository.OrderRepository;
import com.bookshop.demo.repository.UserRepository;
import com.bookshop.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public ResponseEntity getBooks() {
        List<Book> allBooks = bookRepository.findAll();
        return new ResponseEntity<>(allBooks, HttpStatus.OK);
    }

    @Override
    public ResponseEntity createBook(String uuid, String bookName, int year, String description, String imageUrl) {
        if (userRepository.findByUuid(uuid) == null)
            return new ResponseEntity<>(new RequestException("Неверный uuid пользователя"), HttpStatus.OK);

        Book newBook = bookRepository.save( new Book(bookName, year, description, imageUrl) );
        return new ResponseEntity<>(newBook, HttpStatus.OK);
    }

    @Override
    public ResponseEntity editBook(String uuid, String bookId, String bookName, int year, String description, String imageUrl) {
        if (userRepository.findByUuid(uuid) == null)
            return new ResponseEntity<>(new RequestException("Неверный uuid пользователя"), HttpStatus.OK);

        // Поиск книги в базе данных
        Book book = bookRepository.findByBookId( bookId );
        if (book == null)
            return new ResponseEntity<>(new RequestException("Неверный id книги"), HttpStatus.OK);

        // Присвоение значений
        if (bookName != null) {
            if (bookName.length() > 50)
                return new ResponseEntity<>(new RequestException("Название должно иметь максимум 50 символов в длину"), HttpStatus.OK);
            book.setBookName(bookName);
        }
        if (year != 0) {
            if (year > 9999 || year < 0)
                return new ResponseEntity<>(new RequestException("Неверный год издания книги"), HttpStatus.OK);
            book.setYear(year);
        }
        if (description != null) {
            if (description.length() > 500)
                return new ResponseEntity<>(new RequestException("Описание должно иметь максимум 500 символов в длину"), HttpStatus.OK);
            book.setDescription(bookName);
        }
        if (description != null) {
            book.setImageUrl(imageUrl);
        }

        // Сохранение книги
        Book savedBook = bookRepository.save(book);

        return new ResponseEntity<>(savedBook, HttpStatus.OK);
    }

    @Override
    public ResponseEntity deleteBook(String uuid, String bookId) {
        if (userRepository.findByUuid(uuid) == null)
            return new ResponseEntity<>(new RequestException("Неверный uuid пользователя"), HttpStatus.OK);

        // Удаление книги из базы данных
        Book book = bookRepository.deleteByBookId( bookId );
        if (book == null)
            return new ResponseEntity<>(new RequestException("Неверный id книги"), HttpStatus.OK);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity makeOrder(Order order) {
        Order newOrder = orderRepository.save( order );
        return new ResponseEntity<>(newOrder, HttpStatus.OK);
    }
}

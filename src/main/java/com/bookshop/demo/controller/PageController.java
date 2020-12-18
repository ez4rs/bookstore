package com.bookshop.demo.controller;

import com.bookshop.demo.models.Book;
import com.bookshop.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PageController {
    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/catalog")
    public String catalog(Model model) {
        List<Book> books = bookRepository.findAll();
        //model.addAttribute("books", );
        model.addAttribute("books", books);
        return "catalog";
    }

    @GetMapping("/auth")
    public String auth() {
        return "auth";
    }

    @GetMapping("/basket")
    public String basket() {
        return "basket";
    }

}

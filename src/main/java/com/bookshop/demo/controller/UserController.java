package com.bookshop.demo.controller;


import com.bookshop.demo.exception.RequestException;
import com.bookshop.demo.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.bookshop.demo.repository.UserRepository;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public ResponseEntity authUser(@RequestParam String login, @RequestParam String password) {
        User user = userRepository.findByLogin(login);
        if (user != null && user.getPassword().equals( password )) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        return new ResponseEntity<>(new RequestException("Неверный логин или пароль"), HttpStatus.OK);
    }
}

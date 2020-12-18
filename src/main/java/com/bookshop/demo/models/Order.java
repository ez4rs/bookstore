package com.bookshop.demo.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import java.util.List;

@Entity
@Document(collection = "orders")
@NoArgsConstructor
@Data
public class Order {
    @Id private String orderId;
    private List<String> books;
    private String phoneNumber;
    private String name;

    public Order(List<String> books, String phoneNumber, String name) {
        this.books = books;
        this.phoneNumber = phoneNumber;
        this.name = name;
    }
}

package com.bookshop.demo.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Document(collection = "users")
@NoArgsConstructor
@Data
public class User {
    @Id private String id;
    private String uuid;
    private String login;
    private String password;
}

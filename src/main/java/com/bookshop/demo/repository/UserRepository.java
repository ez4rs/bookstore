package com.bookshop.demo.repository;

import com.bookshop.demo.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    User findByUuid(String uuid);

    User findByLogin(String login);
}

package com.example.demo.service;

import com.example.demo.service.dto.User;

import java.util.List;

public interface UserService {
    User findById(String id);

    List<User> save(User user);

    User updateUser(String id, User user);

    List<User> findAll();

    void deleteById(String id);

    User findByName(String name);
}

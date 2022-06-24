package com.example.lab3.bidirectional.service;

import com.example.lab3.bidirectional.entity.User;

import java.util.List;


public interface UserService {
    void save(User user);

    void delete(int id);

    User findById(int id);

    List<User> getAll();
}

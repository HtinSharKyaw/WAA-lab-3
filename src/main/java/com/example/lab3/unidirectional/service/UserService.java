package com.example.lab3.unidirectional.service;

import com.example.lab3.unidirectional.entity.User;

import java.util.List;


public interface UserService {
    void save(User user);

    void delete(int id);

    User findById(int id);

    List<User> getAll();
}

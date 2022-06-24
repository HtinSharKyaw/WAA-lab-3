package com.example.lab3.unidirectional.service;

import com.example.lab3.unidirectional.entity.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    void save(Category category);

    void delete(int id);

    Category findById(int id);

    List<Category> getAll();
}

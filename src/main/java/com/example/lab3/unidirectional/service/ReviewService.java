package com.example.lab3.unidirectional.service;

import com.example.lab3.unidirectional.entity.Review;

import java.util.List;

public interface ReviewService {
    void save(Review review);

    void delete(int id);

    Review findById(int id);

    List<Review> getAll();
}

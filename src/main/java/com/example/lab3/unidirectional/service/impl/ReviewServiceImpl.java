package com.example.lab3.unidirectional.service.impl;

import com.example.lab3.unidirectional.dto.ReviewDTO;
import com.example.lab3.unidirectional.entity.Review;
import com.example.lab3.unidirectional.repository.ReviewRepository;
import com.example.lab3.unidirectional.service.ReviewService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public void save(Review review) {
        reviewRepository.save(review);
    }

    @Override
    public void delete(int id) {
        Review review = findById(id);
        if (null != review) {
            reviewRepository.delete(review);
        }
    }

    @Override
    public Review findById(int id) {
        return reviewRepository.findById(id).isPresent() ? reviewRepository.findById(id).get() : null;
    }

    @Override
    public List<Review> getAll() {
        return (List<Review>) reviewRepository.findAll();
    }

    //use model mapper here
    public ReviewDTO toDTO(Review review) {
        return modelMapper.map(review, ReviewDTO.class);
    }

    public Review toEntity(ReviewDTO reviewDTO) {
        return modelMapper.map(reviewDTO, Review.class);
    }
}

package com.example.lab3.unidirectional.controller;

import com.example.lab3.unidirectional.entity.Review;
import com.example.lab3.unidirectional.service.ReviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/review")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/save")
    public void createReview(@RequestBody Review review){
        reviewService.save(review);
    }

    @GetMapping("/get")
    public List<Review> getAll(){
        return reviewService.getAll();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Review> getReviewById(@PathVariable int id){
        var review = reviewService.findById(id);
        return ResponseEntity.ok(review);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id){
        reviewService.delete(id);
    }

}

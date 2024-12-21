package dev.handsonproject.movies.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.handsonproject.movies.entities.Reviews;
import dev.handsonproject.movies.service.ReviewService;

@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;
    
    @PostMapping
    public ResponseEntity<Reviews> createReview(@RequestBody Reviews payload){

        Reviews review = reviewService.creatReviews(payload);
        return new ResponseEntity<Reviews>(review, HttpStatus.CREATED);
    }
}

package dev.handsonproject.movies.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import dev.handsonproject.movies.entities.Movies;
import dev.handsonproject.movies.entities.Reviews;
import dev.handsonproject.movies.repo.ReviewRepository;

@Service
public class ReviewService {
    
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private MongoTemplate mongoTemplate;

    public Reviews creatReviews(Reviews reviews){

        Reviews review = reviewRepository.insert(new Reviews(reviews.getReview(),reviews.getImdbId()));

        mongoTemplate.update(Movies.class).matching(Criteria.where("imdbId").is(reviews.getImdbId())).apply(new Update().push("reviewIds").value(review)).first();

        return review;
    }
}

package dev.handsonproject.movies.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import dev.handsonproject.movies.entities.Reviews;

@Repository
public interface ReviewRepository extends MongoRepository<Reviews, String>{

    
}

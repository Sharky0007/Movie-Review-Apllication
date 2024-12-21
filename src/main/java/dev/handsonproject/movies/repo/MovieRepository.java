package dev.handsonproject.movies.repo;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import dev.handsonproject.movies.entities.Movies;

@Repository
public interface MovieRepository extends MongoRepository<Movies,ObjectId> {
    
   public Optional<Movies> findByImdbId(String imdbId);
}

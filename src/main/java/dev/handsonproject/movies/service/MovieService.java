package dev.handsonproject.movies.service;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.handsonproject.movies.entities.Movies;
import dev.handsonproject.movies.repo.MovieRepository;

@Service
public class MovieService {

    @Autowired
   private MovieRepository movieRepo;
    
    public List<Movies> getAllMovies(){
        
        List<Movies> movies = movieRepo.findAll();
        return movies;
    }

    public Optional<Movies> getMovieById(ObjectId id){
        Optional<Movies> movie = movieRepo.findById(id);
        return movie;
    }

    public Optional<Movies> getMovieByImdbId(String imdbId){
        Optional<Movies> movie = movieRepo.findByImdbId(imdbId);
        return movie;
    }
}

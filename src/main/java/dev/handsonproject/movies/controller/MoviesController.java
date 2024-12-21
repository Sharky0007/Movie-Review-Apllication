package dev.handsonproject.movies.controller;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.handsonproject.movies.entities.Movies;
import dev.handsonproject.movies.service.MovieService;

@RestController
@RequestMapping("/api/v1/movies")
// @CrossOrigin(origins = "http://localhost:3000")
public class MoviesController {

    @Autowired
    MovieService movieService;
    
    @GetMapping("/getAllMovies")
    public ResponseEntity<List<Movies>> getMovies(){

        List<Movies> movies = movieService.getAllMovies();
        return new ResponseEntity<List<Movies>>(movies, HttpStatus.OK);
    }

    @GetMapping("/getMovieById/{id}")
    public ResponseEntity<Optional<Movies>> getMovieById(@PathVariable ObjectId id){
        
        Optional<Movies> movie  = movieService.getMovieById(id);
        return new ResponseEntity<Optional<Movies>>(movie, HttpStatus.OK);
    }

    @GetMapping("/getMovieByImdbId/{imdbId}")
    public ResponseEntity<Optional<Movies>> getMovieByImdbId(@PathVariable String imdbId){
        
        Optional<Movies> movie  = movieService.getMovieByImdbId(imdbId);
        return new ResponseEntity<Optional<Movies>>(movie, HttpStatus.OK);
    }
}

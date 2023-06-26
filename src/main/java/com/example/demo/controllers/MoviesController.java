package com.example.demo.controllers;

import com.example.demo.models.MoviesEntity;
import com.example.demo.services.MoviesService;
import com.example.demo.util.MovieGenreSubtotalDto;
import com.example.demo.util.MoviesAndRatingsDto;
import com.example.demo.util.MoviesDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class MoviesController {

    @Autowired
    MoviesService moviesService;

    @GetMapping ("/api/v1/longest-duration-movies")
    public ResponseEntity getLongestRuntimeMoviesList() {
        try {
            List<MoviesDto> movies = moviesService.getLongestRuntimeMovies();
            return new ResponseEntity<> (movies, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<> (HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping ("/api/v1/new-movie")
    public String saveMovie (@RequestBody MoviesEntity moviesEntity) {
        try {
            Optional<MoviesEntity> existing = moviesService.getMovie(moviesEntity.getTconst());
            if (existing.isEmpty()) {
                MoviesEntity movies = moviesService.saveMovie(moviesEntity);
                return "SUCCESS";
            }
            return "FAILED";
        }
        catch (Exception e) {
            return "FAILED";
        }
    }

    @GetMapping ("/api/v1/top-rated-movies")
    public ResponseEntity getMovieRatings() {
        try {
            List<MoviesAndRatingsDto> moviesRatings = moviesService.getMoviesWithRatings();
            return new ResponseEntity<> (moviesRatings, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<> (HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping ("/api/v1/genre-movies-with-subtotals")
    public ResponseEntity getMoviesWithGenres() {
        try {
            List<MovieGenreSubtotalDto> moviesRatings = moviesService.getMoviesWithGenres();
            return new ResponseEntity<> (moviesRatings, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<> (HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping ("/api/v1/update-runtime-minutes")
    public String incrementMoviesByGenre () {
        try {
            moviesService.incrementAllMovies();
            return "SUCCESS";
        }
        catch (Exception e) {
            return e.getMessage();
        }
    }

}

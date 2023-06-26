package com.example.demo.services;

import com.example.demo.models.MoviesEntity;
import com.example.demo.util.MovieGenreSubtotalDto;
import com.example.demo.util.MoviesAndRatingsDto;
import com.example.demo.util.MoviesDto;

import java.util.List;
import java.util.Optional;


public interface MoviesService {
    List<MoviesEntity> getAllMovies();
    Optional<MoviesEntity> getMovie(String tconst);
    MoviesEntity saveMovie(MoviesEntity moviesEntity);
    MoviesEntity updateMovie(MoviesEntity moviesEntity);
    void deleteMovie(String tconst);

    List<MoviesDto> getLongestRuntimeMovies();

    List<MoviesAndRatingsDto> getMoviesWithRatings();

    List<MovieGenreSubtotalDto> getMoviesWithGenres();
    void incrementAllMovies();
}

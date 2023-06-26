package com.example.demo.services.impl;

import com.example.demo.models.MoviesEntity;
import com.example.demo.repos.MoviesRepo;
import com.example.demo.services.MoviesService;
import com.example.demo.util.MovieGenreSubtotalDto;
import com.example.demo.util.MoviesAndRatingsDto;
import com.example.demo.util.MoviesDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MoviesImpl implements MoviesService {

    @Autowired
    MoviesRepo moviesRepo;

    @Override
    public List<MoviesEntity> getAllMovies() {
        return moviesRepo.findAll();
    }

    @Override
    public Optional<MoviesEntity> getMovie(String tconst) {
        return moviesRepo.findById(tconst);
    }

    @Override
    public MoviesEntity saveMovie(MoviesEntity moviesEntity) {
        return moviesRepo.save(moviesEntity);
    }

    @Override
    public MoviesEntity updateMovie(MoviesEntity moviesEntity) {
        return moviesRepo.save(moviesEntity);
    }

    @Override
    public void deleteMovie(String tconst) {
        moviesRepo.deleteById(tconst);
    }

    @Override
    public List<MoviesDto> getLongestRuntimeMovies() {
        return moviesRepo.findLongestRuntimeMovies();
    }

    @Override
    public List<MoviesAndRatingsDto> getMoviesWithRatings() {
        return moviesRepo.findMovieWithRatings();
    }

    @Override
    public List<MovieGenreSubtotalDto> getMoviesWithGenres() {
        return moviesRepo.findMovieWithGenres();
    }

    @Override
    public void incrementAllMovies() {
        moviesRepo.incrementMovies();
    }

}

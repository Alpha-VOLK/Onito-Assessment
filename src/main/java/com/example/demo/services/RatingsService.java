package com.example.demo.services;

import com.example.demo.models.RatingsEntity;
import com.example.demo.models.RatingsEntity;

import java.util.List;
import java.util.Optional;

public interface RatingsService {
    List<RatingsEntity> getAllRatings();
    Optional<RatingsEntity> getRating(String tconst);
    RatingsEntity saveRating(RatingsEntity RatingsEntity);
    RatingsEntity updateRating(RatingsEntity RatingsEntity);
    void deleteRating(String tconst);
}

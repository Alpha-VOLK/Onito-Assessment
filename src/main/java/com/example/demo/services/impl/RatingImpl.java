package com.example.demo.services.impl;

import com.example.demo.models.RatingsEntity;
import com.example.demo.repos.RatingsRepo;
import com.example.demo.services.RatingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RatingImpl implements RatingsService {

    @Autowired
    RatingsRepo ratingsRepo;

    @Override
    public List<RatingsEntity> getAllRatings() {
        return ratingsRepo.findAll();
    }

    @Override
    public Optional<RatingsEntity> getRating(String tconst) {
        return ratingsRepo.findById(tconst);
    }

    @Override
    public RatingsEntity saveRating(RatingsEntity ratingsEntity) {
        return ratingsRepo.save(ratingsEntity);
    }

    @Override
    public RatingsEntity updateRating(RatingsEntity ratingsEntity) {
        return ratingsRepo.save(ratingsEntity);
    }

    @Override
    public void deleteRating(String tconst) {
        ratingsRepo.deleteById(tconst);
    }
}

package com.example.demo.repos;

import com.example.demo.models.RatingsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingsRepo extends JpaRepository<RatingsEntity, String> {
}

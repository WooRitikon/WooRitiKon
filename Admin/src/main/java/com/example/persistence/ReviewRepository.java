package com.example.persistence;

import org.springframework.data.repository.CrudRepository;

import com.example.domain.Review;

public interface ReviewRepository extends CrudRepository<Review, Integer>{

}

package com.example.persistence;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.domain.Review;

public interface ReviewRepository extends CrudRepository<Review, Integer>{

	@Query(value = "INSERT into review(rcode, rcontent, bcode, writedate, star)"
			+ "	VALUES (null,null,null,Now(),null) ",nativeQuery = true)
	void sendReview();	
}

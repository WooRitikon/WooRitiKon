package com.example.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.domain.Bucket;

@Repository
public interface BucketRepository extends CrudRepository<Bucket, Integer>{


}

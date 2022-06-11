package com.example.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.domain.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer> {

}

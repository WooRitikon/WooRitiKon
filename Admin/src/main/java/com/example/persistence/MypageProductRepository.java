package com.example.persistence;

import org.springframework.data.repository.CrudRepository;

import com.example.domain.Product;

public interface MypageProductRepository extends CrudRepository<Product, Integer>{

}

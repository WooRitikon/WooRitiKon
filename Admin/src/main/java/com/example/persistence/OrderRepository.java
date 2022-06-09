package com.example.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.domain.Bucket;
import com.example.domain.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Integer>{

}

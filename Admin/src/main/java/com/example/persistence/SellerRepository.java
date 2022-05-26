package com.example.persistence;

import org.springframework.data.repository.CrudRepository;

import com.example.domain.Sellerid;

public interface SellerRepository extends CrudRepository<Sellerid, String> {

}

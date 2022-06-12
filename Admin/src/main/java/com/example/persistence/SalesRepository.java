package com.example.persistence;


import org.springframework.data.repository.CrudRepository;

import com.example.domain.Calculate;

public interface SalesRepository extends CrudRepository<Calculate, Integer>{

	
}

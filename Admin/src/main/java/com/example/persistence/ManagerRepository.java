package com.example.persistence;

import org.springframework.data.repository.CrudRepository;

import com.example.domain.Manager;

public interface ManagerRepository extends CrudRepository<Manager, Integer>{

}

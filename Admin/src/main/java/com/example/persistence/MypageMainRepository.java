package com.example.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.domain.Normalid;

@Repository
public interface MypageMainRepository extends CrudRepository<Normalid, String>{

}

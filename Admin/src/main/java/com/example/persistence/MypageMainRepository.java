package com.example.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.domain.Normalid;

@Repository
public interface MypageMainRepository extends CrudRepository<Normalid, String>{
	
	
}

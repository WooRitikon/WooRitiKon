package com.example.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.domain.Qna;

@Repository
public interface QnaRepository extends CrudRepository<Qna, Integer> {

}

package com.example.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.domain.Qnacomment;

@Repository
public interface QnacommentRepository extends CrudRepository<Qnacomment, Integer> {

}

package com.example.persistence;

import org.springframework.data.repository.CrudRepository;

import com.example.domain.Faq;

public interface FaqRepository extends CrudRepository<Faq, Integer> {

}

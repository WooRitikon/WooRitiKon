package com.example.persistence;

import org.springframework.data.repository.CrudRepository;

import com.example.domain.Notice;

public interface NoticeRepository extends CrudRepository<Notice, Integer>{

}

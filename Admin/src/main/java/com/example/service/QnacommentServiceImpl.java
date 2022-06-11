package com.example.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.controller.AdminController;
import com.example.domain.Qnacomment;
import com.example.persistence.QnacommentRepository;

@Service
public class QnacommentServiceImpl implements QnacommentService {

   static final Logger logger = LoggerFactory.getLogger(AdminController.class);
   
   @Autowired
   private QnacommentRepository QnacomRepo;
   
   @Override
   public void insertReply(Qnacomment qc) {
      logger.info("답글저장");
      QnacomRepo.save(qc);
   }
   
   @Override
   public List<Qnacomment> getQcList(Qnacomment qc) {
      logger.info("답글보기");
      return (List<Qnacomment>)QnacomRepo.findAll();
   }
   
}
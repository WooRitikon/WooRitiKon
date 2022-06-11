package com.example.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;


@Data
@Entity
public class Qna {


      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Integer qcode;
      
      @ManyToOne
      @JoinColumn(name="nid")
      private Normalid nid;
      private String ntitle;
      private String ncontent;
      private String qnastate;
      
//      @Column(insertable = false, updatable = false, columnDefinition = "date default sysdate()")
//      @Temporal(TemporalType.DATE)
      @CreationTimestamp
      private LocalDate ndate;
      
}
   
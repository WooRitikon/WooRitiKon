package com.example.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.domain.Qnacomment;

@Repository
public interface QnacommentRepository extends CrudRepository<Qnacomment, Integer> {
	 @Query(value="SELECT q.qcode, q.nid, q.ntitle, q.ncontent, q.ndate, a.ccode, a.ccontent, a.cdate FROM qna q Left outer JOIN qnacomment a ON q.qcode=a.qcode where q.qcode = :code", nativeQuery=true)
	 List<Object[]> findByqcode(@Param("code") int qCode);

}

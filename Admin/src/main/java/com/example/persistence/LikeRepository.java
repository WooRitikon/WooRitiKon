package com.example.persistence;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.domain.Like;


public interface LikeRepository extends CrudRepository<Like, Integer>{

	//찜한 목록 찾기
	@Query(value="SELECT n.nid nid, s.bname bname, s.btel tel, l.heart heart  "
			+ "FROM `like` l INNER JOIN normalid n  "
			+ "ON l.nid = n.nid  "
			+ "INNER JOIN sellerid s  "
			+ "on l.bcode = s.bcode  "
			+ "WHERE l.heart = 1 AND n.nid = ?1  ",
			nativeQuery=true)
	List<Object[]> shopHeart(String nid);
	
	
}

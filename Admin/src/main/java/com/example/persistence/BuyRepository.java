package com.example.persistence;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.domain.Bucket;
import com.example.domain.Buy;

@Repository
public interface BuyRepository extends CrudRepository<Buy, Integer>{

	//빈 주문 생성
		@Query(value="INSERT into buy(odate, oselect, ototal, ostate, nid) VALUES (CURDATE(),NULL,null,'N',?1);",
				nativeQuery = true
				)
		void updateOrderNumber(String nid);
		
	//주문 번호로 주문 가져오기
		@Query(value="SELECT * FROM buy WHERE nid=?1 AND ostate = \"N\"",nativeQuery = true)
		Buy selectOrderNum(String nid);
		
	//주문 상태 변경
		@Query(value="UPDATE buy SET ostate='Y' WHERE onum=?1",nativeQuery = true)
		void updateOstate(Integer onum);
		
}



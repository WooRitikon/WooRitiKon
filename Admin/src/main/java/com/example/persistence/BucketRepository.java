package com.example.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.domain.Bucket;

@Repository
public interface BucketRepository extends CrudRepository<Bucket, Integer>{

	//장바구니 조회
	@Query(value="SELECT n.nid nid, p.pname pname, p.pprice pprice, b.quantity quantity    "
			+ "FROM bucket b INNER JOIN normalid n  "
			+ "ON b.nid = n.nid  "
			+ "INNER JOIN product p   "
			+ "ON b.pcode = p.pcode   "
			+ "WHERE n.nid= ?1  ", nativeQuery=true)
	List<Object[]> selectBusket(String nid);
}

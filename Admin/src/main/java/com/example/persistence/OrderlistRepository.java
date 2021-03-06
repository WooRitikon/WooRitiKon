package com.example.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.domain.Orderlist;

@Repository
public interface OrderlistRepository extends CrudRepository<Orderlist, Integer>{
	
	//빈 주문리스트 생성
	@Query(value="INSERT into orderlist(quantity, totalprice, pcode) VALUES (null,null,null)",
			nativeQuery = true
			)
	void updateBuylistNumber();
	
	@Query(value="SELECT n.nid nid, o.onum onum, o.odate odate, o.oselect oselect, o.ototal ototal, o.ostate ostate, "
			+ " li.listcode listcode, li.quantity quantity, li.totalprice totalprice, p.pcode pcode, p.pprice pprice, p.pname pname,  "
			+ " p.pcategory pcategory, p.senderid senderid, p.pcontent pcontent  "
			+ " FROM orderlist li OUTER JOIN order o  "
			+ " on li.onum = o.onum  "
			+ " OUTER JOIN product p  "
			+ " on li.pcode = p.pcode  "
			+ " OUTER JOIN normalid n  "
			+ " on o.nid = n.nid  "
			+ " WHERE n.nid= ?1"
			, nativeQuery = true)
	List<Object[]> orderlistset(String nid);
}

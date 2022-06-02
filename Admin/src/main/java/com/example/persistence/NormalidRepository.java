package com.example.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.domain.Normalid;

@Repository
public interface NormalidRepository extends CrudRepository<Normalid, String> {
	
//	@Query(value = "SELECT n FROM normalid n WHERE n.nid = ?1 AND n.npassword = ?2",   nativeQuery = true)
//	List<Normalid> findByNameRecently(String nid, String npassword);
	
	//List<Nomarlid> findAllActiveUsersNative();
	
}

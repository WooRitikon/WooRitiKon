package com.example.persistence;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.domain.Giftikon;

public interface GiftikonRepository extends CrudRepository<Giftikon, Integer>{
	
	@Query(value="SELECT  "
			+ "n.nid nid, g.startdate startdate, g.finaldate finaldate, p.pcode pcode, p.pprice pprice, p.pcategory pcategory, p.pname pname, p.pcontent pcontent, g.gcode gcode  "
			+ " FROM giftikon g INNER JOIN normalid n  "
			+ " ON n.nid = g.nid  "
			+ " INNER JOIN product p  "
			+ " ON g.pcode = p.pcode  "
			+ " WHERE g.finaldate >= NOW() AND n.nid = ?1  "
			+ " ORDER BY g.finaldate asc ",
			nativeQuery=true)
	List<Object[]> giftSelect(String nid);
}
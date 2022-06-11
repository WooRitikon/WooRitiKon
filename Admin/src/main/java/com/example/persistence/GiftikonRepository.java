package com.example.persistence;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.domain.Giftikon;

public interface GiftikonRepository extends CrudRepository<Giftikon, Integer>{
	
	
	//현재 사용가능한 기프티콘 조회
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
	
	
	//전제 구매기프티콘 조회
	@Query(value="SELECT  "
			+ " FROM giftikon g INNER JOIN normalid n  "
			+ " ON n.nid = g.nid  "
			+ " INNER JOIN product p  "
			+ " ON g.pcode = p.pcode  "
			+ " WHERE n.nid = ?1  "
			+ " ORDER BY g.finaldate asc ",
			nativeQuery=true)
	List<Object[]> giftAllSelect(String nid);
	
	//받은 선물 조회
	@Query(value="SELECT  "
			+ " FROM giftikon g INNER JOIN normalid n  "
			+ " ON n.nid = g.nid  "
			+ " INNER JOIN product p  "
			+ " ON g.pcode = p.pcode  "
			+ " ORDER BY g.finaldate asc ",
			nativeQuery=true)
	List<Object[]> giftToSelect(String nid);

}
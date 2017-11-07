package com.example.demo.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Caller;

public interface CallerDAO extends JpaRepository<Caller,Integer> {

	
	@Modifying
	@Query(value ="select Monthname(calldate) AS Month, SUM(billsec/60) AS Minutes from callers where company= :compname && (type = 'OUTBOUND') && Date(calldate) >= (now() - interval 6 month) group by Monthname(calldate)",nativeQuery = true)
	List<Object[]> companymonthlycall(@Param("compname")String compname);
	
	
	@Query(value = "select DATE(calldate) AS Date,AVG(duration-billsec) AS TimetoAnswer from callers group by Date having Date > (CURDATE()- INTERVAL 30 DAY)",nativeQuery = true)
	List<Object[]> getTimetoanswer();
	

	@Query(value = "select calldate, ani,dnis,duration from callers where (dnis LIKE '218%' OR dnis LIKE '320%' OR dnis LIKE '507%' OR dnis LIKE '612%' OR dnis LIKE '736%' OR dnis LIKE '952%' OR dnis LIKE '651%') AND (Date(calldate)=CURDATE()) AND (enddate < NOW()) AND (type = 'OUTBOUND') AND (company= :compn)",nativeQuery = true)
	List<Object[]> getcalllist(@Param("compn")String compn);
			
   
}

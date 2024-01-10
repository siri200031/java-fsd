package com.example.demo.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CenterRepo extends JpaRepository<Center, Integer>{
	
	@Query("SELECT c FROM Center c WHERE c.centername = :centername")
    Center findByCentername(@Param("centername")String centername);

}
package com.example.demo.User;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CitizenRepo extends JpaRepository<Citizen, Integer> {
	@Query("SELECT c FROM Citizen c WHERE c.center = :center")
	List<Citizen> findByCenter(@Param("center")Center center);

}
package com.lorenzolerate.rs.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lorenzolerate.rs.model.Office;

@Repository
public interface OfficeRepo extends JpaRepository<Office, Integer> {
	public Office findByLocation(String location);
	
}
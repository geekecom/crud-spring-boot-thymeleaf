package com.lorenzolerate.rs.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lorenzolerate.rs.model.Technology;

@Repository
public interface TechnologyRepo extends JpaRepository<Technology, Integer> {
	Technology findByName(String name);
}
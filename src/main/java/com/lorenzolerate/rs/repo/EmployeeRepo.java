package com.lorenzolerate.rs.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lorenzolerate.rs.model.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
}
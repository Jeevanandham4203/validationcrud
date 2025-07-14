package com.example.Repo;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.entity.Employee;

public interface EmpRepo extends JpaRepository<Employee, UUID>{
	
	@Query("Select n from Employee n where name=:name")
	Optional<Employee> findbyname(@Param("name")String name);

}

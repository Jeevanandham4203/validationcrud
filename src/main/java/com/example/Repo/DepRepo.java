package com.example.Repo;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Department;

public interface DepRepo extends JpaRepository<Department, UUID>{

}

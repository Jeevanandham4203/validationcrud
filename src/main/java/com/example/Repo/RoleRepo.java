package com.example.Repo;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Role;

public interface RoleRepo extends JpaRepository<Role, UUID>{

}

package com.example.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.Repo.RoleRepo;
import com.example.entity.Role;

@Repository
public class RoleDao {
	@Autowired
	RoleRepo rr;

	public String postrole(Role r) {
		rr.save(r);
		return "role created";
	}
}

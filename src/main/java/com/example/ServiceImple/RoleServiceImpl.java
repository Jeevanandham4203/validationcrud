package com.example.ServiceImple;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.Dao.RoleDao;
import com.example.Service.RoleServices;
import com.example.entity.Role;

public class RoleServiceImpl implements RoleServices{

	@Autowired
	RoleDao rd;
	@Override
	public String postrole(Role r) {
		return rd.postrole(r);
	}

}

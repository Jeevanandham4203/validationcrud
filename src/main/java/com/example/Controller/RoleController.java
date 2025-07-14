package com.example.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Service.RoleServices;
import com.example.entity.Role;

@RestController
@RequestMapping("/Role")
public class RoleController {
	
	@Autowired
	RoleServices rs;
	
	@PostMapping("/postrole")
	public String postrole(@RequestBody Role r) {
		return rs.postrole(r);
	}
}

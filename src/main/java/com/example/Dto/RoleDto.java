package com.example.Dto;

import java.util.List;

import com.example.entity.Employee;

import lombok.Data;

@Data
public class RoleDto {
	 private String name; 
	 private List<Employee> employees;
}

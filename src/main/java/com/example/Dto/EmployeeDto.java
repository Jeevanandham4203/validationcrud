package com.example.Dto;

import java.util.UUID;


import lombok.Data;

@Data
public class EmployeeDto {
	private String name;
	private int age;
	private String email;
	private String position;
	private long salary;
	
	private UUID departmentId;
	
	 private UUID roleId;
}

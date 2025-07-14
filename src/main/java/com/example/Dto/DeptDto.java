package com.example.Dto;

import java.util.List;

import com.example.entity.Employee;

import lombok.Data;

@Data
public class DeptDto {
	private String name;
	private int floorNumber;
	private String deptcode;
	private List<Employee>employee;
}

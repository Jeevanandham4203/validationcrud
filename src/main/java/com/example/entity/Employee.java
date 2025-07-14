package com.example.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Employee")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "emp_id")
	private UUID id;
	
	@Column(name = "emp_name")
	@NotBlank(message = "{employee.name.required}")	
	private String name;
	
	@Column(name = "emp_age")
	@Min(value = 18, message = "{employee.age.invalid}")
	@Max(value = 60, message = "{employee.age.invalid}")
	private int age;
	
	@Email(message = "email should be valid")
	@NotBlank(message = "{employee.email.invalid}")
	private String email;
	
	private String position;
	
	@Column(name = "emp_salary")
	@Positive(message = "{employee.salary.invalid}")
	private long salary; 
	
	
	@ManyToOne
	private Department department;
	
	@ManyToOne
    private Role role;

	

	
	
	
}

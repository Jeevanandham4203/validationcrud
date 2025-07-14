package com.example.entity;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "department")
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "dept_id")
	private UUID id;
	
	@NotNull
	@Column(name = "depName")
	private String name;
	
	@Column(name = "floor_no")
	private int floorNumber;
	
	@Column(name = "dept_code")
	private String deptcode;
	
	@OneToMany(mappedBy = "department",cascade = CascadeType.ALL)
	private List<Employee>employee;
}

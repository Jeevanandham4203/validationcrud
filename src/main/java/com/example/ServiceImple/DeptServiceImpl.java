package com.example.ServiceImple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.Dto.DeptDto;
import com.example.Repo.DepRepo;
import com.example.Service.DeptServices;
import com.example.entity.Department;

@Service
public class DeptServiceImpl implements DeptServices{
	@Autowired
	DepRepo deptrepo;
	
	@Override
	public ResponseEntity<String> posted(DeptDto deptdto) {
		Department dept=new Department();
		dept.setName(deptdto.getName());
		dept.setFloorNumber(deptdto.getFloorNumber());
		dept.setDeptcode(deptdto.getDeptcode());
		deptrepo.save(dept);
		return ResponseEntity.ok("posted Successfully");
		
	}

	@Override
	public ResponseEntity<List<DeptDto>> getall() {
		List<Department>dept=deptrepo.findAll();
		List<DeptDto>deptdto=dept.stream().map(dep->{
			DeptDto dto = new DeptDto();
			dto.setName(dep.getName());
			dto.setFloorNumber(dep.getFloorNumber());
			return dto;
		}).toList();
		return ResponseEntity.ok(deptdto);
	}
	
}

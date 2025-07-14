package com.example.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.Dto.DeptDto;

public interface DeptServices {

	ResponseEntity<String> posted(DeptDto deptdto);

	ResponseEntity<List<DeptDto>> getall();

}

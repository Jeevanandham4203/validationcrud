package com.example.Service;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.Dto.BaseDto;
import com.example.Dto.EmployeeDto;

@Service
public interface EmpServices {

	ResponseEntity<BaseDto> postvalue(EmployeeDto e);

	ResponseEntity<List<EmployeeDto>> getall();

	EmployeeDto getbyid(UUID id);

	String putMethodName(UUID id, EmployeeDto dto);

	String deleted(UUID id);

}

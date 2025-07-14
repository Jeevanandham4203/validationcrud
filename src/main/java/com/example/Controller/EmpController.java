package com.example.Controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Dto.BaseDto;
import com.example.Dto.EmployeeDto;
import com.example.Service.EmpServices;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/Emp")
public class EmpController {
	
	@Autowired
	EmpServices empservices;
	
	
	@PostMapping("/post")
	public ResponseEntity<BaseDto> postvalue(@RequestBody EmployeeDto e){
		return empservices.postvalue(e);
	}
	
	@GetMapping("/getall")
	public ResponseEntity<List<EmployeeDto>> getall(){
		return empservices.getall();
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<EmployeeDto> getbyid(@PathVariable UUID id){
		EmployeeDto empdto= empservices.getbyid(id);
		return new ResponseEntity<>(empdto, HttpStatus.OK);
	}
	
	@PutMapping("/put/{id}")
	public String putMethodName(@PathVariable UUID id, @RequestBody EmployeeDto dto) {
		return empservices.putMethodName(id,dto);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleted(@PathVariable UUID id) {
		return empservices.deleted(id);
	}
}

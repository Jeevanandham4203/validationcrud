package com.example.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Dto.DeptDto;
import com.example.Service.DeptServices;

@RestController
@RequestMapping("/Dept")
public class DeptController {
	
	@Autowired
	DeptServices ds;
	
	@PostMapping("/post")
	public ResponseEntity<String> posted(@RequestBody DeptDto deptdto){
		return ds.posted(deptdto);
	}
	
	@GetMapping("/getall")
	public ResponseEntity<List<DeptDto>> getall(){
		return ds.getall();
	}
}

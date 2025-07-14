package com.example.ServiceImple;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.Dto.BaseDto;
import com.example.Dto.EmployeeDto;
import com.example.Enum.ResponseMessageConstant;
import com.example.Repo.EmpRepo;
import com.example.Service.EmpServices;
import com.example.Validator.Employeevalidator;
import com.example.entity.Employee;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class EmpServiceImpl implements EmpServices {
	@Autowired
	private EmpRepo emprepo;

	@Autowired
	private Employeevalidator empvalidator;

	@Autowired
	private MessageSource msgsource;

	@Override
	public ResponseEntity<BaseDto> postvalue(EmployeeDto empdto) {
		try {
			ResponseMessageConstant validate = empvalidator.validator(empdto);
			if (validate != null) {
				String errorMsg = msgsource.getMessage(String.valueOf(validate.getErrorCode()), null, null);
				return ResponseEntity.status(validate.getErrorCode())
						.body(new BaseDto(validate.getErrorCode(), errorMsg));
			}

			Employee emp = new Employee();
			emp.setName(empdto.getName());
			emp.setAge(empdto.getAge());
			emp.setEmail(empdto.getEmail());
			emp.setPosition(empdto.getPosition());
			emp.setSalary(empdto.getSalary());
			emprepo.save(emp);
			log.info("details saved from db");
			String Successmessage = msgsource.getMessage("200", null, null);
			return ResponseEntity.ok(new BaseDto(200, Successmessage));
		} catch (Exception e) {
			log.error("error occured in create:{}", e);
			String failmsg = msgsource
					.getMessage(String.valueOf(ResponseMessageConstant.FAILED_TO_ADD.getmessageCode()), null, null);
			return ResponseEntity.status(ResponseMessageConstant.FAILED_TO_ADD.getErrorCode())
					.body(new BaseDto(ResponseMessageConstant.FAILED_TO_ADD.getErrorCode(), failmsg));
		}

	}

	@Override
	public ResponseEntity<List<EmployeeDto>> getall() {
		List<Employee> employee = emprepo.findAll();
		List<EmployeeDto> dtoList = employee.stream().map(emp -> {
			EmployeeDto dto = new EmployeeDto();
			dto.setName(emp.getName());
			dto.setAge(emp.getAge());
			dto.setEmail(emp.getEmail());
			dto.setPosition(emp.getPosition());
			dto.setSalary(emp.getSalary());
			dto.setDepartmentId(emp.getDepartment().getId());
			dto.setRoleId(emp.getRole().getId());
			return dto;
		}).collect(Collectors.toList());

		return ResponseEntity.ok(dtoList);
	}

	@Override
	public EmployeeDto getbyid(UUID id) {
		Employee emp = emprepo.findById(id)
				.orElseThrow(() -> new RuntimeException("Employee not found with ID: " + id));
		EmployeeDto empdto = new EmployeeDto();
		empdto.setName(emp.getName());
		empdto.setAge(emp.getAge());
		empdto.setEmail(emp.getEmail());
		empdto.setSalary(emp.getSalary());
		return empdto;
	}

	@Override
	public String putMethodName(UUID id, EmployeeDto dto) {
		Employee emp = emprepo.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
		emp.setName(dto.getName());
		emp.setAge(dto.getAge());
		emp.setEmail(dto.getEmail());
		emp.setSalary(dto.getSalary());
		emprepo.save(emp);
		return "updated successfully";
	}

	@Override
	public String deleted(UUID id) {
		emprepo.deleteById(id);
		return id + "Deleted permanently";
	}

}

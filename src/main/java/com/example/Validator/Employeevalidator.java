package com.example.Validator;

import org.springframework.stereotype.Component;

import com.example.Dto.EmployeeDto;
import com.example.Enum.ResponseMessageConstant;

@Component
public class Employeevalidator {

	public ResponseMessageConstant validator(EmployeeDto empdto) {
		if (empdto.getName() == null || empdto.getName().trim().isEmpty()) {
			return ResponseMessageConstant.NAME_REQUIRED;
		}
		if (empdto.getAge() < 18 || empdto.getAge() > 60) {
			return ResponseMessageConstant.AGE_INVALID;
		}
		if (empdto.getEmail() == null || empdto.getEmail().trim().isEmpty()) {
			return ResponseMessageConstant.EMAIL_REQUIRED;
		}
		if (empdto.getPosition() == null || empdto.getPosition().trim().isEmpty()) {
			return ResponseMessageConstant.POSITION_NOTEMPTY;
		}
		if(empdto.getSalary()<0) {
			return ResponseMessageConstant.SALARY_INVALID;
		}
		return null;
		
	}

}

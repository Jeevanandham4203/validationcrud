package com.example.Dto;

import lombok.Data;

@Data
public class BaseDto {
	private int statuscode;
	private String message;
	
	public BaseDto(int statuscode,String message) {
		statuscode=this.statuscode;
		message=this.message;
	}
	public BaseDto() {}
}

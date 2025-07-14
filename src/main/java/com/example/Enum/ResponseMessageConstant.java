package com.example.Enum;


public enum ResponseMessageConstant {
	SUCCESS_RESPONSE(200,200),
	VALIDATION_FAILED(400,400),
	NAME_REQUIRED(402,402),
	AGE_INVALID(403,403),
	EMAIL_REQUIRED(404,404),
	POSITION_NOTEMPTY(405,405),
	SALARY_INVALID(406,406),
	FAILED_TO_ADD(407,407);
	
	private final int errorCode;
	private final int messageCode;
	
	private ResponseMessageConstant(int errorCode, int messagecode) {
		this.errorCode=errorCode;
		this.messageCode=messagecode;
	}
	
	public int getErrorCode() {
		return errorCode;
	}
	
	public int getmessageCode() {
		return messageCode;
	}
}

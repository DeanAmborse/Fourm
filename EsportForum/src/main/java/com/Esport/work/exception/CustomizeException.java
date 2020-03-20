package com.Esport.work.exception;

public class CustomizeException extends RuntimeException{
	private String message;
	private Integer code;
	public Integer getCode() {
		return code;
	}
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return message;
	}
	public CustomizeException(ICustomizeErrorCode errorCode) {
		this.code = errorCode.getCode();
		this.message = errorCode.getMessage();
	}
	public CustomizeException(String message) {
		this.message = message;
	}
}

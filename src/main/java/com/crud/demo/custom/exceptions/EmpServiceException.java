package com.crud.demo.custom.exceptions;

public class EmpServiceException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	private String err_msg;
	private String err_code;
	
	public EmpServiceException(String errMsg, String errCode) {
		this.setErr_msg(errMsg);
		this.setErr_code(errCode);
		
	}
	
	public EmpServiceException() {
		
	}

	public String getErr_msg() {
		return err_msg;
	}

	public void setErr_msg(String err_msg) {
		this.err_msg = err_msg;
	}

	public String getErr_code() {
		return err_code;
	}

	public void setErr_code(String err_code) {
		this.err_code = err_code;
	}
	
}

package com.crud.demo.custom.exceptions;

public class EmptyInputException extends RuntimeException{
	
	private String errMsg;
	private String errCode;
	
	//This is for global exception in newbranch
	public EmptyInputException (String err_msg, String err_code) {
		this.setErrMsg(err_msg);
		this.setErrCode(err_code);
	}
	
	public String getErrMsg() {
		return errMsg;
	}
	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
	public String getErrCode() {
		return errCode;
	}
	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}
	private static final long serialVersionUID = -3619764525559668594L;
	

}

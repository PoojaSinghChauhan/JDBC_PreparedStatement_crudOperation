package com.jsp.jdbc_preparedStatement_crud_operation.exeption;

public class IdNotFoundException extends Exception{
	String msg;
	public IdNotFoundException(String msg) {
		super(msg);
		this.msg=msg;
	}
}

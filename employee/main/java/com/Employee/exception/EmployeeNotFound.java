package com.Employee.exception;

public class EmployeeNotFound extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public EmployeeNotFound(String source) {
		super(String.format("Employee with %s not found",source));
	}
}

package com.Employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.Employee.dto.CreateEmployeeDto;
import com.Employee.dto.ResponseMessageDto;
import com.Employee.model.Employee;

public interface EmployeeService {

	public List<Employee> getAllEmployee();

	public Employee updateEmployee(Employee employee);

	public Employee createEmployee(CreateEmployeeDto createEmployeeDto);

	public void deleteEmployeeid(Long employeeId);

	public Employee getemployee(Long employeeId);

//	public Optional<Employee> getemployee(int employeeId);

	//public void getBooksById(int employeeId);

	




	

}

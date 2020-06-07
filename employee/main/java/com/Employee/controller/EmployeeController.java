package com.Employee.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.Employee.dto.CreateEmployeeDto;
import com.Employee.dto.ResponseMessageDto;
import com.Employee.model.Employee;
import com.Employee.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@PostMapping(value = "/employee")
	public ResponseEntity<ResponseMessageDto> createEmployees(@RequestBody CreateEmployeeDto createEmployeeDto) {
		ResponseMessageDto responseMessageDto = new ResponseMessageDto();
		 employeeService.createEmployee(createEmployeeDto);
		responseMessageDto.setMessage("Employee created  successfully");
		return new ResponseEntity<>(responseMessageDto, HttpStatus.OK);
	}
	@DeleteMapping(value="/employee/{employeeid}")
	public ResponseEntity<ResponseMessageDto> deleteEmployee(@PathVariable("employeeid") Long employeeId) {
		ResponseMessageDto responseMessageDto = new ResponseMessageDto();
		employeeService.deleteEmployeeid(employeeId);
		responseMessageDto.setMessage("Employee id is:"+employeeId+"deleted");
		return new ResponseEntity<>(responseMessageDto,HttpStatus.OK);
		}
	@GetMapping(value = "/employees")
	public List<Employee> getAllEmployee() {
		return employeeService.getAllEmployee();
	}
	@PutMapping(value = "/employee")
	public ResponseEntity<ResponseMessageDto> updateEmployee(@RequestBody Employee employee) {
		ResponseMessageDto responseMessageDto = new ResponseMessageDto();
		employeeService.updateEmployee(employee);
		responseMessageDto.setMessage("Employee updated  successfully");
		return new ResponseEntity<>(responseMessageDto, HttpStatus.OK);
	}
	@GetMapping(value="/employee/{employeeid}")
	public ResponseEntity<Employee> getemployee(@PathVariable("employeeid") Long employeeId) {
		Employee employee = employeeService.getemployee(employeeId); 
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}
	
}
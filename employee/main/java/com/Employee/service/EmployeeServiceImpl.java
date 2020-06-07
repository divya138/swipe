package com.Employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.ReturnedType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Employee.dto.CreateEmployeeDto;
import com.Employee.dto.ResponseMessageDto;
import com.Employee.exception.EmployeeNotFound;
import com.Employee.model.Employee;
import com.Employee.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public Employee createEmployee(CreateEmployeeDto createEmployeeDto) {
		Employee employee = new Employee();
		BeanUtils.copyProperties(createEmployeeDto, employee);
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		return employeeRepository.saveAndFlush(employee);
	}

	@Override
	public void deleteEmployeeid(Long employeeId) {
		employeeRepository.deleteById(employeeId);

	}

	@Override
	public Employee getemployee(Long employeeId) {
		

	Optional<Employee> employee	=employeeRepository.findById(employeeId);
	
	Employee emp=null;
	if(employee.isPresent()) {
		emp=employee.get();
	}else {
		throw new EmployeeNotFound("");
	}
		
		return emp;
	}


}
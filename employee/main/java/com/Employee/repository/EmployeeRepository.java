package com.Employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Employee.dto.CreateEmployeeDto;
import com.Employee.dto.ResponseMessageDto;
import com.Employee.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	

	


}

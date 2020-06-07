package com.swipe.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.swipe.Model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long>{

}

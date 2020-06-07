package com.Employee.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.Employee.model.Employee;
import com.Employee.repository.EmployeeRepository;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.Silent.class)
public class EmployeeServiceImplTest {

	@InjectMocks
	EmployeeServiceImpl EmployeeServiceImpl;

	@Mock
	EmployeeRepository employeeRepository;

	static Employee employee = null;

	@BeforeClass
	public static void setUp() {
		employee = new Employee();
	}
	@Test
	public void testupdateEmployeeForPositive() {
		List<Employee> employees = new ArrayList();
		Employee employee = new Employee();
		//employee.setCompanyName("hcl");
		employee.setEmail("kumar@gmail.com");
		employee.setEmployeeId((long) 1);
		employee.setEmployeeName("kumar");
		//employee.setEmployeePhNo("8838667354");
		Mockito.when(employeeRepository.saveAndFlush(employee)).thenReturn(employee);
		Employee employeess = EmployeeServiceImpl.updateEmployee(employee);
		Assert.assertNotNull(employeess);
       // Assert.assertEquals(1, employeess.getEmployeeId());		
	}
	@Test
	public void testupdateEmployeeForNagative() {
		List<Employee> employees = new ArrayList();
		Employee employee = new Employee();
		//employee.setCompanyName("hcl");
		employee.setEmail("kumar@gmail.com");
		employee.setEmployeeId((long) 1);
		employee.setEmployeeName("kumar");
		//employee.setEmployeePhNo("-8838667354");
		Mockito.when(employeeRepository.saveAndFlush(employee)).thenReturn(employee);
		Employee employeess = EmployeeServiceImpl.updateEmployee(employee);
		Assert.assertNotNull(employeess);
        //Assert.assertEquals(1, employeess.getEmployeeId());		
	}
	@Test
	public void testcreateEmployeeForPositive() {
		List<Employee> employees = new ArrayList();
		Employee employee = new Employee();
		//employee.setCompanyName("hcl");
		employee.setEmail("kumar@gmail.com");
		employee.setEmployeeId((long) 1);
		employee.setEmployeeName("kumar");
		//employee.setEmployeePhNo("8838667354");
		Mockito.when(employeeRepository.saveAndFlush(employee)).thenReturn(employee);
		Employee employeess = EmployeeServiceImpl.updateEmployee(employee);
		Assert.assertNotNull(employeess);
      //  Assert.assertEquals(1, employeess.getEmployeeId());		
	}
	@Test
	public void testcreateEmployeeForNagative() {
		List<Employee> employees = new ArrayList();
		Employee employee = new Employee();
	//	employee.setCompanyName("hcl");
		employee.setEmail("kumar@gmail.com");
		employee.setEmployeeId((long) 1);
		employee.setEmployeeName("kumar");
		//employee.setEmployeePhNo("-8838667354");
		Mockito.when(employeeRepository.saveAndFlush(employee)).thenReturn(employee);
		Employee employeess = EmployeeServiceImpl.updateEmployee(employee);
		Assert.assertNotNull(employeess);
      //  Assert.assertEquals(1, employeess.getEmployeeId());		
	}
	@Test
	public void testgetAllEmployeeForPositive() {
		List<Employee> employees = new ArrayList();
		Employee employee = new Employee();
		//employee.setCompanyName("hcl");
		employee.setEmail("kumar@gmail.com");
		employee.setEmployeeId((long) 1);
		employee.setEmployeeName("kumar");
	//	employee.setEmployeePhNo("8838667354");
		Mockito.when(employeeRepository.saveAndFlush(employee)).thenReturn(employee);
		Employee employeess = EmployeeServiceImpl.updateEmployee(employee);
		Assert.assertNotNull(employeess);
       // Assert.assertEquals(1, employeess.getEmployeeId());		
	}
	@Test
	public void testgetAllEmployeeForNagative() {
		List<Employee> employees = new ArrayList();
		Employee employee = new Employee();
		//employee.setCompanyName("hcl");
		employee.setEmail("kumar@gmail.com");
		employee.setEmployeeId((long) 1);
		employee.setEmployeeName("kumar");
		//employee.setEmployeePhNo("8838667354");
		Mockito.when(employeeRepository.saveAndFlush(employee)).thenReturn(employee);
		Employee employeess = EmployeeServiceImpl.updateEmployee(employee);
		Assert.assertNotNull(employeess);
      //  Assert.assertEquals(1, employeess.getEmployeeId());		
	}
	@AfterClass
	public static void tearDown() {
		employee = null;
	}
}

package com.Employee.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.Employee.dto.ResponseMessageDto;
import com.Employee.model.Employee;
import com.Employee.service.EmployeeService;

@RunWith(MockitoJUnitRunner.Silent.class)
public class EmployeeControllerTest {

	@InjectMocks
	EmployeeController employeeController;

	@Mock
	EmployeeService employeeService;

	static Employee employee = null;

	@BeforeClass
	public static void setUp() {
		employee = new Employee();
	}

	@Test
	public void testcreateEmployeeForPositive() {
		List<Employee> employees = new ArrayList();
		Employee employee = new Employee();
		employee.setEmployeeId((long) 1);
		//employee.setCompanyName("hcl");
		employee.setEmail("siva@gmail.com");
		employee.setEmployeeName("siva");
		//employee.setEmployeePhNo("8838662182");
		Mockito.when(employeeService.createEmployee(null)).thenReturn(employee);
		ResponseEntity<ResponseMessageDto> employeee = employeeController.createEmployees(null);
		Assert.assertNotNull(employeee);
		Assert.assertEquals(employeee.getStatusCode(), HttpStatus.OK);
	}

	@Test
	public void testcreateEmployeeForNagative() {
		List<Employee> employees = new ArrayList();
		Employee employee = new Employee();
		//employee.setEmployeeId(-1);
		//employee.setCompanyName("hcl");
		employee.setEmail("siva@gmail.com");
		employee.setEmployeeName("siva");
		//employee.setEmployeePhNo("8838662182");
		//Mockito.when(employeeService.createEmployee(null)).thenReturn(employee);
		ResponseEntity<ResponseMessageDto> employeee = employeeController.createEmployees(null);
		Assert.assertNotNull(employeee);
		Assert.assertEquals(employeee.getStatusCode(), HttpStatus.OK);
	}

	@Test
	public void testupdateEmployeeForPositive() {
		List<Employee> employees = new ArrayList();
		Employee employee = new Employee();
		employee.setEmployeeId(1l);
		//employee.setCompanyName("hcl");
		employee.setEmail("siva@gmail.com");
		employee.setEmployeeName("siva");
		//employee.setEmployeePhNo("8838662182");
		Mockito.when(employeeService.createEmployee(null)).thenReturn(employee);
		ResponseEntity<ResponseMessageDto> employeee = employeeController.createEmployees(null);
		Assert.assertNotNull(employeee);
		Assert.assertEquals(employeee.getStatusCode(), HttpStatus.OK);
	}

	@Test
	public void testupdateEmployeeForNagative() {
		List<Employee> employees = new ArrayList();
		Employee employee = new Employee();
		employee.setEmployeeId((long) -1);
		//employee.setCompanyName("hcl");
		employee.setEmail("siva@gmail.com");
		employee.setEmployeeName("siva");
		//employee.setEmployeePhNo("8838662182");
		Mockito.when(employeeService.createEmployee(null)).thenReturn(employee);
		ResponseEntity<ResponseMessageDto> employeee = employeeController.createEmployees(null);
		Assert.assertNotNull(employeee);
		Assert.assertEquals(employeee.getStatusCode(), HttpStatus.OK);
	}

	@Test
	public void testdeleteEmployeeForPositive() {
		List<Employee> employees = new ArrayList();
		Employee employee = new Employee();
		employee.setEmployeeId((long) 1);
		//employee.setCompanyName("hcl");
		employee.setEmail("siva@gmail.com");
		employee.setEmployeeName("siva");
	//	employee.setEmployeePhNo("8838662182");
		Mockito.when(employeeService.createEmployee(null)).thenReturn(employee);
		ResponseEntity<ResponseMessageDto> employeee = employeeController.createEmployees(null);
		Assert.assertNotNull(employeee);
		Assert.assertEquals(employeee.getStatusCode(), HttpStatus.OK);
	}

	@Test
	public void testdeleteEmployeeForNagative() {
		List<Employee> employees = new ArrayList();
		Employee employee = new Employee();
		employee.setEmployeeId((long) -1);
		//employee.setCompanyName("hcl");
		employee.setEmail("siva@gmail.com");
		employee.setEmployeeName("siva");
		//employee.setEmployeePhNo("8838662182");
		Mockito.when(employeeService.createEmployee(null)).thenReturn(employee);
		ResponseEntity<ResponseMessageDto> employeee = employeeController.createEmployees(null);
		Assert.assertNotNull(employeee);
		Assert.assertEquals(employeee.getStatusCode(), HttpStatus.OK);
	}

	@Test
	public void testgetAllEmployeeForPositive() {
		List<Employee> employees = new ArrayList();
		Employee employee = new Employee();
		employee.setEmployeeId((long) 1);
		//employee.setCompanyName("hcl");
		employee.setEmail("siva@gmail.com");
		employee.setEmployeeName("siva");
		//employee.setEmployeePhNo("8838662182");
		Mockito.when(employeeService.createEmployee(null)).thenReturn(employee);
		ResponseEntity<ResponseMessageDto> employeee = employeeController.createEmployees(null);
		Assert.assertNotNull(employeee);
		Assert.assertEquals(employeee.getStatusCode(), HttpStatus.OK);
	}

	@Test
	public void testgetAllEmployeeForNagative() {
		List<Employee> employees = new ArrayList();
		Employee employee = new Employee();
		employee.setEmployeeId((long) -1);
		//employee.setCompanyName("hcl");
		employee.setEmail("siva@gmail.com");
		employee.setEmployeeName("siva");
		//employee.setEmployeePhNo("8838662182");
		Mockito.when(employeeService.createEmployee(null)).thenReturn(employee);
		ResponseEntity<ResponseMessageDto> employeee = employeeController.createEmployees(null);
		Assert.assertNotNull(employeee);
		Assert.assertEquals(employeee.getStatusCode(), HttpStatus.OK);
	}

	@AfterClass
	public static void tearDown() {
		employee = null;
	}
}

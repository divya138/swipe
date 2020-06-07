package com.swipe.controller;

import java.text.ParseException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.swipe.Controller.SwipeController;
import com.swipe.Dto.SwipeOutDto;
import com.swipe.Dto.SwipeResponseDto;
import com.swipe.Dto.swipeInDto;
import com.swipe.Model.Employee;
import com.swipe.Model.Facility;
import com.swipe.Model.Swipe;
import com.swipe.Service.SwipeServiceImpl;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.Silent.class)
public class SwipeControllerTest {
	

	@InjectMocks
	SwipeController swipeController;

	@Mock
	SwipeServiceImpl  swipeServiceImpl;


	@Test
	public void checkSwipeIn() {
		swipeInDto s = new swipeInDto();
		SwipeResponseDto srd= new SwipeResponseDto();
		Mockito.when(swipeServiceImpl.makeswipeIn(s)).thenReturn(srd);
		
		ResponseEntity<SwipeResponseDto> ydc=swipeController.swipeIn(s);
		Assert.assertNotNull(ydc);
		Assert.assertEquals(HttpStatus.OK, ydc.getStatusCode());
		
		
	}

	@Test
	public void checkSwipeOut() throws ParseException {
		SwipeOutDto s = new SwipeOutDto();
		SwipeResponseDto srd= new SwipeResponseDto();
		Mockito.when(swipeServiceImpl.makeswipeOut(s)).thenReturn(srd);
		
		ResponseEntity<SwipeResponseDto> ydc=swipeController.swipeOut(s);
		Assert.assertNotNull(ydc);
		Assert.assertEquals(HttpStatus.OK, ydc.getStatusCode());
		
		
	}
	@Test
	public void checkGrtByEmpId() {
		SwipeOutDto s = new SwipeOutDto();
		Swipe swi = new Swipe();
		Employee e =  new Employee();
		s.setEmployeeId(1l);
		SwipeResponseDto srd= new SwipeResponseDto();
		Mockito.when(swipeServiceImpl.getSwipeEmployee(1l)).thenReturn(e);
		
		ResponseEntity<Employee> ydc=swipeController.EmployeeId(1l);
		Assert.assertNotNull(ydc);
		Assert.assertEquals(HttpStatus.OK, ydc.getStatusCode());
		
		
	}
	
	/*
	 * @Test public void checkGrtByFaciId() { SwipeOutDto s = new SwipeOutDto();
	 * Swipe swi = new Swipe(); Facility f = new Facility(); s.setEmployeeId(1l);
	 * SwipeResponseDto srd= new SwipeResponseDto();
	 * Mockito.when(swipeServiceImpl.getSwipeByFaciltyId(1l)).thenReturn(f);
	 * 
	 * ResponseEntity<Facility> ydc=swipeController.getSwipeReportByFacility(1l);
	 * Assert.assertNotNull(ydc); Assert.assertEquals(HttpStatus.OK,
	 * ydc.getStatusCode());
	 * 
	 * 
	 * }
	 */
	

@Test
public void checkwipeIn() {
	swipeInDto s = new swipeInDto();
	SwipeResponseDto srd= new SwipeResponseDto();
	Mockito.when(swipeServiceImpl.makeswipeIn(s)).thenReturn(srd);
	
	ResponseEntity<SwipeResponseDto> ydc=swipeController.swipeIn(s);
	Assert.assertNotNull(ydc);
	Assert.assertEquals(HttpStatus.OK, ydc.getStatusCode());
	
	
}

@Test
public void checkSwpeOut() throws ParseException {
	SwipeOutDto s = new SwipeOutDto();
	SwipeResponseDto srd= new SwipeResponseDto();
	Mockito.when(swipeServiceImpl.makeswipeOut(s)).thenReturn(srd);
	
	ResponseEntity<SwipeResponseDto> ydc=swipeController.swipeOut(s);
	Assert.assertNotNull(ydc);
	Assert.assertEquals(HttpStatus.OK, ydc.getStatusCode());
	
	
}
@Test
public void checkGrtBEmpId() {
	SwipeOutDto s = new SwipeOutDto();
	Swipe swi = new Swipe();
	Employee e =  new Employee();
	s.setEmployeeId(1l);
	SwipeResponseDto srd= new SwipeResponseDto();
	Mockito.when(swipeServiceImpl.getSwipeEmployee(1l)).thenReturn(e);
	
	ResponseEntity<Employee> ydc=swipeController.EmployeeId(1l);
	Assert.assertNotNull(ydc);
	Assert.assertEquals(HttpStatus.OK, ydc.getStatusCode());
	
	
}

@Test
public void ceckwipeIn() {
	swipeInDto s = new swipeInDto();
	SwipeResponseDto srd= new SwipeResponseDto();
	Mockito.when(swipeServiceImpl.makeswipeIn(s)).thenReturn(srd);
	
	ResponseEntity<SwipeResponseDto> ydc=swipeController.swipeIn(s);
	Assert.assertNotNull(ydc);
	Assert.assertEquals(HttpStatus.OK, ydc.getStatusCode());
	
	
}

@Test
public void checSwpeOut() throws ParseException {
	SwipeOutDto s = new SwipeOutDto();
	SwipeResponseDto srd= new SwipeResponseDto();
	Mockito.when(swipeServiceImpl.makeswipeOut(s)).thenReturn(srd);
	
	ResponseEntity<SwipeResponseDto> ydc=swipeController.swipeOut(s);
	Assert.assertNotNull(ydc);
	Assert.assertEquals(HttpStatus.OK, ydc.getStatusCode());
	
	
}
@Test
public void chekGrtBEmpId() {
	SwipeOutDto s = new SwipeOutDto();
	Swipe swi = new Swipe();
	Employee e =  new Employee();
	s.setEmployeeId(1l);
	SwipeResponseDto srd= new SwipeResponseDto();
	Mockito.when(swipeServiceImpl.getSwipeEmployee(1l)).thenReturn(e);
	
	ResponseEntity<Employee> ydc=swipeController.EmployeeId(1l);
	Assert.assertNotNull(ydc);
	Assert.assertEquals(HttpStatus.OK, ydc.getStatusCode());
	
	
}
}


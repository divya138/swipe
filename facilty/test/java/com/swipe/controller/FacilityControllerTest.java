package com.swipe.controller;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.swipe.dto.ResponseMessageDto;
import com.swipe.model.Facility;
import com.swipe.service.FacilityService;
import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.class)
public class FacilityControllerTest {
	
	@InjectMocks
	FacilityController facilityController;

	@Mock
	FacilityService facilityService;

	MockMvc mockMvc;

	private OngoingStubbing<ResponseMessageDto> thenReturn;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(facilityController).build();
	}

	

	
	@Test
	public void testGetAllFacilitiesPositive() {

		List<Facility> facilities = new ArrayList<Facility>();
        Facility facility = new Facility();
		facility.setFacilityId(1l);
		facility.setFacilityBranch("jilani");
		facility.setFacilityCity("Bangalore");
		facilities.add(facility);
        facility.setFacilityId((long) 2);
		facility.setFacilityBranch("jilani");
		facility.setFacilityCity("Bangalore");
		facilities.add(facility);
		Mockito.when(facilityService.getAllFacilities()).thenReturn(facilities);
		ResponseEntity<List<Facility>> re = facilityController.getAllFacilities();
		Assert.assertNotNull(re);
		Assert.assertEquals(HttpStatus.OK, re.getStatusCode());

	}
	@Test
	public void testGetAllFacilitiesNegative() {

		List<Facility> facilities = new ArrayList<Facility>();
        Facility facility = new Facility();
		facility.setFacilityId((long) -1);
		facility.setFacilityBranch("jilani");
		facility.setFacilityCity("Bangalore");
		facilities.add(facility);
        facility.setFacilityId((long) -2);
		facility.setFacilityBranch("jilani");
		facility.setFacilityCity("Bangalore");
		facilities.add(facility);
		Mockito.when(facilityService.getAllFacilities()).thenReturn(facilities);
		ResponseEntity<List<Facility>> re = facilityController.getAllFacilities();
		Assert.assertNotNull(re);
		Assert.assertEquals(HttpStatus.OK, re.getStatusCode());

	}
	@Test
    public void testupdateFacilityForNagative() {
		List<Facility> facilities = new ArrayList<Facility>();
        Facility facility = new Facility();
		facility.setFacilityId(-1l);
		facility.setFacilityBranch("jilani");
		facility.setFacilityCity("Bangalore");
		facilities.add(facility);
        Mockito.when(facilityService.updateFacility(null)).thenReturn(facility);
        
    }
	@Test
    public void testcreateFacilityForPositive() {
		List<Facility> facilities = new ArrayList<Facility>();
        Facility facility = new Facility();
		facility.setFacilityId(1l);
		facility.setFacilityBranch("jilani");
		facility.setFacilityCity("Bangalore");
		facilities.add(facility);
        Mockito.when(facilityService.updateFacility(null)).thenReturn(facility);
        
    }
	@Test
    public void testcreateFacilityForNagative() {
		List<Facility> facilities = new ArrayList<Facility>();
        Facility facility = new Facility();
		facility.setFacilityId(-1l);
		facility.setFacilityBranch("jilani");
		facility.setFacilityCity("Bangalore");
		facilities.add(facility);
        Mockito.when(facilityService.updateFacility(null)).thenReturn(facility);
        
    }

 
	}
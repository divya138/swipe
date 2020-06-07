package com.swipe.service;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import com.swipe.model.Facility;
import com.swipe.repository.FacilityRepository;


@RunWith(MockitoJUnitRunner.Silent.class)
public class FacilityServiceTest {
	@InjectMocks
	FacilityServiceImpl facilityServiceImpl;

	@Mock
	FacilityRepository facilityRepository;

	
	@Test
	public void testGetAllFacilitiesForPosite() {

		List<Facility> facilities = new ArrayList<Facility>();
        Facility facility = new Facility();
		facility.setFacilityId((long) 1);
		facility.setFacilityBranch("jilani");
		facility.setFacilityCity("Bangalore");
		facilities.add(facility);
        facility.setFacilityId((long) 2);
		facility.setFacilityBranch("jilani");
		facility.setFacilityCity("Bangalore");
		facilities.add(facility);
		Mockito.when(facilityRepository.findAll()).thenReturn(facilities);
		List<Facility> facility2 = facilityServiceImpl.getAllFacilities();

		Assert.assertNotNull(facility2);
		Assert.assertEquals(2, facility2.size());

	}
	@Test
	public void testGetAllFacilitiesForNegative() {

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
		Mockito.when(facilityRepository.findAll()).thenReturn(facilities);
		List<Facility> facility2 = facilityServiceImpl.getAllFacilities();

		Assert.assertNotNull(facility2);
		Assert.assertEquals(2, facility2.size());

	}
	
	@Test
    public void testupdateFacilityForPositive() {
		List<Facility> facilities = new ArrayList<Facility>();
        Facility facility = new Facility();
		facility.setFacilityId((long) 1);
		facility.setFacilityBranch("jilani");
		facility.setFacilityCity("Bangalore");
		facilities.add(facility);
        Mockito.when(facilityRepository.save(facility)).thenReturn(facility);
	}
	@Test
    public void testCreateFacilityForPositive() {
		List<Facility> facilities = new ArrayList<Facility>();
        Facility facility = new Facility();
		facility.setFacilityId((long) 1);
		facility.setFacilityBranch("jilani");
		facility.setFacilityCity("Bangalore");
		facilities.add(facility);
        Mockito.when(facilityRepository.save(facility)).thenReturn(facility);
	}
	@Test
    public void testCreateFacilityForNegative() {
		List<Facility> facilities = new ArrayList<Facility>();
        Facility facility = new Facility();
		facility.setFacilityId((long) -1);
		facility.setFacilityBranch("jilani");
		facility.setFacilityCity("Bangalore");
		facilities.add(facility);
        Mockito.when(facilityRepository.save(facility)).thenReturn(facility);
	}
	}

package com.swipe.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.swipe.dto.FacilityDto;
import com.swipe.dto.ResponseMessageDto;
import com.swipe.exception.FacilityNotFoundException;
import com.swipe.model.Facility;
import com.swipe.service.FacilityService;

import ch.qos.logback.core.db.dialect.MsSQLDialect;

@RestController
public class FacilityController {

	@Autowired
	FacilityService facilityService;

	@PostMapping("/facility")
	public ResponseEntity<ResponseMessageDto> createFacilitys(@RequestBody FacilityDto facilityDto) {
		ResponseMessageDto facilities = facilityService.createFacility(facilityDto);
		return new ResponseEntity<>(facilities, HttpStatus.OK);
	}

	@GetMapping("/facility")
	public ResponseEntity<List<Facility>> getAllFacilities() {
		List<Facility> facilities = facilityService.getAllFacilities();
		return new ResponseEntity<>(facilities, HttpStatus.OK);
	}

	@GetMapping("/facilityId/{facilityId}")
	public Facility getFacilityById(@PathVariable Long facilityId) {
		Facility facility = facilityService.getFacilityById(facilityId);
		if (facility != null) {
			return facility;
		} else {
			throw new FacilityNotFoundException("the given Id is not found");
		}

	}

	@PutMapping("/facility")
	public ResponseEntity<ResponseMessageDto> updateFacilitys(@RequestBody Facility facility) {
		ResponseMessageDto messageDto = new ResponseMessageDto();
		facilityService.updateFacility(facility);
		messageDto.setMessage("Facilty Details updated sucessfully");
		return new ResponseEntity<>(messageDto, HttpStatus.OK);
	}

	@DeleteMapping("/facility/{facilityId}")
	public ResponseEntity<ResponseMessageDto> deleteFacilityById(@PathVariable("facilityId") Long facilityId) {
		ResponseMessageDto responseMessageDto = new ResponseMessageDto();
		facilityService.deleteFacilityById(facilityId);
		responseMessageDto.setMessage("facility Id " + facilityId + " is deleted ");
		return new ResponseEntity<>(responseMessageDto, HttpStatus.OK);

	}

}

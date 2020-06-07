package com.swipe.service;

import java.util.List;
import com.swipe.dto.FacilityDto;
import com.swipe.dto.ResponseMessageDto;
import com.swipe.model.Facility;

public interface FacilityService {

	ResponseMessageDto createFacility(FacilityDto facilityDto);

	List<Facility> getAllFacilities();

	Facility getFacilityById(Long facilityId);

	void deleteFacilityById(Long facilityId);

	public Facility updateFacility(Facility facility);

}

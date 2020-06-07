package com.swipe.service;

import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.swipe.dto.FacilityDto;
import com.swipe.dto.ResponseMessageDto;
import com.swipe.model.Facility;
import com.swipe.repository.FacilityRepository;

@Service
public class FacilityServiceImpl implements FacilityService {

	@Autowired
	FacilityRepository facilityRepository;
	ResponseMessageDto responseMessageDto = new ResponseMessageDto();
	Facility facility = new Facility();

	@Override
	public ResponseMessageDto createFacility(FacilityDto facilityDto) {

		BeanUtils.copyProperties(facilityDto, facility);
		facility = facilityRepository.save(facility);
		responseMessageDto.setMessage("faculty Table with Id " + facility.getFacilityId() + " created successfully");
		return responseMessageDto;

	}

	@Override
	public List<Facility> getAllFacilities() {
		return facilityRepository.findAll();
	}

	@Override
	public Facility getFacilityById(Long facilityId) {
		Facility facility = facilityRepository.getOne(facilityId);
		return facility;
	}

	@Override
	public Facility updateFacility(Facility facility) {
		return facilityRepository.save(facility);
	}

	@Override
	public void deleteFacilityById(Long facilityId) {
		facilityRepository.deleteById(facilityId);

	}

}

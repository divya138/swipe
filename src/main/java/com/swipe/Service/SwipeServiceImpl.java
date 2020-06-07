package com.swipe.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.swipe.Dto.SwipeOutDto;
import com.swipe.Dto.SwipeResponseDto;
import com.swipe.Dto.swipeInDto;
import com.swipe.Exception.DataNotFoundException;
import com.swipe.Model.Employee;
import com.swipe.Model.Facility;
import com.swipe.Model.Swipe;
import com.swipe.Repository.EmployeeRepo;
import com.swipe.Repository.FAcilityRepo;
import com.swipe.Repository.SwipeRepository;

@Service
public class SwipeServiceImpl implements SwipeService {

	@Autowired
	SwipeRepository swipeRepository;
	@Autowired
	EmployeeRepo employeeRepo;
	@Autowired
	FAcilityRepo facilityRepo;
	@Autowired
	RestTemplate restTemplate;
	
	@Bean
	RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	@Override
	public SwipeResponseDto makeswipeIn(swipeInDto swipeInDto) {

		Swipe swipe = new Swipe();
		swipe.setSwipeIn(swipeInDto.getSwipeIn());
		swipe.setDate(new Date());
		Employee employee;
		if (swipeInDto.getEmployeeId() != null) {
			employee = employeeRepo.findById(swipeInDto.getEmployeeId())
					.orElseThrow(() -> new DataNotFoundException("Employe not there"));
		} else {
			throw new DataNotFoundException("employeeId must not be null");
		}
		Facility facility;
		if (swipeInDto.getFacilityId() != null) {
			facility = facilityRepo.findById(swipeInDto.getFacilityId())
					.orElseThrow(() -> new DataNotFoundException("facility not there"));
		} else {
			throw new DataNotFoundException("FacilityId must not be null");
		}
		swipe.setEmployee(employee);
		swipe.setFacility(facility);
		swipeRepository.save(swipe);
		SwipeResponseDto responseDto = new SwipeResponseDto();
		responseDto.setMessage("swipeIn is sucessFull");
		return responseDto;
	}

	@Override
	public SwipeResponseDto makeswipeOut(SwipeOutDto swipeOutDto) throws ParseException {

		Swipe swipe = new Swipe();
		swipe.setSwipeOut(swipeOutDto.getSwipeOut());
		swipe.setDate(new Date());
		Employee employee;
		if (swipeOutDto.getEmployeeId() != null) {
			employee = employeeRepo.findById(swipeOutDto.getEmployeeId())
					.orElseThrow(() -> new DataNotFoundException("Employe not there"));
		} else {
			throw new DataNotFoundException("employeeId must not be null");
		}
		List<Swipe> s = swipeRepository.findByDateAndEmployee(new Date(), employee);

		Optional<Swipe> optional = s.stream().sorted(Comparator.comparing(Swipe::getSwipeId).reversed()).findFirst();
	Swipe k =null;
		if(optional.isPresent()) {
			k=optional.get();
		}
		
		
		SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
		Date date1 = format.parse(swipe.getSwipeOut());
		Date date2 = format.parse(k.getSwipeIn());

		Long sec = date1.getTime() - date2.getTime();
		k.setSwipeOut(swipe.getSwipeOut());
		
		double hours = sec / (60 * 60 * 1000);
		k.setHoursPerFacility(hours);
		k.getEmployee().setWorkingHours(k.getEmployee().getWorkingHours() + hours);

		swipeRepository.save(k);
		SwipeResponseDto responseDto = new SwipeResponseDto();
		responseDto.setMessage("swipeOut is sucessFull");
		return responseDto;
	}
	
	public Employee getSwipeEmployee(Long id)  {
		try {
               
			Employee result = restTemplate.getForObject("http://localhost:7089/employee/" + id, Employee.class);
			
			return result;
		} catch (HttpClientErrorException e) {
			throw new DataNotFoundException("Employee not found");
		}
	}

	public Facility getSwipeByFaciltyId(Long id)  {
		try {
		
			Facility result = restTemplate.getForObject("http://localhost:8001//facilityId/" + id, Facility.class);
			
			return result;
		} catch (HttpClientErrorException e) {
			throw new DataNotFoundException("Facility not found");
		}
	}

	

}
	



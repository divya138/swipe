package com.swipe.Controller;

import java.text.ParseException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.swipe.Dto.SwipeOutDto;
import com.swipe.Dto.SwipeResponseDto;
import com.swipe.Dto.swipeInDto;
import com.swipe.Model.Employee;
import com.swipe.Model.Facility;
import com.swipe.Service.SwipeService;
@RestController
public class SwipeController {
	
	Logger logger = LoggerFactory.getLogger(SwipeController.class);
	
	@Autowired
	SwipeService swipeService;
	
	
	@PostMapping("swipeIn")
	public ResponseEntity<SwipeResponseDto> swipeIn(@RequestBody swipeInDto swipeInDto) {
	logger.info("swipe in method");
		SwipeResponseDto swipeResponseDto=swipeService.makeswipeIn(swipeInDto);
		 
		 return new ResponseEntity<>(swipeResponseDto,HttpStatus.OK);
		
	}
	
	@PostMapping("swipeOut")
	public ResponseEntity<SwipeResponseDto> swipeOut(@RequestBody SwipeOutDto swipeOutDto) throws ParseException {
		logger.info("swipe out method");
		SwipeResponseDto swipeResponseDto=swipeService.makeswipeOut(swipeOutDto);
		 
		 return new ResponseEntity<>(swipeResponseDto,HttpStatus.OK);
		
	}
	
	@GetMapping("/Employee")
	public ResponseEntity<Employee> EmployeeId(@RequestParam Long id){
		
		logger.info("Employee method");
		Employee swipe=swipeService.getSwipeEmployee(id);
	
		
		return new ResponseEntity<>(swipe, HttpStatus.OK);	
	}
	@GetMapping("/Facility")
	public ResponseEntity<Facility> Facility(@RequestParam Long id)  {
		logger.info("Facility method");
		Facility swipe=swipeService.getSwipeByFaciltyId(id);
		
		return new ResponseEntity<>(swipe, HttpStatus.OK);	
	}

}

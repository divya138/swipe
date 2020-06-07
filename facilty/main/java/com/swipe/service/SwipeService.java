package com.swipe.Service;

import java.text.ParseException;

import com.swipe.Dto.SwipeOutDto;
import com.swipe.Dto.SwipeResponseDto;
import com.swipe.Dto.swipeInDto;
import com.swipe.Model.Employee;
import com.swipe.Model.Facility;


public interface SwipeService {

	SwipeResponseDto makeswipeIn(swipeInDto swipeInDto);

	SwipeResponseDto makeswipeOut(SwipeOutDto swipeOutDto) throws ParseException;

	Employee getSwipeEmployee(Long id);
	Facility getSwipeByFaciltyId(Long id);

}

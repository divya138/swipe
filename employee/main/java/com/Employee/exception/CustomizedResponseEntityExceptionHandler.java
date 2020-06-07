package com.Employee.exception;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
	
	@ExceptionHandler(EmployeeNotFound.class)
	public ResponseEntity<Object> DataNotFound(EmployeeNotFound ex, WebRequest request) {

		Map<String, Object> body = new LinkedHashMap<>();
		body.put("TIMESTAmp ", LocalDateTime.now());
		body.put("message", ex.getMessage());
		body.put("status", HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
	}
	

	
}

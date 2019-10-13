package com.mycomp.cards.exception;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import com.mycomp.cards.exception.CustomExceptionMessage;

@RestController
@ControllerAdvice
public class CustomEntityResponseExceptionHandler extends ResponseEntityExceptionHandler {
	//@ResponseStatus(HttpStatus.BAD_REQUEST)
	//@ExceptionHandler(MethodArgumentNotValidException.class)
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest req){
		CustomExceptionMessage customException = new CustomExceptionMessage(new Date(),
				req.getDescription(false), "Validation failed", ex.getBindingResult().toString());
		return new ResponseEntity(customException, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest req){
		CustomExceptionMessage customException = new CustomExceptionMessage(new Date(),
				req.getDescription(false), ex.getMessage());
		return new ResponseEntity(customException, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@ExceptionHandler(NotFoundException.class)
	public final ResponseEntity<Object> handleNotFoundExceptions(NotFoundException ex, WebRequest req){
		CustomExceptionMessage customException = new CustomExceptionMessage(new Date(),
				req.getDescription(false), ex.getMessage());
		return new ResponseEntity(customException, HttpStatus.NOT_FOUND);
	}
}

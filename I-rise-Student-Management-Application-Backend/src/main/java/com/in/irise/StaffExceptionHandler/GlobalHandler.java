package com.in.irise.StaffExceptionHandler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.in.irise.Exception.StaffAccountCreationUnsucessfulException;
import com.in.irise.Exception.UserNotFoundException;

@RestControllerAdvice
public class GlobalHandler {
	
	 @ExceptionHandler(MethodArgumentNotValidException.class)
	    public ResponseEntity<Map<String, String>> handleValidationErrors(MethodArgumentNotValidException ex) {
	        Map<String, String> errors = new HashMap<>();
	        ex.getBindingResult().getFieldErrors().forEach(error ->
	            errors.put(error.getField(), error.getDefaultMessage())
	        );
	        return ResponseEntity.badRequest().body(errors);
	    }
	 
	 
	 @ExceptionHandler(StaffAccountCreationUnsucessfulException.class)
	    public ResponseEntity<Map<String, String>> handleStaffCreation(StaffAccountCreationUnsucessfulException EH) {
	        return ResponseEntity.badRequest().body(Map.of("error", EH.getMessage()));
	    }

	    @ExceptionHandler(Exception.class)
	    public ResponseEntity<Map<String, String>> handleOtherExceptions(Exception ex) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                             .body(Map.of("error", "An unexpected error occurred"));
	    }
	    
	    @ExceptionHandler(UserNotFoundException.class)
	    public ResponseEntity<Map<String, String>> UserNotFoundException(UserNotFoundException EH) {
	        return ResponseEntity.badRequest().body(Map.of("error", EH.getMessage()));
	    } 

}

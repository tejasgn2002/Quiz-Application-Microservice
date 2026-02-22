package com.quiz_service.app.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;


@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(QuizNotFoundException.class)
	public ResponseEntity<Map<String, Object>> quizNotFoundHandler(Exception ex){		
		return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ErrorResponse.response(HttpStatus.NOT_FOUND.value(), ex.getMessage()));
	}
}

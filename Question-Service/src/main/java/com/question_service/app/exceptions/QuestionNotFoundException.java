package com.question_service.app.exceptions;

public class QuestionNotFoundException extends RuntimeException{
	public QuestionNotFoundException(String message) {
		super(message);
	}
}

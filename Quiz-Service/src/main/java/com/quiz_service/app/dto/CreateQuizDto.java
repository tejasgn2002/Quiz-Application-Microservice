package com.quiz_service.app.dto;

import lombok.Data;

@Data
public class CreateQuizDto {
	private String category;
	private Integer noOfQuestions;
	private String title;
	
}

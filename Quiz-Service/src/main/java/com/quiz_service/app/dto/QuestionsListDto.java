package com.quiz_service.app.dto;

import lombok.Data;

@Data
public class QuestionsListDto {
	private Integer id;
	private String questionTitle;
	private String option1;
	private String option2; 
	private String option3;
	private String option4;
	
}

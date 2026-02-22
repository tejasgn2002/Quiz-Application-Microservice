package com.quiz_service.app.dto;


import lombok.Data;

import java.util.List;

@Data
public class QuizDto {
	private Integer id;
	private String title;
	private List<Integer> questionIds;
}

package com.quiz_service.app.service;


import com.quiz_service.app.dto.QuestionsListDto;
import com.quiz_service.app.dto.QuizDto;
import com.quiz_service.app.dto.SubmitResponseDto;

import java.util.List;

public interface QuizService {
	QuizDto createQuiz(String category, String title, Integer numOfQuestions);
	List<QuestionsListDto> getQuizQuestions(int id);
	Integer submitedQuiz(Integer id, List<SubmitResponseDto> submitReponseDto);
}

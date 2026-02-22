package com.quiz_service.app.mapper;

import com.quiz_service.app.dto.QuizDto;
import com.quiz_service.app.entity.Quiz;
import org.springframework.stereotype.Component;


@Component
public class QuizMapper {
	


	public Quiz toEntity(QuizDto dto) {
		Quiz quiz = new Quiz();
		quiz.setId(dto.getId());
		quiz.setTitle(dto.getTitle());
		quiz.setQuestionIds(dto.getQuestionIds());
		return quiz;
	}

	public QuizDto toDto(Quiz quiz) {
		QuizDto quizDto = new QuizDto();
		quizDto.setId(quiz.getId());
		quizDto.setTitle(quiz.getTitle());
        quizDto.setQuestionIds(quiz.getQuestionIds());
		return quizDto;
	}
}
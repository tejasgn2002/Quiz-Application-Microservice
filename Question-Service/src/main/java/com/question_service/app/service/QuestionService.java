package com.question_service.app.service;

import com.question_service.app.dto.QuestionDto;
import com.question_service.app.dto.QuestionsListDto;
import com.question_service.app.dto.SubmitResponseDto;
import com.question_service.app.entity.Question;
import org.jspecify.annotations.Nullable;

import java.util.List;

public interface QuestionService {
	List<QuestionDto> fetchAllQuestions();
	List<QuestionDto> fetchAllQuestionsByCategory(String category);
	QuestionDto addQuestion(QuestionDto questionDto);
    List<Integer> generateQuestions(String category, Integer numOfQuestions);
    List<QuestionsListDto> getQuizQuestions(List<Integer> questionIds);
    Integer submitedQuiz(List<SubmitResponseDto> submitReponseDto);
}

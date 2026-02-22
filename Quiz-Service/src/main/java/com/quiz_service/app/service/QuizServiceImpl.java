package com.quiz_service.app.service;


import com.quiz_service.app.dto.QuestionsListDto;
import com.quiz_service.app.dto.QuizDto;
import com.quiz_service.app.dto.SubmitResponseDto;
import com.quiz_service.app.entity.Quiz;
import com.quiz_service.app.exceptions.QuizNotFoundException;
import com.quiz_service.app.feign.QuizInterface;
import com.quiz_service.app.mapper.QuizMapper;
import com.quiz_service.app.repository.QuizRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class QuizServiceImpl implements QuizService{
	
	private final QuizRepository quizRepo;
	private final QuizMapper quizMapper;
	private final QuizInterface quizInterface;


	@Override
	public QuizDto createQuiz(String category, String title, Integer numOfQuestions) {
        Quiz quiz = new Quiz();
        List<Integer> questionIds = quizInterface.generateQuestions(category,numOfQuestions).getBody();
        quiz.setTitle(title);
        quiz.setQuestionIds(questionIds);
        return quizMapper.toDto(quizRepo.save(quiz));
	}

	@Override
	public List<QuestionsListDto> getQuizQuestions(int id) {
        List<Integer> questionIds = quizRepo.findById(id).orElseThrow(
                () -> new QuizNotFoundException("Quiz Not Found")
        ).getQuestionIds();
		return quizInterface.getQuizQuestions(questionIds).getBody();
	}

	@Override
	public Integer submitedQuiz(Integer id, List<SubmitResponseDto> submitReponseDto) {
		return quizInterface.submitedQuiz(submitReponseDto).getBody();
	}
	
	
	
}

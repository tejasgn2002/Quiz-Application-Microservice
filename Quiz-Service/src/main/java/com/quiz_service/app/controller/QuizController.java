package com.quiz_service.app.controller;


import com.quiz_service.app.dto.CreateQuizDto;
import com.quiz_service.app.dto.QuestionsListDto;
import com.quiz_service.app.dto.QuizDto;
import com.quiz_service.app.dto.SubmitResponseDto;
import com.quiz_service.app.service.QuizService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
@AllArgsConstructor
public class QuizController {

	private final QuizService service;
	
	@PostMapping("create")
	public ResponseEntity<QuizDto> createQuiz(@RequestBody CreateQuizDto quiz){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(service.createQuiz(quiz.getCategory(), quiz.getTitle(), quiz.getNoOfQuestions()));
	}
	
	@GetMapping("{id}")
	public ResponseEntity<List<QuestionsListDto>> getQuizQuestions(@PathVariable int id){
		return ResponseEntity.ok(service.getQuizQuestions(id));
	}

	@PostMapping("submit/{id}")
	public ResponseEntity<Integer> submitedQuiz(@PathVariable Integer id,@RequestBody List<SubmitResponseDto> submitReponseDto){
		return ResponseEntity.ok(service.submitedQuiz(id,submitReponseDto));
	}
}

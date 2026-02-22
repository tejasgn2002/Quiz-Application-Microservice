package com.question_service.app.controller;


import com.question_service.app.dto.QuestionDto;
import com.question_service.app.dto.QuestionsListDto;
import com.question_service.app.dto.SubmitResponseDto;
import com.question_service.app.entity.Question;
import com.question_service.app.service.QuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {
	
	private final QuestionService service;
	
	public QuestionController(QuestionService service) {
		this.service = service;
	}
	
	@GetMapping("allQuestions")
	public ResponseEntity<List<QuestionDto>> fetchAllQuestions(){
		return ResponseEntity.status(HttpStatus.OK).body(service.fetchAllQuestions());
	}
	
	@GetMapping("category/{category}")
	public ResponseEntity<List<QuestionDto>> fetchAllQuesitonsByCategory(@PathVariable String category){
		return ResponseEntity.status(HttpStatus.OK).body(service.fetchAllQuestionsByCategory(category));
	}
	
	@PostMapping("add")
	public ResponseEntity<QuestionDto> addQuestion(@RequestBody QuestionDto questionDto){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.addQuestion(questionDto));
	}

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteQuestion(@PathVariable int id){
        return ResponseEntity.ok("Deleted");
    }

    @GetMapping("generate")
    public ResponseEntity<List<Integer>> generateQuestions(@RequestParam String category,@RequestParam Integer numOfQuestions){
        return ResponseEntity.ok(service.generateQuestions(category,numOfQuestions));
    }

    @PostMapping("getQuestions")
    public ResponseEntity<List<QuestionsListDto>> getQuizQuestions(@RequestBody List<Integer> questionIds){
        return ResponseEntity.ok(service.getQuizQuestions(questionIds));
    }

    @PostMapping("getScore")
    public ResponseEntity<Integer> submitedQuiz(@RequestBody List<SubmitResponseDto> submitReponseDto){
        return ResponseEntity.ok(service.submitedQuiz(submitReponseDto));
    }
}

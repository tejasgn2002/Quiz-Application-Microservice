package com.quiz_service.app.feign;

import com.quiz_service.app.dto.QuestionsListDto;
import com.quiz_service.app.dto.SubmitResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("QUESTION-SERVICE")
public interface QuizInterface {
    @GetMapping("question/generate")
    public ResponseEntity<List<Integer>> generateQuestions(@RequestParam String category, @RequestParam Integer numOfQuestions);

    @PostMapping("question/getQuestions")
    public ResponseEntity<List<QuestionsListDto>> getQuizQuestions(@RequestBody List<Integer> questionIds);

    @PostMapping("question/getScore")
    public ResponseEntity<Integer> submitedQuiz(@RequestBody List<SubmitResponseDto> submitReponseDto);
}

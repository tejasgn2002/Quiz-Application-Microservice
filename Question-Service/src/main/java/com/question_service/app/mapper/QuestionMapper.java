package com.question_service.app.mapper;


import com.question_service.app.dto.QuestionDto;
import com.question_service.app.entity.Question;
import org.springframework.stereotype.Component;

@Component
public class QuestionMapper {
	public Question toEntity(QuestionDto questionDto) {
		
		Question question = new Question();
		question.setId(questionDto.getId());
		question.setQuestionTitle(questionDto.getQuestionTitle());
		question.setOption1(questionDto.getOption1());
		question.setOption2(questionDto.getOption2());
		question.setOption3(questionDto.getOption3());
		question.setOption4(questionDto.getOption4());
		question.setRightAnswer(questionDto.getRightAnswer());
		question.setDifficultyLevel(questionDto.getDifficultyLevel());
		question.setCategory(questionDto.getCategory());
		
		return question;
	}
	
	public QuestionDto toDto(Question question) {
		
		QuestionDto questionDto = new QuestionDto();
		questionDto.setId(question.getId());
		questionDto.setQuestionTitle(question.getQuestionTitle());
		questionDto.setOption1(question.getOption1());
		questionDto.setOption2(question.getOption2());
		questionDto.setOption3(question.getOption3());
		questionDto.setOption4(question.getOption4());
		questionDto.setRightAnswer(question.getRightAnswer());
		questionDto.setDifficultyLevel(question.getDifficultyLevel());
		questionDto.setCategory(question.getCategory());
		
		return questionDto;
	}
}

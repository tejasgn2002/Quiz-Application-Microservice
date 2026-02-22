package com.question_service.app.mapper;


import com.question_service.app.dto.QuestionsListDto;
import com.question_service.app.entity.Question;
import org.springframework.stereotype.Component;

@Component
public class QuestionsListMapper {
	public QuestionsListDto toDto(Question question) {
		QuestionsListDto dto = new QuestionsListDto();
		dto.setId(question.getId());
		dto.setQuestionTitle(question.getQuestionTitle());
		dto.setOption1(question.getOption1());
		dto.setOption2(question.getOption2());
		dto.setOption3(question.getOption3());
		dto.setOption4(question.getOption4());
		return dto;
	}
}

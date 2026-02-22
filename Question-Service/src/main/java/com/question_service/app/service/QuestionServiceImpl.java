package com.question_service.app.service;

import com.question_service.app.dto.QuestionDto;
import com.question_service.app.dto.QuestionsListDto;
import com.question_service.app.dto.SubmitResponseDto;
import com.question_service.app.entity.Question;
import com.question_service.app.mapper.QuestionMapper;
import com.question_service.app.mapper.QuestionsListMapper;
import com.question_service.app.repository.QuestionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class QuestionServiceImpl implements QuestionService{
	
	private final QuestionRepository questionRepo;
	private final QuestionMapper questionMapper;
    private final QuestionsListMapper questionsListMapper;

	@Override
	public List<QuestionDto> fetchAllQuestions() {
		return questionRepo.findAll()
				.stream()
				.map(questionMapper::toDto)
				.toList();
	}

	@Override
	public List<QuestionDto> fetchAllQuestionsByCategory(String category) {
		return questionRepo.findAllByCategory(category)
						.stream()
						.map(questionMapper::toDto)
						.toList();
	}

	@Override
	public QuestionDto addQuestion(QuestionDto questionDto) {
		Question question = questionMapper.toEntity(questionDto);
		return questionMapper.toDto(questionRepo.save(question));
	}


    @Override
    public List<Integer> generateQuestions(String category, Integer numOfQuestions) {
        return questionRepo.findRandomQuestionsByCategory(category,numOfQuestions);
    }

    @Override
    public List<QuestionsListDto> getQuizQuestions(List<Integer> questionIds) {
        return questionRepo.findAllById(questionIds).stream()
                .map(questionsListMapper::toDto)
                .toList();
    }

    @Override
    public Integer submitedQuiz(List<SubmitResponseDto> submitReponseDto) {
        List<Integer> questionIds = submitReponseDto.stream().map(SubmitResponseDto::getId).toList();
        Map<Integer,String> rightAnswer = questionRepo.findAllById(questionIds)
                .stream()
                .collect(Collectors.toMap(Question::getId, Question::getRightAnswer));
        Integer result = 0;
        for(SubmitResponseDto responseDto : submitReponseDto) {
            if(responseDto.getResponse().equals(rightAnswer.get(responseDto.getId()))) {
                result++;
            }
        }
        return result;
    }
}

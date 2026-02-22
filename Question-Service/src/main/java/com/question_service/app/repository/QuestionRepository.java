package com.question_service.app.repository;

import com.question_service.app.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {
	List<Question> findAllByCategory(String category);
	@Query(value = "SELECT id FROM questions WHERE category LIKE ?1 ORDER BY RAND() LIMIT ?2;",nativeQuery = true)
	List<Integer> findRandomQuestionsByCategory(String category, Integer numOfQuestions);
}

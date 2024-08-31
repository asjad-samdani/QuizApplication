package com.example.quizApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.quizApp.entity.Question;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
    List<Question> findByCategory(String category);

    // @NamedNativeQuery(value = "SELECT * FROM question q WHERE q.category =
    // :category ORDER BY RAND() limit=:numQ")
    List<Question> findRandomQuestionsByCategory(String category, Integer numQ);

}

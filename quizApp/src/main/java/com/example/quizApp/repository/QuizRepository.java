package com.example.quizApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.quizApp.entity.Question;
import java.util.List;

public interface QuizRepository extends JpaRepository<Question, Integer> {
    List<Question> findByCategory(String category);

    Question save(Integer id);

}

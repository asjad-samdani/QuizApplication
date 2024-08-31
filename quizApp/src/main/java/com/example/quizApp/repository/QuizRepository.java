package com.example.quizApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.quizApp.entity.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Integer> {

}

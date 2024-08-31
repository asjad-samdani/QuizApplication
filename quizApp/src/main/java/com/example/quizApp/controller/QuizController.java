package com.example.quizApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.quizApp.Dto.QuestionDto;
import com.example.quizApp.server.QuizService;

@RestController
@RequestMapping("/quiz")
public class QuizController {
    @Autowired
    QuizService quizService;

    @PostMapping("/create")
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam Integer numQ,
            @RequestParam String title) {
        return quizService.createQuiz(category, numQ, title);

    }

    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionDto>> getQuizQuestion(@PathVariable Integer id) {
        List<QuestionDto> questionDtos = quizService.getQuizQuestions(id);
        return ResponseEntity.ok(questionDtos);

    }

}

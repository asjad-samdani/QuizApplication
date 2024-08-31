package com.example.quizApp.server;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.quizApp.Dto.QuestionDto;
import com.example.quizApp.entity.Question;
import com.example.quizApp.entity.Quiz;
import com.example.quizApp.repository.QuestionRepository;
import com.example.quizApp.repository.QuizRepository;

@Service
public class QuizService {
    @Autowired
    QuestionRepository questionRepository;
    @Autowired
    QuizRepository quizRepository;

    public ResponseEntity<String> createQuiz(String category, Integer numQ, String title) {
        List<Question> question = questionRepository.findRandomQuestionsByCategory(category, numQ);
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestion(question);
        quizRepository.save(quiz);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    public List<QuestionDto> getQuizQuestions(Integer quizId) {
        Quiz quiz = quizRepository.findById(quizId).get();

        List<QuestionDto> questionDtos = new ArrayList<>();
        for (Question question : quiz.getQuestion()) {
            questionDtos.add(convertToDto(question));
        }
        return questionDtos;
    }

    private QuestionDto convertToDto(Question question2) {
        Question question = new Question();
        question.setQuestionTitle(question2.getQuestionTitle());
        question.setOption1(question2.getOption1());
        question.setOption1(question2.getOption2());
        question.setOption1(question2.getOption3());
        question.setOption1(question2.getOption4());
        question.setOption1(question2.getOption1());
        return null;
    }

}

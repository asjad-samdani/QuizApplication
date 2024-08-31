package com.example.quizApp.server;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.quizApp.entity.Question;
import com.example.quizApp.repository.QuestionRepository;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    public List<Question> getAllQuestionsBycategory(String category) {
        return questionRepository.findByCategory(category);
    }

    public List<Question> addAllQuestions(List<Question> addQuestions) {
        return questionRepository.saveAll(addQuestions);
    }

    public Question updateQuestion(Question question, Integer id) {
        if (questionRepository.existsById(id)) {
            question.setId(id);
            return questionRepository.save(question);

        } else {
            return null;
        }

    }

    public boolean deleteQuestionById(Integer id) {
        try {
            if (questionRepository.existsById(id)) {
                questionRepository.deleteById(id);
                return true;

            }

        } catch (Exception e) {
            System.err.println("Error occurred while deleting question: " + e.getMessage());
        }
        return false;

    }

    public List<Question> findBooksWithSorting(String category) {
        return questionRepository.findAll(Sort.by(Sort.Direction.ASC, category));

    }

}

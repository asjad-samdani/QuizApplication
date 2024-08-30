package com.example.quizApp.server;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.quizApp.entity.Question;
import com.example.quizApp.repository.QuizRepository;

@Service
public class QuizService {

    @Autowired
    private QuizRepository quizRepository;

    public List<Question> getAllQuestions() {
        return quizRepository.findAll();
    }

    public List<Question> getAllQuestionsBycategory(String category) {
        return quizRepository.findByCategory(category);
    }

    public List<Question> addAllQuestions(List<Question> addQuestions) {
        return quizRepository.saveAll(addQuestions);
    }

    public Question updateQuestion(Question question, Integer id) {
        if (quizRepository.existsById(id)) {
            question.setId(id);
            return quizRepository.save(question);

        } else {
            return null;
        }

    }

    public boolean deleteBookById(Integer id) {
        try {
            if (quizRepository.existsById(id)) {
                quizRepository.deleteById(id);
                return true;

            }

        } catch (Exception e) {
            e.getMessage();
        }
        return false;

    }

    public List<Question> findBooksWithSorting(String category) {
        return quizRepository.findAll(Sort.by(Sort.Direction.ASC, category));

    }

}

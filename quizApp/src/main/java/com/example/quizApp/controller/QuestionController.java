package com.example.quizApp.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.quizApp.entity.Question;
import com.example.quizApp.server.QuestionService;

@RestController
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    QuestionService questionService;

    @GetMapping("/allQuestions")
    public ResponseEntity<?> getAllQuestions() {
        List<Question> allQuestions = questionService.getAllQuestions();
        if (allQuestions.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("message", "No questions found"));

        } else {
            return ResponseEntity.ok(allQuestions);
        }

    }

    @GetMapping("/category/{category}")
    public ResponseEntity<?> getQuestionsByCategory(@PathVariable String category) {
        List<Question> QuestionsBycategory = questionService.getAllQuestionsBycategory(category);
        if (QuestionsBycategory.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("message", "No questions found in this category"));

        } else {
            return ResponseEntity.ok(QuestionsBycategory);
        }

    }

    // Sorting the Question
    @GetMapping("/sortQuestion/{category}")
    public ResponseEntity<?> sortQuestionsByCategory(@PathVariable String category) {
        List<Question> sortedQuestions = questionService.findBooksWithSorting(category);
        if (sortedQuestions.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.ok(sortedQuestions);

    }

    @PostMapping("/addQuestions")
    public ResponseEntity<?> addQuestins(@RequestBody List<Question> addQuestions) {

        List<Question> addedQuestions = questionService.addAllQuestions(addQuestions);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedQuestions);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> putMethodName(@RequestBody Question question, @PathVariable Integer id) {
        Question updatedQuestion = questionService.updateQuestion(question, id);
        if (updatedQuestion != null) {
            return ResponseEntity.ok(Map.of("message", "Updated successfully"));

        } else {

            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("message", "Question not found or update failed"));

        }

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteQuestion(@PathVariable Integer id) {
        boolean isDeleted = questionService.deleteQuestionById(id);
        if (isDeleted) {

            return ResponseEntity.ok(Map.of("message", "Question deleted successfully"));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("message", "Question ID not found"));
        }
    }

}
